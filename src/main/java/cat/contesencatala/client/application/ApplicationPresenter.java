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
import com.gwtplatform.mvp.client.proxy.Proxy;

import cat.contesencatala.client.application.jsservices.AdMob;
import cat.contesencatala.client.application.jsservices.Rate;
import cat.contesencatala.client.application.menu.MenuPresenter;

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

    Persistance persistance; 
    Rate rate;

	private AdMob adMob;
    
    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            AppProxy proxy,
            MenuPresenter menuPresenter,
            AdMob adMob,
            Persistance persistance, Rate rate) {
    	
        super(eventBus, view, proxy, RevealType.Root);
        getView().setUiHandlers(this);
        this.menuPresenter = menuPresenter;
        this.adMob = adMob;
        this.rate = rate;
        this.persistance = persistance;
        
    }
    
    @Override
    protected void onBind() {  
    	setInSlot(SLOT_MENU, menuPresenter);

    	logger.info("ApplicationPresenter bind!");
    	
    	persistance.load();
        rate.prepareRating();
        adMob.prepare();
            	
    }
   
}
