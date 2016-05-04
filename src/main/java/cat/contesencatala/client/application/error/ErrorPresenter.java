package cat.contesencatala.client.application.error;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.place.NameTokens;
public class ErrorPresenter extends Presenter<ErrorPresenter.MyView, ErrorPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    Logger logger = Logger.getLogger(ErrorPresenter.class.getName());

    @NameToken(NameTokens.ERROR)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ErrorPresenter> {
    }

    @Inject
    ErrorPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
    }
    
    @Override
    protected void onBind() {    	
    	logger.info("ErrorPresenter bind!");
    }
    
    
}