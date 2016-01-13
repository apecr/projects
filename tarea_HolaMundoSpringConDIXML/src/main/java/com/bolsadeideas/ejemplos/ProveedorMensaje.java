package com.bolsadeideas.ejemplos;

public interface ProveedorMensaje {

	/**
	 * Obtiene el mensaje de este proveedor
	 * 
	 * @return String con el mensaje del proveedor
	 */
	public String getMensaje();

	/**
	 * Getter de ProveedorSaludo
	 * 
	 * @return ProveedorSaludo
	 */
	public ProveedorSaludo getProveedorSaludo();

	/**
	 * Setter de ProveedorSaludo
	 * 
	 * @param proveedorSaludo
	 *            Instancia de ProveedorSaludo a inyectar en la implementacion
	 *            de ProveedorMensaje
	 */
	public void setProveedorSaludo(ProveedorSaludo proveedorSaludo);
}
