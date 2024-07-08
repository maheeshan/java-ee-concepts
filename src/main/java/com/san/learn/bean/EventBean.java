package com.san.learn.bean;

import java.time.LocalDateTime;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.san.learn.annotation.Admin;
import com.san.learn.annotation.SuperUserEvent;
import com.san.learn.annotation.Web;
import com.san.learn.event.EventData;
import com.san.learn.event.User;

import lombok.Data;

@Web
@Data
public class EventBean {

	@Inject
	private User user;

	@Inject
	Event<EventData> plainEvent;

	@Inject
	@SuperUserEvent
	Event<EventData> superUserEvent;

	@Inject
	Event<String> greetingEvent;

	@Inject
	@Admin
	private Event<EventData> conditionalEvent;

	public void login() {
		plainEvent.fire(new EventData(user.getUserName(), LocalDateTime.now()));
	}

	public void superUserLogin() {
		superUserEvent.fire(new EventData(user.getUserName(), LocalDateTime.now()));
	}

	public void adminLogin() {
		conditionalEvent.fire(new EventData(user.getUserName(), LocalDateTime.now()));
	}

	public void sayHello() {
		greetingEvent.fire("Hello World!!!");
	}
}
