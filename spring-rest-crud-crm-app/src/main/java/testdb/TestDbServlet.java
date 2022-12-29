package testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Setup connection variables (MySQL Workbench'de create-user.sql komutuyla oluşturduğumuz id ve password)
		String user = "SpringRest_CRUD-CRM-App";
		String pass = "SpringRest_CRUD-CRM-App";
		
		String jdbcURL = "jdbc:mysql://localhost:3306/SpringRest_CRUD-CRM_Web-Customer-Tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Get connection to database
		try {		
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: " + jdbcURL);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			
			out.println("Connected Successfully!!!");
			
			myConn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}

/*
 	Hibernate kısmında DB connection'ını test ederken class kullanmıştık
 	Bu bir web uygulaması olduğu için Servlet kullanmak daha best practice oluyor. Yine oradaki gibi class üzerinden bu işlemi yapabilirdik
*/ 
