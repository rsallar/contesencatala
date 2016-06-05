package cat.contesencatala.client.application.home;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import cat.contesencatala.client.resources.AppImagesSmall;
import gwt.material.design.client.ui.MaterialImage;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    MaterialImage image;
    
    
    @Inject
    HomeView(Binder uiBinder, AppImagesSmall bundle) {
        initWidget(uiBinder.createAndBindUi(this));
        image.setUrl(bundle.home_img().getSafeUri().asString());
        image.getParent().getElement().getStyle().setDisplay(Display.BLOCK);

    }
    
    
    @UiHandler("tales")
    void handleClick(ClickEvent e) {
    	getUiHandlers().showTales();
    }
    
	@Override
	public void goTop() {
		Window.scrollTo(0 ,0);		
	}
	
	
}
