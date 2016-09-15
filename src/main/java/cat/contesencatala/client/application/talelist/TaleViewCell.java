package cat.contesencatala.client.application.talelist;

import java.util.logging.Logger;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.uibinder.client.UiRenderer;
import com.google.inject.Inject;

import cat.contesencatala.client.application.model.Tale;
import cat.contesencatala.client.resources.AppResources;

public class TaleViewCell extends AbstractCell<Tale> {
	
	 Logger logger = Logger.getLogger(TaleViewCell.class.getName());
  
	interface MyUiRenderer extends UiRenderer {
     void render(SafeHtmlBuilder sb, String title, SafeUri url,
    		 String description, String iconClasses, String badgeClasses);
  }
  
	private static MyUiRenderer renderer = GWT.create(MyUiRenderer.class);
  
private boolean favoriteMode;

private AppResources appRes;
  
  @Inject
  TaleViewCell(AppResources appRes){
	  super("click");
	  this.appRes = appRes;
  }

  @Override
  public void render(Context context, Tale value, SafeHtmlBuilder builder) {
	  
	if(favoriteMode && !value.favorite){
		return;
	}
	
	ImageResource imgRes = (ImageResource) appRes.getResource(value.id+"_img");

	logger.fine("rendering id: "+value.id);
	
	
	
    renderer.render(builder, value.title, imgRes.getSafeUri(), value.author, getIconClass(value), getBadgeClass(value));
  }

private String getIconClass(Tale value) {
	String iconClass = "material-icons "+appRes.style().favorite();
	if(!value.favorite){
		iconClass = iconClass + " hide";
	}
	return iconClass;
}

private String getBadgeClass(Tale value) {
	String badgeClass = "white-text blue badge sideBarBadge";
	if(!value.newTale){
		badgeClass = badgeClass + " hide";
	}
	return badgeClass;
}

//
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
  
  public void setFavoriteMode(boolean favoriteMode){
	  this.favoriteMode = favoriteMode;
  }
  
}