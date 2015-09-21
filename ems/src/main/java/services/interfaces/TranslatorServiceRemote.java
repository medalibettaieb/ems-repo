package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface TranslatorServiceRemote {

	String translate(String french);

}
