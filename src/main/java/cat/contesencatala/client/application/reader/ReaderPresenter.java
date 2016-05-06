package cat.contesencatala.client.application.reader;

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
public class ReaderPresenter extends Presenter<ReaderPresenter.MyView, ReaderPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    Logger logger = Logger.getLogger(ReaderPresenter.class.getName());

    @NameToken(NameTokens.reader)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ReaderPresenter> {
    }

    @Inject
    ReaderPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
    }
    
    @Override
    protected void onBind() {  
    
    	//IconType.star
    	logger.info("ReaderPresenter bind!");
    }
}