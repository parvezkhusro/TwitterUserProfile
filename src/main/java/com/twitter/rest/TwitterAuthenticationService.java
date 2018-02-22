package com.twitter.rest;

import com.sun.jersey.api.view.Viewable;
import com.twitter.utils.*;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

@Path("/service")
public class TwitterAuthenticationService {	
	final static Logger log = Logger.getLogger(TwitterAuthenticationService.class);
	static TwitterUtils twitterUtils= null;
	String screenName="";
	String userDetailsPage = " ";
	
	//This method shows starting webpage
	@GET
	@Path("/welcome")
	@Produces("text/html")
	public Viewable index() {
		 log.debug("Showing welcome webpage");
		 return new Viewable("/index");
	} 
	
	//This method redirects to twitter Authentication url
	@GET
	@Path("/signin")
	public Response Signin() {
		twitterUtils = new TwitterUtils();
		log.debug("Redirecting to Twitter Authentication URL");
		return Response.temporaryRedirect(twitterUtils.twitterAuthenticationURI).build();
	}
	
	/*This method calls the twitter accesstoken method by using parameter from call back url of twitter 
	and redirects page to userdetails webpage*/
	@GET
	@Path("/callback")
	@Produces("text/html")
	public Response Callback(@QueryParam("oauth_verifier") String oauth_verifier) throws Exception {
		screenName=twitterUtils.getAccessTokenAndScreenName(oauth_verifier);
		Properties prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("path.properties");
		prop.load(inputStream);
		log.debug("Redirecting to userdetails webpage");
		return Response.temporaryRedirect(new URI(prop.getProperty("userdetailspath"))).build();
	}
	 
	 @GET
	 @Path("/userdetails")
	 @Produces("text/html")
	 public String profiledetails() {
		 twitterUtils.getUserDetails(screenName);
		 log.debug("Showing userdetails webpage");
		 userDetailsPage=twitterUtils.getUserDetails(screenName);
		 return userDetailsPage;
	 }   
	    
}