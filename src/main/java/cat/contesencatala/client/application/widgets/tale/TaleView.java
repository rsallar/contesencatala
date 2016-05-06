package cat.contesencatala.client.application.widgets.tale;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

class TaleView extends ViewWithUiHandlers<TaleUiHandlers> implements TalePresenter.MyView {
    interface Binder extends UiBinder<Widget, TaleView> {
    }

    @UiField
    MaterialLink title;
    
    @UiField
    MaterialIcon starIcon;
    
    @UiField
    MaterialCollapsibleItem item;
    
    @UiField
    MaterialLabel description;
    
    @UiField
    MaterialButton readBtn;
  
    

    @Inject
    TaleView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	@Override
	public void setTitle(String text) {
		title.setText(text);
		
		
	}

	@Override
	public void setDescription(String text) {
		description.setText(text);
	}
	
	@UiHandler("starIcon")
	void handleClick(ClickEvent e) {
		this.getUiHandlers().selectionToogle();
		e.stopPropagation();
	
	}
	
	 @UiHandler("readBtn")
	 void onSource(ClickEvent e) {
		 this.getUiHandlers().read();
		 //MaterialPathAnimator.animate(readBtn.getElement(), overlayTarget.getElement());
		
	 }
	 
	


	@Override
	public void select() {
		starIcon.setIconType(IconType.STAR);
	}

	@Override
	public void unselect() {
		starIcon.setIconType(IconType.STAR_OUTLINE);
		
	}

	@Override
	public void setTale(String tale) {
		// TODO Auto-generated method stub
		
	}
    
}