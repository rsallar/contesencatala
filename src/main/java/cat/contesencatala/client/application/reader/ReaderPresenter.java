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
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.application.Persistance;
import cat.contesencatala.client.application.jsservices.AdMob;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.place.NameParams;
import cat.contesencatala.client.place.NameTokens;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.jquery.client.api.Functions;
public class ReaderPresenter extends Presenter<ReaderPresenter.MyView, ReaderPresenter.MyProxy> implements ReaderUiHandlers {
    interface MyView extends View,HasUiHandlers<ReaderUiHandlers> {

		void goTop();

		void setParams(Tale taleById);

		void unfavorite();

		void favorite();

		void setOpacity(double i);
    }
    
    MaterialAnimation animation = new MaterialAnimation();
    Logger logger = Logger.getLogger(ReaderPresenter.class.getName());
    PlaceManager placeManager;
	private Model model;
	private Persistance persistance;
	private AdMob adMob;
    @NameToken(NameTokens.reader)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ReaderPresenter> {
    }

    @Inject
    ReaderPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            PlaceManager placeManager, Model model, Persistance persistance, AdMob adMob) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
        this.model = model;
        this.adMob = adMob;
        this.persistance = persistance;
    }
    
    @Override
    protected void onBind() {  
    	logger.info("ReaderPresenter bind!");
    	
    }

	@Override
	public void back() {
		
		Functions.Func runnable = new Functions.Func(){
	
			@Override
			public void call() {
				getView().setOpacity(0);
				placeManager.navigateBack();		
				
			}
		};
		animation.setDelayMillis(0);
		animation.setDurationMillis(400);
		animation.setTransition(Transition.FADEOUTRIGHT);
		animation.setInfinite(false);
		animation.animate(getView().asWidget(), runnable);
				
	}
	
	
	@Override
	public void onReveal() {
		adMob.showInterstitial();
		getView().goTop();
		
		Functions.Func runnable = new Functions.Func(){
			
			@Override
			public void call() {
				getView().setOpacity(1);	
				
			}
		};
			
		animation.setDelayMillis(0);
		animation.setDurationMillis(1000);
		animation.setTransition(Transition.FADEINRIGHT);
		animation.setInfinite(false);
		animation.animate(getView().asWidget(), runnable);


	}

	@Override
	public void favoriteClick() {
		if(model.selectedTale.favorite){
			getView().unfavorite();	
		}else{
			getView().favorite();
		}
		model.selectedTale.favorite = !model.selectedTale.favorite;
		persistance.save(model.selectedTale);
	}
	
	@Override
	public void onReset(){
				
		String taleId = placeManager.getCurrentPlaceRequest().getParameter(NameParams.taleId, null);
		model.selectedTale = model.getTaleById(taleId);
		getView().setParams(model.selectedTale);
		if(model.selectedTale.favorite){
			getView().favorite();	
		}else{
			getView().unfavorite();
		}
		
	}
	
	@Override
	public boolean useManualReveal() {
	    return true;
	}
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		getView().setOpacity(0);
		getView().goTop();
		getProxy().manualReveal(this);
	}
	
}