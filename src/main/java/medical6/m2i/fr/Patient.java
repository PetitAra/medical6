/**
 * 
 */
package medical6.m2i.fr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author тс
 *
 */
public class Patient {
	private int id;
	public String nom;
	public String prenom;
	public Date datenaissance;
	public String adresse;
	public String pays;
	public String ville;
	private Properties config;

	
	/**
	 * 
	 */
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param date
	 * @param adress
	 * @param pays
	 * @param ville
	 */
	public Patient(int id, String nom, String prenom, Date datenaissance, String adresse, String pays, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;

		config = new Properties();
		try {
			config.load(getClass().getResourceAsStream("patients.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	/**
	 * @return the datenaissance
	 */
	public Date getLocalDatenaissance() {
		return datenaissance;
	}

	/**
	 * @param datenaissance the datenaissance to set
	 */
	public void setLocalDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	
	/**
	 * @return the ids
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

	public void savePatient() throws ClassNotFoundException, SQLException {
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
		PreparedStatement psPatients = connection.prepareStatement(
				"INSERT INTO Patients ( nom, prenom,dateNaissance,adresse, pays, ville) VALUES(?,?,?,?,?,?)");

		psPatients.setString(1, nom);
		psPatients.setString(2, prenom);
		psPatients.setDate(3, datenaissance);
		psPatients.setString(4, adresse);
		psPatients.setString(5, pays);
		psPatients.setString(6, ville);
		int i = psPatients.executeUpdate();
		if (i != 0) {
			System.out.println("<br>Record has been inserted");
		} else {
			System.out.println("failed to insert the data");
		}

	}

	public List<Patient> getPatients() throws Exception {

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
		ResultSet result = statement.executeQuery("select * from patients");

		List<Patient> lp = new ArrayList<Patient>();
		Patient p;
		while (result.next()) {
			p = new Patient( result.getInt("id"), result.getString("nom") , result.getString("prenom") , result.getDate("datenaissance") ,
					result.getString("adresse") , result.getString("pays") , result.getString("ville") );
			lp.add(p);
		}

		// validation de la transaction
		connection.close();
		return lp;
	}
	
	}

