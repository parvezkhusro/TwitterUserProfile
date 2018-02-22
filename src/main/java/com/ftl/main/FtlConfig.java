package com.ftl.main;

import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import twitter4j.User;

public class FtlConfig {
	final static Logger log = Logger.getLogger(FtlConfig.class);
	public String ftlConfigurationAndSettingUserDataToFtlPage(User user){	
		Properties prop = new Properties();
		InputStream inputStream = null;
		String Result="";
		try {
			log.debug("Configuring ftl templates");
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			inputStream = classLoader.getResourceAsStream("path.properties");
			prop.load(inputStream);
			Configuration cfg = new Configuration();
			//Setting path of templates
			log.debug("Template path-->"+prop.getProperty("templatepath"));
			cfg.setDirectoryForTemplateLoading(new File(prop.getProperty("templatepath")));
			cfg.setIncompatibleImprovements(new Version(2, 3, 20));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setLocale(Locale.US);
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			//Preparing the template input:
			Map<String, String> input = new HashMap<String, String>();
			input.put("profilepiclink", user.getOriginalProfileImageURL());
			input.put("name", user.getName());
			input.put("location", user.getLocation());
			input.put("status", user.getDescription());
			input.put("followersCount", Integer.toString(user.getFollowersCount()));
			input.put("friendsCount", Integer.toString(user.getFriendsCount()));
			input.put("tweetsCount", Integer.toString(user.getStatusesCount()));
			//Getting the template
			Template template = cfg.getTemplate("profiledetails.ftl");
			Writer out_result = new StringWriter();
			template.process(input, out_result);
			Result=out_result.toString();
		}
		catch(Exception e) {
				e.printStackTrace();
		}
		return Result;
	}
}