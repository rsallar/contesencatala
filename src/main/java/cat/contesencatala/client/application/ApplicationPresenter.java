package cat.contesencatala.client.application;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

import cat.contesencatala.client.application.events.TaleSelectedEvent;
import cat.contesencatala.client.application.events.TaleSelectedEvent.TaleSelectedHandler;
import cat.contesencatala.client.application.menu.MenuPresenter;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.place.NameTokens;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy>  implements TaleSelectedHandler, ApplicationUiHandlers{
	
	Logger logger = Logger.getLogger(ApplicationPresenter.class.getName());
	private PlaceManager placeManager;
	private Model model;
	private MenuPresenter menuPresenter;
	
    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {

		void showTaleMenu();

		void hideTaleMenu();
    }

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    
    public static final NestedSlot SLOT_MAIN = new NestedSlot();
    public static final PermanentSlot<MenuPresenter> SLOT_MENU = new PermanentSlot<>();

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager,
            MenuPresenter menuPresenter,
            Model model) {
    	
        super(eventBus, view, proxy, RevealType.Root);
        this.placeManager = placeManager;
        this.model = model;
        getView().setUiHandlers(this);
        addRegisteredHandler(TaleSelectedEvent.getType(), this);
        this.menuPresenter = menuPresenter;
        
    }
    
    @Override
    protected void onBind() {  
    	addToSlot(SLOT_MENU, menuPresenter);

    	logger.info("ApplicationPresenter bind!");
    	
    }
    
    void registerTowardsHistory() {
	   // placeManager.getEventBus().
	  }
    
    @Override
    protected void onReveal() {  
    	if(placeManager.getCurrentPlaceRequest().getNameToken().equals(NameTokens.reader)){
    		logger.info("eureka");
    	}
    	
    }
    @Override
    protected void onReset(){
    	getView().hideTaleMenu();
    }

	@Override
	public void onTaleSelected(TaleSelectedEvent event) {
		logger.fine("tale selected");
		getView().showTaleMenu();
		
	}

	/*
	@Override
	public void read() {
	
	}

	@Override
	public void favorite() {
	
		TaleFavoritedEvent.fire(this);
		
	}*/
}
