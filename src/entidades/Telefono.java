package entidades;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Entity implementation class for Entity: Telefono
 *
 */
@Entity

public class Telefono implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tel_id")
	private int telId;
	
	@Column(name="tel_numero", length=10, nullable=false, unique=true)
	private String telNumero;
	
	@Column(name="tel_elimindao", columnDefinition="BOOLEAN DEFAULT 0")
	private boolean telEliminado;
	
	@ManyToOne
	@JoinColumn
	private Usuario telUsu;
	
	@ManyToOne
	@JoinColumn
	private Tipo telTipo;
	
	@ManyToOne
	@JoinColumn
	private Operadora telOpe;
	
	public Telefono() {
		super();
	}

	public int getTelId() {
		return telId;
	}

	public void setTelId(int telId) {
		this.telId = telId;
	}

	public String getTelNumero() {
		return telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public boolean isTelEliminado() {
		return telEliminado;
	}

	public void setTelEliminado(boolean telEliminado) {
		this.telEliminado = telEliminado;
	}

	public Usuario getTelUsu() {
		return telUsu;
	}

	public void setTelUsu(Usuario telUsu) {
		this.telUsu = telUsu;
	}

	public Tipo getTelTipo() {
		return telTipo;
	}

	public void setTelTipo(Tipo telTipo) {
		this.telTipo = telTipo;
	}

	public Operadora getTelOpe() {
		return telOpe;
	}

	public void setTelOpe(Operadora telOpe) {
		this.telOpe = telOpe;
	}
   
}
