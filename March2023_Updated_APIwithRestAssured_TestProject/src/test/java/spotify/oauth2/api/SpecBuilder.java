package spotify.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	//static String access_token="BQCilJcyoxD11T6XGD7Ywpwr_UVnb6WpegrS9yvgMjJJuEQGX-RmSFzV-rfjMLdNrwGU4Un-0J1-7UA4HQMSvqNUfcpNJ43_7dp22GZy4WqLp-sXeSMqX0lFP7inRMvEF7Z5LuhdCBqpXLryUjhNELf77uLITYVmD0aee-prgz9cRMvfUannttwy2azVK35bmCaYaeUBwjwE70Hh7kbfQSZaKMLJx5KauDp5SJRJRWRQ";
	
	 public static RequestSpecification  getRequestSpecBuilder() {
		        return new RequestSpecBuilder().
                setBaseUri("https://api.spotify.com").
                setBasePath(ConstantFile.BASE_PATH).
               // addHeader("Authorization","Bearer "+access_token).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
	         }
	
		 public static RequestSpecification  getpostRequestSpecBuilder() {
	        return new RequestSpecBuilder().
         setBaseUri("https://accounts.spotify.com").
        // setBasePath("/v1").
        // addHeader("Authorization","Bearer "+access_token).
         setContentType(ContentType.URLENC).
         log(LogDetail.ALL).
         build();
      }
	
	 public static ResponseSpecification getResponseSpecBuilder() {
		           return new ResponseSpecBuilder().
                   log(LogDetail.ALL).
                   build();
	          }
                }
