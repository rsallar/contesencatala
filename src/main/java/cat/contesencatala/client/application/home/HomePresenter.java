package cat.contesencatala.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.place.NameTokens;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {
    interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }
}
