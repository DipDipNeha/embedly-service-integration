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
//			logger.info("Header " + jheader.toString());
//			logger.info("Body " + jbody.toString());
			logger.info("Service Request  " + request);
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CREATE_INDI_CUSTOMER_URL",
					"");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			logger.info("Service Response  " + response);

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			logger.error("Service Error  " + response.toString());
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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			logger.info("Response " + response.toString());

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
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
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
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(), "UPDATE_CONTACTS_URL",
					jbody.getString("customerId"), "updatecontact");

			System.out.println("Response " + response.toString());
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			logger.info("Response " + response.toString());
			System.out.println("Response " + response.toString());
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
			String nin = jbody.getString("nin");
			String params = "?customerId=" + customerId + "&nin=" + nin;

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CUST_KYC_UPGRADE_URL",
					params);
			System.out.println("Response " + response.toString());
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_ALL_COUNTRY_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_CURRENCY_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"WALLET_CLOSING_REASONS_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CREATE_WALLET_URL", "");

			logger.info("Response " + response.toString());
			System.out.println("Response " + response.toString());
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

		} catch (Exception e) {
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
			String params = customerId + "/wallets";
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"CREATE_CORP_CUST_WALLET_URL", params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

		} catch (Exception e) {
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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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
			String customerId = jbody.getString("customerId");

			String params = "?customerId=" + customerId + "&startDate=" + startDate + "&endDate=" + endDate
					+ "&pageSize=" + pageSize + "&pageNumber=" + paeNumber + "&onlyOrganization=" + onlyOrganization;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_ORG_WALLET_TRANSACTIONS_URL", params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}

	// Wallet to Wallet Requery
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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}

	// Wallet History
	public JSONObject getWalletTransactionHistory(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "WALLET_HISTORY_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CLOSE_WALLET_ACCOUNT_URL",
					"");
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	// Restrict by AccountID
	public JSONObject restrictWalletByAccountId(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

//			{accountId}/type/{restrictionType}
			String accountId = jbody.getString("accountId");
			String restrictionType = jbody.getString("restrictionType");
			String params = params = accountId + "/type/" + restrictionType;
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"RESTRICT_WALLET_BY_ACCOUNT_ID_URL", params, "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

		} catch (Exception e) {
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
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

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
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject createNewProduct(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "CREATE_NEW_PRODUCT_URL",
					"");
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject getAllProducts(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_ALL_PRODUCT_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject updateExistingProduct(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
//			String productId = jbody.getString("productId");
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"UPDATE_EXISTING_PRODUCT_URL", "", "");
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject activateProductById(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String productId = jbody.getString("productId");
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"ACTIVATE_PRODUCT_BY_ID_URL", productId, "");
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();

		}

		return response;
	}

	public JSONObject deactivateProductById(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String productId = jbody.getString("productId");
			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"DEACTIVATE_PRODUCT_BY_ID_URL", productId, "");
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();

		}
		return response;
	}

	public JSONObject retrieveLimitOfProductAndCurrency(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String productId = jbody.getString("productId");
			String currencyId = jbody.getString("currencyId");
			String params = productId + "/currency/" + currencyId;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"RETRIEVE_LIMIT_OF_PRODUCT_AND_CURRENCY_URL", params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}

		return response;
	}

	public JSONObject getLimitForCustomer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String customerId = jbody.getString("customerId");
