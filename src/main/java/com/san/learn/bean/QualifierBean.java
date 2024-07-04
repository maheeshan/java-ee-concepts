package com.san.learn.bean;

import java.io.Serializable;

import javax.inject.Inject;

import com.san.learn.annotation.ServiceMan;
import com.san.learn.annotation.Web;
import com.san.learn.interfaces.Salute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Web
public class QualifierBean implements Serializable {

	@Inject
	@ServiceMan(value = ServiceMan.ServiceType.POLICEMAN)
	private Salute policeSalute;
	@Inject
	@ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
	private Salute soldierSalute;

	private String police;
	private String soldier;
	private String name;

	public void policeSalutation() {
		police = policeSalute.salute(name);
	}

	public void soldierSalutation() {
		soldier = soldierSalute.salute(name);
	}
}
