package cat.contesencatala.client.application.talelist;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class TaleView extends ViewImpl{
	
    interface Binder extends UiBinder<Widget, TaleView> {
    }

    @UiField
    HasText title;
    
    @UiField
    HasText text;

    @Inject
    TaleView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    
    public void setText(String _text){
    	text.setText(_text);
    }
    
    public void setTitle(String text){
    	title.setText(text);
    }
 
}