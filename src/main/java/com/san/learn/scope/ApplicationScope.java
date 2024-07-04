package com.san.learn.scope;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationScope implements Serializable {

	public String getHashCode() {
		return this.hashCode() + " ";
	}
}
