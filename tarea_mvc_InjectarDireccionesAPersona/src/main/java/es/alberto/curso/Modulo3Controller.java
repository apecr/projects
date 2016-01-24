package es.alberto.curso;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Modulo3Controller {

	private static final Logger logger = LoggerFactory.getLogger(Modulo3Controller.class);

	@Autowired
	private Persona persona;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/direcciones", method = RequestMethod.GET)
	public void viewDirecciones() {
	}
	
	@RequestMapping(value = "/persona", method = RequestMethod.GET)
	public void viewPersona() {
	}

	/**
	 * Simply selects the index view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@ModelAttribute("persona")
	public Persona populatePersona() {
		return persona;
	}

}
