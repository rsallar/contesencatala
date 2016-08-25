package cat.contesencatala.client.application.login;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import cat.contesencatala.client.place.NameTokens;
public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    Logger logger = Logger.getLogger(LoginPresenter.class.getName());
    @ProxyStandard
    @NameToken(NameTokens.login)
    interface MyProxy extends ProxyPlace<LoginPresenter>{}

    @Inject
    LoginPresenter(
            EventBus eventBus,
            MyView view, MyProxy proxy) {
    	 super(eventBus, view, proxy, RevealType.Root);
        
    }
    
    @Override
    protected void onBind() {    	
    	logger.info("LoginPresenter bind!");
    }
}