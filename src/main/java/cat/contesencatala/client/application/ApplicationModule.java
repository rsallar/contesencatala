package cat.contesencatala.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import cat.contesencatala.client.application.error.ErrorModule;
import cat.contesencatala.client.application.home.HomeModule;
import cat.contesencatala.client.application.login.LoginModule;
import cat.contesencatala.client.application.talelist.TaleListModule;
import cat.contesencatala.client.application.widgets.tale.TaleModule;
import cat.contesencatala.client.application.reader.ReaderModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ReaderModule());
		install(new TaleModule());
		install(new ErrorModule());
		install(new LoginModule());
		install(new HomeModule());
		install(new TaleListModule());
	
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
