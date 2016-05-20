package cat.contesencatala.client.application.talelist2;

import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
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
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.place.NameParams;
import cat.contesencatala.client.place.NameTokens;
public class TaleList2Presenter extends Presenter<TaleList2Presenter.MyView, TaleList2Presenter.MyProxy> implements TaleList2UiHandlers {
    interface MyView extends View , HasUiHandlers<TaleList2UiHandlers> {

		HasData<Tale> getList();

		void init();
    }


    @NameToken(NameTokens.talelist2)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<TaleList2Presenter> {
    }

	private Model model;
	private PlaceManager placeManager;
    
    

    @Inject
    TaleList2Presenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            Model model,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
        getView().setUiHandlers(this);
        getView().init();
        this.placeManager = placeManager;
        this.model = model;
    }
    
    protected void onBind() {
        super.onBind();
        
        ListDataProvider<Tale> list = new ListDataProvider<>(model.tales);
        list.addDataDisplay(getView().getList());
        
    }

	@Override
	public void update(Tale tale) {
		PlaceRequest placeRequest = new PlaceRequest.Builder()
	            .nameToken(NameTokens.reader).with(NameParams.taleId, tale.id)
	            .build();
		placeManager.revealPlace(placeRequest, true);
	}
    
    
    
}