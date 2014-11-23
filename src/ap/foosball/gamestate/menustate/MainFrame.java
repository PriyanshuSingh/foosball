package ap.foosball.gamestate.menustate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import ap.foosball.main.Game;

public class MainFrame extends JFrame implements ActionListener{
	private JButton startbtn;
	private JButton helpbtn;
	private JButton aboutbtn;
	private JButton quitbtn;
	//ye static ya jo bhi krna hai krlena
	private Game game;
	
	
	public MainFrame(){
		super("FooSB0ll");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.startbtn=new JButton("START");
		this.aboutbtn=new JButton("ABOUT");
		this.helpbtn=new JButton("HELP");
		this.quitbtn=new JButton("QUIT");
		
		this.add(startbtn);
		this.add(helpbtn);
		this.add(aboutbtn);
		this.add(quitbtn);
		
		setSize(game.getWidth(), game.getHeight());
	
		
		quitbtn.setMnemonic('Q');
		quitbtn.addActionListener(this);
		quitbtn.setActionCommand("quit");
	
		startbtn.setMnemonic('S');
		startbtn.addActionListener(this);
		startbtn.setActionCommand("str");
		
		helpbtn.setMnemonic('H');
		helpbtn.addActionListener(this);
		helpbtn.setActionCommand("help");
		
		aboutbtn.setMnemonic('A');
		aboutbtn.addActionListener(this);
		aboutbtn.setActionCommand("abt");
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		switch(arg0.getActionCommand()){
//		case "quit":
//			System.exit(0);
//			break;
//		case "str":
//
//			break;
//		case "help":
//
//			break;
//		case "abt":
//
//			break;
//		}
	}
	
}