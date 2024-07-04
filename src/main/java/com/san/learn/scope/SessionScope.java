package com.san.learn.scope;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SessionScope implements Serializable {

	public String getHashCode() {
		return this.hashCode() + " ";
	}
}
