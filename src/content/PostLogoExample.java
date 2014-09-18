package content;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import util.Utility;

import java.io.File;

/**
 * Created by hemant on 17/09/14.
 */
public class PostLogoExample
{
	static String BASE_URL         = "https://restapi.actonsoftware.com/";
	public static void main(String[] args)
		{
				postLogoUsingFile();
				postLogoUsingImageUrl();
		}

	public static void postLogoUsingFile()
		{

		try
			{
			File file = new File("posttest.jpeg");
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<JsonNode> jsonResponse = Unirest.post(BASE_URL + "api/1/logo")
					.header("accept", "application/json")
					.field("name", "testpostlogo")
					.field("alttext", "examplealttext")
					.field("tooltip", "exampletooltip")
					.field("targeturl", "https://www.google.co.in/")
					.field("file", file)
					.asJson();

			if(jsonResponse.getCode()==200){
				JSONObject jsonResponseBody = jsonResponse.getBody().getObject();
				System.out.println("The response body is : "+jsonResponseBody );
			}else {
				System.out.println("The response is : "+ jsonResponse);
			}
			}
		catch (UnirestException e)
			{
			e.printStackTrace();
			}
		}

	public static void postLogoUsingImageUrl()
		{

		try
			{
			String imagelink = "http://www.gstatic.com/hostedimg/6d57e3f765338942_landing";
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<JsonNode> jsonResponse = Unirest.post(BASE_URL + "api/1/logo")
					.header("accept", "application/json")
					.field("name", "testfisle2")
					.field("imagelink", imagelink)
					.field("alttext", "altrr")
					.field("tooltip", "attaa")
					.field("targeturl", "https://www.google.co.in/")
					.asJson();

			if(jsonResponse.getCode()==200){
				JSONObject jsonResponseBody = jsonResponse.getBody().getObject();
				System.out.println("The response body is : "+jsonResponseBody );
			}else {
				System.out.println("The response is : "+ jsonResponse);
			}
			}
		catch (UnirestException e)
			{
			e.printStackTrace();
			}
		}

}
