package cat.contesencatala.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import cat.contesencatala.client.application.home.HomeModule;
import cat.contesencatala.client.application.login.LoginModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new LoginModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
