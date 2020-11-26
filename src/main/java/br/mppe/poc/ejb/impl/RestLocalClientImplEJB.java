package br.mppe.poc.ejb.impl;

import java.io.File;

import javax.ejb.Stateless;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import br.mppe.poc.ejb.definition.RestLocalClient;

@Stateless
public class RestLocalClientImplEJB implements RestLocalClient{

	private String urlRest = "http://localhost:8080/poc/v1/protocolarAcao/";
	
	@Override
	public String ProtocolarAcao(String nomeAcao, String file) {
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost postRequest = new HttpPost(urlRest+nomeAcao+"/");
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addBinaryBody("file", new File(file),ContentType.APPLICATION_OCTET_STREAM,"file");
		HttpEntity entity = builder.build();
		postRequest.setEntity(entity);
		
		try {
		
			CloseableHttpResponse response = client.execute(postRequest);
			client.close();
			return String.valueOf(response.getStatusLine().getStatusCode());
		}
		catch(Exception ex) {
			return ex.getMessage();
		}
		
	}
	
}
