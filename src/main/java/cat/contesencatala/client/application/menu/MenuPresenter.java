package cat.contesencatala.client.application.menu;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {
    interface MyView extends View , HasUiHandlers<MenuUiHandlers> {
    }

    @Inject
    MenuPresenter(
            EventBus eventBus,
            MyView view) {
        super(eventBus, view);
        
        getView().setUiHandlers(this);
    }
    
    
}