package cat.contesencatala.client.application.talelist2;

import java.util.logging.Logger;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiRenderer;
import com.google.inject.Inject;

import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.resources.AppResources;

public class TaleViewCell extends AbstractCell<Tale> {
	
	 Logger logger = Logger.getLogger(TaleViewCell.class.getName());
  
	interface MyUiRenderer extends UiRenderer {
     void render(SafeHtmlBuilder sb, String title, String url, String description);
  }
  
	private static MyUiRenderer renderer = GWT.create(MyUiRenderer.class);
  
  private AppResources res;
  
  @Inject
  TaleViewCell(AppResources res){
	  super("click");
	  this.res=res;
  }

  @Override
  public void render(Context context, Tale value, SafeHtmlBuilder builder) {
	ImageResource imgRes = (ImageResource) res.getResource(value.id+"_img");

	String safeUrl = imgRes.getSafeUri().asString();
	logger.fine("rendering id: "+value.id);

    renderer.render(builder, value.title, safeUrl, value.author);
  }
  @Override
  public void onBrowserEvent(Context context, Element parent, Tale value, NativeEvent event,
      ValueUpdater<Tale> valueUpdater) {
	    super.onBrowserEvent(context, parent, value, event, valueUpdater);
	    if ("click".equals(event.getType())) {
	      // Ignore clicks that occur outside of the outermost element.
	      EventTarget eventTarget = event.getEventTarget();
	      if (parent.getFirstChildElement().isOrHasChild(Element.as(eventTarget))) {
	        doAction(value, valueUpdater);
	      }
	    }
  }

  private void doAction(Tale value, ValueUpdater<Tale> valueUpdater) {
     valueUpdater.update(value);
  }
  
}