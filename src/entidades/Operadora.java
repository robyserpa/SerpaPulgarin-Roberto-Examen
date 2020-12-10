package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: Operadora
 *
 */
@Entity

public class Operadora implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ope_id")
	private int opeId;
	
	@Column(name="ope_nombre", length=255, nullable=false, unique=true)
	private String opeNombre;
	
	@Column(name="ope_elimindao", columnDefinition="BOOLEAN DEFAULT 0")
	private boolean opeEliminado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "telOpe")
	private List<Telefono> telefonos = new ArrayList<Telefono>();
	
	public Operadora() {
		super();
	}

	public int getOpeId() {
		return opeId;
	}

	public void setOpeId(int opeId) {
		this.opeId = opeId;
	}

	public String getOpeNombre() {
		return opeNombre;
	}

	public void setOpeNombre(String opeNombre) {
		this.opeNombre = opeNombre;
	}

	public boolean isOpeEliminado() {
		return opeEliminado;
	}

	public void setOpeEliminado(boolean opeEliminado) {
		this.opeEliminado = opeEliminado;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	
   
}
