package com.twitter.rest;

import com.ftl.main.LoadingPropertyFile;
import com.sun.jersey.api.view.Viewable;
import com.twitter.utils.*;
import freemarker.template.TemplateException;
import twitter4j.TwitterException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
	String screenName=" ";
	String userDetailsPage = " ";
	LoadingPropertyFile propertyFile=null;
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
	public Response Signin() throws URISyntaxException{
		try {
			twitterUtils = new TwitterUtils();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		log.debug("Redirecting to Twitter Authentication URL");
		return Response.temporaryRedirect(twitterUtils.twitterAuthenticationURI).build();
	}
	
	/*This method calls the twitter accesstoken method by using parameter from call back url of twitter 
	and redirects page to userdetails webpage*/
	@GET
	@Path("/callback")
	@Produces("text/html")
	public Response Callback(@QueryParam("oauth_verifier") String oauth_verifier) throws URISyntaxException, IOException{
		try {
			screenName=twitterUtils.getAccessTokenAndScreenName(oauth_verifier);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		LoadingPropertyFile propertyFile=new LoadingPropertyFile();
		log.debug("Redirecting to userdetails webpage");
		log.debug("userdetailsPath"+propertyFile.userDetailsPath);
		return Response.temporaryRedirect(new URI(propertyFile.userDetailsPath)).build();
	}
	 
	 @GET
	 @Path("/userdetails")
	 @Produces("text/html")
	 public String profiledetails() throws TemplateException, IOException{
		 try {
			userDetailsPage=twitterUtils.getUserDetails(screenName);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		 log.debug("Showing userdetails webpage");
		 return userDetailsPage;
	 }   
	    
}