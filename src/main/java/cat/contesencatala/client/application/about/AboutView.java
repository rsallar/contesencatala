package cat.contesencatala.client.application.about;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

class AboutView extends ViewImpl implements AboutPresenter.MyView {
    interface Binder extends UiBinder<Widget, AboutView> {
    }

    @UiField
    MaterialCollection collection;

    @Inject
    AboutView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	@Override
	public void addCredit(String title, String photoCreditUrl) {
		MaterialCollectionItem item = new MaterialCollectionItem();
		//item.setBackgroundColor("teal lighten-5");
		MaterialLabel label = new MaterialLabel(title); 
		
		//label.setFontSize("0.8em");
		//label.setMarginTop(0);
        MaterialLink link = new MaterialLink(photoCreditUrl);
        
       	link.addClickHandler(handler);
       
        
        item.add(label);
        item.add(link);
        collection.add(item);

	}
	
	@Override
	public void goTop() {
		Window.scrollTo(0 ,0);		
	}
    
	
	ClickHandler handler = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			MaterialLink element = (MaterialLink)event.getSource();
			Window.open(element.getText(), "_blank", null);
			
		}
	};
	
	
    
   
}