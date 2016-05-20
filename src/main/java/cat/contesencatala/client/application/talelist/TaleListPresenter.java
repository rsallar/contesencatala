package cat.contesencatala.client.application.talelist;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.application.events.TaleFavoritedEvent;
import cat.contesencatala.client.application.events.TaleFavoritedEvent.TaleFavoritedHandler;
import cat.contesencatala.client.application.events.TaleSelectedEvent;
import cat.contesencatala.client.application.events.TaleSelectedEvent.TaleSelectedHandler;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.application.widgets.tale.TalePresenter;
import cat.contesencatala.client.place.NameParams;
import cat.contesencatala.client.place.NameTokens;
public class TaleListPresenter extends Presenter<TaleListPresenter.MyView, TaleListPresenter.MyProxy> 
    implements TaleSelectedHandler, TaleFavoritedHandler {
    interface MyView extends View  {

		void addTale(TalePresenter tale1);

		void showAll();

		void clear();

		void hideTale(int i);
    }
    Logger logger = Logger.getLogger(TaleListPresenter.class.getName());
    
    private TalePresenter selectedTale;
    
    @Inject Provider<TalePresenter> talesProvider;

	private Model model;

	private PlaceManager placeManager;
	
    
    @NameToken(NameTokens.talelist)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<TaleListPresenter> {
    }

    @Inject
    TaleListPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            PlaceManager placeManager,
            Model model) {
    	
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.model = model;
        this.placeManager = placeManager;
    }
    
    @Override
    protected void onBind() {    	
    	logger.info("TaleListPresenter bind!");
    	addRegisteredHandler(TaleSelectedEvent.getType(), this);
    	addRegisteredHandler(TaleFavoritedEvent.getType(), this);
    	init();
    	
    }
    
    public void init(){
        	    	
    	for(Tale tale : model.tales){
    		TalePresenter talePresenter = talesProvider.get();
    		talePresenter.setTale(tale);
    		getView().addTale(talePresenter);
    	}

    }
    
    public void showFavorite(){
    	for(int i=0; i<model.tales.size(); i++){
    		if(!model.tales.get(i).favorite){
    			getView().hideTale(i);
    		}
    	}
    	
    }
    
    @Override
    public void onReveal(){
    	if(selectedTale!=null){
    		selectedTale.unselect();
    	}
    	Boolean favoriteMode = Boolean.parseBoolean(placeManager.getCurrentPlaceRequest().getParameter(NameParams.favorite, "false"));
    	
    	logger.fine("onReveal. FavoriteMode is: "+ favoriteMode);
    	if(favoriteMode){
    		showFavorite();
    	}else{
    		getView().showAll();
    	}


    }
    
    
    @Override
    public void onReset(){
    	onReveal();
    }

	@Override
	public void onTaleSelected(TaleSelectedEvent event) {
		
		if(selectedTale!=null){
			selectedTale.unselect();
		}
		selectedTale = (TalePresenter) event.getSource();
		selectedTale.select();
		
	}

	@Override
	public void onTaleFavorited(TaleFavoritedEvent event) {
		logger.info("favorited event captured");
		model.selectedTale.favorite = !model.selectedTale.favorite;
		if(model.selectedTale.favorite){
			selectedTale.favorite(true);
		}else{
			selectedTale.favorite(false);
		}
		
	}
}