package com.doc.online.utilties;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MCIIndiaService {

	private String regNumber;
	private String council;

	public MCIIndiaService(String regNumber, String council) {
		this.regNumber = regNumber;
		this.council = council;
	}

	public String getDoctors() {
		String docName = null;
		String urlString = "https://mciindia.org/MCIRest/open/getDataFromService?service=searchDoctor";
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(urlString);
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("registrationNo", regNumber);
			request.setEntity(new StringEntity(jsonObject.toString()));
			System.out.println("REQUEST : " + request.getEntity());
			HttpResponse response = httpClient.execute(request);
			String result = EntityUtils.toString(response.getEntity());
			docName = findTheDoctor(result);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return docName;
	}

	public String findTheDoctor(String response) throws JSONException {
		String docName = null;
		JSONObject object = new JSONObject("{\"data\":" + response + "}");
		JSONArray jsonArray = object.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if(jsonObject.getString("smcName").contains(council)) {
				docName = jsonObject.getString("firstName");
				break;
			}
		}
		System.out.println("DOC NAME : "+docName);
		return docName;
	}

	public static void main(String[] args) {
		MCIIndiaService mciIndiaService = new MCIIndiaService("43413", "Travancore");
		mciIndiaService.getDoctors();
	}

}
