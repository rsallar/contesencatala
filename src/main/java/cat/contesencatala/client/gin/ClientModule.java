/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package cat.contesencatala.client.gin;

import java.util.logging.Logger;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

import cat.contesencatala.client.application.ApplicationModule;
import cat.contesencatala.client.application.Persistance;
import cat.contesencatala.client.application.jsservices.AdMob;
import cat.contesencatala.client.application.jsservices.Rate;
import cat.contesencatala.client.application.model.Model;
import cat.contesencatala.client.application.talelist.TaleViewCell;
import cat.contesencatala.client.place.NameTokens;
import cat.contesencatala.client.resources.ResourceLoader;
import cat.contesencatala.client.resources.i18n.AppMessages;

public class ClientModule extends AbstractPresenterModule {
	Logger logger = Logger.getLogger("ClientModule");
	

    @Override
    protected void configure() {
    	//RestDispatchAsyncModule.Builder dispatchBuilder = new RestDispatchAsyncModule.Builder();	
    	
    	install(new DefaultModule.Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .defaultPlace(NameTokens.home)
                .errorPlace(NameTokens.error)
                .unauthorizedPlace(NameTokens.error)
                .build());
    	
    	install(new ApplicationModule());
    	
    	bind(AppMessages.class).asEagerSingleton();
    	bind(ResourceLoader.class).asEagerSingleton();
        bind(TaleViewCell.class).asEagerSingleton();
        bind(Model.class).asEagerSingleton();
    	bind(Persistance.class).asEagerSingleton();
    	bind(AdMob.class).asEagerSingleton();
    	bind(Rate.class).asEagerSingleton();

    }
}
