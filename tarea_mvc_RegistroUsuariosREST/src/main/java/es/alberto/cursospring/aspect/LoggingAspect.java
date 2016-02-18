package es.alberto.cursospring.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import es.alberto.cursospring.vo.Usuario;

@Component
@Aspect
public class LoggingAspect {

	private static final Log LOG = LogFactory.getLog(LoggingAspect.class);

	/**
	 * Advice que realiza el log de cuando se crea un usuario. El advice es AfterReturning
	 * 
	 * @param usuario UsuarioVO con los datos del usuario que se ha creado
	 */
	@AfterReturning("ArchitecturePointcuts.loggCreateUser(usuario)")
	public void logBefore(Usuario usuario) {
		LOG.info("Se ha creado un nuevo usuario con id = " + usuario.getId() + " y con nombre = " + usuario.getNombre()
				+ " " + usuario.getApellido());
	}

}
