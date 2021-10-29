package medical6.m2i.fr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Ville {
private Properties config;
public int id;
public String nom;
public String codepost;


/**
 * 
 */
public Ville() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @param id
 * @param nom
 * @param codepost
 */
public Ville(int id, String nom, String codepost) {
	super();
	this.id = id;
	this.nom = nom;
	this.codepost = codepost;
	
	config = new Properties();
	try {
		config.load(getClass().getResourceAsStream("patients.properties"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the nom
 */
public String getNom() {
	return nom;
}

/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}

/**
 * @return the codepost
 */
public String getCodepost() {
	return codepost;
}

/**
 * @param codepost the codepost to set
 */
public void setCodepost(String codepost) {
	this.codepost = codepost;
}


public List<Ville> getVilles() throws Exception {

	String url = config.getProperty("url");
	String user = config.getProperty("user");
	String password = config.getProperty("password");
	String sql = null;

	// Get Connection Driver to establish database connection
	Class.forName("com.mysql.cj.jdbc.Driver");
	// Establish connection
	Connection connection = DriverManager.getConnection(url, user, password);

	// creation du statement , Write SQL query to insert data
	Statement statement = connection.createStatement();
	ResultSet result = statement.executeQuery("select * from ville");

	List<Ville> lv = new ArrayList<Ville>();
	Ville v;
	while (result.next()) {
		v = new Ville( result.getInt("id"), result.getString("nom") , result.getString("codepost"));
		lv.add(v);
	}

	// validation de la transaction
	connection.close();
	return lv;
}

}

