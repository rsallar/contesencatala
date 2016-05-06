package cat.contesencatala.client.application.reader;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ReaderModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ReaderPresenter.class, ReaderPresenter.MyView.class, ReaderView.class, ReaderPresenter.MyProxy.class);
    }
}