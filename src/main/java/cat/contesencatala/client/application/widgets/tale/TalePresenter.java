package cat.contesencatala.client.application.widgets.tale;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import cat.contesencatala.client.application.events.TaleSelectedEvent;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
public class TalePresenter extends PresenterWidget<TalePresenter.MyView> implements TaleUiHandlers {
    

	PlaceManager placeManager;
	private Model model;
	private Tale tale;

	interface MyView extends View , HasUiHandlers<TaleUiHandlers> {

		void setTitle(String title);

		void setAuthor(String author);

		void select();
		
		void unselect();

		void favorite();

		void unfavorite();

    }

    @Inject
    TalePresenter(
            EventBus eventBus,
            MyView view,
            PlaceManager placeManager, Model model) {
        super(eventBus, view);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
        this.model = model;
    }
    
         
	public void favorite(boolean favorite) {
				
		if(favorite){
			getView().favorite();
		}else{
			getView().unfavorite();
		}
	}



	public void setTale(Tale tale) {
		this.tale = tale;
		getView().setAuthor(tale.author);
		getView().setTitle(tale.title);
		getView().setAuthor(tale.author);
		if(tale.favorite){
			getView().favorite();
		}
	}


	@Override
	public void selection() {
		model.selectedTale = tale;
		TaleSelectedEvent.fire(this);
		
	}
	
	public void select(){
		getView().select();
	}
	
	public void unselect(){
		getView().unselect();
	}

	
    
}