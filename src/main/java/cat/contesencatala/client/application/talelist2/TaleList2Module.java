package cat.contesencatala.client.application.talelist2;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TaleList2Module extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(TaleList2Presenter.class, TaleList2Presenter.MyView.class, TaleList2View.class, TaleList2Presenter.MyProxy.class);
    }
}