/**
 * @author Dipak
 */

/**
 * 
 */
package com.pscs.embedly.test;

import java.util.UUID;

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
//		 test.getCustomerDetails();
//		test.getCustomerAllDetails();
//		test.updateCustomerName();
		test.updateContactDetails();
//		test.getCustEkycProperties();// check customer ekyc status
//		test.customerKycUpgrade(); //nin
//		test.primiumEkyc();  //BVN
//		test.custAddrVerification();
//		test.getAllCountry();
//		test.getAllCustType();
//		test.getCurrency() ;
//		test.getWalletRestrictionType();
//		test.getACClosingReasons();
//		test.walletCreation();
		//		test.createCorporateCustomerWallet();
//				test.getWalletId();   ///view wallet balance by walletId
//				test.getWalletByAcNumber();
//				test.walletToWalletTransfer();
		//		test.getOrgWalletTransactions();
//				test.walletToWalletRequery();
//				test.walletHistory();
		//		test.reverseTransaction();
		//		test.closeWalletAccount();
//		        test.restrictWalletByAccountId();
//		test.restrictWallet();
		
		//Payout
//		test.getBanks();      
//		test.bankAccountNameEnquiry();
//		test.interBankTransfer();
//		test.transactionStatusReQuery();
//		test.createNewProduct();
//		test.getAllProduct();
//		test.updateExistingProduct();
//		test.activateProductById();
//		test.deactivateProductById();
//		test.retrieveLimitOfProductAndCurrency();
//		test.limitForCustomer();
//		test.defaultTransactionLimits();
//		test.addLimitCustomer();
//		test.updateDefaultTransactionLimit();
//		test.addLimitToExistingProduct();
//		test.getOrgPrefixMappings();
		
//		test.createCheckoutWallet();
//		test.getCheckoutWallets();
//		test.getCheckoutWalletTransactions();
//		test.activateAfrigoCard();
		
		
		
		
		
		

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
			jbody.put("firstName", "Samson");
			jbody.put("lastName", "Jabo");
			jbody.put("middleName", "Kumar");
			jbody.put("emailAddress", "kumardipakkl@example.com");
			jbody.put("mobileNumber", "+2348000000003");
			jbody.put("dob", "1990-05-15");
			jbody.put("customerTypeId", "f671da57-e281-4b40-965f-a96f4205405e");
			jbody.put("address", "123 MG Road, Sector 45");
			jbody.put("city", "Lagos");
			jbody.put("countryId", "c15ad9ae-c4d7-4342-b70f-de5508627e3b");
			jbody.put("alias", "samson");
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

			jbody.put("customerId", "792c446e-9954-11f0-a7cf-0274f77d4a81");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getCustomerAllDetails() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_ALL_CUST_DETAILS");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// update Customer Name

	public void updateCustomerName() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "UPDATE_CUST_NAME");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("organizationId", "6ca322f8-9547-11f0-a7cf-0274f77d4a81");
			jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("firstName", "Chinedu");
			jbody.put("lastName", "Okafor");
			jbody.put("middleName", "Ifeanyi");
			jbody.put("dob", "1990-05-15");
			jbody.put("city", "Lagos");
			jbody.put("address", "12 Adeola Street, Ikeja");
			jbody.put("occupation", "Software Engineer");
			jbody.put("gender", "Male");
			jbody.put("bvnVerified", true);
			jbody.put("ninVerified", true);
			jbody.put("bvn", "22134567890");
			jbody.put("nin", "A123456789");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//update contact details
	public void updateContactDetails() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "UPDATE_CUST_CONTACT");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("organizationId", "6ca322f8-9547-11f0-a7cf-0274f77d4a81");
			jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("mobileNumber", "+916301655736");
			jbody.put("emailAddress", "dipak@gmail.com");
			

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//get customer ekyc 
	public void getCustEkycProperties() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_CUST_EKYC_PRO");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("customerId", "15974cb2-a90a-11f0-a7cf-0274f77d4a81");
			

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Customer KYC Upgrade-nin
	public void customerKycUpgrade() {
        try {
            JSONObject request = new JSONObject();
            JSONObject response = new JSONObject();
            JSONObject jheader = new JSONObject();

            jheader.put("userid", "dipak");
            jheader.put("ip", "133243dsf");
            jheader.put("timestamp", "1234353454");
            jheader.put("requestType", "CUST_KYC_UPGRADE");
            jheader.put("channel", "ADMIN");
            request.put("jheader", jheader);

            JSONObject jbody = new JSONObject();

            jbody.put("nin", "63184876213");
            jbody.put("customerId", "792c446e-9954-11f0-a7cf-0274f77d4a81");
            jbody.put("firstname", "Bunchu");
            jbody.put("lastname", "Dillon");
            jbody.put("dob", "1991-08-17");
            request.put("jbody", jbody);
            System.out.println("Request " + request.toString());
            EmbedlyServiceCaller service = new EmbedlyServiceCaller();
            response = service.callService(request);
            System.out.println("Response " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//premium ekyc - bvn
	public void primiumEkyc() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "CUST_PREMIUM_KYC");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("customerId", "6828b59b-9955-11f0-a7cf-0274f77d4a81");
			jbody.put("bvn", "22222222222");
			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Customer Address Verification (Tier 3 upgrade)
	public void custAddrVerification() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "CUST_ADDR_VERIFICATION");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("meterNumber", "1234567890");
			jbody.put("houseAddress", "Lagos");
			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getAllCountry() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_ALL_COUNTRY");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getAllCustType() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_ALL_CUST_TYPE");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//wallet creation service 
	public void getCurrency() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_CURRENCY");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getWalletRestrictionType() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "WAL_RESTRICTION_TYPE");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getACClosingReasons() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "WALLET_CLOSING_REASONS");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void walletCreation() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "CREATE_WALLET");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();
            //unique id generate
			 UUID id = UUID.randomUUID();
			 
