package cat.contesencatala.client.application.home;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import cat.contesencatala.client.resources.AppImages;
import cat.contesencatala.client.services.InAppPurchase;

public class HomeView extends ViewImpl implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

	private AppImages res;
    
    
    @Inject
    HomeView(Binder uiBinder, AppImages res) {
        initWidget(uiBinder.createAndBindUi(this));
        this.res = res;
        
       // image.setUrl(res.background().getSafeUri().asString());
    }
    
    
    @UiHandler("testButton")
    void handleClick(ClickEvent e) {
    		InAppPurchase purchase = new InAppPurchase();
    		
    		purchase.test();
     }
    
	@Override
	public void goTop() {
		Window.scrollTo(0 ,0);		
	}
}
