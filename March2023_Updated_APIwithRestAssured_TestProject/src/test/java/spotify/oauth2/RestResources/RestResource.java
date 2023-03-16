package spotify.oauth2.RestResources;

import static io.restassured.RestAssured.given;
import static spotify.oauth2.api.SpecBuilder.getResponseSpecBuilder;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import spotify.oauth2.api.SpecBuilder;
import spotify.oauth2.pojo.Playlist;

public class RestResource {
	

	public static Response post(String path,String token,Object requestPlaylist) {
		return given(SpecBuilder.getRequestSpecBuilder()).
	     body(requestPlaylist).
	     header("Authorization","Bearer "+token).
	     when().
	     post(path). 
	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
	     extract().
	     response();
	     	}
	
      public static Response get(String path,String token) {
    	    return given(SpecBuilder.getRequestSpecBuilder()).
    	    		header("Authorization","Bearer "+token).
    			     when().
    			     get(path). 
    			     then().spec(SpecBuilder.getResponseSpecBuilder()). 
    			     extract().
    			     response();
    			     }
      
      public static Response put(String path,String token,Object requestPlaylist) {
    	  return given(SpecBuilder.getRequestSpecBuilder()).
    	     		 header("Authorization","Bearer "+token).
 	     body(requestPlaylist).
 	     when().
 	     put(path). 
 	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
 	     extract().
 	     response();
        }
      public static Response postaccount(HashMap<String,String> formParams) {
    	  return given(SpecBuilder.getpostRequestSpecBuilder()).
          //baseUri("https://accounts.spotify.com").
         // contentType(ContentType.URLENC).
          formParams(formParams). 
         // log().all().
          when().
          post("/api/token").
          then().
          spec(getResponseSpecBuilder()).
          extract().
          response();
      }
        }

