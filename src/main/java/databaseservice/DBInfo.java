package databaseservice;

public class DBInfo {
	private String dburl = "jdbc:mysql://localhost:3306/";
    private String dbname;
    private String dbusername;
    private String dbpassword;

    public DBInfo() {
        this.dbname = "java_ecom";
        this.dbusername = "root";
        this.dbpassword ="";
    }
    public DBInfo(String dbname, String username, String password) {
        this.dbname = dbname;
        this.dbusername = username;
        this.dbpassword = password;
    }
    
    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}

	public String getDbusername() {
		return dbusername;
	}

	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}

	public String getDbpassword() {
		return dbpassword;
	}

	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}
}
