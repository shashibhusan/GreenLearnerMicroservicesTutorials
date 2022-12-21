package com.patel.ProfileDemoApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvDetails {
	@Value("${app.server.name}")
	private String name;
	@Value("${app.server.detail}")
	private String detail;
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUser;
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	public EnvDetails() {
		
		System.out.println(" ");
	}


	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Override
    public String toString() {
        return "EnvDetails{" +
        		"  name='" + name + '\'' +
        		"  name='" + detail + '\'' +
                "  dbUrl='" + dbUrl + '\'' +
                ", dbUser='" + dbUser + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                '}';
    }
	
	
}