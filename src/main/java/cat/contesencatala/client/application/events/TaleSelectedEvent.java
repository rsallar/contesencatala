package cat.contesencatala.client.application.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class TaleSelectedEvent extends GwtEvent<TaleSelectedEvent.TaleSelectedHandler> {
    private static Type<TaleSelectedHandler> TYPE = new Type<TaleSelectedHandler>();
    
    public interface TaleSelectedHandler extends EventHandler {
        void onTaleSelected(TaleSelectedEvent event);
    }
    
    public interface TaleSelectedHandlers extends HasHandlers {
        HandlerRegistration addTaleSelectedHandler(TaleSelectedHandler handler);
    }
    
   
    public TaleSelectedEvent() {

    }

    public static Type<TaleSelectedHandler> getType() {
        return TYPE;
    }
    
    public static void fire(HasHandlers source) {
        source.fireEvent(new TaleSelectedEvent());
    }

    @Override
    protected void dispatch(final TaleSelectedHandler handler) {
        handler.onTaleSelected(this);
    }

    @Override
    public Type<TaleSelectedHandler> getAssociatedType() {
        return TYPE;
    }
    
}