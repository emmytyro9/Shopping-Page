package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class Shopping extends JFrame {

	JComboBox choice ;
	JComboBox choice2 ;
	JTextField number = new JTextField("0") ;
	JTextField number2 = new JTextField("0") ;
	JLabel info_SmallProduct1 ;
	JLabel info_MediumProduct1 ;
	JLabel info_LargeProduct1;
	JLabel info_SmallProduct2 ;
	JLabel info_MediumProduct2;
	JLabel info_LargeProduct2 ;
	private int currentProductOneSmall = 10 ;
	private int currentProductTwoSmall = 10 ;
	private int currentProductOneMedium = 10 ;
	private int currentProductTwoMedium = 10 ;
	private int currentProductOneLarge = 10 ;
	private int currentProductTwoLarge = 10 ;
	private String firstForSetString = "" ;
	private String secondForSetString = "" ;

	public Shopping() {
		initComponent();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void run() {
		this.pack();
		this.setVisible(true);
	}

	private void initComponent() {

		this.setLayout(new FlowLayout()) ;

		Container containerA = new Container() ;
		this.add(containerA) ;
		BoxLayout layout = new BoxLayout(containerA , BoxLayout.Y_AXIS) ;
		containerA.setLayout(layout) ;

		Container containerB = new Container() ;
		this.add(containerB) ;
		BoxLayout layout2 = new BoxLayout(containerB , BoxLayout.Y_AXIS) ;
		containerB.setLayout(layout2) ;

		ClassLoader loader = this.getClass().getClassLoader() ;
		URL url = loader.getResource("images/blooming.jpg") ;
		ImageIcon img = new ImageIcon(url) ;
		JLabel blooming = new JLabel(img) ;
		containerA.add(blooming) ;

		ClassLoader loader2 = this.getClass().getClassLoader() ;
		URL url2 = loader2.getResource("images/jadore.jpg") ;
		ImageIcon img2 = new ImageIcon(url2) ;
		JLabel jadore = new JLabel(img2) ;
		containerB.add(jadore) ;


		JLabel infoProduct1 = new JLabel("MISS DIOR BLOOMING BOUQUET") ;
		infoProduct1.setFont(new Font("Serif", Font.BOLD, 20));
		this.add(infoProduct1) ;
		containerA.add(infoProduct1) ;
		JLabel empty = new JLabel(" ") ;
		containerA.add(empty) ;

		JLabel infoProduct2 = new JLabel("J'ADORE") ;
		infoProduct2.setFont(new Font("Serif", Font.BOLD, 20));
		this.add(infoProduct2) ;
		containerB.add(infoProduct2) ;
		JLabel empty2 = new JLabel(" ") ;
		containerB.add(empty2) ;

		info_SmallProduct1 = new JLabel("Small     (1,925 Baht)          :   " + currentProductOneSmall) ;
		this.add(info_SmallProduct1) ;
		containerA.add(info_SmallProduct1) ;
		info_MediumProduct1 = new JLabel("Medium     (2,695 Baht)      :   " + currentProductOneMedium) ;
		this.add(info_MediumProduct1) ;
		containerA.add(info_MediumProduct1) ;
		info_LargeProduct1 = new JLabel("Large     (3,465 Baht)          :   " + currentProductOneLarge) ;
		this.add(info_LargeProduct1) ;
		containerA.add(info_LargeProduct1) ;
		JLabel empty3 = new JLabel(" ") ;
		containerA.add(empty3) ;

		info_SmallProduct2 = new JLabel("Small     (3,465 Baht)          :   "  + currentProductTwoSmall) ;
		this.add(info_SmallProduct2) ;
		containerB.add(info_SmallProduct2) ;
		info_MediumProduct2 = new JLabel("Medium    (4,165 Baht)       :   " + currentProductTwoMedium) ;
		this.add(info_MediumProduct2) ;
		containerB.add(info_MediumProduct2) ;
		info_LargeProduct2 = new JLabel("Large     (4,865 Baht)          :   " + currentProductTwoLarge) ;
		this.add(info_LargeProduct2) ;
		containerB.add(info_LargeProduct2) ;
		JLabel empty4 = new JLabel(" ") ;
		containerB.add(empty4) ;

		String[] text = {"Small" , "Medium" , "Large"} ;
		choice = new JComboBox(text) ;
		this.add(choice) ;
		containerA.add(choice) ;
		JLabel empty5 = new JLabel(" ") ;
		containerA.add(empty5) ;
		JLabel wantNumber = new JLabel("How many would you like to buy?") ;
		wantNumber.setFont(new Font("Serif", Font.BOLD, 15));
		this.add(wantNumber) ;
		containerA.add(wantNumber) ;
		JLabel empty6 = new JLabel(" ") ;
		containerA.add(empty6) ;
		containerA.add(number) ;


		String[] text2 = {"Small" , "Medium" , "Large"} ;
		choice2 = new JComboBox(text2) ;
		this.add(choice2) ;
		containerB.add(choice2) ;
		JLabel empty7 = new JLabel(" ") ;
		containerB.add(empty7) ;

		JLabel wantNumber2 = new JLabel("How many would you like to buy?") ;
		wantNumber2.setFont(new Font("Serif", Font.BOLD, 15));
		this.add(wantNumber2) ;
		containerB.add(wantNumber2) ;
		JLabel empty8 = new JLabel(" ") ;
		containerB.add(empty8) ;
		containerB.add(number2) ;

		JButton button1 = new JButton("BUY");
		this.add(button1);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				String msg =(String)choice.getSelectedItem() ;
				switch(msg) {
				case "Small" : 
					if(getFirstNumber() > 0 && getFirstNumber() <= currentProductOneSmall) {
					firstForSetString = "You buy " + getFirstNumber() + " small MISS DIOR BLOOMING BOUQUET, Total price = " + (getFirstNumber()*1925) + " ß." ;
						 currentProductOneSmall = updateNumber(currentProductOneSmall , getFirstNumber()) ;
						 info_SmallProduct1.setText("Small     (1,925 Baht)          :   " + currentProductOneSmall) ;
					}else if(getFirstNumber() == 0) {
						firstForSetString = "" ;
					}else {
						firstForSetString = "Sorry, there are not enough MISS DIOR BLOOMING BOUQUET." ;
					}
					break ;
				case "Medium" : 
					if(getFirstNumber() > 0 && getFirstNumber() <= currentProductOneMedium) {
					firstForSetString = "You buy " + getFirstNumber() + " medium MISS DIOR BLOOMING BOUQUET, Total price = " + (getFirstNumber()*2695) + " ß." ;
						 currentProductOneMedium = updateNumber(currentProductOneMedium , getFirstNumber()) ;
						info_MediumProduct1.setText("Medium    (4,165 Baht)       :   " + currentProductOneMedium) ;
					}else {
						firstForSetString = "Sorry, there are not enough MISS DIOR BLOOMING BOUQUET." ;
					}
					break ;
				case "Large" : 
					if(getFirstNumber() > 0 && getFirstNumber() <= currentProductOneLarge) {
					firstForSetString = "You buy " + getFirstNumber() + " large MISS DIOR BLOOMING BOUQUET, Total price = " + (getFirstNumber()*3465) + " ß." ;
						 currentProductOneLarge = updateNumber(currentProductOneLarge , getFirstNumber()) ;
						info_LargeProduct1.setText("Large     (3,465 Baht)          :   " + currentProductOneLarge) ;
					}else {
						firstForSetString = "Sorry, there are not enough MISS DIOR BLOOMING BOUQUET." ;
					}
					break ;
				default :
					firstForSetString = "You buy nothing from MISS DIOR BLOOMING BOUQUET, Total price = 0 ß." ;
					break ;
				}
				
				showDialog(firstForSetString) ;

				String msg2 =(String)choice2.getSelectedItem() ;
					switch(msg2) {
					case "Small" : 
						if(getSecondNumber() > 0 && getSecondNumber() <= currentProductTwoSmall) {
						secondForSetString = "You buy " + getSecondNumber() + " small J'ADORE, Total price = " + (getSecondNumber()*3465) + " ß." ;
							 currentProductTwoSmall = updateNumber(currentProductTwoSmall , getSecondNumber()) ;
							info_SmallProduct2.setText("Small     (3,465 Baht)          :   "  + currentProductTwoSmall) ;
						}else {
							secondForSetString = "Sorry, there are not enough J'ADORE." ;
						}
						break ;
					case "Medium" : 
						if(getSecondNumber() > 0 && getSecondNumber() <= currentProductTwoMedium) {
						secondForSetString = "You buy " + getSecondNumber() + " medium J'ADORE, Total price = " + (getSecondNumber()*4165) + " ß." ;
						 currentProductTwoMedium = updateNumber(currentProductTwoMedium , getSecondNumber()) ;
							info_MediumProduct2.setText("Small     (3,465 Baht)          :   "  + currentProductTwoMedium) ;
						}else {
							secondForSetString = "Sorry, there are not enough J'ADORE." ;
						}
						break ;
					case "Large" : 
						if(getSecondNumber() > 0 && getSecondNumber() <= currentProductTwoLarge) {
							if(currentProductTwoLarge <= 0) {
								secondForSetString = "Sorry, there are not enough J'ADORE." ;
							}else{
						secondForSetString = "You buy " + getSecondNumber() + " large J'ADORE, Total price = " + (getSecondNumber()*4185) + " ß." ;
							 currentProductTwoLarge = updateNumber(currentProductTwoLarge , getSecondNumber()) ;
							info_LargeProduct2.setText("Large     (4,865 Baht)          :   " + currentProductTwoLarge) ;
						}
						}else {
							secondForSetString = "Sorry, there are not enough J'ADORE." ;
						}
						break ;
					default :
						secondForSetString = "You buy nothing from J'ADORE, Total price = 0 ß." ;
						break ;
					}
				showDialog(secondForSetString) ;
			}
		}) ;
	}	

	public int getFirstNumber() {
		int FirstNumber = 0 ;
		String info = number.getText() ;
		FirstNumber = Integer.valueOf(info) ;
		return FirstNumber ;
	}

	public int getSecondNumber() {
		int SecondNumber = 0 ;
		String info = number2.getText() ;
		SecondNumber = Integer.valueOf(info) ;
		return SecondNumber ;
	}

	public int updateNumber(int product , int numNeedProduct) {
		product -= numNeedProduct ;
		return product ;
	}

	private void showDialog(String str) {
		String str2 = str ;
		if(!str2.equals("")){
		JOptionPane.showMessageDialog(this,str2, "EMMY'S STORE", JOptionPane.PLAIN_MESSAGE);
		}else {
			str2 = "" ;
		}
	}

	public static void main(String[] args) {
		Shopping shop = new Shopping();
		shop.run();
	}
}