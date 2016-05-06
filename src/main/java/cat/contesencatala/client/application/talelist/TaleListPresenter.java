package cat.contesencatala.client.application.talelist;

import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.application.widgets.tale.TalePresenter;
import cat.contesencatala.client.place.NameTokens;
public class TaleListPresenter extends Presenter<TaleListPresenter.MyView, TaleListPresenter.MyProxy>  {
    interface MyView extends View  {

		void addTale(TalePresenter tale1);
    }
    Logger logger = Logger.getLogger(TaleListPresenter.class.getName());
    
    @Inject Provider<TalePresenter> talesProvider;
    
    @NameToken(NameTokens.talelist)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<TaleListPresenter> {
    }

    @Inject
    TaleListPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
    }
    
    @Override
    protected void onBind() {    	
    	logger.info("TaleListPresenter bind!");
    	init();
    }
    
    public void init(){
    	
    	for(int i=0; i<10; i++){
    		
    		TalePresenter tale = talesProvider.get();
    		tale.setTitle("title "+i);
    		tale.setDescription("descripton "+i);
    		
    		tale.setTale("tale tale tale tale tale");
    		
    		getView().addTale(tale);
    	}

    	
    }
}