//			jbody.put("id", id.toString());
//			jbody.put("walletGroupId", id.toString());
			jbody.put("customerId", "6828b59b-9955-11f0-a7cf-0274f77d4a81");
//			jbody.put("availableBalance", 0);
//			jbody.put("ledgerBalance", 0);
//			jbody.put("walletRestrictionId", "3fa68c68-4203-4487-a56f-222b128a9b56");
//			jbody.put("walletClassificationId", "1");
			jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
//			jbody.put("isInternal", true);
//			jbody.put("isDefault", true);
			jbody.put("name", "Samson Jabo");
//			jbody.put("overdraft", 0);
//			jbody.put("mobNum", "+919876543210");
//			jbody.put("customerTypeId", "f671da57-e281-4b40-965f-a96f4205405e");
			

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	//create corporate customer wallet
	public void createCorporateCustomerWallet() {
		try {
            JSONObject request = new JSONObject();
            JSONObject response = new JSONObject();
            JSONObject jheader = new JSONObject();

            jheader.put("userid", "dipak");
            jheader.put("ip", "133243dsf");
            jheader.put("timestamp", "1234353454");
            jheader.put("requestType", "CREATE_CORP_CUST_WALLET");
            jheader.put("channel", "ADMIN");
            request.put("jheader", jheader);

            JSONObject jbody = new JSONObject();
            //unique id generate
            jbody.put("customerId", "792c446e-9954-11f0-a7cf-0274f77d4a81");
            jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
            jbody.put("name", "Primary Wallet");
            

            request.put("jbody", jbody);
            System.out.println("Request " + request.toString());
            EmbedlyServiceCaller service = new EmbedlyServiceCaller();
            response = service.callService(request);
            System.out.println("Response " + response.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	//get walletId
	public void getWalletId() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_WALLET_ID");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("walletId", "ea9a5cb9-9955-11f0-a7cf-0274f77d4a81");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//get wallet by account Number 
	public void getWalletByAcNumber() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_WALLET_BY_AC_NUMBER");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("accountNumber", "9710007990");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//wallet to wallet transfer
	public void walletToWalletTransfer() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "WALLET_TO_WALLET_TRANSFER");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("fromAccount", "1234567890");
			jbody.put("toAccount", "0987654321");
			jbody.put("amount", 1000);
			jbody.put("transactionReference", "TXN"+System.currentTimeMillis());
			jbody.put("remarks", "Test transfer");
			jbody.put("transactionTypeId", 1);
			
			
			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Get Organization Wallet Transactions
	public void getOrgWalletTransactions() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_ORG_WALLET_TRANSACTIONS");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			  jbody.put("customerId", "b1f5e6d2-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("startDate", "1");
			jbody.put("endDate", "12");
			jbody.put("onlyOrganization", true);
			jbody.put("pageNumber", 1);
			jbody.put("pageSize", 10);

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//wallet to waller Requery
	public void walletToWalletRequery() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "WALLET_TO_WALLET_REQUERY");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("transactionReference", "TXN1677054323457");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Wallet History 
	public void walletHistory() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "WALLET_HISTORY");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("customerId", "792c446e-9954-11f0-a7cf-0274f77d4a81");
			jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("walletId", "ea9a5cb9-9955-11f0-a7cf-0274f77d4a81");
			jbody.put("from", "2023-12-31");
			jbody.put("to", "2025-12-31");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Reverse Transaction
	public void reverseTransaction() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "REVERSE_TRANSACTION");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("transactionReference", "TXN1677054323457");
			jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// close wallet account
	public void closeWalletAccount() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "CLOSE_WALLET_ACCOUNT");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("walletId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("accountClosureReasonId", 134);
			jbody.put("tellerId", 134);
			jbody.put("accountNumber", "1234567890");
			jbody.put("closeOrDelete", true);
			jbody.put("customerOrAccount", true);

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// restrictWalletByAccountId 
	public void restrictWalletByAccountId() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "RESTRICT_WALLET_BY_ACCOUNT_ID");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("accountId", "1234567890");
			jbody.put("restrictionType", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Restrict Wallet
	public void restrictWallet() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "RESTRICT_WALLET");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();
