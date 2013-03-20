import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PizzaOrder {

		static JPanel headPanel = new JPanel();
    	static JPanel topPanel = new JPanel();
    	static JPanel sizePanel = new JPanel();
    	static JPanel billPanel = new JPanel();
    	static JPanel buttonPanel = new JPanel();
    	static JPanel radiopanel = new JPanel();
    	static JPanel blurbPanel = new JPanel();
    	
    	static JRadioButton small, medium, large;
    	
		static JCheckBox Pepperonini, Chicken, BlackPudding, Salami, Pineapple, Peppers, Bacon, Mozzerella, Mushrooms; 
		static ImageIcon icon = new ImageIcon("image/pizza2.jpg");
		static JLabel banner = new JLabel();
		
		static JTextArea ta = new JTextArea(5,25);
		static JButton order = new JButton("Place order!");
		static JButton cancel = new JButton("Reset"); 
		
		static double total =0.0;
		static double smallpizza = 7.0;
		static double medPizza = 10.0;
		static double largePizza = 14.0;
		
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		

		public static void addSizeMenu(){
			
			BorderLayout b = new BorderLayout();
			sizePanel.setLayout(b);
			
			ButtonGroup sizeGroup = new ButtonGroup();
			
			/*GridBagLayout gb = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			sizePanel.setLayout(gb);*/
			
			/*JLabel blurb = new JLabel();
			JRadioButton small, medium, large; 
			*/
    		small = new JRadioButton("small: $7");
    		small.setSelected(true);
    		radioPanel.add(small);
    		sizeGroup.add(small);
    		//JLabel sizeLabel = new JLabel();
    		
    	
    	//small = new JRadioButton("Small €7");
    	//small.setSelected(true);
    	
    	medium = new JRadioButton("Medium €10");
    	radioPanel.add(medium);
    	sizeGroup.add(medium);
    	
    	large = new JRadioButton("Large €14");
    	radioPanel.add(medium);
    	sizeGroup.add(medium);
    	sizePanel.add(radioPanel, BorderLayout.NORTH);
		}
		/*
    	
    	group.add(small);
    	group.add(medium);
    	group.add(large);
    	
    	sizePanel.add(small);
    	sizePanel.add(medium);
    	sizePanel.add(large);
    	
    	sizeLabel = new JLabel("Please choose a pizza size..");
    	sizePanel.add(sizeLabel);
    		
    	}
    	
	
*/
		public static void addToppingMenu(){
	
	GridLayout gl = new GridLayout(3,3,5,5);
	topPanel.setLayout(gl);
	
	
	Pepperonini = new JCheckBox("Pepperonini");
	topPanel.add(pepperoni);
	Chicken = new JCheckBox("Chicken");
	topPanel.add(Chicken);
	BlackPudding = new JCheckBox("Black Pudding");
	topPanel.add(Black_Pudding);
	Salami= new JCheckBox("Salami");
	topPanel.add(Salami);
	Pineapple = new JCheckBox("Pineapple");
	topPanel.add(Pineapple);
	Peppers = new JCheckBox("Peppers"); 
	topPanel.add(Peppers);
	Bacon = new JCheckBox("Bacon");
	topPanel.add(Bacon);
	Mozzerella = new JCheckBox("Mozzerella");
	topPanel.add(Mozzerella);
	Mushrooms = new JCheckBox("Mushrooms");
	topPanel.add(Mushrooms);
	

}
	public static void addBorders(){
		
		Border b1 = BorderFactory.createTitledBorder("Size");
    	sizePanel.setBorder(b1);
    		
    	Border b2 = BorderFactory.createTitledBorder("Toppings");
    	topPanel.setBorder(b2);

}

    public static void display(){
    	JFrame frame = new JFrame("Pizza Orders");	
    	Container c = frame.getContentPane();
    	BoxLayout b = new BoxLayout(c, BoxLayout.Y_AXIS);
    	c.setLayout(b);
    	
    	banner.setIcon(icon); // default centre selection
    	headPanel.add(banner);
    	
    	addBorders();
    	addSizeMenu();
    	addToppingMenu();
    	blurb();
    	
    	billPanel.add(ta);
    	order.addActionListener( this );
    	cancel.addActionListener( this );
    	buttonPanel.add(order);
    	buttonPanel.add(cancel);
    	
    	c.add(headPanel);
    	c.add(topPanel);
    	c.add(sizePanel);
    	c.add(billPanel);
    	c.add(buttonPanel);
    	
    	frame.setSize(300, 600);
    	frame.setVisible(true);
    	frame.setResizable(false);
    	frame.pack();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    	headPanel.setBackground(Color.BLACK);
    	topPanel.setBackground(Color.GREEN);
    	sizePanel.setBackground(Color.YELLOW);
    	billPanel.setBackground(Color.RED); 		
    }
    
	public void findPrice(){
		string custOrder = "You ordered a ";
		String toppings ="";
		
		if (small.isSelected())
			total += smallPizza;
		else
		if (medium.isSelected()){
			total += medPizza;
			custOrder +=" medium pizza with: ";
		}
		else
			Total+= largePizza;
			
			if(pepperoni.isSelected()){
				custOrder += "\n* Pepperoni";
				total += 0.40;
			}
	
	`		Ta.setText(custOrder + "\n\nThe total price is $" + twoDigits.format(total));

}
	public void reset() {
		ta.setText("");
		Pepperonini.setSelected(false);
		mushrooms.setSelected(false); 
		anchovies.setSelected(false);
		sweetcorn.setSelected(false);
		jalapenos.setSelected(false);
		peppers.setSelected(false);
		chicken.setSelected(false);
		ham.setSelected(false);
		
		small.setselected(true);
		medium.setselected(false)
		large.setselected(false);
			
	}
	
	public void actionPerforme (ActionEvent ae){
		//reset all components if order is cancelled
		if (ae.getSource() == cancel)
			reset();
			
			else
		//proceed with order (fire the event)
		if(ae.getsource() == order)
			find price();
	}
	public static void main(string{} args)
		PizzaOrderTest10 app = New PizzaOrderTest10();
		app.display();
}

    }
    
    
