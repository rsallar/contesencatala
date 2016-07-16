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
import cat.contesencatala.client.services.BackButton;
import cat.contesencatala.client.services.Rate;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.AppProxy>  implements ApplicationUiHandlers{
	
	Logger logger = Logger.getLogger(ApplicationPresenter.class.getName());
	
	private MenuPresenter menuPresenter;
	
    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {

    }

    @ProxyStandard
    interface AppProxy extends Proxy<ApplicationPresenter> {
    }

    
    public static final NestedSlot SLOT_MAIN = new NestedSlot();
    public static final PermanentSlot<MenuPresenter> SLOT_MENU = new PermanentSlot<>();

    BackButton backButton;
    Persistance persistance; 
    Rate rate;
    
    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            AppProxy proxy,
            MenuPresenter menuPresenter,
           
            Persistance persistance, Rate rate) {
    	
        super(eventBus, view, proxy, RevealType.Root);
        getView().setUiHandlers(this);
        this.menuPresenter = menuPresenter;
        
        this.rate = rate;
        this.persistance = persistance;
        this.backButton = backButton;
        
    }
    
    @Override
    protected void onBind() {  
    	setInSlot(SLOT_MENU, menuPresenter);

    	logger.info("ApplicationPresenter bind!");
    	
    	persistance.load();
        rate.prepareRating();
        backButton.init();
    	
    }
   
}
