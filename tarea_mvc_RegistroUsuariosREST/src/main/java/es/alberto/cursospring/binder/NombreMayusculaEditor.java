package es.alberto.cursospring.binder;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.text.WordUtils;

public class NombreMayusculaEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		}
		else {
			setValue(WordUtils.capitalizeFully(text));
		}
	}
}
