package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tipo
 *
 */
@Entity

public class Tipo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tip_id")
	private int tipId;
	
	@Column(name="tip_nombre", length=255, nullable=false, unique=true)
	private String tipNombre;
	
	@Column(name="tip_elimindao", columnDefinition="BOOLEAN DEFAULT 0")
	private boolean tipEliminado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "telTipo")
	private List<Telefono> telefonos = new ArrayList<Telefono>();

	public Tipo() {
		super();
	}

	public int getTipId() {
		return tipId;
	}

	public void setTipId(int tipId) {
		this.tipId = tipId;
	}

	public String getTipNombre() {
		return tipNombre;
	}

	public void setTipNombre(String tipNombre) {
		this.tipNombre = tipNombre;
	}

	public boolean isTipEliminado() {
		return tipEliminado;
	}

	public void setTipEliminado(boolean tipEliminado) {
		this.tipEliminado = tipEliminado;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
   
}
