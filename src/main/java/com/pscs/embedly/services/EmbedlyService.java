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

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"CREATE_INDI_CUSTOMER_URL","");

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
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_CUSTOMER_DETAILS_URL",
					customerId);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}

		return response;
	}

	public JSONObject getAllCustomerDetails(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_ALL_CUSTOMER_DETAILS_URL", "");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}
		return response;
	}

	public JSONObject updateCustomerName(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"UPDATE_CUSTOMER_NAME_URL", jbody.getString("customerId"), "updatename");
			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject updateCustomerContacts(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"UPDATE_CONTACTS_URL", jbody.getString("customerId"), "updatecontact");
			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
		}

	public JSONObject getCustEkycProperties(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String customerId = jbody.getString("customerId");
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_CUST_EKYC_URL",
					customerId);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}

		return response;
		
	}

	public JSONObject uploadCustomerDocument(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			
			String customerId = jbody.getString("customerId");
			String nin=jbody.getString("nin");
			String params="?customerId="+customerId+"&nin="+nin;
			
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CUST_KYC_UPGRADE_URL",params);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}
		return response;
	}

	public JSONObject premiumEkyc(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			String customerId = jbody.getString("customerId");
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CUST_PREMIUM_KYC_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject addressVerification(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			String customerId = jbody.getString("customerId");
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"CUST_ADDR_VERIFICATION_URL", "");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject getAllCountry(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			 response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_ALL_COUNTRY_URL", "");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject getAllCustomerType(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_ALL_CUST_TYPE_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject getAllCurrency(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_CURRENCY_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}
	public JSONObject walletRestrictionType(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "WAL_RESTRICTION_TYPE_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}
	public JSONObject walletAccountClosingReason(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "WALLET_CLOSING_REASONS_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject createWallet(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			String customerId = jbody.getString("customerId");
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"CREATE_WALLET_URL", "");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			
			
		}catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject createCorporateCustomerWallet(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
            JSONObject jbody = request.getJSONObject("jbody");
            logger.info("Header " + jheader.toString());
            logger.info("Body " + jbody.toString());

            String customerId = jbody.getString("customerId");
            String params=customerId+"/wallets";
            response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
                    "CREATE_CORP_CUST_WALLET_URL", params);

            response.put("respCode", CoreConstant.SUCCESS_CODE);
            response.put("respMessage", CoreConstant.SUCCESS);
		}
		catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject getWalletId(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String walletId = jbody.getString("walletId");
			String params = walletId;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_WALLET_ID_URL",
					params);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}
		return response;
	}

	public JSONObject getWalletByAccountNumber(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String accountNumber = jbody.getString("accountNumber");
			String params = accountNumber;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_WALLET_BY_ACCOUNT_NUMBER_URL", params);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
		}
		return response;
	}

	public JSONObject walletToWalletTransfer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"WALLET_TO_WALLET_TRANSFER_URL", "");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject getOrgWalletTransactions(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			boolean onlyOrganization = jbody.getBoolean("onlyOrganization");
			String startDate = jbody.getString("startDate");
			String endDate = jbody.getString("endDate");
			String pageSize = jbody.getString("pageSize");
			String paeNumber = jbody.getString("pageNumber");
			String customerId= jbody.getString("customerId");
			
			String params="?customerId="+customerId+"&startDate="+startDate+"&endDate="+endDate+"&pageSize="+pageSize+"&pageNumber="+paeNumber+"&onlyOrganization="+onlyOrganization;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_ORG_WALLET_TRANSACTIONS_URL", params);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}
	//Wallet to Wallet Requery
	public JSONObject walletToWalletRequery(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String transactionId = jbody.getString("transactionId");
			String params = transactionId;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"WALLET_TO_WALLET_REQUERY_URL", params);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}
	//Wallet History
	public JSONObject getWalletTransactionHistory(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "WALLET_HISTORY_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}
	// Reverse Transaction
	public JSONObject reverseTransaction(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "REVERSE_TRANSACTION_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}
	// Close Wallet
	public JSONObject closeWalletAccount(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String walletId = jbody.getString("walletId");
			String params = walletId;
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"CLOSE_WALLET_ACCOUNT_URL", "");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}
	//Restrict by AccountID
	public JSONObject restrictWalletByAccountId(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			
//			{accountId}/type/{restrictionType}
			String accountId=jbody.getString("accountId");
			String restrictionType=jbody.getString("restrictionType");
			String params =params=accountId+"/type/"+restrictionType;
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"RESTRICT_WALLET_BY_ACCOUNT_ID_URL", params,"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject restrictWallet(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(), "RESTRICT_WALLET_URL", "",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject getAllBanks(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_BANKS_URL", "");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
		
	}

	public JSONObject bankAccountNameEnquiry(JSONObject request) {
	JSONObject response = new JSONObject();
	try {
		JSONObject jheader = request.getJSONObject("jheader");
		JSONObject jbody = request.getJSONObject("jbody");
		logger.info("Header " + jheader.toString());
		logger.info("Body " + jbody.toString());
		response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "BANK_AC_NAME_ENQUIRY_URL",
				"");

		response.put("respCode", CoreConstant.SUCCESS_CODE);
		response.put("respMessage", CoreConstant.SUCCESS);
		
	}catch (Exception e) {
		response.put("respCode", CoreConstant.FAILED);
		response.put("respMessage", CoreConstant.ERROR);
		e.printStackTrace();
		return response;
	}
		return response;
	}

	public JSONObject interBankTransfer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "INTER_BANK_TRANSFER_URL",
					"");

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject transactionStatusRequery(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String transactionId = jbody.getString("transactionRef");
			String params = transactionId;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "TXN_STATUS_REQUERY_URL",
					params);

			response.put("respCode", CoreConstant.SUCCESS_CODE);
			response.put("respMessage", CoreConstant.SUCCESS);
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}
	
}
