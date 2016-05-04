package cat.contesencatala.client.application.menu;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.place.NameTokens;
public class MenuPresenter extends Presenter<MenuPresenter.MyView, MenuPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    
    public static final NestedSlot SLOT_MENU = new NestedSlot();
    Logger logger = Logger.getLogger(MenuPresenter.class.getName());
    
    @ProxyStandard
    @NameToken(NameTokens.MENU)
    interface MyProxy extends Proxy<MenuPresenter> {
    }

    @Inject
    MenuPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
    }
    
    @Override
    protected void onBind() {    	
    	logger.info("MenuPresenter bind!");
    }
    
    
}