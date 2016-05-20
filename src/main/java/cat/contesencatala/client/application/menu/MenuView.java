package cat.contesencatala.client.application.menu;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavSection;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers> implements MenuPresenter.MyView {
    interface Binder extends UiBinder<Widget, MenuView> {
    }

    @UiField
    MaterialLink favoriteBtn;
    @UiField
    MaterialNavSection navBarSection;
   
    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        //navBarSection.removeStyleName("hide-on-med-and-down");
    }
    
    @UiHandler("favoriteBtn")
	void onClickFavBtn(ClickEvent e) {
		//this.getUiHandlers().favorite();
		
	 }
}