/**
 * @author Dipak
 */

package com.pscs.embedly.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.JSONObject;

import com.pscs.db.helper.ConnectionHelper;

public class TrackEmbedlyService {

	public static void main(String[] args) {

	}

	public void trackService(JSONObject request, JSONObject response) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.connectMySQL();
			String sql = "INSERT INTO EMBEDDLY_SER_TRACK_TBL (id,user_id,request_type,request_data,response_data,response_code,response_message,created_date) VALUES (?,?,?,?,?,?,?,NOW())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, System.currentTimeMillis() + "");
			pstmt.setString(2, request.getJSONObject("jheader").optString("userId"));
			pstmt.setString(3, request.getJSONObject("jheader").optString("requestType"));
			pstmt.setString(4, request.toString());
			pstmt.setString(5, response.toString());
			pstmt.setString(6, response.optString("responseCode"));
			pstmt.setString(7, response.optString("responseMessage"));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
