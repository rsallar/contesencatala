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
		tales.add(new Tale("caputxeta", "La caputxeta vermella", "Conte popular europeu", "https://dribbble.com/shots/298333-Little-red-riding-hood"));
		tales.add(new Tale("aneguetlleig", "L'aneguet lleig", "Hans Christian Andersen","https://dribbble.com/shots/1565655-The-Ugly-Duckling-the-Duck-Family"));
		tales.add(new Tale("patufet", "En Patufet", "Conte popular català", "https://dribbble.com/shots/709365-Laluna"));
		tales.add(new Tale("flautista", "El flautista de Hamelin", "Germans Grimm","https://dribbble.com/shots/2182857-Kawaii-Pied-Piper-of-Hamelin"));
		tales.add(new Tale("gatbotes", "El gat amb botes", "Charles Perrault","https://dribbble.com/shots/516669-Puss-In-Boots"));
		tales.add(new Tale("princesapesol", "La princesa i el pèsol", "H.C. Andersen","https://dribbble.com/shots/173882-The-Princess-and-The-Pea"));
		tales.add(new Tale("reinaabelles", "La reina de les abelles", "Germans Grimm","https://dribbble.com/shots/1667177-Queen-Bee"));
		tales.add(new Tale("rapunzel", "Rapunzel", "Germans Grimm","https://dribbble.com/shots/633984-Rapunzel"));
		tales.add(new Tale("musics", "Els músics de Bremen", "Germans Grimm","https://dribbble.com/shots/1543228-Town-Musicians-of-Bremen"));
		tales.add(new Tale("soldadetplom", "El soldadet de plom", "Hans Christian Andersen","https://dribbble.com/shots/1830021-1985"));
		tales.add(new Tale("princepfelic", "El príncep feliç", "Oscar Wilde","https://dribbble.com/shots/1157617-Happy-Prince"));
		tales.add(new Tale("rateta", "La rateta que escombrava l'escaleta", "Conte popular","https://dribbble.com/shots/1474849-Cuckoo-clock", true));
		tales.add(new Tale("peresensepor", "En Pere sense por", "Joan Amades","https://dribbble.com/shots/2314695-Haunted", true));
		tales.add(new Tale("princesatrista", "La princesa trista", "Joan Amades","https://dribbble.com/shots/692755-Principessa", true));
		tales.add(new Tale("cigalaformiga", "La cigala i la formiga", "Isop","https://dribbble.com/shots/1889059-The-Ant-and-the-Grasshopper", true));
		tales.add(new Tale("peixetor", "El peixet d'or", "Rondalla popular russa","https://dribbble.com/shots/1133451-Golden-Fish", true));
		
		
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
