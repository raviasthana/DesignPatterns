package com.indefsystems.dp.mvc.demo1.view.controller;

import com.indefsystems.dp.mvc.demo1.model.Model;
import com.indefsystems.dp.mvc.demo1.view.View;

//controller instructs model on what to do
//controller instructs view on what to do
//controller may listen to the view
//controller may or may not listen to model as well
//controller therefore has reference to both model and view
public class Controller {
	
	private Model model;
	private View view;
	
	public Model getModel() {
		return model;
	}

	public View getView() {
		return view;
	}

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
}
