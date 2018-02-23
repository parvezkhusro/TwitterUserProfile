package com.twitter.utils;

import com.ftl.main.*;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.log4j.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterUtils{
	final static Logger log = Logger.getLogger(TwitterUtils.class);
	Twitter twitter;
	RequestToken requestToken;
	AccessToken accessToken;
	User user;
	FtlConfig ftlConfig;
	public URI twitterAuthenticationURI;
	public TwitterUtils() throws TwitterException, URISyntaxException{
		twitter = new TwitterFactory().getInstance();
		requestToken = twitter.getOAuthRequestToken();
		twitterAuthenticationURI = new URI(requestToken.getAuthenticationURL()); 	
		ftlConfig=new FtlConfig();
	}
	public String getAccessTokenAndScreenName(String oauthVerifier) throws TwitterException{
		log.debug("Calling twitter4j api method for getting accesstoken");
		accessToken=twitter.getOAuthAccessToken(requestToken,oauthVerifier);	
		return accessToken.getScreenName();
	}
	public String getUserDetails(String screenName) throws TwitterException, IOException, TemplateException {
		log.debug("Calling twitter4j api method for getting user profile details using screen name of user");
		user = twitter.showUser(accessToken.getScreenName());
		return ftlConfig.ftlConfigurationAndSettingUserDataToFtlPage(user);
	}
}