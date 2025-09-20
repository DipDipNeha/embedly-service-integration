/**
 * @author Dipak
 */

/**
 * 
 */
package com.pscs.embedly.caller;

import org.json.JSONObject;

import com.pscs.embedly.services.EmbedlyService;

/**
 * 
 */
public class EmbedlyServiceCaller {
	
	public JSONObject callService(JSONObject request) {

		JSONObject response = new JSONObject();
		response.put("respCode", "99");
		response.put("respMessage", "Invalid request");
		
		String requestType = request.getJSONObject("jheader").getString("requestType");
		
		switch (requestType) {
		case "REGISTER":
			response =EmbedlyService.getInstance().registerIndiviualCustomer(request);
			break;
		case "GET_CUST_DETAILS":
			response= EmbedlyService.getInstance().getCustomerDetails(request);
			break;
		default:
			response.put("status", "Unknown request type");
			break;
		}
		
		return response;
	}

}
