package com.indefsystems.dp.observer.demo1.main;

import javax.swing.SwingUtilities;

import com.indefsystems.dp.observer.demo1.controller.Controller;
import com.indefsystems.dp.observer.demo1.model.Model;
import com.indefsystems.dp.observer.demo1.view.View;

public class Application {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runApp();
			}
		});
	}
	
	private static void runApp(){
		
		Model model = new Model();
		//view makes use of model for its representation
		View view = new View(model);
		
		//controller makes use of both the view and model
		//as it instructs both the view and the model on 
		//what to do
		Controller controller = new Controller(view,model);
		//register controller as the observer of login event with view
		view.setLoginListner(controller);
	}
}
