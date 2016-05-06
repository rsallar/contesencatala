package cat.contesencatala.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends ClientBundle {
    
	
	interface Normalize extends CssResource {
    }

    interface Style extends CssResource{
    	String closeIcon();
        String star();
        String reader();
    }	
   
    @Source("css/style.gss")
    Style style();
    @Source("css/normalize.gss")
    Normalize normalize();

   
}