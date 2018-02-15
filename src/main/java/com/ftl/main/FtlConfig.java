package com.ftl.main;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.log4j.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import twitter4j.User;


public class FtlConfig {
	final static Logger log = Logger.getLogger(FtlConfig.class);
	public void Config_SendDataToFtl(User user){
		
	try {
		
		Configuration cfg = new Configuration();

		// Where do we load the templates from:
		cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\divya\\Pictures\\TwitterUserProfile\\templates\\"));

		// Some other recommended settings:
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		// 2. Proccess template(s)
		
		// You will do this for several times in typical applications.
		// 2.1. Prepare the template input:

		Map<String, String> input = new HashMap<String, String>();
		log.debug("profile image url\t"+user.getProfileImageURL()+"\nFollowers count\t"+
		user.getFollowersCount()+"\nFriends count\t"+user.getFriendsCount()+
		"\nFavourites count\t"+user.getFriendsCount()+"\ndescription\t"+user.getDescription()+
		"\nLocation\t"+user.getLocation()+"\nLanguage\t"+user.getLang()+"\nStatus\t"+
		user.getStatus()+"\nId\t"+user.getId()+"\naccesslevel\t"+user.getAccessLevel());
		input.put("profilepiclink", user.getOriginalProfileImageURL());
		input.put("name", user.getName());
		input.put("id", Long.toString(user.getId()));
		input.put("location", user.getLocation());
		input.put("language", user.getLang());
		input.put("status", user.getDescription());
		input.put("followersCount", Integer.toString(user.getFollowersCount()));
		input.put("friendsCount", Integer.toString(user.getFriendsCount()));
		input.put("tweetsCount", Integer.toString(user.getStatusesCount()));
		
		// 2.2. Get the template

		Template template = cfg.getTemplate("profiledetails.ftl");

		// 2.3. Generate the output

		// Write output to the console
		Writer consoleWriter = new OutputStreamWriter(System.out);
		template.process(input, consoleWriter);

		// For the sake of example, also write output into a file:
		Writer fileWriter = new FileWriter(new File("C:\\Users\\divya\\Pictures\\TwitterUserProfile\\src\\main\\webapp\\WEB-INF\\views" , "profiledetails.html"));
		try {
			template.process(input, fileWriter);
		} finally {
			fileWriter.close();
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
  }
}
