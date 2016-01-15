package com.bolsadeideas.ejemplos;

public class HolaMundoProveedorMensaje implements ProveedorMensaje {

	private ProveedorSaludo proveedorSaludo;

	public String getMensaje() {
		return this.proveedorSaludo.getSaludo();
	}

	@Override
	public ProveedorSaludo getProveedorSaludo() {
		return proveedorSaludo;
	}

	@Override
	public void setProveedorSaludo(ProveedorSaludo proveedorSaludo) {
		this.proveedorSaludo = proveedorSaludo;
	}

}