

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DAO.railwayCrossingDataDAO;
import com.example.model.railwayCrossingData;

/**
 * Servlet implementation class UpdateRailwayCrossingController
 */
public class UpdateRailwayCrossingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRailwayCrossingController() {
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
	    try {
	        railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
	        railwayCrossingData RC = new railwayCrossingData();
			RC.setCrossingId(Integer.parseInt(request.getParameter("id")));

	        RC.setCrossingName(request.getParameter("crossingName"));
	        RC.setAddress(request.getParameter("crossingAddress"));
	        RC.setLandmark(request.getParameter("landmark"));
	        String trainScheduleStr = request.getParameter("trainSchedule");
	        LocalTime trainSchedule = LocalTime.parse(trainScheduleStr); // Parse the String to LocalTime
	        RC.setTrainSchedule(trainSchedule); // Set the LocalTime object to railwayCrossingData
	        RC.setPersonInCharge(request.getParameter("personInCharge"));
	        RC.setStatusCrossing(request.getParameter("statusCrossing"));

	        dao.updateRailwayCrossingData(RC);

	        response.sendRedirect("AdminHome.jsp");
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception for debugging
	        response.sendRedirect("error.jsp"); // Redirect to error page
	    }
	}
}


