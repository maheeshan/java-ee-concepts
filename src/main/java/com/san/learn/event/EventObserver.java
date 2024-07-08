package com.san.learn.event;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

import com.san.learn.annotation.Admin;
import com.san.learn.annotation.SuperUserEvent;

@ApplicationScoped
public class EventObserver implements Serializable {

	@Inject
	private Logger logger;

	void plainEvent(@Observes EventData eventData) {

		logger.log(Level.INFO, "User {0} logged in at {1}. Logged from plain event observer", new Object[] {eventData.getEmail(),
				eventData.getLoginTime()});

		/*try {
			Thread.sleep(6000);
		}
		catch (InterruptedException exception) {
			logger.log(Level.SEVERE, null, exception);
		}*/
	}

	void superUserEvent(@Observes @SuperUserEvent EventData eventData) {
		logger.log(Level.INFO, "Super user {0} has logged in at {1}", new Object[] {eventData.getEmail(), eventData.getLoginTime()});
	}

	void adminEvent(
			@Observes(notifyObserver = Reception.IF_EXISTS, during = TransactionPhase.AFTER_COMPLETION)
			@Admin EventData eventData) {
		logger.log(Level.INFO, "Admin {0} has logged in at {1}", new Object[] {eventData.getEmail(), eventData.getLoginTime()});

	}

	void asyncObserver(@ObservesAsync @SuperUserEvent EventData eventData) {
		logger.log(Level.INFO, "User {0} logged in at {1}. Logged from plain event observer", new Object[] {eventData.getEmail(),
				eventData.getLoginTime()});
	}

	void lowPriorityObserver(@Observes @Priority(2) String greeting) {
		logger.log(Level.INFO, "low priority observer invoked with {0}", greeting);
	}

	void highPriorityObserver(@Observes @Priority(1) String greeting) {
		logger.log(Level.INFO, "high priority observer invoked with {0}", greeting);
	}

}
