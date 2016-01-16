package com.bolsadeideas.ejemplos;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
		Persona persona = (Persona) factory.getBean("persona");
		System.out.println(getInfoPersona(persona));
	}

	public static String getInfoPersona(Persona persona) {
		StringBuilder direcciones = new StringBuilder();
		if (persona.getDirecciones() != null) {
			for (Direccion direccion : persona.getDirecciones().getListaDirecciones()) {
				direcciones.append(" Direccion: ").append(direccion.getNumero()).append(" ").append(direccion.getCalle())
						.append(" ").append(direccion.getCiudad()).append(" ").append(direccion.getPais()).append("\n");

			}
		}
		return "Nombre:" + persona.getNombre() + "\n" + "Edad:" + persona.getEdad() + "\n" + "Peso: "
				+ persona.getPeso() + "\n" + "Es Programador?: " + persona.isProgramador() + "\n"
				+ "Direcciones:\n"
				+ direcciones.toString();
	}
}