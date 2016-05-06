package cat.contesencatala.client.application.widgets.tale;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import cat.contesencatala.client.place.NameTokens;
public class TalePresenter extends PresenterWidget<TalePresenter.MyView> implements TaleUiHandlers {
    
	private boolean selected = false;
	
	PlaceManager placeManager;
	private String taleId;
	
	interface MyView extends View , HasUiHandlers<TaleUiHandlers> {

		void setTitle(String title);

		void setDescription(String description);

		void select();
		
		void unselect();

		void setTale(String tale);
    }

    @Inject
    TalePresenter(
            EventBus eventBus,
            MyView view,
            PlaceManager placeManager) {
        super(eventBus, view);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }
    
    public void setTaleId(String taleId){
    	this.taleId = taleId;
    }
    
    public void setTitle(String title){
    	getView().setTitle(title);
    }
    
    public void setDescription(String description){
    	getView().setDescription(description);
    }

	@Override
	public void selectionToogle() {
		if(selected){
			getView().unselect();
		}else{
			getView().select();
		}
		selected = !selected;
		
	}

	public void setTale(String tale) {
		getView().setTale(tale);
	}

	@Override
	public void read() {
		PlaceRequest placeRequest = new PlaceRequest.Builder()
	            .nameToken(NameTokens.reader)
	            .with("taleId", taleId)
	            .build();
		placeManager.revealPlace(placeRequest);
	}
    
}