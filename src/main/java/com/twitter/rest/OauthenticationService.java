package com.twitter.rest;

import com.sun.jersey.api.view.Viewable;
import com.twitter.service.TwitterService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/service")
public class OauthenticationService {	
	static TwitterService obj=new TwitterService();
	@GET
	@Path("/signin")
	public Response Signin() {
		return Response.temporaryRedirect(obj.uri).build();
	}
	@GET
	@Path("/callback")
	@Produces("text/html")
	public Response Callback(@QueryParam("oauth_verifier") String oauth_verifier) throws Exception {
		obj.getAccessToken(oauth_verifier);
		return Response.ok(new Viewable("/profiledetails.html")).build();
	}
	 @GET
	 @Path("/welcome")
	 @Produces("text/html")
	 public Viewable index() {
	        return new Viewable("/index");

	 }   	
}