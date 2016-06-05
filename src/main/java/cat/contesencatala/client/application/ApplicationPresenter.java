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

import cat.contesencatala.client.application.menu.MenuPresenter;
import cat.contesencatala.client.services.AdMob;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy>  implements ApplicationUiHandlers{
	
	Logger logger = Logger.getLogger(ApplicationPresenter.class.getName());
	private PlaceManager placeManager;

	private MenuPresenter menuPresenter;
	private AdMob AdMob;
	
    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {

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
            Persistance persistance, AdMob AdMob) {
    	
        super(eventBus, view, proxy, RevealType.Root);
        this.AdMob = AdMob;
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
        this.menuPresenter = menuPresenter;
        persistance.load();
        
    }
    
    @Override
    protected void onBind() {  
    	setInSlot(SLOT_MENU, menuPresenter);
    	AdMob.prepareAdds();
    	logger.info("ApplicationPresenter bind!");
    	
    }
   
}
