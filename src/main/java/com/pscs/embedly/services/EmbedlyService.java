/**
 * @author Dipak
 */

/**
 * 
 */
package com.pscs.embedly.services;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.pscs.embedly.helper.CoreConstant;
import com.pscs.embedly.posting.EmbedlyPostingService;

/**
 * 
 */
public class EmbedlyService {
	private static final Logger logger = Logger.getLogger(EmbedlyService.class);

	private EmbedlyService() {
	}

	private static class SingletonHelper {
		private static final EmbedlyService INSTANCE = new EmbedlyService();
	}

	public static EmbedlyService getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public JSONObject registerIndiviualCustomer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			
			response =	EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CREATE_INDI_CUSTOMER_URL");
			
			
			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}

		return response;
	}

	public JSONObject getCustomerDetails(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String customerId = jbody.getString("customerId");
			response =EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_CUSTOMER_DETAILS_URL",customerId );
			
			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}

		return response;
	}

}
