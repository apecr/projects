package es.alberto.cursospring.binder;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		}
		else {
			String value = text.toUpperCase();
			setValue(value);
		}
	}
}
