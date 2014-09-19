package content;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import util.Utility;

/**
 * Created by hemant on 18/09/14.
 */
public class GetMediaExample
{
	static String BASE_URL         = "https://restapi.actonsoftware.com/api/1/";
	public static void main(String[] args)
		{
				getMedia();
				getMediaById();
		}

	public static void getMedia()
		{
		try
			{
			String accessToken  = Utility.getAccessToken();
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<String> jsonResponse = Unirest.get(BASE_URL+"media")
					.header("accept", "application/json")
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

	public static void getMediaById()
		{
		try
			{
			String accessToken  = Utility.getAccessToken();
			String id = "<Provide media id>";
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<String> jsonResponse = Unirest.get(BASE_URL+"media/"+id)
					.header("accept", "application/json")
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
