package content;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import util.Utility;

import java.io.File;

/**
 * Created by hemant on 18/09/14.
 */
public class PostMediaExample
{
	static String BASE_URL         = "https://restapi.actonsoftware.com/actonapi/1/";
	public static void main(String[] args)
		{
			postMedia();
		}

	public static void postMedia()
		{
		try
			{
			File file = new File("TestMedia.pdf");
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<JsonNode> jsonResponse = Unirest.post(BASE_URL + "media")
					.header("accept", "application/json")
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
