package cat.contesencatala.client.gin;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.web.bindery.event.shared.UmbrellaException;
import com.gwtplatform.mvp.client.PreBootstrapper;

public class PreBootstrapperImpl implements PreBootstrapper {
	
	Logger logger = Logger.getLogger(PreBootstrapperImpl.class.getName());
    @Override
    public void onPreBootstrap() {
    	
        GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void onUncaughtException(final Throwable e) {
            	logger.fine("severe error");
            	Throwable unwrapped = unwrap(e);
            	logger.log(Level.FINE, unwrapped.getMessage(), unwrapped);
            	 
            }
        });
    }
    
    public Throwable unwrap(Throwable e) {
	    if(e instanceof UmbrellaException) {
	      UmbrellaException ue = (UmbrellaException) e;
	      if(ue.getCauses().size() == 1) {
	        return unwrap(ue.getCauses().iterator().next());
	      }
	    }
	    return e;
	  }
    
} 