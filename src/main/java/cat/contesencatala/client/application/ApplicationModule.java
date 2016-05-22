package cat.contesencatala.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import cat.contesencatala.client.application.about.AboutModule;
import cat.contesencatala.client.application.error.ErrorModule;
import cat.contesencatala.client.application.home.HomeModule;
import cat.contesencatala.client.application.login.LoginModule;
import cat.contesencatala.client.application.reader.ReaderModule;
import cat.contesencatala.client.application.talelist.TaleListModule;
import cat.contesencatala.client.application.widgets.tale.TaleModule;
import cat.contesencatala.client.application.menu.MenuModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

		install(new MenuModule());
		install(new TaleListModule());
		install(new AboutModule());
		install(new ReaderModule());
		install(new TaleModule());
		install(new ErrorModule());
		install(new LoginModule());
		install(new HomeModule());
	
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
