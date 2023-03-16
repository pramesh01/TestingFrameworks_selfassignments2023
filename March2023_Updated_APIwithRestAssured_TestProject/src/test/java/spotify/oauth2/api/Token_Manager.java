package spotify.oauth2.api;
import static io.restassured.RestAssured.*;
import java.time.Instant;
import java.util.HashMap;
import static spotify.oauth2.api.SpecBuilder.getResponseSpecBuilder;
import  util.ConfigLoader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import spotify.oauth2.RestResources.RestResource;
public class Token_Manager {
	
	private static String access_token;
	 private static Instant expiry_time;
	
	public static String getnewToken() {
		try {
			if(access_token==null || Instant.now().isAfter(expiry_time))
			{
				System.out.println("token has been expired , Renewing it automatically.");
				Response response=Refresh_Token();
				access_token=response.path("access_token");
				int durationofexpiry=response.path("expires_in");
				expiry_time=Instant.now().plusSeconds(durationofexpiry-100);
			}
			else {
				System.out.println("Go ahead with the token .it is good to Use.");
			}
		}catch(Exception e) {
			throw new RuntimeException("Abort ! failed to achieve the new token.");
		}
		return access_token;
	}
	
	public static Response Refresh_Token() {
		HashMap<String,String> formParams=new HashMap<String,String>();
		formParams.put("client_id",ConfigLoader.getInstance().getClientId());
		formParams.put("client_secret",ConfigLoader.getInstance().getSecret());
		formParams.put("grant_type",ConfigLoader.getInstance().getGrantType());
		formParams.put("refresh_token",ConfigLoader.getInstance().getRefreshToken());
		
		/*Response response=given().
				          baseUri("https://accounts.spotify.com").
				          contentType(ContentType.URLENC).
				          formParams(formParams). 
				          log().all().
				          when().
				          post("/api/token").
				          then().
				          spec(getResponseSpecBuilder()).
				          extract().
				          response();*/
		Response response=RestResource.postaccount(formParams);
		
		if(response.statusCode() != 200) {
			throw new RuntimeException("Abort ! Renew token failed");
		}
		//return response.path("access_token");
		return response;	
	}
}
