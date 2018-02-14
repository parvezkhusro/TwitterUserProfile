package com.twitter.service;
import com.ftl.main.*;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterService {
	Twitter twitter;
	RequestToken requestToken;
	public URI uri;
	AccessToken accesstoken;
	User user;
	public TwitterService(){
		try {
		twitter = new TwitterFactory().getInstance();
		requestToken = twitter.getOAuthRequestToken();
 	    uri = new URI(requestToken.getAuthenticationURL()); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getAccessToken(String oauthVerifier) throws Exception{
		try {
			accesstoken=twitter.getOAuthAccessToken(requestToken, oauthVerifier);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		user = twitter.showUser(accesstoken.getScreenName());
		FtlConfig obj=new FtlConfig(user);
		
		return accesstoken.getScreenName();
	}
	
	public void createFe(String screenName, int followerCount) throws Exception{
		@SuppressWarnings("deprecation")
		Configuration cfg = new Configuration();

        // Where do we load the templates from:
		cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\divya\\Documents\\TwitterUserProfile\\templates\\"));

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // 2. Proccess template(s)
        //
        // You will do this for several times in typical applications.

        // 2.1. Prepare the template input:

        Map<String, String> input = new HashMap<String, String>();

        input.put("screenName", screenName);
        input.put("followerCount", Integer.toString(followerCount));

        
        // 2.2. Get the template

        Template template = cfg.getTemplate("profiledetails.ftl");

        // 2.3. Generate the output

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("C:\\Users\\divya\\Documents\\TwitterUserProfile\\src\\main\\webapp\\WEB-INF\\views" , "profiledetails.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }
	}
}