//        {productId}/currency/{currencyId}/customer/{customerId}
			String productId = jbody.getString("productId");
			String currencyId = jbody.getString("currencyId");
			String params = productId + "/currency/" + currencyId + "/customer/" + customerId;

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "LIMIT_FOR_CUSTOMER_URL",
					params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject defaultTransactionLimits(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"DEFAULT_TRANSACTION_LIMITS_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject addLimitForCustomer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"ADD_LIMIT_FOR_CUSTOMER_URL", "", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject updateDefaultTransactionLimit(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"UPDATE_DEFAULT_TRANSACTION_LIMIT_URL", "", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject addLimitToExistingProduct(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(),
					"ADD_LIMIT_TO_EXISTING_PRODUCT_URL", "", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject setCustomerLimits(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPatchRequest(jbody.toString(), "CUSTOMER_LIMIT_URL", "",
					"");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject getOrgPrefixMappings(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String organizationId = jbody.getString("organizationId");
			int pageNumber = jbody.getInt("page");
			int pageSize = jbody.getInt("pageSize");
			String params = "?organizationId=" + organizationId + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize;
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_ORG_PREFIX_MAPPINGS_URL", params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject createCheckoutWallet(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"CREATE_CHECKOUT_WALLET_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject getCheckoutWallets(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String page = jbody.getString("page");
			String size = jbody.getString("pageSize");
			String startDate = jbody.getString("startDate");
			String endDate = jbody.getString("endDate");
			String status = jbody.getString("status");
			String params = "?page=" + page + "&pageSize=" + size + "&startDate=" + startDate + "&endDate=" + endDate
					+ "&status=" + status;

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_CHECKOUT_WALLET_URL",
					params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject getCheckoutWalletTransactions(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String walletId = jbody.getString("walletId");
			String organizationId = jbody.getString("organizationId");
			String page = jbody.getString("page");
			String size = jbody.getString("pageSize");
			String params = walletId + "/transactions?organizationId=" + organizationId + "&page=" + page + "&pageSize="
					+ size;

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_CHECKOUT_WALLET_TXN_URL", params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
			return response;
		}
		return response;
	}

	public JSONObject issueAfrigoCard(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "ISSUE_AFRIGO_CARD_URL",
					"");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject activateAfrigoCard(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(), "ACTIVATE_AFRIGO_CARD_URL",
					"");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject updateAfrigoCardInformation(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"UPDATE_AFRIGO_CARD_INFORMATION_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject mapPhysicalAfrigoCardToCustomer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"MAP_PHYSICAL_AFRIGO_CARD_TO_CUSTOMER_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject createCorporateUser(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			System.out.println("Body" + jbody.toString());
			logger.info("Service Request :" + request.toString());
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"CREATE_CORPORATE_USER_URL", "");

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}
			logger.info("Service Response :" + response.toString());
			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();

		}
		return response;
	}

	public JSONObject getCorporateUsers(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String customerId = jbody.getString("customerId");

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(), "GET_CORPORATE_USERS_URL",
					customerId);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject updateCorporateCustDetails(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

			String customerId = jbody.getString("customerId");

			response = EmbedlyPostingService.getInstance().sendPutRequest(jbody.toString(),
					"UPDATE_CORPORATE_CUST_DETAILS_URL", "", customerId);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject addDirectorToCorporateCustomer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

//			{customerId}/directors
			String customerId = jbody.getString("customerId");
			String params = customerId + "/directors";

			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"ADD_DIRECTOR_TO_CORPORATE_CUSTOMER_URL", params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject getCorporateCustomerDirectors(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String customerId = jbody.getString("customerId");
//            {customerId}/directors/{directorId}
			String directorId = jbody.getString("directorId");
			String params = customerId + "/directors";

			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_CORPORATE_CUSTOMER_DIRECTORS_URL", params);
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);

			}
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();

		}
		return response;
	}

	public JSONObject getAllDirectorsOfCorporateCustomer(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String customerId = jbody.getString("customerId");
			String params = customerId + "/directors";
//            {customerId}/directors
			response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
					"GET_ALL_DIRECTORS_OF_CORPORATE_CUSTOMER_URL", params);
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);

			}
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return response;
	}

	public JSONObject updateCorporateCustomerDirector(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());
			String customerId = jbody.getString("customerId");
			String directorId = jbody.getString("directorId");
			String params = customerId + "/directors/" + directorId;
			response = EmbedlyPostingService.getInstance().sendPutRequest(jbody.toString(),
					"UPDATE_CORPORATE_CUSTOMER_DIRECTOR_URL", params, "");
			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);

			}
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();

		}
		return response;
	}

	public JSONObject uploadCorporateCustomerDocuments(JSONObject request) {
		JSONObject response = new JSONObject();
		try {
			JSONObject jheader = request.getJSONObject("jheader");
			JSONObject jbody = request.getJSONObject("jbody");
			logger.info("Header " + jheader.toString());
			logger.info("Body " + jbody.toString());

//			{customerId}/documents
			String customerId = jbody.getString("customerId");
			String params = customerId + "/documents";
			response = EmbedlyPostingService.getInstance().sendPostRequest(jbody.toString(),
					"UPLOAD_CORPORATE_CUSTOMER_DOCUMENTS_URL", params);

			if (response.getString("respcode").equals("00")) {
				response.put("respCode", CoreConstant.SUCCESS_CODE);
				response.put("respMessage", CoreConstant.SUCCESS);
			} else {
				response.put("respCode", CoreConstant.FAILED);
				response.put("respMessage", CoreConstant.ERROR);
			}

			return response;
		} catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject updateCorporateCustomerDocuments(JSONObject request) {
		
		JSONObject response = new JSONObject();
		try {
            JSONObject jheader = request.getJSONObject("jheader");
            JSONObject jbody = request.getJSONObject("jbody");
            logger.info("Header " + jheader.toString());
            logger.info("Body " + jbody.toString());
//            {customerId}/documents
            String customerId = jbody.getString("customerId");
            String params = customerId + "/documents";
            response = EmbedlyPostingService.getInstance().sendPutRequest(jbody.toString(),
                    "UPDATE_CORPORATE_CUSTOMER_DOCUMENTS_URL", params, "");
            if (response.getString("respcode").equals("00")) {
            	                response.put("respCode", CoreConstant.SUCCESS_CODE);
                response.put("respMessage", CoreConstant.SUCCESS);
            } else {
                response.put("respCode", CoreConstant.FAILED);
                response.put("respMessage", CoreConstant.ERROR);
            }
            return response;
		}catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
            
		return response;
	}

	public JSONObject getCorporateCustomerDocuments(JSONObject request) {

		JSONObject response = new JSONObject();
		try {
            JSONObject jheader = request.getJSONObject("jheader");
            JSONObject jbody = request.getJSONObject("jbody");
            logger.info("Header " + jheader.toString());
            logger.info("Body " + jbody.toString());
//            {customerId}/documents
            String customerId = jbody.getString("customerId");
            String params = customerId + "/documents";
            response = EmbedlyPostingService.getInstance().sendGetRequest(jbody.toString(),
                    "GET_CORPORATE_CUSTOMER_DOCUMENTS_URL", params);
            if (response.getString("respcode").equals("00")) {
            	                response.put("respCode", CoreConstant.SUCCESS_CODE);
                response.put("respMessage", CoreConstant.SUCCESS);
            } else {
                response.put("respCode", CoreConstant.FAILED);
                response.put("respMessage", CoreConstant.ERROR);
            }
            return response;
		}catch (Exception e) {
			response.put("respCode", CoreConstant.FAILED);
			response.put("respMessage", CoreConstant.ERROR);
			e.printStackTrace();
		}
            
		return response;
	}

}
