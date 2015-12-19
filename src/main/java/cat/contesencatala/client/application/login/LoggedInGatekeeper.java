package cat.contesencatala.client.application.login;
import javax.inject.Inject;

import com.gwtplatform.mvp.client.annotations.DefaultGatekeeper;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

//@DefaultGatekeeper
public class LoggedInGatekeeper implements Gatekeeper {
    private final CurrentSession currentSession;

    @Inject
    LoggedInGatekeeper(CurrentSession currentSession) {
        this.currentSession = currentSession;
    }

    @Override
    public boolean canReveal() {
        return currentSession.isLoggedIn();
    }
}