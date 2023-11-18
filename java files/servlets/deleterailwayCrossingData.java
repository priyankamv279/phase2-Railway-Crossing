import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.DAO.railwayCrossingDataDAO;
import com.example.model.railwayCrossingData;
import com.example.util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleterailwayCrossingData
 */
public class deleterailwayCrossingData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleterailwayCrossingData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int crossingId = Integer.parseInt(request.getParameter("id"));

		    railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
		    railwayCrossingData RC = new railwayCrossingData();
		    
		    RC.setCrossingId(crossingId);
		    dao.deleteRailwayCrossingData(RC);
		    
		    response.sendRedirect("AdminHome.jsp");	
		    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int crossingId = Integer.parseInt(request.getParameter("id"));

	    railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
	    railwayCrossingData RC = new railwayCrossingData();
	    
	    RC.setCrossingId(crossingId);
	    dao.deleteRailwayCrossingData(RC);
	    
	    response.sendRedirect("AdminHome.jsp");
	}

}
