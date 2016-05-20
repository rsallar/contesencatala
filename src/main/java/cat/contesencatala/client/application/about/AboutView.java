package cat.contesencatala.client.application.about;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class AboutView extends ViewImpl implements AboutPresenter.MyView {
    interface Binder extends UiBinder<Widget, AboutView> {
    }

    @UiField
    SimplePanel main;

    @Inject
    AboutView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
   
}