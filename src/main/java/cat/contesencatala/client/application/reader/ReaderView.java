package cat.contesencatala.client.application.reader;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class ReaderView extends ViewImpl implements ReaderPresenter.MyView {
    interface Binder extends UiBinder<Widget, ReaderView> {
    }
   
    /*@UiField
    MaterialOverlay overlayTarget;*/
    /*@UiField
    SimplePanel main;*/

    @Inject
    ReaderView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("closeBtn")
	 void onClose(ClickEvent e) {
		 //item.setVisible(true);
		 //MaterialPathAnimator.reverseAnimate(readBtn.getElement(), overlayTarget.getElement());
	 }
}