package es.alberto.cursospring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import es.alberto.cursospring.vo.Usuario;

@Component
@Aspect
public class ArchitecturePointcuts {
	
	@Pointcut("execution(** es.alberto.cursospring.models.service.IUsuarioService.save(es.alberto.cursospring.vo.Usuario)) " + "&& args(usuario)")
    public void loggCreateUser(Usuario usuario){}

}
