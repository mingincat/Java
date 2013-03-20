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
		static JButton cancel = new JButton("reset"); 
		
		public static void addSizeMenu(){
			GridBagLayout gb = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			sizePanel.setLayout(gb);
			
			JLabel blurb = new JLabel();
			JRadioButton small, medium, large; 
    		ButtonGroup sizeGroup  = new ButtonGroup();
    		
    		small = new JRadioButton("small: $7");
    		small.setSelected(true);
    		sizePanel.add(small);
    		sizeGroup.add(small);
    		//JLabel sizeLabel = new JLabel();
    		
    	
    	//small = new JRadioButton("Small €7");
    	//small.setSelected(true);
    	
    	medium = new JRadioButton("Medium €10");
    	sizePanel.add(medium);
    	sizeGroup.add(medium);
    	
    	large = new JRadioButton("Large €14");
    	sizePanel.add(medium);
    	sizeGroup.add(medium);
    	
    	
    	group.add(small);
    	group.add(medium);
    	group.add(large);
    	
    	sizePanel.add(small);
    	sizePanel.add(medium);
    	sizePanel.add(large);
    	
    	sizeLabel = new JLabel("Please choose a pizza size..");
    	sizePanel.add(sizeLabel);
    		
    	}
    	
		public static void addBorders(){
		
		Border sizeBorder = BorderFactory.createTitledBorder("Size");
    	sizePanel.setBorder(sizeBorder);
    		
    	Border toppingBorder = BorderFactory.createTitledBorder("Toppings");
    	topPanel.setBorder(toppingBorder);

}

		public static void addToppingMenu(){
	
	GridLayout g = new GridLayout(3,3,3,3);
	topPanel.setLayout(g);
	
	
	Pepperonini = new JCheckBox("Pepperonini");
	Chicken = new JCheckBox("Chicken");
	BlackPudding = new JCheckBox("Black Pudding");
	Salami= new JCheckBox("Salami");
	Pineapple = new JCheckBox("Pineapple");
	Peppers = new JCheckBox("Peppers"); 
	Bacon = new JCheckBox("Bacon");
	Mozzerella = new JCheckBox("Mozzerella");
	Mushrooms = new JCheckBox("Mushrooms");
	
	topPanel.add(Pepperonini);
	topPanel.add(Chicken);
	topPanel.add(BlackPudding);
	topPanel.add(Salami);
	topPanel.add(Pineapple);
	topPanel.add(Peppers);
	topPanel.add(Bacon);
	topPanel.add(Mozzerella);
	topPanel.add(Mushrooms);
}

    	public static void display(){
    
    	JFrame f = new JFrame("Pizza Order");
    	
    	JTextArea ta = new JTextArea(6,25);
    	ta.setEditable(false);
    	
    	JButton order = new JButton("Place Order");
    	JButton reset = new JButton("Reset Order");	
    	Container c = f.getContentPane();
    	BoxLayout b = new BoxLayout(c, BoxLayout.Y_AXIS);
    	c.setLayout(b);
    	
    	
    	addBorders();
    	addSizeMenu();
    	addToppingMenu();
    	
    	billPanel.add(ta);
    	billPanel.add(order);
    	billPanel.add(reset);
    		
    	c.add(headPanel);
    	c.add(topPanel);
    	c.add(sizePanel);
    	c.add(billPanel);
    	
    	headPanel.setBackground(Color.BLACK);
    	topPanel.setBackground(Color.GREEN);
    	sizePanel.setBackground(Color.YELLOW);
    	billPanel.setBackground(Color.RED); 	
    
    	
    	
    	c.add(headPanel);
    	c.add(topPanel);
    	c.add(sizePanel);
    	c.add(billPanel);
    	
    	f.setSize(300, 600);
    	f.setResizable(false);
    	f.setLocation(100, 100);
    	f.setVisible(true);
    	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    }
public static void main (String[] args) {
display();


}

    }
    
    
