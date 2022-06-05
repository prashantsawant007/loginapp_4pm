package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/verifyLogin")
public class loginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public loginServelet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapp_4pm","root","Prashant@007");
		    Statement stmnt=con.createStatement();
		    ResultSet result=stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		if(result.next()) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/welcome.html");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request,response );
		    }
		}
		catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


