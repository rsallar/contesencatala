package cat.contesencatala.client.application;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import gwt.material.design.client.ui.MaterialContainer;

public class ApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers> implements ApplicationPresenter.MyView {
    
	
	
	interface Binder extends UiBinder<Widget, ApplicationView> {
    }
    Logger logger = Logger.getLogger(ApplicationView.class.getName());
    
    @UiField
    MaterialContainer main;
    @UiField
    HTMLPanel menu;
       
    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
       
        bindSlot(ApplicationPresenter.SLOT_MENU,  menu);
        
        bindSlot(ApplicationPresenter.SLOT_MAIN, main);
       
        
       
    }
}
