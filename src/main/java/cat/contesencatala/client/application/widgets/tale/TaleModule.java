package cat.contesencatala.client.application.widgets.tale;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TaleModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(TalePresenter.class, TalePresenter.MyView.class, TaleView.class);
    }
}