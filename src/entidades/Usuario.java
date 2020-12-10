package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: usuario
 *
 */
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usu_id")
	private int usuId;
	
	@Column(name="usu_nombre", length=255, nullable=false, unique=true)
	private String usuNombre;
	
	@Column(name="usu_correo", length=255, nullable=false, unique=true)
	private String usuCorreo;
	
	@Column(name="usu_cedula", length=10, nullable=false, unique=true)
	private String usuCedula;
	
	@Column(name="usu_eliminado", columnDefinition="BOOLEAN DEFAULT 0")
	private boolean usuEliminado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "telUsu")
	private List<Telefono> telefonos = new ArrayList<Telefono>();
	
	public Usuario() {
		super();
	}

	public int getUsuId() {
		return usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public String getUsuNombre() {
		return usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public String getUsuCorreo() {
		return usuCorreo;
	}

	public void setUsuCorreo(String usuCorreo) {
		this.usuCorreo = usuCorreo;
	}

	public String getUsuCedula() {
		return usuCedula;
	}

	public void setUsuCedula(String usuCedula) {
		this.usuCedula = usuCedula;
	}

	public boolean isUsuEliminado() {
		return usuEliminado;
	}

	public void setUsuEliminado(boolean usuEliminado) {
		this.usuEliminado = usuEliminado;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
   
	
}
