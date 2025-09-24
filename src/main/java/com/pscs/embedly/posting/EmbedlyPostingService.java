/**
 * @author Dipak
 */

package com.pscs.embedly.posting;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class EmbedlyPostingService {

	private static final Logger logger = Logger.getLogger(EmbedlyPostingService.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("embedlyservice");

	private EmbedlyPostingService() {
	}

	private static class SingletonHelper {
		private static final EmbedlyPostingService INSTANCE = new EmbedlyPostingService();
	}

	public static EmbedlyPostingService getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public JSONObject sendPostRequest(String jsonBody, String urlType,String params) {
		JSONObject responseJson = new JSONObject();
		try {
			String apiKey = bundle.getString("API_KEY");
			System.out.println("Params "+params);
			String url = bundle.getString(urlType).concat(params.trim()).trim();
			

			logger.info("Embdely POST URL" + url + "\n Api Key" + apiKey + "\n Request " + jsonBody);
			System.out.println("Final URL " + url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("x-api-key", apiKey);

			HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

			ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
			// response status code
			System.out.println("Response " + response);
			HttpStatusCode statusCode = response.getStatusCode();
			logger.info("Bank Response Code:" + statusCode);
			System.out.println("Response Code " + statusCode);
			int value = statusCode.value();
			if (response.getBody() == null) {
				responseJson.put("respcode", "500");
				responseJson.put("respmsg", "Internal Server Error");
				responseJson.put("data", "No response from bank");
				return responseJson;
			} else {
				JSONObject responseBody = new JSONObject(response.getBody());
				if (value == 200) {
					logger.info("Bank Response Body" + response.getBody());
					responseJson = responseBuilder(response.getBody());
				}
			}

		} catch (HttpClientErrorException.NotFound e) {
			logger.error("Error: Resource not found - " + e.getResponseBodyAsString());
			responseJson.put("respcode", "404");
			responseJson.put("respmsg", "Resource not found");
			responseJson.put("data", e.getResponseBodyAsString());
		} catch (Exception e) {
			e.printStackTrace();
			responseJson.put("respcode", "500");
			responseJson.put("respmsg", "Internal Server Error");
			responseJson.put("data", e.getMessage());
		}
		return responseJson;
	}

	// GET Method Request
	public JSONObject sendGetRequest(String jsonBody, String urlType, String params) {
		JSONObject responseJson = new JSONObject();
		try {
			String apiKey = bundle.getString("API_KEY");
			String url = bundle.getString(urlType).concat(params);
			System.out.println("Final URL " + url);
			logger.info("Embedly GET URL" + url + "\n Api Key" + apiKey + "\n Request " + jsonBody);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("x-api-key", apiKey);
			HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

			// response status code
			HttpStatusCode statusCode = response.getStatusCode();
			logger.info("Bank Response Code:" + statusCode);
			System.out.println("Response Code " + statusCode);
			int value = statusCode.value();
			if (response.getBody() == null) {
				responseJson.put("respcode", "500");
				responseJson.put("respmsg", "Internal Server Error");
				responseJson.put("data", "No response from bank");
				return responseJson;
			} else {
				if (value == 200) {
					System.out.println(response.getBody());
					responseJson.put("respsode", "00");
					responseJson.put("respmsg", "SUCCESS");
					JSONObject responseBody = new JSONObject(response.getBody());
					responseJson.put("data", responseBody.get("data"));

				} else {
					responseJson.put("respsode", value + "");
					responseJson.put("respmsg", "Failed");
					responseJson.put("data", response.getBody());
				}

			}
		} catch (HttpClientErrorException.NotFound e) {
			logger.error("Error: Resource not found - " + e.getResponseBodyAsString());
			responseJson.put("respcode", "404");
			responseJson.put("respmsg", "Resource not found");
			responseJson.put("data", e.getResponseBodyAsString());
		} catch (Exception e) {
			e.printStackTrace();
			responseJson.put("respcode", "500");
			responseJson.put("respmsg", "Internal Server Error");
			responseJson.put("data", e.getMessage());
		}
		return responseJson;
	}

	public JSONObject responseBuilder(String responseStr) {

		JSONObject responseJson = new JSONObject();
		JSONObject jsonObject = new JSONObject(responseStr);

		if (!jsonObject.has("code")) {
			responseJson.put("respcode", "500");
			responseJson.put("respmsg", "Internal Server Error");
			return responseJson;
		}

		String code = jsonObject.getString("code");
		String message = jsonObject.getString("message");
		if (code.equalsIgnoreCase("00")) {
			responseJson.put("respcode", code);
			responseJson.put("respmsg", message);
			responseJson.put("data", jsonObject.get("data"));

		} else {
			responseJson.put("respcode", code);
			responseJson.put("respmsg", message);
			responseJson.put("data", jsonObject.get("data"));
		}
		return responseJson;
	}

	// Create PATCH Method Request service

	public JSONObject sendPatchRequest(String jsonBody, String urlType, String params, String fieldName) {

		JSONObject responseJson = new JSONObject();
		try {

			String apiKey = bundle.getString("API_KEY");
			String url = bundle.getString(urlType).concat(params);
			if (fieldName != null && !fieldName.isEmpty() && !fieldName.isBlank()) {
				url = url + "/" + fieldName;
			}
			System.out.println("Final URL " + url);
			logger.info("Embedly PATCH URL" + url + "\n Api Key" + apiKey + "\n Request " + jsonBody);
			RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("x-api-key", apiKey);
			HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PATCH, entity, String.class);

			// response status code
			HttpStatusCode statusCode = response.getStatusCode();
			logger.info("Bank Response Code:" + statusCode);
			System.out.println("Response Code " + statusCode);
			int value = statusCode.value();
			if (response.getBody() == null) {
				responseJson.put("respcode", "500");
				responseJson.put("respmsg", "Internal Server Error");
				responseJson.put("data", "No response from bank");
				return responseJson;
			} else {
				if (value == 200) {
					System.out.println(response.getBody());
					responseJson.put("respsode", "00");
					responseJson.put("respmsg", "SUCCESS");
					JSONObject responseBody = new JSONObject(response.getBody());
					responseJson.put("data", responseBody.get("data"));

				} else {
					responseJson.put("respsode", value + "");
					responseJson.put("respmsg", "Failed");
					responseJson.put("data", response.getBody());
				}

			}
		} catch (HttpClientErrorException.NotFound e) {
			logger.error("Error: Resource not found - " + e.getResponseBodyAsString());
			responseJson.put("respcode", "404");
			responseJson.put("respmsg", "Resource not found");
			responseJson.put("data", e.getResponseBodyAsString());
		} catch (Exception e) {
			e.printStackTrace();
			responseJson.put("respcode", "500");
			responseJson.put("respmsg", "Internal Server Error");
			responseJson.put("data", e.getMessage());
		}

		return responseJson;
	}
}
