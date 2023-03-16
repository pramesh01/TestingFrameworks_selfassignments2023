package spotify.oauth2.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import spotify.oauth2.pojo.Playlist;
import util.DataLoader;
import spotify.oauth2.api.SpecBuilder;
import spotify.oauth2.applicationapi.PlaylistApi;
import spotify.oauth2.pojo.Error;
import static org.hamcrest.MatcherAssert.*;

public class PlaylistTests {
	
	/*RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	String access_token="BQBKE-DLDYdCulqIOuAjDi8Baw_De-k_Ua8J3KMMz-WKDdPM09yV8I1b-vxMUJqvHHaS-G_vyD3LuV4IXGVGgDi-ICmQ_A-fG9gpO_1fdmxJX25sZ8YRGfsDULClYHHd_mlPvEhwqUREINxDiqeUNNF11GhQImhAlcGxdP8qwZeZ7-BoJWVAVt2vu2OVvsvehPMKyVVCTJ3UjAfRqWbApmOo0RZOEJwAZPZE-asWPnId";
	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder().
				                   setBaseUri("https://api.spotify.com").
				                   setBasePath("/v1").
				                   addHeader("Authorization","Bearer "+access_token).
				                   setContentType(ContentType.JSON).
	                               log(LogDetail.ALL);		
		requestSpecification=requestSpecBuilder.build();
		
		ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder().
				                                //expectContentType(ContentType.JSON).
				                                log(LogDetail.ALL);
		responseSpecification=responseSpecBuilder.build();
		
	}
	*/
	public Playlist playlistBuilder(String name,String description,boolean _public) {
		return new Playlist().
        setName(name).
        setDescription(description).
        setPublic(_public);
	    }
	public void assertPlaylistEquals(Playlist responsePlaylist,Playlist requestPlaylist) {
		assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
	    assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
		assertThat(responsePlaylist.getPublic(),equalTo(requestPlaylist.getPublic()));
	}
	
	public void assertStatusCode(int actualStatusCode,int expectedStatusCode) {
	       assertThat(actualStatusCode,equalTo(expectedStatusCode));	
	}
	
	public void errorAssert(Error errmsg,int code,String msg) {
		assertThat(errmsg.getError().getStatus(),equalTo(code));
		   assertThat(errmsg.getError().getMessage(),equalTo(msg));
	}
	@Test
	public void shouldbeabletoCreatePlaylist() {
		   
		Playlist requestPlaylist=playlistBuilder("new PlayList_AutomatedbyPramesh","new playlist description_ThroughAutomation",false);
		
		/*Playlist requestPlaylist=new Playlist().
				                 setName("new PlayList_AutomatedbyPramesh").
				                 setDescription("new playlist description_ThroughAutomation").
				                 setPublic(false);*/
		
		/*Playlist requestPlaylist=new Playlist();
		requestPlaylist.setName("new PlayList_AutomatedbyPramesh");
		requestPlaylist.setDescription("new playlist description_ThroughAutomation");
		requestPlaylist.setPublic(false);  */
		/*String payload="{\n"+
	                   "\"name\":\"new PlayList_AutomatedbyPramesh\",\n"+
				       "\"description\":\"new playlist description_ThroughAutomation\",\n"+    
	                   "\"public\":false \n"+
				       "}"; */
		    /*Playlist responsePlaylist= given(SpecBuilder.getRequestSpecBuilder()).
		     body(requestPlaylist).
		     when().
		     post("/users/kadt73tu7wjqxur2lmbe7gzpp/playlists"). 
		     then().spec(SpecBuilder.getResponseSpecBuilder()). 
		     assertThat().
		     statusCode(201). 
		     extract().
		     response().
		     as(Playlist.class);*/
		
		Response response=PlaylistApi.post(requestPlaylist);
		//assertThat(response.statusCode(),equalTo(201));
		assertStatusCode(response.statusCode(),201);
		//Playlist responsePlaylist=response.as(Playlist.class);
		
		assertPlaylistEquals(response.as(Playlist.class),requestPlaylist);

	/*assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
    assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
	assertThat(responsePlaylist.getPublic(),equalTo(requestPlaylist.getPublic()));*/
		    
		    
		     /*body("name",equalTo("new PlayList_AutomatedbyPramesh"),
		    		 "description",equalTo("new playlist description_ThroughAutomation"),
		    		 "public",equalTo(false)
		    		 ); */
	       }
	
	@Test
	public void shouldbeabletogetPlaylist() {
		
	Playlist requestPlaylist=playlistBuilder("new PlayList_AutomatedbyPramesh","new playlist description_ThroughAutomation",false);
		
	   /*	Playlist requestPlaylist=new Playlist().
				setName("new PlayList_AutomatedbyPramesh").
				setDescription("new playlist description_ThroughAutomation").
				setPublic(false);  */
		/*Playlist requestPlaylist=new Playlist();
		requestPlaylist.setName("new PlayList_AutomatedbyPramesh");
		requestPlaylist.setDescription("new playlist description_ThroughAutomation");
		requestPlaylist.setPublic(false);*/
		Response response=PlaylistApi.get(DataLoader.getInstance().getplaylistId());
		//assertThat(response.statusCode(),equalTo(200));
		//Playlist responsePlaylist=response.as(Playlist.class);
		 /*Playlist responsePlaylist=given(SpecBuilder.getRequestSpecBuilder()).
	     when().
	     get("/playlists/2KzzWegVBfPAL4kgKiGLtu"). 
	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
	     assertThat().
	     statusCode(200). 
	     extract().
	     response().
	     as(Playlist.class);  */
		assertStatusCode(response.statusCode(),200);
		//Playlist responsePlaylist=response.as(Playlist.class);
		
		assertPlaylistEquals(response.as(Playlist.class),requestPlaylist);
	    
/*assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
assertThat(responsePlaylist.getPublic(),equalTo(requestPlaylist.getPublic()));*/
	    
   /*body("name",equalTo("New Test Playlist_Pramesh"),
	    		 "description",equalTo("New playlist created by me in March 2022"),
	    		 "public",equalTo(false)
	    		 ); */
	}
	
