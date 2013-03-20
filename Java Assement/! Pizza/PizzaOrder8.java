import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PizzaOrder8 implements ActionListener {
				
				//A selection of Seperate panels in which to place the different options
				static JPanel headPanel = new JPanel();
    			static JPanel topPanel = new JPanel();
    			static JPanel sizePanel = new JPanel();
    			static JPanel billPanel = new JPanel();
    			static JPanel buttonPanel = new JPanel();
    			static JPanel radioPanel = new JPanel();
    			static JPanel blurbPanel = new JPanel();
    			static JPanel extrasPanel = new JPanel ();
    			
    			//Radio and check box variables.  
    			static JRadioButton small, medium, large, xtralarge;
				static JCheckBox pepperoni, mushrooms, anchovies, onions, sweetcorn, jalapenos, ham, chicken, peppers, Chicken_Strippers, Garlic_Bread, Dough_Balls;;
			 	
			 	//Location of logo and banner variable
			 	static ImageIcon icon = new ImageIcon("Images/pizza3.jpg");
				static JLabel banner = new JLabel();
				
				//Text area for loading order into and buttons for placing order
				static JTextArea ta = new JTextArea(15,40);
				static JButton order = new JButton("Place order!");
				static JButton cancel = new JButton("Reset"); 
				static JButton confirm = new JButton("Confirm Order");
				
				//Values for seperate selectable options 
				static double total =0.0;
				static double smallPizza = 7.0;
				static double medPizza = 10.0;
				static double largePizza = 14.0;
				static double xtralargePizza = 16.0;
				static double GarlicBread = 3.0;
				static double ChickenStrippers = 5.0;
				static double DoughBalls = 2.0;
				
				//Formatting Numbers
				DecimalFormat twoDigits = new DecimalFormat("0.00");
		
				
		public static void addSizeMenu(){
			//Border around menu displaying menu Name. 
			BorderLayout b = new BorderLayout();
			sizePanel.setLayout(b);
			
			//Options for selecting different sized pizza's. using boolean and radio buttons asinging to a variable
			ButtonGroup sizeGroup = new ButtonGroup();
			small = new JRadioButton("Small : €7");
    		small.setSelected(true);
    		radioPanel.add(small);
    		sizeGroup.add(small);
    		
    		medium = new JRadioButton("Medium : €10");
    		radioPanel.add(medium);
    		sizeGroup.add(medium);
    	
    		large = new JRadioButton("Large : €14");
    		radioPanel.add(large);
    		sizeGroup.add(large);
    		
    		xtralarge = new JRadioButton("Extra Large : €16");
    		radioPanel.add(xtralarge);
    		sizeGroup.add(xtralarge);
    		
    		sizePanel.add(radioPanel, BorderLayout.NORTH);
		}	
			
					
		
		public static void addExtrasMenu(){
			//Using a grid layout three variables will be used for selction here based on extras 
			GridLayout gl = new GridLayout(1,1,3,3);
			extrasPanel.setLayout(gl);
			
			Chicken_Strippers = new JCheckBox("Chicken Strippers");
			extrasPanel.add(Chicken_Strippers);
			Garlic_Bread = new JCheckBox("Garlic Bread");
			extrasPanel.add(Garlic_Bread);
			Dough_Balls = new JCheckBox("Dough Balls");
			extrasPanel.add(Dough_Balls);
		}
		
		public static void addToppingMenu(){
			//Like the one before it Using a similar layout but selecting toppings
			GridLayout gl = new GridLayout(3,3,5,5);
			topPanel.setLayout(gl);
	
			//Naming and Assingn to menus 
			pepperoni = new JCheckBox("Pepperoni");
			topPanel.add(pepperoni);
			mushrooms = new JCheckBox("Mushrooms");
			topPanel.add(mushrooms);
			anchovies = new JCheckBox("Anchovies");
			topPanel.add(anchovies);
			onions = new JCheckBox("Onions");
			topPanel.add(onions);
			sweetcorn = new JCheckBox("Sweetcorn");
			topPanel.add(sweetcorn);
			jalapenos = new JCheckBox("Jalapenos"); 
			topPanel.add(jalapenos);
			ham = new JCheckBox("Ham");
			topPanel.add(ham);
			chicken = new JCheckBox("Chicken");
			topPanel.add(chicken);
			peppers = new JCheckBox("Peppers");
			topPanel.add(peppers);
	

}
		public static void addBorders(){
			//Border settings and Naming of each section  
			Border b1 = BorderFactory.createTitledBorder("Size");
    		sizePanel.setBorder(b1);
    		
    		Border b2 = BorderFactory.createTitledBorder("Toppings");
    		topPanel.setBorder(b2);
    		
    		Border b3 = BorderFactory.createTitledBorder("Pizza Thang Ordering System");
    		headPanel.setBorder(b3);
    		
    		Border b4 = BorderFactory.createTitledBorder("Order Total");
    		billPanel.setBorder(b4);
    		
    		Border b5 = BorderFactory.createTitledBorder("Extras");
    		extrasPanel.setBorder(b5);		
}

		public static void blurb(){
			
			//Small piece of text to advise the customer of the price of each topping 
			JLabel blurb = new JLabel();
			blurb.setText("Extra toppings cost 50c each."); 
			
			blurbPanel.add(blurb);
			sizePanel.add(blurbPanel, BorderLayout.SOUTH);
}

   	 public void display(){
   	 	
   	 		//Output options in the 
    		JFrame frame = new JFrame("Pizza Orders");	
    		Container c = frame.getContentPane();
    		BoxLayout b = new BoxLayout(c, BoxLayout.Y_AXIS);
    		c.setLayout(b);
    	
    		banner.setIcon(icon); // default centre selection
    		headPanel.add(banner);
    		
    		//Displaying the various algorithms  
    		addBorders();
    		addSizeMenu();
    		addToppingMenu();
    		addExtrasMenu();
	   		blurb();
	   		
	   		//Displaying the various buttons on which to place the order
    		billPanel.add(ta);
    		order.addActionListener( this );
    		cancel.addActionListener( this );
    		confirm.addActionListener(this);
    		buttonPanel.add(order);
    		buttonPanel.add(cancel);
    		buttonPanel.add(confirm); 
    	
    		//Adding the differnt sections of the of the pizza menu 
    		c.add(headPanel);
    		c.add(sizePanel);
    		c.add(topPanel);
			c.add(extrasPanel);
    		c.add(billPanel);
    		c.add(buttonPanel);
    		
    		//The window setting of the main program 
    		frame.setSize(300,600);
    		frame.setVisible(true);
    		frame.setResizable(false);
    		frame.pack();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   			
   			//Backround colour options 
    		headPanel.setBackground(Color.white);
    		topPanel.setBackground(Color.GREEN);
    		sizePanel.setBackground(Color.YELLOW);
    		billPanel.setBackground(Color.RED); 		
    }
    
	public void findPrice(){
		
		//Algorithim to decide on how much to charge the customer and what to display 
		//based on their selection of pizza sizes, toppings and extras
		String custOrder = "You ordered ";
		String toppings ="";
			
			if 	(small.isSelected()){
			total += smallPizza;
			custOrder += (" a Small Pizza with: ");
			}
			else
			if (medium.isSelected()){
			total += medPizza;
			custOrder += (" a Medium Pizza with: ");
			}
			else
			if (large.isSelected()){
			total += largePizza;
			custOrder +=(" a Large Pizza with");
			}
			else 
			{total += xtralargePizza;
			custOrder +=("an Extra Large Pizza with");	}
			if(pepperoni.isSelected()){
			custOrder += "\n* Pepperoni";
			total += 0.50;	}
			if(mushrooms.isSelected()){
			custOrder += "\n* mushrooms";
			total += 0.50;	}
			if(anchovies.isSelected()){
			custOrder += "\n* anchovies";
			total += 0.50;	}
			if(sweetcorn.isSelected()){
			custOrder += "\n* sweetcorn";
			total += 0.50;	}
			if(jalapenos.isSelected()){
			custOrder += "\n* jalapenos";
			total += 0.50;	}
			if(peppers.isSelected()){
			custOrder += "\n* peppers";
			total += 0.50;	}
			if(chicken.isSelected()){
			custOrder += "\n* chicken";
			total += 0.50;	}
			if(ham.isSelected()){
			custOrder += "\n* ham";
			total += 0.50;	}
			if(onions.isSelected()){
			custOrder += "\n* onions";
			total += 0.50;	}
			if(Chicken_Strippers.isSelected()){
			custOrder += "\n* Extras - Chicken Strippers - €5";
			total += ChickenStrippers;	}
			if(Garlic_Bread.isSelected()){
			custOrder += "\n* Extras - Garlic Bread - €3 ";
			total += GarlicBread;	}
			if(Dough_Balls.isSelected()){
			custOrder += "\n* Extras - Dough Balls - €2 ";
			total += DoughBalls;	
			}
			//Formatting the Total price
			ta.setText(custOrder + "\n\nThe total price is €" + twoDigits.format(total));
}
	public void reset() {
	
		//Reset Algorithm in which to revert everything back to its initaial preset. 
		ta.setText("");//Reset the text area
		//resetting the toppings 
		onions.setSelected(false);
		pepperoni.setSelected(false);
		mushrooms.setSelected(false); 
		anchovies.setSelected(false);
		sweetcorn.setSelected(false);
		jalapenos.setSelected(false);
		peppers.setSelected(false);
		chicken.setSelected(false);
		ham.setSelected(false);
		//Extras
		Chicken_Strippers.setSelected(false);
		Garlic_Bread.setSelected(false);
		Dough_Balls.setSelected(false);
		//Sizes
		small.setSelected(true);
		medium.setSelected(false);
		large.setSelected(false);
		//Charge
		total = 0.00;	
	}
	public void ConfirmOrder (){
		//Message box confirm order 
		JOptionPane.showMessageDialog(null,"Thank you for your purchase, \nYour pizza will be dispatched in 30 minutes" );
	}
	public void actionPerformed (ActionEvent ae){
			//reset all components if order is cancelled
			if (ae.getSource() == cancel)
			reset();
			else
				
			//Review Order (fire the event)
			if(ae.getSource() == order)
			findPrice();
			else 
				
			//Confirm Order
			if(ae.getSource() == confirm)
			ConfirmOrder();		
	}
	//main method to trigger display 
	public static void main(String[] args){
		PizzaOrder8 app = new PizzaOrder8();
		app.display();
}

    }
    
    
