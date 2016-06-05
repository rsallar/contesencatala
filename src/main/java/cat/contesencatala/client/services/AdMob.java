package cat.contesencatala.client.services;

import java.util.logging.Logger;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class AdMob {

	Logger logger = Logger.getLogger(AdMob.class.getName());
	JavaScriptObject admobid;
	
	public void prepareAdds() {
		admobid = prepareId();
		prepareAdMob(admobid);
	}
	
	public void showAdd(){
		show();
		prepareAdMob(admobid);
	}
	

	private static native void show()/*-{
		if($wnd.AdMob){
			$wnd.AdMob.showInterstitial();
		}
	}-*/;
	
	private static native JavaScriptObject prepareId() /*-{
	
		var admobid = {};
		if (/(android)/i.test(navigator.userAgent)) { // for android & amazon-fireos
			admobid = {
				banner : 'ca-app-pub-9236413644503434/3266419309', // or DFP format "/6253334/dfp_example_ad"
				interstitial : 'ca-app-pub-9236413644503434/9247404101'
			};
		} else if (/(ipod|iphone|ipad)/i.test(navigator.userAgent)) { // for ios
			admobid = {
				banner : 'ca-app-pub-9236413644503434/3266419309', // or DFP format "/6253334/dfp_example_ad"
				interstitial : 'ca-app-pub-9236413644503434/9247404101'
			};
		} else { // for windows phone
			admobid = {
				banner : 'ca-app-pub-9236413644503434/3266419309', // or DFP format "/6253334/dfp_example_ad"
				interstitial : 'ca-app-pub-9236413644503434/9247404101'
			};
		}
				
		return admobid;
		
	}-*/;
	
	private static native void prepareAdMob(JavaScriptObject admobid) /*-{
		
		if($wnd.AdMob){
			 $wnd.AdMob.prepareInterstitial({
			    adId: admobid.interstitial,
			    isTesting: true, // TODO: remove this line when release
			    autoShow: false
	 		});
		}
  		

	}-*/;
	
	
	public static JsArrayString toJsArray(String[] input) {
		JsArrayString jsArrayString = JsArrayString.createArray().cast();
		for (String s : input) {
			jsArrayString.push(s);
		}
		return jsArrayString;
	}

}
