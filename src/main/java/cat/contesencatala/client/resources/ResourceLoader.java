package cat.contesencatala.client.resources;

import java.util.logging.Logger;

import javax.inject.Inject;

import cat.contesencatala.client.application.ApplicationPresenter;

public class ResourceLoader {
	Logger logger = Logger.getLogger(ApplicationPresenter.class.getName());
	
    @Inject
    ResourceLoader(AppResources appResources) {
    	
    	logger.info("ResourceLoader loading styles...");
    	
        appResources.style().ensureInjected();
    }
}
