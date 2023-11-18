import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.util.HibernateUtil;
import com.example.DAO.*;
import com.example.model.*;

/**
 * Servlet implementation class removefavoriteCrossing
 */
public class removefavoriteCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removefavoriteCrossing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		favouriteCrossingDAO dao = new favouriteCrossingDAO();
	favouriteCrossing data = new favouriteCrossing();
	
	
	data.setFavId(Integer.parseInt(request.getParameter("id")));
	List<favouriteCrossing> listCrossing = dao.deletefavouriteCrossing(data);
	
	response.sendRedirect("addfavoriteCrossing.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {favouriteCrossingDAO dao = new favouriteCrossingDAO();
	favouriteCrossing data = new favouriteCrossing();
	
	
	data.setFavId(Integer.parseInt(request.getParameter("id")));
	List<favouriteCrossing> listCrossing = dao.deletefavouriteCrossing(data);
	
	response.sendRedirect("addfavoriteCrossing.jsp");}

}
