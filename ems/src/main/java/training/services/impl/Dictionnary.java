package training.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class Dictionnary {
	
	private Map<String, String> translations;

    public Dictionnary() {
    }
    
    @PostConstruct
    public void init(){
    	translations = new HashMap<String, String>();
    	translations.put("courir", "run");
    	translations.put("marcher", "walk");
    }

	public Map<String, String> getTranslations() {
		return translations;
	}
    
    

}
