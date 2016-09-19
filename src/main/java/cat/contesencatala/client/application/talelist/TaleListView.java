package cat.contesencatala.client.application.talelist;

import javax.inject.Inject;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import cat.contesencatala.client.application.model.Tale;


class TaleListView extends ViewWithUiHandlers<TaleListUiHandlers> implements TaleListPresenter.MyView {
    interface Binder extends UiBinder<Widget, TaleListView> {
    }
    

    @UiField(provided=true)
    final CustomCellList<Tale> cellList ;

	private TaleViewCell cell;

    @Inject
    TaleListView(Binder uiBinder, TaleViewCell cell) {
       
        this.cell = cell;
        cellList = new CustomCellList<>(cell);
        cellList.addCellParentClassName("col s12 m6 l4");
        Element firstChild = (Element)cellList.getElement().getFirstChild();
        firstChild.addClassName("row");
        initWidget(uiBinder.createAndBindUi(this));
    
       
    }
    
    @Override
    public void init(){
        cellList.setValueUpdater(getUiHandlers());
    }

	@Override
	public HasData<Tale> getList() {
		return cellList;
	}
	@Override
	public void redrawTale(int talePos){
		 cellList.redrawRow(talePos);
	}
	@Override
	public void setFavoriteMode(boolean favoriteMode) {
		cell.setFavoriteMode(favoriteMode);
	}
	@Override
	public void redraw() {
		cellList.redraw();
		
	}
	
		
	@Override
	public void setOpacity(double i) {
		this.asWidget().getElement().getStyle().setOpacity(i);
		
	}
	
	@Override
	public int getScrollPos(){
		return Window.getScrollTop();	
	}

	@Override
	public void scrollTo(int scrollPos) {
		Window.scrollTo(0 ,scrollPos);		
	}
    
}