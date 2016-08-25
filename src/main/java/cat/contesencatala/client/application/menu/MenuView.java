package cat.contesencatala.client.application.menu;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import gwt.material.design.client.base.SearchObject;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.client.ui.MaterialSideNav;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers> implements MenuPresenter.MyView {
    interface Binder extends UiBinder<Widget, MenuView> {
    }
    Logger logger = Logger.getLogger(MenuView.class.getName());
  
    @UiField
    MaterialNavBar navBar, navBarSearch;
    
    @UiField
    MaterialSideNav sideNav;
    
    @UiField 
    MaterialSearch txtSearch;

   
    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        

        txtSearch.addCloseHandler(new CloseHandler<String>() {
            @Override
            public void onClose(CloseEvent<String> event) {
                navBar.setVisible(true);
                navBarSearch.setVisible(false);
            }
        });
            
        
    }
    
    @UiHandler("btnSearch")
    void onSearch(ClickEvent e){
    	txtSearch.clear();
        navBarSearch.setVisible(true);
        navBar.setVisible(false);

    }

	@Override
	public void addListSearches(List<SearchObject> listSearches) {
		txtSearch.setListSearches(listSearches);	
		
	}
      
}