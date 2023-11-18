import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import com.example.model.Admin;
import com.example.util.HibernateUtil;
import org.hibernate.exception.SQLGrammarException;
/**
 * Servlet implementation class AdminloginProcess
 */
public class AdminloginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminloginProcess() {
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

        String enteredEmail = request.getParameter("email");
        String enteredPassword = request.getParameter("password");

        try (Session loginSession = HibernateUtil.dbConn()) {
            Query<Admin> query = loginSession.createQuery("from Admin where adminEmail = :email", Admin.class);
            query.setParameter("email", enteredEmail);
            Admin admin = query.uniqueResult();

            if (admin != null && admin.getAdminPassword().equals(enteredPassword)) {
                response.sendRedirect("AdminHome.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid, please try again");
                request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any potential exceptions (logging, error messages, etc.)
            response.sendRedirect("error.jsp");
        }
    
	}

}
