package com.san.learn.scope;

import java.io.Serializable;

public class DependentScope implements Serializable {

	public String getHashCode() {
		return this.hashCode() + "";
	}
}