	@Test
	public void updatePlaylist() {
		
		Playlist requestPlaylist=playlistBuilder("Pramesh Playlist updatedAgaainByPUT","i have updated Again it with PUT command",false);
		/*Playlist requestPlaylist=new Playlist().
				                 setName("Pramesh Playlist updatedAgaainByPUT").
				                 setDescription("i have updated Again it with PUT command").
				                 setPublic(false);  */
		/*Playlist requestPlaylist=new Playlist();
		requestPlaylist.setName("Pramesh Playlist updatedAgaainByPUT");
		requestPlaylist.setDescription("i have updated Again it with PUT command");
		requestPlaylist.setPublic(false);   */
		
		/* String payload="{\n"+
                "\"name\":\"Pramesh Playlist updatedByPUT\",\n"+
			       "\"description\":\"i have updated it with PUT command\",\n"+    
                "\"public\":false \n"+
			       "}";      */
		 /*given(SpecBuilder.getRequestSpecBuilder()).
	     body(requestPlaylist).
	     when().
	     put("/playlists/7i5dq3CY1ukHs75eaqVQLl"). 
	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
	     assertThat().
	     statusCode(200);    */
	     //extract().
	     //response().
	     //as(Playlist.class);
	    Response response=PlaylistApi.put(DataLoader.getInstance().updateplaylistID(), requestPlaylist);
	    //assertThat(response.statusCode(),equalTo(200));
	    assertStatusCode(response.statusCode(),200);
	    //assertPlaylistEquals(response.as(Playlist.class),requestPlaylist);
	    
//assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
//assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
//assertThat(responsePlaylist.getPublic(),equalTo(requestPlaylist.getPublic()));;
	   }
	@Test
	public void shouldnotbeabletocreatePlaylistwithoutName() {
		
		/* Playlist requestPlaylist=new Playlist().
				                 setName("").
				                 setDescription("without Name playlist").
				                 setPublic(false);*/
		
		Playlist requestPlaylist=playlistBuilder("","without Name playlist",false);
		
		/*requestPlaylist.setName("");
		requestPlaylist.setDescription("without Name playlist");
		requestPlaylist.setPublic(false);*/
		
		/*String payload="{\n"+
                "\"name\":\"\",\n"+
			       "\"description\":\"without Name playlist.\",\n"+    
                "\"public\":false \n"+
			       "}";  */
		
		Response response=PlaylistApi.post(requestPlaylist);
		assertThat(response.statusCode(),equalTo(400));
		//Error error=response.as(Error.class);
		
		
	    /* Error error=given(SpecBuilder.getRequestSpecBuilder()).
	     body(requestPlaylist).
	     when().
	     post("/users/kadt73tu7wjqxur2lmbe7gzpp/playlists"). 
	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
	     assertThat().
	     statusCode(400).
	     extract().
	     as(Error.class);   */
		errorAssert(response.as(Error.class),400,"Missing required field: name");
	  /* assertThat(error.getError().getStatus(),equalTo(400));
	   assertThat(error.getError().getMessage(),equalTo("Missing required field: name")); */
	   
	     
	    /* body("error.status",equalTo(400),
	    		 "error.message",equalTo("Missing required field: name")
	    		 ); */
	    }
	@Test
	public void shouldnotbeabletocreatewithwrongToken() {
		String invalid_Toen="12345";
		/*String payload="{\n"+
                "\"name\":\"test Palylist\",\n"+
			       "\"description\":\"without Name playlist.\",\n"+    
                "\"public\":false \n"+
			       "}";  */
		/*Playlist requestPlaylist=new Playlist().
				                setName("test Palylist").
				                setDescription("with invalid token check").
				                setPublic(false);*/
		
Playlist requestPlaylist=playlistBuilder("test Palylist","with invalid token check",false);
		
    /*requestPlaylist.setName("test Palylist");
	requestPlaylist.setDescription("with invalid token check");
	requestPlaylist.setPublic(false);*/
		
		Response response=PlaylistApi.post(invalid_Toen, requestPlaylist);
		//assertThat(response.statusCode(),equalTo(401));
		//Error error=response.as(Error.class);
		
	     /*Error error=given().
	          baseUri("https://api.spotify.com").
              basePath("/v1").
              header("Authorization","Bearer "+123415).
              contentType(ContentType.JSON).
              log().all().
	     body(requestPlaylist).
	     when().
	     post("/users/kadt73tu7wjqxur2lmbe7gzpp/playlists"). 
	     then().spec(SpecBuilder.getResponseSpecBuilder()). 
	     assertThat().
	     statusCode(401).
	     extract().
	     as(Error.class);  */
		errorAssert(response.as(Error.class),401,"Invalid access token");
	  // assertThat(error.getError().getStatus(),equalTo(401));
	   //assertThat(error.getError().getMessage(),equalTo("Invalid access token"));
	   
	    /* body("error.status",equalTo(401),
	    		 "error.message",equalTo("Invalid access token")
	    		 ); */ 
	       }
        }
