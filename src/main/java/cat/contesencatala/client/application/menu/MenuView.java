package cat.contesencatala.client.application.menu;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class MenuView extends ViewImpl implements MenuPresenter.MyView {
    interface Binder extends UiBinder<Widget, MenuView> {
    }

    @UiField
    SimplePanel main;

    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        //bindSlot(MenuPresenter.SLOT_MENU, main);
    }
    
   
}