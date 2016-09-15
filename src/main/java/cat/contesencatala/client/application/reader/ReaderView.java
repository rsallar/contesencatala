package cat.contesencatala.client.application.reader;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.resources.AppResources;
import gwt.material.design.client.constants.FlexAlignSelf;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;

class ReaderView extends ViewWithUiHandlers<ReaderUiHandlers> implements ReaderPresenter.MyView {
    interface Binder extends UiBinder<Widget, ReaderView> {
    }
    Logger logger = Logger.getLogger(ReaderView.class.getName());
    
    @UiField
    MaterialRow container;
    @UiField
    MaterialCardTitle title;
    @UiField
    MaterialLabel text;
    @UiField
    MaterialImage image;
    @UiField
    MaterialButton favorite, fontplus, fontminus;
    
    /*@UiField
    SimplePanel main;*/
	private AppResources resources;

    @Inject
    ReaderView(Binder uiBinder, AppResources resources) {
    	this.resources = resources;
        initWidget(uiBinder.createAndBindUi(this));
        image.setFlexAlignSelf(FlexAlignSelf.CENTER);
        image.getParent().getElement().getStyle().setDisplay(Display.BLOCK);
        
    }
    
    @UiHandler("back")
	 void onClose(ClickEvent e) {
    	 this.getUiHandlers().back();
	 }
    
    @UiHandler("favorite")
	 void onFavorite(ClickEvent e) {
    	 getUiHandlers().favoriteClick();
	 }
    
    @UiHandler("fontminus")
	void onFontLess(ClickEvent e) {
    	double fontSize = Double.valueOf(text.getFontSize().replace("px", ""));
    	fontplus.setEnabled(true);
    	if(fontSize==8){
    		fontminus.setEnabled(false);
    	}
    	text.setFontSize(fontSize-1, Unit.PX);
	}
    
    @UiHandler("fontplus")
   	void onFontMore(ClickEvent e) {
    	double fontSize = Double.valueOf(text.getFontSize().replace("px", ""));
    	fontminus.setEnabled(true);
    	if(fontSize==28){
    		fontplus.setEnabled(false);
    	}
    	text.setFontSize(fontSize+1, Unit.PX);
   	}
    
    
	@Override
	public void goTop() {
		Window.scrollTo(0 ,0);		
	}


	@Override
	public void setParams(Tale tale) {
		
		TextResource textRes = (TextResource) resources.getResource(tale.id);	
		ImageResource imageRes = (ImageResource) resources.getResource(tale.id+"_img");
		
		image.setUrl(imageRes.getSafeUri().asString());
		text.setText(textRes.getText());
		title.setText(tale.title);
				
	}

	@Override
	public void unfavorite() {
		favorite.setIconType(IconType.FAVORITE_BORDER);

	}

	@Override
	public void favorite() {
		favorite.setIconType(IconType.FAVORITE);

	}


	@Override
	public void setOpacity(double i) {
		this.asWidget().getElement().getStyle().setOpacity(i);
		
	}
	
	
}