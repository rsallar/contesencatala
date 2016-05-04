package cat.contesencatala.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import cat.contesencatala.client.application.home.HomeModule;
import cat.contesencatala.client.application.login.LoginModule;
import cat.contesencatala.client.application.menu.MenuModule;
import cat.contesencatala.client.application.error.ErrorModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ErrorModule());
		install(new MenuModule());
		// install(new ErrorModule());
		install(new LoginModule());
		install(new HomeModule());
	
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
