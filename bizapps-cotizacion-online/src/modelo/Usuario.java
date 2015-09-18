package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AN8")
	private String an8;

	@Column(name="id_email")
	private String idEmail;

	@Id
	@Column(name="id_usuario")
	private String idUsuario;

	private String nombre;

	private String password;

	private String rol;

	public Usuario() {
	}

	public String getAn8() {
		return this.an8;
	}

	public void setAn8(String an8) {
		this.an8 = an8;
	}

	public String getIdEmail() {
		return this.idEmail;
	}

	public void setIdEmail(String idEmail) {
		this.idEmail = idEmail;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}