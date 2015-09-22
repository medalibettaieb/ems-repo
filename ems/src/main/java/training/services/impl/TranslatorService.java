package training.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import training.services.interfaces.TranslatorServiceRemote;

@Stateless
public class TranslatorService implements TranslatorServiceRemote {

	@EJB
	private Dictionnary dictionnary;

	public TranslatorService() {
	}

	public String translate(String french) {
		String english = dictionnary.getTranslations().get(french);
		// return english!=null?english:"not found";
		if (english != null) {
			return english;
		} else {
			return "not found";
		}
	}

}
