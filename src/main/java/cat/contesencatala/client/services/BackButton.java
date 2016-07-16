package cat.contesencatala.client.services;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import cat.contesencatala.client.place.NameTokens;

public class BackButton {
	
	Logger logger = Logger.getLogger(BackButton.class.getName());
	
	PlaceManager placeManager;
	
	@Inject
	public BackButton(PlaceManager placeManager){
		this.placeManager = placeManager;
	}
	
	public void init(){
		//exportMyFunction();
		//initCloseHandler();
		logger.fine("init BackButton service");
	}
	
	public static native void exportMyFunction()/*-{
	  $wnd.handleAnchorClick = @cat.contesencatala.client.services.BackButton::back(*);
	}-*/;
	
	
	private static native void initCloseHandler()/*-{
				
		$doc.addEventListener("backbutton", $wnd.handleAnchorClick, false);

		
	}-*/;
	
	private static native void closeApp()/*-{
		alert("close");
	}-*/;
	
	public void back(){
		
		if(!placeManager.getCurrentPlaceRequest().getNameToken().equals(NameTokens.home)){
			logger.fine("navigating back");
			placeManager.navigateBack();
			
		}else{
			logger.fine("closig app");
			closeApp();
		}
		
	}
	

}
