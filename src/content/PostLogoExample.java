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
	static String BASE_URL         = "https://restapi.actonsoftware.com/api/1/";
	public static void main(String[] args)
		{
				postLogoUsingFile();
				postLogoUsingImageUrl();
		}

	public static void postLogoUsingFile()
		{

		try
			{
			File file = new File("<Provide Logo image>");
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<String> jsonResponse = Unirest.post(BASE_URL + "logo")
					.header("accept", "application/json")
					.field("name", "testapipostlogo")
					.field("alttext", "testapialttext")
					.field("tooltip", "testapitooltip")
					.field("targeturl", "https://www.google.com/")
					.field("file", file)
					.asString();

			if(jsonResponse.getCode()==200){
				String jsonResponseBody = jsonResponse.getBody();
				System.out.println("The response body is : "+jsonResponseBody );
			}else {
				System.out.println("The response is : "+ jsonResponse.toString());
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
			String imagelink = "<Provide image link url>";
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<String> jsonResponse = Unirest.post(BASE_URL + "logo")
					.header("accept", "application/json")
					.field("name", "testapipostlogo2")
					.field("imagelink", imagelink)
					.field("alttext", "testapialttext2")
					.field("tooltip", "testapitooltip2")
					.field("targeturl", "https://www.google.com/")
					.asString();

			if(jsonResponse.getCode()==200){
				String jsonResponseBody = jsonResponse.getBody();
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
