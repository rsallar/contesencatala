package cat.contesencatala.client.application;

import com.google.gwt.storage.client.Storage;
import com.google.inject.Inject;

import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;

public class Persistance {

	private Model model;

	@Inject
	public Persistance(Model model) {
		this.model = model;
	}

	private Storage storage;

	public void save(Tale tale) {
		storage = Storage.getLocalStorageIfSupported();

		if (storage != null) {
			String persistanceId = tale.id + "#" + "favorite";
			if (tale.favorite) {
				storage.setItem(persistanceId, "true");
			}else{
				storage.removeItem(persistanceId);
			}

		}
	}

	public void load() {
		storage = Storage.getLocalStorageIfSupported();

		if (storage != null) {
			for (Tale tale : model.tales) {
				//boolean favorite = new Boolean(storage.getItem(tale.id + "#" + "favorite"));
				//tale.favorite = favorite;
			}
		}

	}

}
