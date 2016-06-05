package cat.contesencatala.client.application.home;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.place.NameTokens;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {
    interface MyView extends View, HasUiHandlers<HomeUiHandlers>{

		void goTop();

    }
    Logger logger = Logger.getLogger(HomePresenter.class.getName());
	private PlaceManager placeManager;
    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
        getView().setUiHandlers(this);
       this.placeManager = placeManager;
    }
    
    @Override
    protected void onBind() {    	
    	logger.info("HomePresenter bind!");
    }
    
    @Override
    public void onReveal(){
    	getView().goTop();
    }

	@Override
	public void showTales() {
		  PlaceRequest placeRequest = new PlaceRequest.Builder()
		            .nameToken(NameTokens.talelist)
		            .build();
	
		placeManager.revealPlace(placeRequest);
		
	}
}
