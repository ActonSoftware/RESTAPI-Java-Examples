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
public class PutLogoExample
{
	static String BASE_URL         = "https://restapi.actonsoftware.com/api/1/";
	public static void main(String[] args)
		{
			putLogoUsingFile();
			putLogoUsingImageUrl();

		}

	public static void putLogoUsingImageUrl()
		{
		try
			{
			String imagelink = "<Provide image link url>";
			String id = "<Provide logo id>";
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<String> jsonResponse = Unirest.put(BASE_URL + "logo/"+id)
					.header("accept", "application/json")
					.field("name", "testapiputlogo")
					.field("imagelink", imagelink)
					.field("alttext", "testapiputalttext")
					.field("tooltip", "testapiputtooltip")
					.field("targeturl", "https://yahoo.com/")
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

	public static void putLogoUsingFile()
		{
		try
			{
			File file = new File("<Provide Logo image>");
			String id = "<Provide logo id>";
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<String> jsonResponse = Unirest.put(BASE_URL + "logo/"+id)
					.header("accept", "application/json")
					.field("name", "testapiputlogo2")
					.field("alttext", "testapiputalttext2")
					.field("tooltip", "testapiputtooltip2")
					.field("targeturl", "https://yahoo.com/")
					.field("file", file)
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
