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
	
	private Log LOG = LogFactory.getLog(this.getClass());

    @AfterReturning("ArchitecturePointcuts.loggCreateUser(usuario)")
    public void logBefore(Usuario usuario) {
        LOG.info("Se ha creado un nuevo usuario con id = " + usuario.getId() + " y con nombre = " +usuario.getNombre() + " " + usuario.getApellido());
    }

}
