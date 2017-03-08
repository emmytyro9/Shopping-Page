package view;
import javax.swing.* ;
import java.awt.event.* ;
import java.awt.* ;
public class mainPage extends JFrame{
	
	public mainPage() {
		super("mainPage") ;
		initComponent() ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
	}

	public void run() {
		pack() ;
		setVisible(true) ;
	}

	private void initComponent() {
		
	}
	
	public  static void main(String[] args) {
		mainPage main = new mainPage() ;
		main.run() ;
	}

}
