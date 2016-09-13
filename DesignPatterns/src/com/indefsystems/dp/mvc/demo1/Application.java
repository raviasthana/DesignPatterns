package com.indefsystems.dp.mvc.demo1;

import javax.swing.SwingUtilities;

import com.indefsystems.dp.mvc.demo1.model.Model;
import com.indefsystems.dp.mvc.demo1.view.View;
import com.indefsystems.dp.mvc.demo1.view.controller.Controller;

public class Application {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				runApp();
			}
		});
	}
	
	public static void runApp(){
		Model model = new Model();
		//view has reference to the model as it represents the model
		View view = new View(model);
		//controller has reference to both model and view as it instructs
		//both model and view on what to do. In addition it listen to the 
		//view and may or may not listen to the model as well
		Controller controller = new Controller(model,view);
	}
}
