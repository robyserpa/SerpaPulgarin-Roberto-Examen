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
import entidades.Tipo;
import entidades.Usuario;

/**
 * Servlet implementation class Telefono
 */
@WebServlet("/crear-telefono")
public class CrearTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
	private Tipo tipo;
	private Operadora operadora;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearTelefono() {
        super();
        telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
        telefono =  new Telefono();
        tipo = new Tipo();
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
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			telefono.setTelNumero(request.getParameter("tel_numero"));
			telefono.setTelTipo(tipo);
			telefono.setTelOpe(operadora);
			telefono.setTelUsu(usuario);
			
			telefonoDAO.create(telefono);
			
			response.getWriter().append("Se agrego correctamente");
			
		} catch (Exception e) {
			response.getWriter().append("Error al agreagar telefono");
			e.printStackTrace();
		}
	}

}
