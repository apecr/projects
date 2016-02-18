package es.alberto.cursospring.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import es.alberto.cursospring.binder.NombreMayusculaEditor;
import es.alberto.cursospring.models.service.IUsuarioService;
import es.alberto.cursospring.vo.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/usuario")
@SessionAttributes("user")
public class RegistroUsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	public static final String USER_DETAIL = "userDetail";

	public static final String REDIRECT_USUARIO = "redirect:/usuario/";

	public static final String CREATE_USER = "createUser";
	public static final String LISTADO_USERS = "/usuario/listado.htm";

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String crear(@RequestParam(value = "id", required = false, defaultValue = "0") Long id, ModelMap model) {
		Usuario user = null;
		if (id > 0) {
			user = this.usuarioService.findById(id);
		} else {
			user = new Usuario();
		}
		model.addAttribute("user", user);
		return CREATE_USER;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("user") Usuario user, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return CREATE_USER;
		}
		this.usuarioService.save(user);
		status.setComplete();
		return REDIRECT_USUARIO + user.getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String verDetalle(@PathVariable Long id, Model model) {
		Usuario user = this.usuarioService.findById(id);
		if (user == null) {
			throw new RecursoNoEncontradoException(id);
		}
		model.addAttribute("user", user);
		return USER_DETAIL;
	}

	@RequestMapping(value = "/listado.htm", method = RequestMethod.GET)
	@ModelAttribute("listadoUsuarios")
	public List<Usuario> verListado(Model model) {
		return usuarioService.findAll();
	}
	
	@RequestMapping(value = "/listado2", method=RequestMethod.GET)
	public @ResponseBody List<Usuario> verListadoJson(Model model){
		return verListado(model);
	}

	@RequestMapping(value = "/eliminar.htm/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable Long id, Model model) {
		Usuario userTodelete = usuarioService.findById(id);
		if (userTodelete != null) {
			this.usuarioService.delete(userTodelete);
		}
		model.addAttribute("listadoUsuarios", usuarioService.findAll());
		return "redirect:" + LISTADO_USERS;
	}

}
