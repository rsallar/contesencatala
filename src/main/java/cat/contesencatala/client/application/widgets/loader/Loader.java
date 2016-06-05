package cat.contesencatala.client.application.widgets.loader;

import gwt.material.design.client.ui.MaterialLoader;

public class Loader {
	
	public static void load(){
		MaterialLoader.showLoading(true);
	}
	
	public static void stop(){
		MaterialLoader.showLoading(false);
	}
}

