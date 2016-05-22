package cat.contesencatala.client.application.menu;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.place.NameTokens;
import gwt.material.design.client.base.SearchObject;
import gwt.material.design.client.constants.IconType;


public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {
    interface MyView extends View , HasUiHandlers<MenuUiHandlers> {

		void addListSearches(List<SearchObject> listSearches);

    }
    private List<SearchObject> listSearches = new ArrayList<>();
	private Model model;
    @Inject
    MenuPresenter(
            EventBus eventBus,
            MyView view,
            Model model
            ) {
    
        super(eventBus, view);
        this.model = model;
        getView().setUiHandlers(this);
    }
    
    @Override
    public void onBind(){
     	
    	for(Tale tale: model.tales){
    		String token = "#"+NameTokens.reader+"?taleId="+tale.id;

    		if(tale.favorite){
    			listSearches.add(new SearchObject(IconType.FAVORITE, tale.title, token));
    		}else{
    			listSearches.add(new SearchObject(IconType.BOOKMARK_BORDER, tale.title, token));
    		}
    			
    	}
    	
    	getView().addListSearches(listSearches);
    	  
    }

	   
    
}