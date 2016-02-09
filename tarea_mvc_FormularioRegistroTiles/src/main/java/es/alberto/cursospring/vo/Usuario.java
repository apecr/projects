package es.alberto.cursospring.vo;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	
	private static final AtomicLong ID_SEQUENCIA = new AtomicLong();
	
	private Long id;
	
	@NotEmpty(message = "El nombre no puede ser vacio")
	private String nombre;
	
	@NotEmpty(message = "El apellido no puede ser vacio")
	private String apellido;
	
	@NotEmpty(message = "Debe introducir un email valido")
	@Email(message = "Debe introducir un email valido")
	private String email;
	
	@NotEmpty(message = "Username no puede ser vacio")
	private String userName;
	
	@Size( min = 4, max = 8, message = "El tamaño de la clave tiene que estar entre 4 y 8")
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
