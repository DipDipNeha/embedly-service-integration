/**
 * @author Dipak
 */

/**
 * 
 */
package com.pscs.embedly.caller;

import org.json.JSONObject;

import com.pscs.embedly.db.TrackEmbedlyService;
import com.pscs.embedly.services.EmbedlyService;

/**
 * 
 */
public class EmbedlyServiceCaller {

	public JSONObject callService(JSONObject request) {

		JSONObject response = new JSONObject();
		try {
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
		case "RESTRICT_WALLET":
			response = EmbedlyService.getInstance().restrictWallet(request);
			break;
		case "GET_BANKS":
			response = EmbedlyService.getInstance().getAllBanks(request);
			break;
		case "BANK_AC_NAME_ENQUIRY":
			response = EmbedlyService.getInstance().bankAccountNameEnquiry(request);
			break;
		case "INTER_BANK_TRANSFER":
			response = EmbedlyService.getInstance().interBankTransfer(request);
			break;
		case "TXN_STATUS_REQUERY":
			response = EmbedlyService.getInstance().transactionStatusRequery(request);
			break;
		case "CREATE_NEW_PRODUCT":
			response = EmbedlyService.getInstance().createNewProduct(request);
			break;
		case "GET_ALL_PRODUCT":
			response = EmbedlyService.getInstance().getAllProducts(request);
			break;
		case "UPDATE_EXISTING_PRODUCT":
			response = EmbedlyService.getInstance().updateExistingProduct(request);
			break;
		case "ACTIVATE_PRODUCT_BY_ID":
			response = EmbedlyService.getInstance().activateProductById(request);
			break;
		case "DEACTIVATE_PRODUCT_BY_ID":
			response = EmbedlyService.getInstance().deactivateProductById(request);
			break;
		case "RETRIEVE_LIMIT_OF_PRODUCT_AND_CURRENCY":
			response = EmbedlyService.getInstance().retrieveLimitOfProductAndCurrency(request);
			break;
		case "LIMIT_FOR_CUSTOMER":
			response = EmbedlyService.getInstance().getLimitForCustomer(request);
			break;
		case "DEFAULT_TRANSACTION_LIMITS":
			response = EmbedlyService.getInstance().defaultTransactionLimits(request);
			break;
		case "ADD_LIMIT_CUSTOMER":
			response = EmbedlyService.getInstance().addLimitForCustomer(request);
			break;
		case "UPDATE_DEFAULT_TRANSACTION_LIMIT":
			response = EmbedlyService.getInstance().updateDefaultTransactionLimit(request);
			break;
		case "ADD_LIMIT_TO_EXISTING_PRODUCT":
			response = EmbedlyService.getInstance().addLimitToExistingProduct(request);
			break;
		case "CUSTOMER_LIMIT":
			response = EmbedlyService.getInstance().setCustomerLimits(request);
			break;
		case "GET_ORG_PREFIX_MAPPINGS":
			response = EmbedlyService.getInstance().getOrgPrefixMappings(request);
			break;
		case "CREATE_CHECKOUT_WALLET":
            response = EmbedlyService.getInstance().createCheckoutWallet(request);
            break;
		case "GET_CHECKOUT_WALLETS":
			response = EmbedlyService.getInstance().getCheckoutWallets(request);
			break;
		case "GET_CHECKOUT_WALLET_TRANSACTIONS":
			response = EmbedlyService.getInstance().getCheckoutWalletTransactions(request);
			break;
		case "ISSUE_AFRIGO_CARD":
			response = EmbedlyService.getInstance().issueAfrigoCard(request);
			break;
		case "ACTIVATE_AFRIGO_CARD":
			response = EmbedlyService.getInstance().activateAfrigoCard(request);
			break;
		case "UPDATE_AFRIGO_CARD_INFORMATION":
			response = EmbedlyService.getInstance().updateAfrigoCardInformation(request);
			break;
		case "MAP_PHYSICAL_AFRIGO_CARD_TO_CUSTOMER":
			response = EmbedlyService.getInstance().mapPhysicalAfrigoCardToCustomer(request);
			break;
			
		default:
			response.put("status", "Unknown request type");
			break;
		}
	} catch (Exception e) {
		e.printStackTrace();
		try {
			response.put("respCode", "96");
			response.put("respMessage", "System error:" + e.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		finally {
			// Track the service request and response
             TrackEmbedlyService trackService = new TrackEmbedlyService();
             trackService.trackService(request, response);
		}
		return response;
	}

}
