package cat.contesencatala.client.application.reader;

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

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.place.NameParams;
import cat.contesencatala.client.place.NameTokens;
public class ReaderPresenter extends Presenter<ReaderPresenter.MyView, ReaderPresenter.MyProxy> implements ReaderUiHandlers {
    interface MyView extends View,HasUiHandlers<ReaderUiHandlers> {

		void goTop();

		void setParams(Tale taleById);
    }
    Logger logger = Logger.getLogger(ReaderPresenter.class.getName());
    PlaceManager placeManager;
	private Model model;
    @NameToken(NameTokens.reader)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ReaderPresenter> {
    }

    @Inject
    ReaderPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            PlaceManager placeManager, Model model) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
        this.model = model;
    }
    
    @Override
    protected void onBind() {  
    
    	//IconType.star
    	logger.info("ReaderPresenter bind!");
    	
    }

	@Override
	public void back() {
		
		placeManager.navigateBack();
	}
	
	
	@Override
	public void onReveal() {
		String taleId = placeManager.getCurrentPlaceRequest().getParameter(NameParams.taleId, null);
		getView().setParams(model.getTaleById(taleId));
		getView().goTop();
	}
	
}