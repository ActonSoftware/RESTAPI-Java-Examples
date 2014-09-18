package content;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import util.Utility;

/**
 * Created by hemant on 17/09/14.
 */
public class DeleteLogoExample
{
	static String BASE_URL         = "https://restapi.actonsoftware.com/";
	public static void main(String[] args)
		{
			deleteLogo();
		}

	public static void deleteLogo()
		{
		try
			{
			String accessToken  = Utility.getAccessToken();
			String id = "<Provide logo id>";
			Unirest.setHttpClient(Utility.makeClient());
			Unirest.setDefaultHeader("Authorization", "Bearer " + accessToken );
			HttpResponse<JsonNode> jsonResponse = Unirest.delete(BASE_URL + "api/1/logo/"+id)
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
