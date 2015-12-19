package cat.contesencatala.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import cat.contesencatala.client.application.login.LoginView;

public interface AppResources extends ClientBundle {
    
	interface Normalize extends CssResource {
    }

    interface Style extends LoginView.Style{
    }

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source("css/style.gss")
    Style style();
}