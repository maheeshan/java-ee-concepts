package com.san.learn.sessionbeans;

import java.io.Serializable;
import java.text.MessageFormat;

import com.san.learn.annotation.ServiceMan;
import com.san.learn.interfaces.Salute;

@ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
public class Soldier implements Salute, Serializable {

	@Override
	public String salute(String name) {
		return MessageFormat.format("Aye Aye Captain!! {0}", name);
	}
}
