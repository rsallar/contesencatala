package cat.contesencatala.client.application.talelist;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import cat.contesencatala.client.application.widgets.tale.TalePresenter;
import cat.contesencatala.client.resources.AppResources;
import gwt.material.design.client.ui.MaterialCollection;

class TaleListView extends ViewImpl implements TaleListPresenter.MyView {
    interface Binder extends UiBinder<Widget, TaleListView> {
    }

    @UiField
    MaterialCollection list;
	private AppResources resources;
    
    
    
    @Inject
    TaleListView(Binder uiBinder, AppResources resources) {
    	initWidget(uiBinder.createAndBindUi(this));
    	this.resources = resources;
        
    }



	@Override
	public void addTale(TalePresenter tale) {
		list.add(tale);	
	}



	@Override
	public void hideTale(int i) {
		list.getWidget(i).addStyleName(resources.style().hideTale());
		
	}



	@Override
	public void showAll() {
		for (int i=0; i<list.getWidgetCount(); i++){
			list.getWidget(i).removeStyleName(resources.style().hideTale());
		}
		
	}



	@Override
	public void clear() {
		list.clear();
		
	}
      
}