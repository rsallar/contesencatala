package cat.contesencatala.client.application.talelist;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialCollapsibleBody;
import gwt.material.design.client.ui.MaterialCollapsibleHeader;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

class TaleListView extends ViewImpl implements TaleListPresenter.MyView {
    interface Binder extends UiBinder<Widget, TaleListView> {
    }

    @UiField
    MaterialCollapsible list;
    
    private TaleView.Binder viewBinder;

    @Inject
    TaleListView(Binder uiBinder, TaleView.Binder viewBinder) {
        this.viewBinder = viewBinder;
    	initWidget(uiBinder.createAndBindUi(this));
        init();
    }
    
    
    public void init(){
    	
    	/*viewBinder.createAndBindUi(TaleView.class);
    	
    	
    	list.add(createItem("tale1"));
    	list.add(createItem("tae2"));
    	*/
    	
    }
    
    /*
    private MaterialCollapsibleItem createItem(String text){
    	
    	
    	label.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat");
    	body.add(label);
    	
    	item.add(header);
    	item.add(body);

    	return item;
    	
    }*/
    
}