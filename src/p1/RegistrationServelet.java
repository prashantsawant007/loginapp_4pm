package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet("/newReg")
public class RegistrationServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServelet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		request.getParameter("name");
		request.getParameter("city");
		request.getParameter("email");
		request.getParameter("mobile");
		
	}

}
