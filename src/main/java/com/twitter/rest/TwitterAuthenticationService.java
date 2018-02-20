package com.twitter.rest;

import com.sun.jersey.api.view.Viewable;
import com.twitter.utils.*;

import java.net.URI;

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
	URI userDetailsURI=null;
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
		twitterUtils.getAccessToken(oauth_verifier);
		userDetailsURI=new URI("http://localhost:8080/TwitterUserProfile/service/userdetails");
		log.debug("Redirecting to userdetails webpage");
		return Response.temporaryRedirect(userDetailsURI).build();
	}
	 
	 @GET
	 @Path("/userdetails")
	 @Produces("text/html")
	 public Viewable profiledetails() {
		 log.debug("Showing userdetails webpage");
	     return new Viewable("/profiledetails.html");
	 }   
}