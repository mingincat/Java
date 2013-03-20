import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PizzaOrder10 implements ActionListener {

		static JPanel headPanel = new JPanel();
    	static JPanel topPanel = new JPanel();
    	static JPanel sizePanel = new JPanel();
    	static JPanel billPanel = new JPanel();
    	static JPanel buttonPanel = new JPanel();
    	static JPanel radioPanel = new JPanel();
    	static JPanel blurbPanel = new JPanel();
    	
    	static JRadioButton small, medium, large, xtraLarge;
    	
		static JCheckBox pepperoni, mushrooms, anchovies, onions, sweetcorn, jalapenos, ham, chicken, peppers; 
		static ImageIcon icon = new ImageIcon("image/pizza2.jpg");
		static JLabel banner = new JLabel();
		
		static JTextArea ta = new JTextArea(5,25);
		static JButton order = new JButton("Place order!");
		static JButton cancel = new JButton("Reset"); 
		
		static double total =0.0;
		static double smallPizza = 7.0;
		static double medPizza = 10.0;
		static double largePizza = 14.0;
		static double xtraLargePizza = 16.0;
		
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		

	public static void addSizeMenu(){
			
			BorderLayout b = new BorderLayout();
			sizePanel.setLayout(b);
			
			ButtonGroup sizeGroup = new ButtonGroup();
		
    		small = new JRadioButton("small: $7");
    		small.setSelected(true);
    		radioPanel.add(small);
    		sizeGroup.add(small);
    
    		medium = new JRadioButton("Medium €10");
    		radioPanel.add(medium);
    		sizeGroup.add(medium);
    	
    		large = new JRadioButton("Large €14");
    		radioPanel.add(large);
    		sizeGroup.add(large);
    		
    		xtraLarge = new JRadioButton("XtraLarge €16");
    		radioPanel.add(xtraLarge);
    		sizeGroup.add(xtraLarge);
    		
    		sizePanel.add(radioPanel, BorderLayout.NORTH);
		}	
			
/*	public static void addSizeMenu(){
				BorderLayout b = new BorderLayout();
				sizePanel.setLayout(b);
				
				ButtonGroup sizeGroup = new ButtonGroup();
				
				small = new JRadioButton("Small: €7 ");
				small.setSelected(true);
				radioPanel.add(small);
				sizeGroup.add(small);
				
				medium = new JRadioButton("Medium: €10 ");
				radioPanel.add(medium);
				sizeGroup.add(medium);
				
				large = new JRadioButton("Large: €14 ");
				radioPanel.add(large);
				sizegroup.add(large);
				sizePanel.add(radioPanel, BorderLayout.NORTH);						
			}*/
				
	public static void addToppingMenu(){
	
			GridLayout gl = new GridLayout(3,3,5,5);
			topPanel.setLayout(gl);
	
		
			pepperoni = new JCheckBox("pepperoni");
			topPanel.add(pepperoni);
			mushrooms = new JCheckBox("mushrooms");
			topPanel.add(mushrooms);
			anchovies = new JCheckBox("anchovies");
			topPanel.add(anchovies);
			onions = new JCheckBox("onions");
			topPanel.add(onions);
			sweetcorn = new JCheckBox("sweetcorn");
			topPanel.add(sweetcorn);
			jalapenos = new JCheckBox("jalapenos"); 
			topPanel.add(jalapenos);
			ham = new JCheckBox("ham");
			topPanel.add(ham);
			chicken = new JCheckBox("chicken");
			topPanel.add(chicken);
			peppers = new JCheckBox("peppers");
			topPanel.add(peppers);
	

}
	public static void addBorders(){
		
			Border b1 = BorderFactory.createTitledBorder("Size");
    		sizePanel.setBorder(b1);
    		
    		Border b2 = BorderFactory.createTitledBorder("Toppings");
    		topPanel.setBorder(b2);

}

	public static void blurb(){
			JLabel blurb = new JLabel();
			blurb.setText("Extra toppings cost 50c each."); 
			
			blurbPanel.add(blurb);
			sizePanel.add(blurbPanel, BorderLayout.SOUTH);
}

    public void display(){
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
    	
    	frame.setSize(300,600);
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
		String custOrder = "You ordered a ";
		String toppings ="";
		
		if (small.isSelected())
			total += smallPizza;
			custOrder +=" Small pizza with: ";
			
		if (medium.isSelected()){
			total += medPizza;
			custOrder +=" Medium pizza with: ";
			
		if (large.isSelected()){
			total += largePizza;
			custOrder +=" Large Pizza with: ";	
		}
		else
			total+= xtraLargePizza;
			custOrder +=" Xtra Large Pizza with: ";
			
			if(pepperoni.isSelected()){
				custOrder += "\n* Pepperoni";
				total += 0.50;
			}
			ta.setText(custOrder + "\n\nThe total price is $" + twoDigits.format(total));
}
	}
	public void reset() {
		ta.setText("");
		pepperoni.setSelected(false);
		mushrooms.setSelected(false); 
		anchovies.setSelected(false);
		sweetcorn.setSelected(false);
		jalapenos.setSelected(false);
		peppers.setSelected(false);
		chicken.setSelected(false);
		ham.setSelected(false);
		
		small.setSelected(true);
		medium.setSelected(false);
		large.setSelected(false);
			
	}
	
	public void actionPerformed (ActionEvent ae){
		//reset all components if order is cancelled
		if (ae.getSource() == cancel)
			reset();
			
			else
		//proceed with order (fire the event)
		if(ae.getSource() == order)
			findPrice();
	}
	
	public static void main(String[] args){
		PizzaOrder9 app = new PizzaOrder9();
		app.display();
}

    }
    
    
