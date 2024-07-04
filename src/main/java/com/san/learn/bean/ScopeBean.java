package com.san.learn.bean;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import com.san.learn.annotation.Web;
import com.san.learn.scope.ApplicationScope;
import com.san.learn.scope.DependentScope;
import com.san.learn.scope.RequestScope;
import com.san.learn.scope.SessionScope;

@Web
public class ScopeBean implements Serializable {

	@Inject
	private RequestScope requestScope;

	@Inject
	private ApplicationScope applicationScope;

	@Inject
	private SessionScope sessionScope;

	@Inject
	private DependentScope dependentScope;

	@Inject
	private Logger logger;

	@PostConstruct
	private void init() {
		logger.log(Level.INFO, "**************************************************************");
		logger.log(Level.INFO, "*********************** Scope bean called ********************");
		logger.log(Level.INFO, "**************************************************************");
	}

	@PreDestroy
	private void kill() {
		logger.log(Level.INFO, "**************************************************************");
		logger.log(Level.INFO, "*********************** Scope bean destroyed ********************");
		logger.log(Level.INFO, "**************************************************************");
	}

	public String requestScopeHashCode() {
		return requestScope.getHashCode();
	}

	public String dependentScopeHashCode() {
		return dependentScope.getHashCode();
	}

	public String sessionScopeHashCode() {
		return sessionScope.getHashCode();
	}

	public String applicationScopeHashCode() {
		return applicationScope.getHashCode();
	}

}