//			
//				  "id": "<string>",
//				  "walletGroupId": "<string>",
//				  "customerId": "<string>",
//				  "availableBalance": 123,
//				  "ledgerBalance": 123,
//				  "walletRestrictionId": "<string>",
//				  "walletClassificationId": "<string>",
//				  "currencyId": "<string>",
//				  "isInternal": true,
//				  "isDefault": true,
//				  "name": "<string>",
//				  "overdraft": 123,
//				  "virtualAccount": {},
//				  "mobNum": "<string>",
//				  "customerTypeId": "<string>"
			 UUID id = UUID.randomUUID();
			jbody.put("id", id.toString());
			jbody.put("walletGroupId",id.toString());
			jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
			jbody.put("availableBalance", 0);
			jbody.put("ledgerBalance", 0);
			jbody.put("walletRestrictionId", "3fa68c68-4203-4487-a56f-222b128a9b56");
			jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
			jbody.put("isInternal", true);
			jbody.put("isDefault", true);
			jbody.put("name", "Primary Wallet");
			jbody.put("overdraft", 0);
			jbody.put("mobNum", "+919876543210");
			jbody.put("customerTypeId", "f671da57-e281-4b40-965f-a96f4205405e");
			
			
			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// payout service from here 
	//Get Banks
	public void getBanks() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "GET_BANKS");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Bank Account Name Enquiry
	public void bankAccountNameEnquiry() {
		try {
			JSONObject request = new JSONObject();
			JSONObject response = new JSONObject();
			JSONObject jheader = new JSONObject();

			jheader.put("userid", "dipak");
			jheader.put("ip", "133243dsf");
			jheader.put("timestamp", "1234353454");
			jheader.put("requestType", "BANK_AC_NAME_ENQUIRY");
			jheader.put("channel", "ADMIN");
			request.put("jheader", jheader);

			JSONObject jbody = new JSONObject();

			jbody.put("accountNumber", "1234567890");
			jbody.put("bankCode", "001");

			request.put("jbody", jbody);
			System.out.println("Request " + request.toString());
			EmbedlyServiceCaller service = new EmbedlyServiceCaller();
			response = service.callService(request);
			System.out.println("Response " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Inter Bank Transfer
public void interBankTransfer() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "INTER_BANK_TRANSFER");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

        jbody.put("destinationBankCode", "001");
        jbody.put("destinationAccountNumber", "1234567890");
        jbody.put("destinationAccountName", "John Doe");
        jbody.put("sourceAccountNumber", "9710007990");
        jbody.put("sourceAccountName", "Jane Smith");
        jbody.put("remarks", "Test transfer");
        jbody.put("amount", 5000);
        jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
        jbody.put("customerTransactionReference", "TXN"+System.currentTimeMillis());
        jbody.put("webhookUrl", "https://example.com/webhook");
        
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//Transaction Status Re-Query
public void transactionStatusReQuery() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "TXN_STATUS_REQUERY");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

        jbody.put("transactionRef", "TXN1677054323457");

        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	
//Create new product
public void createNewProduct() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "CREATE_NEW_PRODUCT");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("name", "Samson");
        jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("description", "Standard savings account");
        jbody.put("direction", "C");
        jbody.put("isActive", true);
        
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
// get all product
public void getAllProduct() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "GET_ALL_PRODUCT");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//Update existing Product
public void updateExistingProduct() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "UPDATE_EXISTING_PRODUCT");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("id", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
        jbody.put("name", "Samson Jabo");
        jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("description", "Premium savings account");
        jbody.put("direction", "C");
        jbody.put("isActive", true);
        
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	//Activate Product by its ID
public void activateProductById() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "ACTIVATE_PRODUCT_BY_ID");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
        
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Deactivate Product by its ID
public void deactivateProductById() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "DEACTIVATE_PRODUCT_BY_ID");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
        
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Retrieve Limit of a product and Currency
public void retrieveLimitOfProductAndCurrency() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "RETRIEVE_LIMIT_OF_PRODUCT_AND_CURRENCY");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

     jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
     jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
     jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
     jbody.put("singleTransactionLimit", 100000);
     jbody.put("frequency", 5);
     jbody.put("dailyTransactionLimit", 500000);
     jbody.put("monthlyTransactionLimit", 2000000);
     jbody.put("id", "6828b59b-9955-11f0-a7cf-0274f77d4a81");
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Limit for Customer
public void limitForCustomer() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "LIMIT_FOR_CUSTOMER");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

     jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
     jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
     jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Default transaction limits
