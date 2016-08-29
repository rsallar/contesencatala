package cat.contesencatala.client.application.jsservices;

import java.util.logging.Logger;

import com.google.gwt.core.client.JavaScriptObject;

public class AdMob {
	
	Logger logger = Logger.getLogger(AdMob.class.getName());
	JavaScriptObject admobid;
	
	/*public void prepareAdds() {
		admobid = prepareId();
		prepareInterstitial(admobid);
	}
	
	public void showAdd(){
		show();
		prepareInterstitial(admobid);
	}*/
	
	public void showBanner(){
		logger.fine("prepareId");
		admobid = prepareId();
		logger.fine("showBanner");
		showBanner(admobid);
	}
	

	private static native void show()/*-{
		if($wnd.AdMob){
			console.info("admob found");
			$wnd.AdMob.showInterstitial();
		}else{
			console.info("admob NOT found");
		}
	}-*/;
	
	private static native JavaScriptObject prepareId() /*-{
	
		var admobid = {};
		if (/(android)/i.test(navigator.userAgent)) { // for android & amazon-fireos
			admobid = {
				banner : 'ca-app-pub-9236413644503434/3266419309',
				interstitial : 'ca-app-pub-9236413644503434/9247404101'
			};
		} else if (/(ipod|iphone|ipad)/i.test(navigator.userAgent)) { // for ios
			admobid = {
				banner : 'ca-app-pub-9236413644503434/3266419309', 
				interstitial : 'ca-app-pub-9236413644503434/9247404101'
			};
		} else { // for windows phone
			admobid = {
				banner : 'ca-app-pub-9236413644503434/3266419309',
				interstitial : 'ca-app-pub-9236413644503434/9247404101'
			};
		}
				
		return admobid;
		
	}-*/;
	
	private static native void prepareInterstitial(JavaScriptObject admobid) /*-{
		
		if($wnd.AdMob){
			
			 $wnd.AdMob.prepareInterstitial({
			    adId: admobid.interstitial,
			    isTesting: true, // TODO: remove this line when release
			    autoShow: true
	 		});
		}

	}-*/;
	
	public static native void showBanner(JavaScriptObject admobid) /*-{
		
		if($wnd.AdMob){
			console.info("admob found");
			$wnd.AdMob.createBanner({ 
		  	  adId: admobid.banner, 
			  position:$wnd.AdMob.AD_POSITION.BOTTOM_CENTER, 
			  isTesting: true, // TODO: remove this line when release
			  autoShow:true 
			});
			
		}else{
			console.info("admob not found");
		}
	
	}-*/;
	
}
