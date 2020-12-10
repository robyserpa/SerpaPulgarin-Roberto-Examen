package controlador.telefono;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.TelefonoDAO;
import entidades.Telefono;

/**
 * Servlet implementation class ReadTelefono
 */
@WebServlet("/leer-telefono")
public class LeerTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeerTelefono() {
        super();
        telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int telId = Integer.parseInt(request.getParameter("tel_id"));
			telefono = telefonoDAO.read(telId);
			getServletContext().setAttribute("telefonoRead", telefono);
		} catch (Exception e) {
			getServletContext().setAttribute("telefonoRead", null);
			response.sendRedirect("/JSP/error.jsp");		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
