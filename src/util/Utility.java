package util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.juddi.v3.client.mapping.MockSSLSocketFactory;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public class Utility
{
	static String BASE_URL         = "https://restapi.actonsoftware.com/";
	static String ACTON_USERNAME     = "<Username>";
	static String ACTON_PASSWORD     = "<Password>";
	static String CLIENT_ID     = "<Client_ID>";
	static String CLIENT_SECRET     = "<Client_Secret>";

	public static String getAccessToken() throws UnirestException
		{
		Unirest.setHttpClient(makeClient());
		HttpResponse jsonResponse = Unirest.post(BASE_URL + "token")
				.header("accept", "application/json")
				.field("grant_type", "password")
				.field("username", ACTON_USERNAME)
				.field("password", ACTON_PASSWORD)
				.field("client_id", CLIENT_ID)
				.field("client_secret", CLIENT_SECRET)
				.asJson();
		return ((JsonNode)jsonResponse.getBody()).getObject().getString("access_token");
		}

	public static HttpClient makeClient()
		{
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		try
			{
			schemeRegistry.register(new Scheme("https", 443, new MockSSLSocketFactory()));
			}
		catch (KeyManagementException e)
			{
			e.printStackTrace();
			}
		catch (UnrecoverableKeyException e)
			{
			e.printStackTrace();
			}
		catch (NoSuchAlgorithmException e)
			{
			e.printStackTrace();
			}
		catch (KeyStoreException e)
			{
			e.printStackTrace();
			}
		ClientConnectionManager cm = new SingleClientConnManager(schemeRegistry);
		DefaultHttpClient httpclient = new DefaultHttpClient(cm);
		return httpclient;
		}
}
