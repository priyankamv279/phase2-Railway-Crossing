import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.DAO.railwayCrossingDataDAO;
import com.example.model.railwayCrossingData;
import com.example.util.HibernateUtil;

/**
 * Servlet implementation class AddRailwayCrossing
 */
public class AddRailwayCrossingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRailwayCrossingController() {
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
		railwayCrossingDataDAO dao=new railwayCrossingDataDAO();
		railwayCrossingData RC =new railwayCrossingData();

		RC.setCrossingName(request.getParameter("crossingName"));
		RC.setAddress(request.getParameter("crossingAddress"));
		RC.setLandmark(request.getParameter("landmark"));
		String trainScheduleStr = request.getParameter("trainSchedule");
		LocalTime trainSchedule = LocalTime.parse(trainScheduleStr); // Parse the String to LocalTime

		// Set the LocalTime object to railwayCrossingData
		RC.setTrainSchedule(trainSchedule);		RC.setPersonInCharge(request.getParameter("personInCharge"));
		RC.setStatusCrossing(request.getParameter("statusCrossing"));

		int row=dao.addRailwayCrossingData(RC);

		if(row>0){
			response.sendRedirect("AdminHome.jsp");
			
		}
		else{
			response.sendRedirect("fail.jsp");
		}

	}

}
