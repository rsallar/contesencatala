package cat.contesencatala.client.application.reader;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.resources.AppImagesSmall;
import cat.contesencatala.client.resources.AppResources;
import gwt.material.design.client.constants.FlexAlignSelf;
import gwt.material.design.client.constants.IconType;
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
    
    /*@UiField
    SimplePanel main;*/
	private AppImagesSmall bundle;
	private AppResources resources;

    @Inject
    ReaderView(Binder uiBinder, AppImagesSmall bundle, AppResources resources) {
    	this.bundle = bundle;
    	this.resources = resources;
        initWidget(uiBinder.createAndBindUi(this));
        image.setFlexAlignSelf(FlexAlignSelf.CENTER);
        title.setIconColor("red accent-2");
        title.getIcon().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				 getUiHandlers().favoriteClick();
			}
		});
        image.getParent().getElement().getStyle().setDisplay(Display.BLOCK);

    }
    
    @UiHandler("back")
	 void onClose(ClickEvent e) {
    	 this.getUiHandlers().back();
	 }
    
    
	@Override
	public void goTop() {
		Window.scrollTo(0 ,0);		
	}


	@Override
	public void setParams(Tale tale) {
		
		TextResource textRes = (TextResource) resources.getResource(tale.id);	
		ImageResource imageRes = (ImageResource) bundle.getResource(tale.id+"_img");
		
		image.setUrl(imageRes.getSafeUri().asString());
		
		//image.setWidth(container.getOffsetWidth()+"px");
		text.setText(textRes.getText());
		title.setText(tale.title);
				
	}

	@Override
	public void unfavorite() {
		title.setIconType(IconType.FAVORITE_BORDER);

	}

	@Override
	public void favorite() {
		title.setIconType(IconType.FAVORITE);

	}
}