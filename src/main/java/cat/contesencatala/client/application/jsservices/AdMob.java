package cat.contesencatala.client.application.jsservices;

import java.util.logging.Logger;

import com.google.gwt.core.client.JavaScriptObject;

public class AdMob {
	
	Logger logger = Logger.getLogger(AdMob.class.getName());
	JavaScriptObject admobid;
	
	public void prepare(){
		initAdd();
		registerAdEvents();
		//showBanner();
	}
		
	private native void showBanner() /*-{
		if ( $wnd.plugins && $wnd.plugins.AdMob ){
    		$wnd.plugins.AdMob.createBannerView();
		}
   	}-*/;
		
	public native void showInterstitial() /*-{
		if ( $wnd.plugins && $wnd.plugins.AdMob ){
			$wnd.plugins.AdMob.showInterstitialAd();
			$wnd.plugins.AdMob.createInterstitialView();  //get the interstitials ready to be shown
            $wnd.plugins.AdMob.requestInterstitialAd();
		}
	}-*/;

	

	private static native void initAdd()/*-{
		
		if ( $wnd.plugins && $wnd.plugins.AdMob ) {
            var ad_units = {
                ios : {
                   banner : 'ca-app-pub-9236413644503434/3266419309', 
					interstitial : 'ca-app-pub-9236413644503434/9247404101'
                },
                android : {
                    banner : 'ca-app-pub-9236413644503434/3266419309',
					interstitial : 'ca-app-pub-9236413644503434/9247404101'
                }
            };
            var admobid = ( /(android)/i.test(navigator.userAgent) ) ? ad_units.android : ad_units.ios;

            $wnd.plugins.AdMob.setOptions( {
                publisherId: admobid.banner,
                interstitialAdId: admobid.interstitial,
                adSize: $wnd.plugins.AdMob.AD_SIZE.SMART_BANNER,  //use SMART_BANNER, BANNER, IAB_MRECT, IAB_BANNER, IAB_LEADERBOARD
                bannerAtTop: false, // set to true, to put banner at top
                overlap: true, // banner will overlap webview 
                offsetTopBar: true, // set to true to avoid ios7 status bar overlap
                isTesting: false, // receiving test ad
                autoShow: false // auto show interstitial ad when loaded
            });

            //registerAdEvents();
            $wnd.plugins.AdMob.createInterstitialView();  //get the interstitials ready to be shown
            $wnd.plugins.AdMob.requestInterstitialAd();

        } else {
            //alert( 'admob plugin not ready' );
        }
        
        
        
	
	}-*/;
	
	
	private static native void registerAdEvents() /*-{
        $doc.addEventListener('onReceiveAd', function(){});
        $doc.addEventListener('onFailedToReceiveAd', function(data){});
        $doc.addEventListener('onPresentAd', function(){});
        $doc.addEventListener('onDismissAd', function(){ });
        $doc.addEventListener('onLeaveToAd', function(){ });
        $doc.addEventListener('onReceiveInterstitialAd', function(){ });
        $doc.addEventListener('onPresentInterstitialAd', function(){ });
        $doc.addEventListener('onDismissInterstitialAd', function(){
            //window.plugins.AdMob.createInterstitialView();          //REMOVE THESE 2 LINES IF USING AUTOSHOW
            //window.plugins.AdMob.requestInterstitialAd();           //get the next one ready only after the current one is closed
        });
	}-*/;
	
	
	
	
}
