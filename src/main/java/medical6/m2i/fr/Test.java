package medical6.m2i.fr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/addpatient")
public class Test extends HttpServlet {
	private Properties config;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub

		config = new Properties();
		try {
			config.load(getClass().getResourceAsStream("patients.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Je suis bien dans la méthode post");

		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String datenaissance = request.getParameter("datenaissance");
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");

		response.setContentType(" text / html ");
		PrintWriter out = response.getWriter();
		out.println("<html >");
		out.println("<body >");
		out.println("<h1 > Bonjour " + prenom + " " + nom + " ! </h1 >");
		out.println("<p>Vous etes né le : " + datenaissance + "</p>"); // la date de naissance
		out.println("<p>Votre adresse est : " + adresse + ", " + ville + ", " + pays + "</p>"); // � la place des **** :
																								// adresse + pays +
																								// ville
		out.println(" </body >");
		out.println(" </html >");

		saveData(nom, prenom, datenaissance, adresse, pays, ville);
	}

	public void saveData(String nom, String prenom, String datenaissance, String adresse, String pays, String ville) {

		SimpleDateFormat formateur = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		Patient p = new Patient(nom, prenom, Date.valueOf(datenaissance), adresse, pays, ville);

		try {
			p.savePatient();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
