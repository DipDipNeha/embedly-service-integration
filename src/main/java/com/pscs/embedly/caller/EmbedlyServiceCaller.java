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
			response = EmbedlyService.getInstance().registerIndiviualCustomer(request);
			break;
		case "GET_CUST_DETAILS":
			response = EmbedlyService.getInstance().getCustomerDetails(request);
			break;
		case "GET_ALL_CUST_DETAILS":
			response = EmbedlyService.getInstance().getAllCustomerDetails(request);
			break;
		case "UPDATE_CUST_NAME":
			response = EmbedlyService.getInstance().updateCustomerName(request);
			break;
		case "UPDATE_CUST_CONTACT":
			response = EmbedlyService.getInstance().updateCustomerContacts(request);
			break;
		case "GET_CUST_EKYC_PRO":
			response = EmbedlyService.getInstance().getCustEkycProperties(request);
			break;
		case "CUST_KYC_UPGRADE":
			response = EmbedlyService.getInstance().uploadCustomerDocument(request);
			break;
		case "CUST_PREMIUM_KYC":
			response = EmbedlyService.getInstance().premiumEkyc(request);
			break;
		case "CUST_ADDR_VERIFICATION":
			response = EmbedlyService.getInstance().addressVerification(request);
			break;
		case "GET_ALL_COUNTRY":
			response = EmbedlyService.getInstance().getAllCountry(request);
			break;
		case "GET_ALL_CUST_TYPE":
			response = EmbedlyService.getInstance().getAllCustomerType(request);
			break;
		case "GET_CURRENCY":
			response= EmbedlyService.getInstance().getAllCurrency(request);
			break;
		case "WAL_RESTRICTION_TYPE":
			response= EmbedlyService.getInstance().walletRestrictionType(request);
			break;
		case "WALLET_CLOSING_REASONS":
			response= EmbedlyService.getInstance().walletAccountClosingReason(request);
			break;	
		case "CREATE_WALLET":
			response = EmbedlyService.getInstance().createWallet(request);
			break;
		case "CREATE_CORP_CUST_WALLET":
			response = EmbedlyService.getInstance().createCorporateCustomerWallet(request);
			break;
		case "GET_WALLET_ID":
			response = EmbedlyService.getInstance().getWalletId(request);
			break;
		case "GET_WALLET_BY_AC_NUMBER":
			response = EmbedlyService.getInstance().getWalletByAccountNumber(request);
			break;
		case "WALLET_TO_WALLET_TRANSFER":
            response = EmbedlyService.getInstance().walletToWalletTransfer(request);
            break;
		case "GET_ORG_WALLET_TRANSACTIONS":
			response = EmbedlyService.getInstance().getOrgWalletTransactions(request);
			break;
		case "WALLET_TO_WALLET_REQUERY":
			response = EmbedlyService.getInstance().walletToWalletRequery(request);
			break;
		case "WALLET_HISTORY":
			response = EmbedlyService.getInstance().getWalletTransactionHistory(request);
			break;
		case "REVERSE_TRANSACTION":
			response = EmbedlyService.getInstance().reverseTransaction(request);
			break;
		case "CLOSE_WALLET_ACCOUNT":
			response = EmbedlyService.getInstance().closeWalletAccount(request);
			break;
		case "RESTRICT_WALLET_BY_ACCOUNT_ID":
			response = EmbedlyService.getInstance().restrictWalletByAccountId(request);
			break;
			
		default:
			response.put("status", "Unknown request type");
			break;
		}

		return response;
	}

}
