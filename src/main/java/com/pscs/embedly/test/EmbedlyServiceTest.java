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
//		test.updateContactDetails();
//		test.getCustEkycProperties();
//		test.customerKycUpgrade();
//		test.primiumEkyc();
//		test.custAddrVerification();
//		test.getAllCountry();
//		test.getAllCustType();
//		test.getCurrency() ;
//		test.getWalletRestrictionType();
//		test.getACClosingReasons();
//		test.walletCreation();
		//		test.createCorporateCustomerWallet();
				test.getWalletId();
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
			jbody.put("emailAddress", "kumardipak@example.com");
			jbody.put("mobileNumber", "+2348000000001");
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

            jbody.put("nin", "22222222222");
            jbody.put("customerId", "792c446e-9954-11f0-a7cf-0274f77d4a81");
            jbody.put("firstname", "Dipak");
            jbody.put("lastname", "Kumar Sharma");
            jbody.put("dob", "1990-05-15");
            request.put("jbody", jbody);
            System.out.println("Request " + request.toString());
            EmbedlyServiceCaller service = new EmbedlyServiceCaller();
            response = service.callService(request);
            System.out.println("Response " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
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
	
}
