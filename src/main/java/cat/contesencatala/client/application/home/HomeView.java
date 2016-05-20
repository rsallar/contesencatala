package cat.contesencatala.client.application.home;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import cat.contesencatala.client.resources.AppResources;
import gwt.material.design.client.ui.MaterialImage;

public class HomeView extends ViewImpl implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

	private AppResources res;
    
    
    @Inject
    HomeView(Binder uiBinder, AppResources res) {
        initWidget(uiBinder.createAndBindUi(this));
        this.res = res;
        
       // image.setUrl(res.background().getSafeUri().asString());
    }
}
