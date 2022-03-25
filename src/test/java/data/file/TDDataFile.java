package data.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TDDataFile{
	
	private String username;
	private String password;
	private String globalError;
	private String emptyUserError;
	private String emptyPassError;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getglobalError() {
		return globalError;
	}

	public void setglobalError(String globalError) {
		this.globalError = globalError;
	}
	
	public String getEmptyUserError() {
		return emptyUserError;
	}

	public void setEmptyUserError(String emptyUserError) {
		this.emptyUserError = emptyUserError;
	}
	
	public String getEmptyPassError() {
		return emptyPassError;
	}

	public void setEmptyPassError(String emptyPassError) {
		this.emptyPassError = emptyPassError;
	}
	
	public void DataFetch() throws IOException {
		FileInputStream dataFetch = new FileInputStream("D:\\Testing\\tdProperties.properties");
		Properties dataProp = new Properties();
		dataProp.load(dataFetch);
		
		 username= dataProp.getProperty("username");
		 password = dataProp.getProperty("password");
		 globalError = dataProp.getProperty("globalError");
		 emptyUserError =dataProp.getProperty("emptyUserError");
		 emptyPassError=dataProp.getProperty("emptyPasswordError");
		 
		 setUsername(username);
		 setPassword(password);
		 setglobalError(globalError);
		 setEmptyUserError(emptyUserError);
		 setEmptyPassError(emptyPassError);
	}

}
