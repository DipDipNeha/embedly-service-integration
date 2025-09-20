/**
 * @author Dipak
 */

/**
 * 
 */
package com.pscs.embedly.test;

import org.json.JSONObject;

import com.pscs.embedly.caller.EmbedlyServiceCaller;

/**
 * 
 */
public class EmbedlyServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EmbedlyServiceTest test = new EmbedlyServiceTest();
//		test.createCustomer();
		test.getCustomerDetails();
		
	}

	// Create Customer
	public void createCustomer() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "REGISTER");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);
			
			
			JSONObject jbody = new JSONObject();

			jbody.put("organizationId", "6ca322f8-9547-11f0-a7cf-0274f77d4a81");
			jbody.put("firstName", "Rahul");
			jbody.put("lastName", "Sharma");
			jbody.put("middleName", "Kumar");
			jbody.put("emailAddress","rahul.sharma@example.com");
			jbody.put("mobileNumber", "+919876543210");
			jbody.put("dob", "1990-05-15");
			jbody.put("customerTypeId", "f671da57-e281-4b40-965f-a96f4205405e");
			jbody.put("address", "123 MG Road, Sector 45");
			jbody.put("city", "Bengaluru");
			jbody.put("countryId", "c15ad9ae-c4d7-4342-b70f-de5508627e3b");
			jbody.put("alias", "rahul90");
			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void getCustomerDetails() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_CUST_DETAILS");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);
			
			
			JSONObject jbody = new JSONObject();

			jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
		
			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
