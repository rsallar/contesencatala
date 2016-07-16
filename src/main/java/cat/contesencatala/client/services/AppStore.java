package cat.contesencatala.client.services;

import com.google.gwt.core.client.JavaScriptObject;

public class AppStore {

	private static native JavaScriptObject prepareId() /*-{

		function initializeStore() {

			// Let's set a pretty high verbosity level, so that we see a lot of stuff
			// in the console (reassuring us that something is happening).
			$wnd.store.verbosity = store.INFO;

			// We register a dummy product. It's ok, it shouldn't
			// prevent the store "ready" event from firing.
			$wnd.store.register({
				id : "cat.contesencatala.inappid1",
				alias : "100 coins",
				type : store.CONSUMABLE
			});

			// When every goes as expected, it's time to celebrate!
			// The "ready" event should be welcomed with music and fireworks,
			// go ask your boss about it! (just in case)
			$wnd.store.ready(function() {
				console.log("\\o/ STORE READY \\o/");
			});

			// After we've done our setup, we tell the store to do
			// it's first refresh. Nothing will happen if we do not call store.refresh()
			$wnd.store.refresh();
		}
	}-*/;
}
