package cat.contesencatala.client.application.login;

import com.google.gwt.core.shared.GWT;
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
    
    @ProxyStandard
    @NameToken(NameTokens.LOGIN)
    interface MyProxy extends ProxyPlace<LoginPresenter>{}

    @Inject
    LoginPresenter(
            EventBus eventBus,
            MyView view, MyProxy proxy) {
    	 super(eventBus, view, proxy, RevealType.Root);
        
    }
    
    @Override
    protected void onReveal() {
    	GWT.log("reveal");
    }
}