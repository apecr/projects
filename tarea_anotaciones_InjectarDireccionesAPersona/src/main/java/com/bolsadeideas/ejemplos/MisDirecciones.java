package com.bolsadeideas.ejemplos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MisDirecciones implements IDirecciones {

	@Autowired
	private List<Direccion> listaDirecciones;

	@Override
	public List<Direccion> getListaDirecciones() {
		return listaDirecciones;
	}

	
	@Override
	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

}
