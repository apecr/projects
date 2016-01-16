package com.bolsadeideas.ejemplos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MisDirecciones implements IDirecciones {

	private List<Direccion> listaDirecciones;

	@Autowired
	private void setDireccionesTarea(@Qualifier("primeraDireccion") Direccion primeraDireccion,
			@Qualifier("segundaDireccion") Direccion segundaDireccion) {
		this.listaDirecciones = new ArrayList<Direccion>();
		this.listaDirecciones.add(primeraDireccion);
		this.listaDirecciones.add(segundaDireccion);
	}

	@Override
	public List<Direccion> getListaDirecciones() {
		return listaDirecciones;
	}

	@Override
	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

}
