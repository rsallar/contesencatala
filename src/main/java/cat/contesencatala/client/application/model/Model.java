package cat.contesencatala.client.application.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	public Tale selectedTale;
	public List<Tale> tales = new ArrayList<Tale>();
	
	public Model(){
		init();
	}
	
	
	public void init(){
		tales.add(new Tale("caputxeta", "La caputxeta vermella", "Conte popular europeu"));
		tales.add(new Tale("aneguetlleig", "L'aneguet lleig", "Hans Christian Andersen"));
		tales.add(new Tale("patufet", "En Patufet", "Conte popular català"));
		tales.add(new Tale("flautista", "El flautista de Hamelin", "Germans Grimm"));
		tales.add(new Tale("gatbotes", "El gat amb botes", "Charles Perrault"));
		tales.add(new Tale("princesapesol", "La princesa i el pèsol", "H.C. Andersen"));
		tales.add(new Tale("reinaabelles", "La reina de les abelles", "Germans Grimm"));
		tales.add(new Tale("rapunzel", "Rapunzel", "Germans Grimm"));
		tales.add(new Tale("musics", "Els músics de Bremen", "Germans Grimm"));
		tales.add(new Tale("soldadetplom", "El soldadet de plom", "Hans Christian Andersen"));
		tales.add(new Tale("princepfelic", "El príncep feliç", "Oscar Wilde"));
		
	}


	public Tale getTaleById(String taleId) {
		for(Tale tale: tales){
			if(tale.id == taleId){
				return tale;
			}
		}
		return null;
		
	}
}
