package spotify.oauth2.applicationapi;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import spotify.oauth2.RestResources.RestResource;
import spotify.oauth2.api.SpecBuilder;
import spotify.oauth2.api.Token_Manager;
import spotify.oauth2.api.ConstantFile;
import spotify.oauth2.pojo.Playlist;

public class PlaylistApi {
	
	//static String access_token="BQDwLoUrU0Fgve4qUiaQeDEUffDle4Wccs4i44zjoEVfHavnLyZSsU9lRmynoRYGrpswEmse9YcI6pOVu5Qy7mSUTRJCCuAYKShhpwRz0ayFIlLK1k-Tmwt4Z6i7niEf3B2KwVw5Uy17rWTuURmKQd2R6zmeTVe0UoFFLk-JPZ4p4lPduKJg5ELbYjHnFHolrq1ZNDjJxmt4eRjKJ48VrDlpXp0BxAMurrj2MpLcUtPh";
	
	public static Response post(Playlist requestPlaylist) {
		return RestResource.post(ConstantFile.USERS+"/kadt73tu7wjqxur2lmbe7gzpp"+ConstantFile.PLAYLISTS, Token_Manager.getnewToken(), requestPlaylist);
		/*return given(SpecBuilder.getRequestSpecBuilder()).
	     body(requestPlaylist).
	     header("Authorization","Bearer "+access_token).
	     when().
	     post("/users/kadt73tu7wjqxur2lmbe7gzpp/playlists"). 
	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
	     extract().
	     response();*/
	     	}
	
	public static Response post(String invalid_token,Playlist requestPlaylist) {
		return RestResource.post(ConstantFile.USERS+"/kadt73tu7wjqxur2lmbe7gzpp"+ConstantFile.PLAYLISTS,invalid_token, requestPlaylist);
		/*return given(SpecBuilder.getRequestSpecBuilder()).
	     body(requestPlaylist).
	     header("Authorization","Bearer "+invalid_token).
	     when().
	     post("/users/kadt73tu7wjqxur2lmbe7gzpp/playlists"). 
	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
	     extract().
	     response();*/
	     	}
	
      public static Response get(String playlistID) {
    	  return RestResource.get(ConstantFile.PLAYLISTS+"/"+playlistID, Token_Manager.getnewToken());
    	             /*return given(SpecBuilder.getRequestSpecBuilder()).
    	    		 header("Authorization","Bearer "+access_token).
    			     when().
    			     get("/playlists/"+playlistID). 
    			     then().spec(SpecBuilder.getResponseSpecBuilder()). 
    			     extract().
    			     response();*/
    			     }
      
     
        public static Response put(String playlistID,Playlist requestPlaylist) {
    	  return RestResource.put(ConstantFile.PLAYLISTS+"/"+playlistID, Token_Manager.getnewToken(), requestPlaylist);
    	
    	  /*return given(SpecBuilder.getRequestSpecBuilder()).
    			 header("Authorization","Bearer "+access_token).
 	     body(requestPlaylist).
 	     when().
 	     put("/playlists/"+playlistID). 
 	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
 	     extract().
 	     response();*/
        }
          }
