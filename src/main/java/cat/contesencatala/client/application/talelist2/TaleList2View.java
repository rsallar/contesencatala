package cat.contesencatala.client.application.talelist2;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.resources.AppResources;
import gwt.material.design.client.ui.MaterialColumn;


class TaleList2View extends ViewWithUiHandlers<TaleList2UiHandlers> implements TaleList2Presenter.MyView {
    interface Binder extends UiBinder<Widget, TaleList2View> {
    }
    

    @UiField
    MaterialColumn main;

	private AppResources res;
    private	CellList<Tale> cellList;

    @Inject
    TaleList2View(Binder uiBinder, TaleViewCell cell, AppResources res) {
    	this.res = res;
        initWidget(uiBinder.createAndBindUi(this));
        cellList = new CellList<>(cell);
       
    }
    @Override
    public void init(){
    	
    	cellList.setValueUpdater(getUiHandlers());
	    main.add(cellList);
	    
	    //cellList.setRowCount(model.tales.size(), true);
	    //cellList.setRowData(0, model.tales);
	    
	   
    }

	@Override
	public HasData<Tale> getList() {
		return cellList;
	}
    
    
}