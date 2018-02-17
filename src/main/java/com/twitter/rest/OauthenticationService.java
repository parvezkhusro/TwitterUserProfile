package com.twitter.rest;

import com.sun.jersey.api.view.Viewable;
import java.net.URI;
import com.twitter.service.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


@Path("/service")
public class OauthenticationService {	
	final static Logger log = Logger.getLogger(OauthenticationService.class);
	static TwitterService obj= null;
	@GET
	@Path("/signin")
	public Response Signin() {
		obj = new TwitterService();
		return Response.temporaryRedirect(obj.uri).build();
	}
	@GET
	@Path("/callback")
	@Produces("text/html")
	public Response Callback(@QueryParam("oauth_verifier") String oauth_verifier) throws Exception {
		obj.getAccessToken(oauth_verifier);
		URI uri1=new URI("http://localhost:8080/RESTfulExample/service/userdetails");
		return Response.temporaryRedirect(uri1).build();
	}
	 @GET
	 @Path("/welcome")
	 @Produces("text/html")
	 public Viewable index() {
	        return new Viewable("/index");

	 } 
	 @GET
	 @Path("/userdetails")
	 @Produces("text/html")
	 public Viewable profiledetails() {
	        return new Viewable("/profiledetails.html");

	 }   
	 
}