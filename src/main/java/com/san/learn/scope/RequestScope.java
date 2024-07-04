package com.san.learn.scope;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScope implements Serializable {

	public String getHashCode() {
		return this.hashCode() + " ";
	}
}
