package es.alberto.cursospring.vo;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	
	private static final AtomicLong ID_SEQUENCIA = new AtomicLong();
	
	private Long id;
	
	@NotEmpty(message = "{error.nombre}")
	private String nombre;
	
	@NotEmpty(message = "{error.apellido}")
	private String apellido;
	
	@NotEmpty(message = "{error.email}")
	@Email(message = "{error.email}")
	private String email;
	
	@NotEmpty(message = "{error.username}")
	private String userName;
	
	@Size( min = 4, max = 8, message = "{error.clave}")
	private String clave;
	
	public Long asignarId() {
		this.id = ID_SEQUENCIA.incrementAndGet();
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
