package cat.contesencatala.client.application.talelist;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import cat.contesencatala.client.application.widgets.tale.TalePresenter;
import gwt.material.design.client.ui.MaterialCollapsible;

class TaleListView extends ViewImpl implements TaleListPresenter.MyView {
    interface Binder extends UiBinder<Widget, TaleListView> {
    }

    @UiField
    MaterialCollapsible list;
    
    
    
    @Inject
    TaleListView(Binder uiBinder) {
    	initWidget(uiBinder.createAndBindUi(this));
        
    }



	@Override
	public void addTale(TalePresenter tale) {
		list.add(tale);	
	}
    
      
}