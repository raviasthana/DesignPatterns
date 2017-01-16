package mvc.demo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mvc.demo1.model.Model;

public class View extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	//view keeps a reference of model as it needs
	//to represent the model
	private Model model;
	private JButton helloButton;
	private JButton goodByeButton;
	
	public View(Model model) {
		super("MVC Demo");
		this.model = model;
		
		helloButton = new JButton("Say Hello!");
		goodByeButton = new JButton("Say Goodbye!");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx=1;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=1;
		gc.fill=GridBagConstraints.NONE;
		
		add(helloButton,gc);

		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx=1;
		gc.gridy=2;
		gc.weightx=1;
		gc.weighty=1;
		gc.fill=GridBagConstraints.NONE;

		add(goodByeButton,gc);
		
		helloButton.addActionListener(this);
		goodByeButton.addActionListener(this);
		
		//add the observer as an anonymous class
		goodByeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Good Bye!!!");
			}
		});
		
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	//Top level class as the observer of the events
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if(source == helloButton){
			System.out.println("Hello There!!!");
		}else{
			System.out.println("Some other button");
		}
	}
	
	public Model getModel() {
		return model;
	}
}
