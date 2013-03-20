import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimplePlayer extends JFrame implements ActionListener {

   
			JFrame frame = new JFrame ();
			JPanel p1 = new JPanel ();
			JPanel p2 = new JPanel (); 
			JMenuBar mbar = new JMenuBar();
			JMenu fileMenu = new JMenu("File");
			JMenu aboutMenu = new JMenu("About"); 
			
			JMenuItem open = new JMenuItem("Open");
			JMenuItem save = new JMenuItem("Save");
			JMenuItem print = new JMenuItem("Print");
			JMenuItem exit = new JMenuItem("Exit");
			JMenuItem about = new JMenuItem("About this program");
			
			 public void display() {
				
				Container c = frame.getContentPane();
				
				GridLayout g = new GridLayout(2,1,4,4);
					c.setLayout(g); 
						
					p1.setBackground(Color.RED);
					p2.setBackground(Color.BLUE);
							
					c.add(p1);
					c.add(p2);
					
					fileMenu.add(open);
					fileMenu.add(save);
					fileMenu.add(print);
					fileMenu.add(exit);
					
					about.addActionListener( this );
					aboutMenu.add(about);
					
					mbar.add(fileMenu);
					mbar.add(aboutMenu);
					
					frame.setJMenuBar(mbar);		
					frame.setSize(300,300);
					frame.setTitle("simple PLayer")	;
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
    }
				public void ActionPerformed(ActionEvent ae){
					if (ae.getSource() == about)
						JOptionPane.showMessageDialog(null, "Program Version 1.0");
					
    			}				
    				
    		public static void main (String args[]) {
					SimplePlayer app = new SimplePlayer();
					app.display();
				}   
				}