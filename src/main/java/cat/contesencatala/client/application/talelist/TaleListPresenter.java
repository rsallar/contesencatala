package cat.contesencatala.client.application.talelist;

import java.util.logging.Logger;

import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.place.NameParams;
import cat.contesencatala.client.place.NameTokens;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;
public class TaleListPresenter extends Presenter<TaleListPresenter.MyView, TaleListPresenter.MyProxy> implements TaleListUiHandlers {
    interface MyView extends View , HasUiHandlers<TaleListUiHandlers> {

		HasData<Tale> getList();

		void redrawTale(int talePos);

		void setFavoriteMode(boolean b);

		void redraw();

		void init();

		void setOpacity(double i);

		void scrollTo(int scrollPos);

		int getScrollPos();

    }
    Logger logger = Logger.getLogger(TaleListPresenter.class.getName());

    @NameToken(NameTokens.talelist)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<TaleListPresenter> {
    }

	private Model model;
	private PlaceManager placeManager;
	private ListDataProvider<Tale> list = new ListDataProvider<>();
    boolean favoriteModeActive = false;
    boolean firstLoad = false;
    int scrollPos = 0;

    @Inject
    TaleListPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            Model model,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        getView().setUiHandlers(this);
        this.placeManager = placeManager;
        this.model = model;
    }
    
    protected void onBind() {
        super.onBind();
        getView().init();
        list.addDataDisplay(getView().getList());
        firstLoad=true;
    }
       
    
    
    @Override
    protected void onReset(){
    	
    	logger.info("onReset");
    	
    	
    	if(firstLoad){
    		logger.fine("First Load");
    		firstLoad=false;
    		favoriteModeActive = getFavoriteModeFromPlaceToken();
    		list.setList(model.tales);
    		showTales();
    		animate();
    		return;
    	}
    	
    	if(favoriteModeActive!=getFavoriteModeFromPlaceToken() ){
    		logger.fine("Mode change. Favorite is: "+favoriteModeActive);
    		favoriteModeActive = getFavoriteModeFromPlaceToken();
    		showTales();
    		animate();
    		return;
    	}
    	
    	redrawSelectedTale();
    	animate();
    	
    	
    }
    
    private void animate(){
    	logger.info("animate");
    	getView().scrollTo(scrollPos);   	
    	
    	Runnable runnable = new Runnable(){

			@Override
			public void run() {
				getView().setOpacity(1);
			}
			
		};
    	
    	MaterialAnimator.animate(Transition.FADEINLEFT, getView().asWidget(), 0, 1000, runnable, false);
    }
    
    
    private void showTales(){
    	logger.fine("actualMode is: " +favoriteModeActive);
    	
    	if(favoriteModeActive){
    		showFavoriteTales();
       	}else{
       		showAllTales();
       	}
    }
    
    private void redrawSelectedTale(){
    	if(model.selectedTale!=null){
    		getView().redrawTale(model.tales.indexOf(model.selectedTale));
    	}
    }
    
    private void showFavoriteTales() {
    	
    	getView().setFavoriteMode(true);
    	getView().redraw();
    	logger.fine("showing favorited");
	}

	private void showAllTales() {
		getView().setFavoriteMode(false);
    	getView().redraw();
		logger.fine("showing all");
	}

	private boolean getFavoriteModeFromPlaceToken(){
    	String favoriteStr = placeManager.getCurrentPlaceRequest().getParameter(NameParams.favorite, "false");
    	logger.fine("place from token. Favorite mode is:" + favoriteStr);
    	if("true".equals(favoriteStr)){
    		return true;
    	}else{
    		return false;
    	}
    	
    	
    }

	/**
	 * When user selects a tale
	 */
    @Override
	public void update(Tale tale) {
    	scrollPos = getView().getScrollPos();
    	Runnable runnable = new Runnable(){

			@Override
			public void run() {
				PlaceRequest placeRequest = new PlaceRequest.Builder()
			            .nameToken(NameTokens.reader).with(NameParams.taleId, tale.id)
			            .build();
				placeManager.revealPlace(placeRequest, true);
				getView().setOpacity(0);
				
			}
    	};
    	
    	MaterialAnimator.animate(Transition.FADEOUTLEFT, this.asWidget(), 0, 400, runnable, false);

	
	}
    
    @Override
	public void prepareFromRequest(PlaceRequest request) {
    	
    	logger.info("prepareFromRequest");
		getView().setOpacity(0);
		getProxy().manualReveal(this);
	}
	
    
    @Override
	public boolean useManualReveal() {
	    return true;
	}
    
    @Override
    protected void onReveal(){
    	logger.info("onReveal");
    
    	
    }
        
} 