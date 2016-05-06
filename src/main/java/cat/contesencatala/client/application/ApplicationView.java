package cat.contesencatala.client.application;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    
	
	
	interface Binder extends UiBinder<Widget, ApplicationView> {
    }
    Logger logger = Logger.getLogger(ApplicationView.class.getName());
    
    @UiField
    SimplePanel main;
    
    @Inject
    ApplicationView(
            Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));    
        bindSlot(ApplicationPresenter.SLOT_MAIN, main);
    }

}
