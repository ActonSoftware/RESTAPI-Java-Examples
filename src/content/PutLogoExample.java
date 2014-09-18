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
	static String BASE_URL         = "https://restapi.actonsoftware.com/";
	public static void main(String[] args)
		{
			putLogoUsingFile();
			putLogoUsingImageUrl();

		}

	public static void putLogoUsingImageUrl()
		{
		try
			{
			String imagelink = "http://www.gstatic.com/hostedimg/58dd96b6262d32ce_large";
			// provide logoid
			String id = "<Provide Logo Id>";
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<JsonNode> jsonResponse = Unirest.put(BASE_URL + "api/1/logo/"+id)
					.header("accept", "application/json")
					.field("name", "testfilcqce2")
					.field("imagelink", imagelink)
					.field("alttext", "aewqltrr")
					.field("tooltip", "atctaa")
					.field("targeturl", "https://in.yahoo.com/")
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

	public static void putLogoUsingFile()
		{
		try
			{
			File file = new File("puttest.jpeg");
			// provide logoid
			String id = "<Provide Logo Id>";
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<JsonNode> jsonResponse = Unirest.put(BASE_URL + "api/1/logo/"+id)
					.header("accept", "application/json")
					.field("name", "testfile")
					.field("alttext", "newalttext")
					.field("tooltip", "newtooltip")
					.field("targeturl", "https://in.yahoo.com/")
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

}
