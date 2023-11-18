import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import com.example.model.User;
import com.example.util.HibernateUtil;
import org.hibernate.exception.SQLGrammarException;

public class UserloginProcess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserloginProcess() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enteredEmail = request.getParameter("email");
        String enteredPassword = request.getParameter("password");

        try (Session loginSession = HibernateUtil.dbConn()) {
            Query<User> query = loginSession.createQuery("from User where userEmail = :email", User.class);
            query.setParameter("email", enteredEmail);
            User user = query.uniqueResult();

            if (user != null && user.getUserPassword().equals(enteredPassword)) {
                response.sendRedirect("UserHome.jsp");
            } else {
            	request.setAttribute("errorMessage", "Invalid, please try again");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any potential exceptions (logging, error messages, etc.)
            response.sendRedirect("error.jsp");
        }
    }
}
