package cat.contesencatala.client.application.widgets.tale;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class TaleView extends ViewWithUiHandlers<TaleUiHandlers> implements TalePresenter.MyView {
    interface Binder extends UiBinder<Widget, TaleView> {
    }

    @UiField
    SimplePanel main;

    @Inject
    TaleView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
}