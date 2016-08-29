package cat.contesencatala.client.application.jsservices;

import java.util.logging.Logger;

public class Rate {
	
	Logger logger = Logger.getLogger(Rate.class.getName());
	
	
	public void prepareRating() {
		prepare();
	}

	private static native void prepare()/*-{
		if($wnd.AppRate){
			$wnd.AppRate.preferences.openStoreInApp = false;
			$wnd.AppRate.preferences.displayAppName = 'Contes en català';
			$wnd.AppRate.preferences.useLanguage = 'ca';
			$wnd.AppRate.preferences.storeAppURL.ios = '<my_app_id>';
  			$wnd.AppRate.preferences.storeAppURL.android = 'market://details?id=cat.contesencatala';
  			$wnd.AppRate.preferences.usesUntilPrompt = 3;
			$wnd.AppRate.preferences.promptAgainForEachNewVersion = false;
			$wnd.AppRate.promptForRating(false); 
		}
	}-*/;
	

}