public void defaultTransactionLimits() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "DEFAULT_TRANSACTION_LIMITS");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Limit Customer
public void addLimitCustomer() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "ADD_LIMIT_CUSTOMER");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

     jbody.put("id", "6828b59b-9955-11f0-a7cf-0274f77d4a81");
     jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
     jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
     jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
     jbody.put("singleTransactionLimit", 100000);
     jbody.put("frequency", 5);
     jbody.put("dailyTransactionLimit", 500000);
     jbody.put("monthlyTransactionLimit", 2000000);
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }}

//Update default transaction limit
public void updateDefaultTransactionLimit() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "UPDATE_DEFAULT_TRANSACTION_LIMIT");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

     jbody.put("id", "6828b59b-9955-11f0-a7cf-0274f77d4a81");
     jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
     jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
     jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
     jbody.put("singleTransactionLimit", 150000);
     jbody.put("frequency", 10);
     jbody.put("dailyTransactionLimit", 700000);
     jbody.put("monthlyTransactionLimit", 2500000);
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Add Limit to existing Product
public void addLimitToExistingProduct() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "ADD_LIMIT_TO_EXISTING_PRODUCT");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

     jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
     jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
     jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
     jbody.put("singleTransactionLimit", 100000);
     jbody.put("frequency", 5);
     jbody.put("dailyTransactionLimit", 500000);
     jbody.put("monthlyTransactionLimit", 2000000);
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Customer Limit
//The endpoint allows you to add limits for a specific customer.
public void customerLimit() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "CUSTOMER_LIMIT");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

     jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
     jbody.put("productId", "5df5e2b2-99b3-11f0-a7cf-0274f77d4a81");
     jbody.put("currencyId", "fd5e474d-bb42-4db1-ab74-e8d2a01047e9");
     jbody.put("singleTransactionLimit", 100000);
     jbody.put("frequency", 5);
     jbody.put("dailyTransactionLimit", 500000);
     jbody.put("monthlyTransactionLimit", 2000000);
     jbody.put("id", "6828b59b-9955-11f0-a7cf-0274f77d4a81");
     
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Get Organization Prefix Mappings
public void getOrgPrefixMappings() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "GET_ORG_PREFIX_MAPPINGS");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("page",1);
        jbody.put("pageSize",10);
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//Create Checkout Wallet
public void createCheckoutWallet() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "CREATE_CHECKOUT_WALLET");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("expectedAmount", 1500);
        jbody.put("organizationPrefixMappingId", "b1f5e6d2-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("expiryDurationMinutes", 60);
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Get checkout wallets
public void getCheckoutWallets() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "GET_CHECKOUT_WALLETS");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("page","1");
        jbody.put("pageSize","10");
        jbody.put("startDate","2023-01-01");
        jbody.put("endDate","2024-12-31");
        jbody.put("status","ACTIVE");
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//Get checkout wallet transactions
public void getCheckoutWalletTransactions() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "GET_CHECKOUT_WALLET_TRANSACTIONS");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();
        jbody.put("walletId","e9a5cb9-9955-11f0-a7cf-0274f77d4a81");
        jbody.put("organizationId","a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("page", "1");
        jbody.put("pageSize", "10");
     
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Issue Afrigo Card
public void issueAfrigoCard() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "ISSUE_AFRIGO_CARD");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

        jbody.put("accountNumber", "1234567890");
        jbody.put("pickupMethod", "DELIVERY");
        jbody.put("cardType", "VIRTUAL");
        jbody.put("idType", "NATIONAL_ID");
        jbody.put("idNo", "A12345678");
        jbody.put("email", "dipak@gmail.com");
        jbody.put("address", "123 Main St, City, Country");
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Activate Afrigo Card
public void activateAfrigoCard() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "ACTIVATE_AFRIGO_CARD");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

        jbody.put("cardNumber", "1234567890123456");
        jbody.put("accountNumber", "12/25");
        jbody.put("pin", "1234");
        
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Update Afrigo Card Information
public void updateAfrigoCardInformation() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "UPDATE_AFRIGO_CARD_INFORMATION");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

        jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("walletId", "e9a5cb9-9955-11f0-a7cf-0274f77d4a81");
        jbody.put("cardNumber", "1234567890123456");
        jbody.put("nameOnCard", "John Doe");
        jbody.put("oldMobile", "+919876543210");
        jbody.put("newMobile", "+919876543211");
        jbody.put("email", "dipak@gmail.com");
        jbody.put("address", "123 Main St, City, Country");
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Map Physical Afrigo Card to Customer
public void mapPhysicalAfrigoCardToCustomer() {
    try {
        JSONObject request = new JSONObject();
        JSONObject response = new JSONObject();
        JSONObject jheader = new JSONObject();

        jheader.put("userid", "dipak");
        jheader.put("ip", "133243dsf");
        jheader.put("timestamp", "1234353454");
        jheader.put("requestType", "MAP_PHYSICAL_AFRIGO_CARD_TO_CUSTOMER");
        jheader.put("channel", "ADMIN");
        request.put("jheader", jheader);

        JSONObject jbody = new JSONObject();

        jbody.put("customerId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        jbody.put("accountNumber", "1234567890");
        jbody.put("cardNumber", "1234567890123456");
        jbody.put("organizationId", "a8f4cd75-9629-11f0-a7cf-0274f77d4a81");
        request.put("jbody", jbody);
        System.out.println("Request " + request.toString());
        EmbedlyServiceCaller service = new EmbedlyServiceCaller();
        response = service.callService(request);
        System.out.println("Response " + response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//
}
