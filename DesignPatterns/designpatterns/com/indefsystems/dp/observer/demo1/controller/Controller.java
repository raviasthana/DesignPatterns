package com.indefsystems.dp.observer.demo1.controller;

import com.indefsystems.dp.observer.demo1.LoginFormEvent;
import com.indefsystems.dp.observer.demo1.LoginListener;
import com.indefsystems.dp.observer.demo1.model.Model;
import com.indefsystems.dp.observer.demo1.view.View;

//controller is implementing login listener as it wants
//to be notified of login event
//so controller is an OBSERVER for login events
public class Controller implements LoginListener {

	private Model model;
	private View view;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void loginPerformed(LoginFormEvent event) {
		System.out.println("Login performed: " + event.getUserName() + "; " + event.getUserPassword());
	}
}
