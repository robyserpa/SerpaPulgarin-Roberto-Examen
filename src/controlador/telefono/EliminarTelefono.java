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
 * Servlet implementation class EliminarTelefono
 */
@WebServlet("/eliminar-telefono")
public class EliminarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarTelefono() {
        super();
        telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
        telefono =  new Telefono();    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int e = Integer.parseInt(request.getParameter("tel_eliminado"));
			if (e == 0) {
				telefono.setTelEliminado(false);
				telefonoDAO.update(telefono);
			}else {
				telefono.setTelEliminado(true);
				telefonoDAO.update(telefono);
				response.getWriter().append("Se elimino el telefono");
			}
		} catch (Exception e) {
			response.getWriter().append("No se elimino el telefono");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
