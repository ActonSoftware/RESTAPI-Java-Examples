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
				getMediaById();
		}

	public static void getMediaById()
		{
		try
			{
			String accessToken  = Utility.getAccessToken();
			System.out.println("The accessToken is : "+accessToken);
			String id = "f-09f5";
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken);
			HttpResponse<JsonNode> jsonResponse = Unirest.get(BASE_URL+"media/"+id)
					.header("accept", "application/json")
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
