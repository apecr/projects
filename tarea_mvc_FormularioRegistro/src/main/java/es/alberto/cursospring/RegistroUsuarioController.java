package es.alberto.cursospring;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import es.alberto.cursospring.vo.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/usuario")
public class RegistroUsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(RegistroUsuarioController.class);

	private Map<Long, Usuario> mapaUsuarios = new HashMap<Long, Usuario>();
	
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
		return "createUser";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("userModel") Usuario user, BindingResult result) {
		if (result.hasErrors()) {
			return "createUser";
		}
		this.mapaUsuarios.put(user.asignarId(), user);
		return "redirect:/usuario/" + user.getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String verDetalle(@PathVariable Long id, Model model) {
		Usuario user = this.mapaUsuarios.get(id);
		if (user == null) {
			throw new RecursoNoEncontradoException(id);
		}
		model.addAttribute("userModel", user);
		// return "cuenta/detalle"; // Muestra el detalle de la cuenta en
		// formato formulario
		return "userDetail"; // Muestra el detalle de la cuenta en formato
									// tabla html
	}

}
