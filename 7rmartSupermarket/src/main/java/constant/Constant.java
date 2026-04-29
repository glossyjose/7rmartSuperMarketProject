package constant;

public class Constant {
	public static final String TESTDATAFILE=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx"; //excel data is stored inside \\src\\test\\
	public static final String ORANGEIMAGE=System.getProperty("user.dir")+"\\src\\test\\resources\\Orange.jpg";
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	public static final String VALIDCREDENTIALMSG="Home page is not loaded with valid credentials";
	public static final String INVALIDPASSWORDMSG="Home Page is loaded with invalid password";
	public static final String INVALIDUSERNAMEMSG="Home Page is loaded with invalid Username";
	public static final String INVALIDCREDENTIALMSG="Home Page is loaded with invalid credentials";
	public static final String ADMINUSEREXISTSMSG="Admin User already exists";
	public static final String CATEGORYEXISTSMSG="Category Exists already";
	public static final String CONTACTUPDATEFAILSMSG="Contact Update failed";
	public static final String FOOTERTEXTFAILSMSG ="Footer text Update Failed";
	public static final String NEWSFAILSMSG = "News creation failed";
}
