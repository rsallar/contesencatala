package cat.contesencatala.client.application.reader;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.FontWeight;
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
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;

class ReaderView extends ViewWithUiHandlers<ReaderUiHandlers> implements ReaderPresenter.MyView {
    interface Binder extends UiBinder<Widget, ReaderView> {
    }
   
    @UiField
    MaterialCardTitle title;
    @UiField
    MaterialLabel text;
    @UiField
    MaterialImage image;
    
    /*@UiField
    SimplePanel main;*/
	private AppResources bundle;

    @Inject
    ReaderView(Binder uiBinder, AppResources bundle) {
    	this.bundle = bundle;
        initWidget(uiBinder.createAndBindUi(this));
        image.setFlexAlignSelf(FlexAlignSelf.CENTER);
        title.setFontWeight(FontWeight.BOLD);
    }
    
    @UiHandler("back")
	 void onClose(ClickEvent e) {
    	
    	 this.getUiHandlers().back();
		 //item.setVisible(true);
		 //MaterialPathAnimator.reverseAnimate(readBtn.getElement(), overlayTarget.getElement());
	 }
    
    
	@Override
	public void goTop() {
		Window.scrollTo(0 ,0);		
	}


	@Override
	public void setParams(Tale tale) {
		
		TextResource textRes = (TextResource) bundle.getResource(tale.id);	
		ImageResource imageRes = (ImageResource) bundle.getResource(tale.id+"_img");
		image.setUrl(imageRes.getSafeUri().asString());
		text.setText(textRes.getText());
		title.setText(tale.title);
		
	}
}