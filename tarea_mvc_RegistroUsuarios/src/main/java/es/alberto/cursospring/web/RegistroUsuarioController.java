package es.alberto.cursospring.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import es.alberto.cursospring.binder.NombreMayusculaEditor;
import es.alberto.cursospring.models.service.IUsuarioService;
import es.alberto.cursospring.vo.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/usuario")
public class RegistroUsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;

	public static final String USER_DETAIL = "userDetail";

	public static final String REDIRECT_USUARIO = "redirect:/usuario/";

	public static final String CREATE_USER = "createUser";

	private static final Logger LOG = LoggerFactory.getLogger(RegistroUsuarioController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
	}

	// Metodo handler formulario, para crear al estudiante
	@RequestMapping(method = RequestMethod.GET)
	public String crear(ModelMap model) {
		LOG.info("Primer metodo del controlador");

		Usuario user = new Usuario();
		model.addAttribute("userModel", user);

		// retornamos la vista form
		return CREATE_USER;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("userModel") Usuario user, BindingResult result) {
		if (result.hasErrors()) {
			return CREATE_USER;
		}
		this.usuarioService.save(user);
		return REDIRECT_USUARIO + user.getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String verDetalle(@PathVariable Long id, Model model) {
		Usuario user = this.usuarioService.findById(id);
		if (user == null) {
			throw new RecursoNoEncontradoException(id);
		}
		model.addAttribute("userModel", user);
		// return "cuenta/detalle"; // Muestra el detalle de la cuenta en
		// formato formulario
		return USER_DETAIL; // Muestra el detalle de la cuenta en formato
									// tabla html
	}

}
