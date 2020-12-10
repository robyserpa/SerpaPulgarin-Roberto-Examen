package controlador.telefono;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.TelefonoDAO;
import entidades.Operadora;
import entidades.Telefono;
import entidades.Usuario;

/**
 * Servlet implementation class UpdateTelefono
 */
@WebServlet("/actualizar-telefono")
public class ActualizarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
	private Operadora operadora;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTelefono() {
        super();
        telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
        telefono = new Telefono();
        operadora = new Operadora();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			operadora.setOpeId(Integer.parseInt(request.getParameter("ope_id")));
			telefono.setTelNumero(request.getParameter("tel_numero"));
			telefono.setTelOpe(operadora);
			telefono.setTelUsu(usuario);
			telefonoDAO.update(telefono);
			
			getServletContext().setAttribute("telefonoRead", null);
			
			response.getWriter().append("Se actualizo correctamente");

		} catch (Exception e) {
			response.getWriter().append("No se actualizo");
			e.printStackTrace();
		}
	}

}
