package cat.contesencatala.client.application.login;

import javax.inject.Inject;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class LoginView extends ViewImpl implements LoginPresenter.MyView {
    interface Binder extends UiBinder<Widget, LoginView> {
    }
    
    public interface Style extends CssResource{
    	String loginDemo();
    	String panel();
    	String fieldPanel();
    	String imgProfile();
    	String rowAction();
    }

    @Inject
    LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
  
    
}