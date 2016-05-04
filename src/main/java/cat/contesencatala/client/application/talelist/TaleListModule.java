package cat.contesencatala.client.application.talelist;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TaleListModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(TaleListPresenter.class, TaleListPresenter.MyView.class, TaleListView.class, TaleListPresenter.MyProxy.class);
    }
}