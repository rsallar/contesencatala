package cat.contesencatala.client.application.about;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import cat.contesencatala.client.application.ApplicationPresenter;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.place.NameTokens;
public class AboutPresenter extends Presenter<AboutPresenter.MyView, AboutPresenter.MyProxy>  {
    interface MyView extends View  {

		void addCredit(String title, String photoCreditUrl);

		void goTop();
    }
    

    @NameToken(NameTokens.about)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<AboutPresenter> {
    }

	private Model model;

    @Inject
    AboutPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            Model model) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.model = model;
    }
    
    @Override
    public void onBind(){
    	
    	for(Tale tale: model.tales){
    		getView().addCredit(tale.title, tale.photoCreditUrl);
    	}
    }
    
    @Override
    public void onReveal(){
    	getView().goTop();
    }
}