/**
 * @author Dipak
 */

package com.pscs.embedly.posting;

import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
	public JSONObject sendPostRequest(String jsonBody, String urlType, String params) {
	    JSONObject responseJson = new JSONObject();
	    try {
	        String apiKey = bundle.getString("API_KEY");
	        System.out.println("Params " + params);
	        String url = bundle.getString(urlType).concat(params.trim()).trim();

	        logger.info("Embedly POST URL " + url + "\nApi Key " + apiKey + "\nRequest " + jsonBody);
	        System.out.println("Final URL " + url);

	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("x-api-key", apiKey);

	        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

	        HttpStatusCode statusCode = response.getStatusCode();
	        int value = statusCode.value();

	        logger.info("Embedly Response Code: " + value);
	        System.out.println("Response Code: " + value);

	        if (response.getBody() == null) {
	            responseJson.put("respcode", "500");
	            responseJson.put("respmsg", "Internal Server Error");
	            responseJson.put("data", "No response from Embedly");
	        } else {
	            JSONObject responseBody = new JSONObject(response.getBody());
	            if (value == 200) {
	                logger.info("Embedly Response Body: " + response.getBody());
	                responseJson = responseBuilder(response.getBody());
	            } else {
	                responseJson.put("respcode", String.valueOf(value));
	                responseJson.put("respmsg", responseBody.optString("message", "Failed"));
	                responseJson.put("data", responseBody.opt("data"));
	            }
	        }

	    } catch (HttpClientErrorException e) {
	        // 
	        logger.error("HTTP Client Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
	        try {
	            JSONObject errorBody = new JSONObject(e.getResponseBodyAsString());
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", errorBody.optString("message", "Client Error"));
	            responseJson.put("data", errorBody.opt("data"));
	        } catch (Exception parseEx) {
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", "Client Error");
	            responseJson.put("data", e.getResponseBodyAsString());
	        }

	    } catch (Exception e) {
	        logger.error("Unexpected Error", e);
	        responseJson.put("respcode", "500");
	        responseJson.put("respmsg", "Internal Server Error");
	        responseJson.put("data", e.getMessage());
	    }

	    return responseJson;
	}

	public JSONObject sendGetRequest(String jsonBody, String urlType, String params) {
	    JSONObject responseJson = new JSONObject();
	    try {
	        String apiKey = bundle.getString("API_KEY");
	        String url = bundle.getString(urlType).concat(params);
	        System.out.println("Final URL " + url);
	        logger.info("Embedly GET URL " + url + "\nApi Key: " + apiKey + "\nRequest: " + jsonBody);

	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("x-api-key", apiKey);

	        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

	        HttpStatusCode statusCode = response.getStatusCode();
	        int value = statusCode.value();
	        logger.info("Embedly Response Code: " + value);
	        System.out.println("Response Code " + value);

	        if (response.getBody() == null) {
	            responseJson.put("respcode", "500");
	            responseJson.put("respmsg", "No response from Embedly service");
	            responseJson.put("data", JSONObject.NULL);
	            return responseJson;
	        }

	        JSONObject responseBody = new JSONObject(response.getBody());
	        if (value == 200) {
	            logger.info("Embedly Response Body: " + response.getBody());
	            responseJson.put("respcode", "00");
	            responseJson.put("respmsg", "SUCCESS");
	            responseJson.put("data", responseBody.opt("data"));
	        } else {
	            responseJson.put("respcode", String.valueOf(value));
	            responseJson.put("respmsg", responseBody.optString("message", "Failed"));
	            responseJson.put("data", responseBody.opt("data"));
	        }

	    } catch (HttpClientErrorException e) {
	        
	        logger.error("HTTP Client Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
	        try {
	            JSONObject errorBody = new JSONObject(e.getResponseBodyAsString());
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", errorBody.optString("message", "Client Error"));
	            responseJson.put("data", errorBody.opt("data"));
	        } catch (Exception parseEx) {
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", "Client Error");
	            responseJson.put("data", e.getResponseBodyAsString());
	        }

	    } catch (Exception e) {
	        logger.error("Unexpected Error", e);
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
	        logger.info("Embedly PATCH URL " + url + "\nApi Key: " + apiKey + "\nRequest: " + jsonBody);

	        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("x-api-key", apiKey);

	        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PATCH, entity, String.class);

	        HttpStatusCode statusCode = response.getStatusCode();
	        int value = statusCode.value();
	        logger.info("Embedly Response Code: " + value);
	        System.out.println("Response Code: " + value);

	        if (response.getBody() == null) {
	            responseJson.put("respcode", "500");
	            responseJson.put("respmsg", "No response from Embedly service");
	            responseJson.put("data", JSONObject.NULL);
	            return responseJson;
	        }

	        JSONObject responseBody = new JSONObject(response.getBody());
	        if (value == 200) {
	            logger.info("Embedly Response Body: " + response.getBody());
	            responseJson.put("respcode", "00");
	            responseJson.put("respmsg", "SUCCESS");
	            responseJson.put("data", responseBody.opt("data"));
	        } else {
	            responseJson.put("respcode", String.valueOf(value));
	            responseJson.put("respmsg", responseBody.optString("message", "Failed"));
	            responseJson.put("data", responseBody.opt("data"));
	        }

	    } catch (HttpClientErrorException e) {
	        logger.error("HTTP Client Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
	        try {
	            JSONObject errorBody = new JSONObject(e.getResponseBodyAsString());
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", errorBody.optString("message", "Client Error"));
	            responseJson.put("data", errorBody.opt("data"));
	        } catch (Exception parseEx) {
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", "Client Error");
	            responseJson.put("data", e.getResponseBodyAsString());
	        }

	    } catch (Exception e) {
	        logger.error("Unexpected Error", e);
	        responseJson.put("respcode", "500");
	        responseJson.put("respmsg", "Internal Server Error");
	        responseJson.put("data", e.getMessage());
	    }

	    return responseJson;
	}


	// Create Put Method Request service
	public JSONObject sendPutRequest(String jsonBody, String urlType, String params, String fieldName) {
	    JSONObject responseJson = new JSONObject();
	    try {
	        String apiKey = bundle.getString("API_KEY");
	        String url = bundle.getString(urlType).concat(params);
	        if (fieldName != null && !fieldName.isEmpty() && !fieldName.isBlank()) {
	            url = url + "/" + fieldName;
	        }

	        System.out.println("Final URL " + url);
	        logger.info("Embedly PATCH URL " + url + "\nApi Key: " + apiKey + "\nRequest: " + jsonBody);

	        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("x-api-key", apiKey);

	        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);

	        HttpStatusCode statusCode = response.getStatusCode();
	        int value = statusCode.value();
	        logger.info("Embedly Response Code: " + value);
	        System.out.println("Response Code: " + value);

	        if (response.getBody() == null) {
	            responseJson.put("respcode", "500");
	            responseJson.put("respmsg", "No response from Embedly service");
	            responseJson.put("data", JSONObject.NULL);
	            return responseJson;
	        }

	        JSONObject responseBody = new JSONObject(response.getBody());
	        if (value == 200) {
	            logger.info("Embedly Response Body: " + response.getBody());
	            responseJson.put("respcode", "00");
	            responseJson.put("respmsg", "SUCCESS");
	            responseJson.put("data", responseBody.opt("data"));
	        } else {
	            responseJson.put("respcode", String.valueOf(value));
	            responseJson.put("respmsg", responseBody.optString("message", "Failed"));
	            responseJson.put("data", responseBody.opt("data"));
	        }

	    } catch (HttpClientErrorException e) {
	        logger.error("HTTP Client Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
	        try {
	            JSONObject errorBody = new JSONObject(e.getResponseBodyAsString());
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", errorBody.optString("message", "Client Error"));
	            responseJson.put("data", errorBody.opt("data"));
	        } catch (Exception parseEx) {
	            responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
	            responseJson.put("respmsg", "Client Error");
	            responseJson.put("data", e.getResponseBodyAsString());
	        }

	    } catch (Exception e) {
	        logger.error("Unexpected Error", e);
	        responseJson.put("respcode", "500");
	        responseJson.put("respmsg", "Internal Server Error");
	        responseJson.put("data", e.getMessage());
	    }

	    return responseJson;
	}
	
	
	public JSONObject sendMultipartRequest(File file, String urlType, Map<String, String> formFields)  {
    JSONObject responseJson = new JSONObject();

    try {
        String apiKey = bundle.getString("API_KEY");
        String baseUrl = bundle.getString(urlType);

        logger.info("Uploading document to Third-Party API: {}\nFile: {}");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(file));

        if (formFields != null) {
            for (Map.Entry<String, String> entry : formFields.entrySet()) {
                body.add(entry.getKey(), entry.getValue());
            }
        }

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, entity, String.class);

        int statusCode = response.getStatusCodeValue();
        String bodyStr = response.getBody();

        logger.info("Third-Party Response Code: {}"+statusCode);
        logger.info("Third-Party Response Body: {}"+bodyStr);

        if (response.getBody() == null) {
            responseJson.put("respcode", "500");
            responseJson.put("respmsg", "No response from Embedly service");
            responseJson.put("data", JSONObject.NULL);
            return responseJson;
        }

        JSONObject responseBody = new JSONObject(response.getBody());
        if (statusCode == 200) {
            logger.info("Embedly Response Body: " + response.getBody());
            responseJson.put("respcode", "00");
            responseJson.put("respmsg", "SUCCESS");
            responseJson.put("data", responseBody.opt("data"));
        } else {
            responseJson.put("respcode", String.valueOf(statusCode));
            responseJson.put("respmsg", responseBody.optString("message", "Failed"));
            responseJson.put("data", responseBody.opt("data"));
        }

//        JSONObject responseBody = new JSONObject(bodyStr != null ? bodyStr : "{}");
//        responseJson.put("respcode", String.valueOf(statusCode));
//        responseJson.put("respmsg", responseBody.optString("message", "Success"));
//        responseJson.put("data", responseBody.opt("data"));

    } catch (HttpClientErrorException e) {
        logger.error("HTTP Client Error: {} - {}");
        responseJson.put("respcode", String.valueOf(e.getStatusCode().value()));
        responseJson.put("respmsg", e.getStatusText());
        responseJson.put("data", e.getResponseBodyAsString());
    } catch (Exception e) {
        logger.error("Unexpected Error while uploading document", e);
        responseJson.put("respcode", "500");
        responseJson.put("respmsg", "Internal Server Error");
        responseJson.put("data", e.getMessage());
    }

    return responseJson;
}

	
}
