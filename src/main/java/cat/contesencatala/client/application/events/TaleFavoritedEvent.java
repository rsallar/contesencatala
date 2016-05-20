package cat.contesencatala.client.application.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class TaleFavoritedEvent extends GwtEvent<TaleFavoritedEvent.TaleFavoritedHandler> {
    private static Type<TaleFavoritedHandler> TYPE = new Type<TaleFavoritedHandler>();
    
    public interface TaleFavoritedHandler extends EventHandler {
        void onTaleFavorited(TaleFavoritedEvent event);
    }
    
    public interface TaleFavoritedHandlers extends HasHandlers {
        HandlerRegistration addTaleFavoritedHandler(TaleFavoritedHandler handler);
    }
    
   
    public TaleFavoritedEvent() {

    }

    public static Type<TaleFavoritedHandler> getType() {
        return TYPE;
    }
    
    public static void fire(HasHandlers source) {
        source.fireEvent(new TaleFavoritedEvent());
    }

    @Override
    protected void dispatch(final TaleFavoritedHandler handler) {
        handler.onTaleFavorited(this);
    }

    @Override
    public Type<TaleFavoritedHandler> getAssociatedType() {
        return TYPE;
    }
    
}