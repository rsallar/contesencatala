package cat.contesencatala.client.application.widgets.tale;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import cat.contesencatala.client.resources.AppImages;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.constants.FlexJustifyContent;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

class TaleView extends ViewWithUiHandlers<TaleUiHandlers> implements TalePresenter.MyView {
    interface Binder extends UiBinder<Widget, TaleView> {
    }

    
    @UiField
    MaterialLink title;
    
    @UiField
    MaterialIcon favoriteIcon;
    
    @UiField
    MaterialCollectionItem item;
    
    @UiField
    MaterialLabel author;
    

	private AppImages bundle;
  
    

    @Inject
    TaleView(Binder uiBinder,  AppImages bundle) {
        initWidget(uiBinder.createAndBindUi(this));
        this.bundle = bundle;
        item.setDisplay(Display.FLEX);
        item.setFlexJustifyContent(FlexJustifyContent.SPACE_BETWEEN);
    }

	@Override
	public void setTitle(String text) {
		title.setText(text);
				
	}
	


	@Override
	public void setAuthor(String text) {
		author.setText(text);
	}
		
	 
	 @UiHandler("item")
	 void onClick(ClickEvent e) {
	
		this.getUiHandlers().selection();
		
	 }
	 
	 @Override
	public void select(){
		 item.setBackgroundColor("blue lighten-5");
	 }
	 @Override
	public void unselect(){
		 item.setBackgroundColor("white");
	 }
	 
	
	@Override
	public void favorite() {
		favoriteIcon.setVisible(true);
	}

	@Override
	public void unfavorite() {
		favoriteIcon.setVisible(false);
		
	}
    
}