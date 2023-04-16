package com.example.spring.demo.config;

import com.example.spring.demo.config.beans.DbCredential;
import com.example.spring.demo.config.beans.DbCredentialTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.env.EnvironmentPostProcessorApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class ConfigApplication
{

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

	//Spring expression language
	@Value("${my.greeting.message}")
	private String greeting;

    @Value("Hello My Static Message")
	private String staticMessage;

	@Value("${my.greeting.default : default message}")
	private String defaultGreeting;

	@Value("${my.language}")
	private List<String> languages;

	@Value("#{${my.credential}}")
	private Map<String,String> credentials;

	@Autowired
	private DbCredential dbCredential;

	@Autowired
	private DbCredentialTest dbCredentialTest;
	@Autowired
	Environment environment;


	@RequestMapping("/")
    public String getMyGreeting()
	{
		return greeting;
	}
	@RequestMapping("/defaultGreeting")
	public String getMyDefaultGreeting()
	{
		return defaultGreeting;
	}
	@RequestMapping("/languages")
	public List<String> getLanguages()
	{
		return languages;
	}

	@RequestMapping("/credentials")
	public Map<String,String> getMyCredentials()
	{
		return credentials;
	}
	@RequestMapping("/db-credentials-test")
	public DbCredentialTest getMyDbCredentialsTest()
	{
		return dbCredentialTest;
	}

	@RequestMapping("/db-credentials")
	public DbCredential getMyDbCredentials()
	{
		return dbCredential;
	}

	@RequestMapping("/environmental-variable")
	public String getMyEnvironment()
	{
		return environment.toString();
	}

}
