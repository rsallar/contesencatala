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

package cat.contesencatala.client.application;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import cat.contesencatala.client.application.place.NameTokens;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {

	Logger logger = Logger.getLogger(ApplicationPresenter.class.getName());

	@NameToken(NameTokens.HOME)
	@ProxyCodeSplit
	public interface MyProxy extends ProxyPlace<ApplicationPresenter> {
	}

	public static final NestedSlot MAIN_SLOT = new NestedSlot();

	public interface MyView extends View {

	}

	@Inject
	ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {

		super(eventBus, view, proxy, RevealType.RootLayout);
	}

}
