package com.kosa.controller;

import com.kosa.controller.action.Action;
import com.kosa.controller.action.IndexAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory  :" + command);
		/* 추가된 부분 */
		if (command.equals("index")) {
			action = new IndexAction();
		}
		return action;
	}
}