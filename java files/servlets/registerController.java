

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.User;
import com.example.util.HibernateUtil;

/**
 * Servlet implementation class registerController
 */
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regName = request.getParameter("name");
	    String regEmail = request.getParameter("email");
	    String regPassword = request.getParameter("password");

	    User user = new User();
	    user.setUserName(regName);
	    user.setUserEmail(regEmail);
	    user.setUserPassword(regPassword);

	    try {
	        Session regSession = HibernateUtil.dbConn();
	        Transaction transaction = regSession.beginTransaction();
	        regSession.save(user);
	        transaction.commit();
	        regSession.close();
	        response.sendRedirect("registrationSuccess.jsp");
	    } catch (Exception e) {
	      //  out.println("Error: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}
