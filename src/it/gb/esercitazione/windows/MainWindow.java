package it.gb.esercitazione.windows;

import java.awt.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.gb.esercitazione.util.ListenerProxies;
import it.gb.esercitazione.util.UtilMethods;
public class MainWindow extends Frame
{
	private static final long serialVersionUID = 1L;

	// starting window
public static void mainWindow()
  {
	UtilMethods utilM = new UtilMethods();
	Object obj = new SecondWindow();   
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	panel.add(new JLabel("Welcome to the Java Excercise menu"), BorderLayout.NORTH);
	panel.add(new JLabel("Please, choose your excercise:"), BorderLayout.SOUTH);
	JButton bEx1 = new JButton("EXCERCISE 1");
	JButton bEx2 = new JButton("EXCERCISE 2");
	
	// ListenerProxies class contains methods that allows to execute generics methods
	ListenerProxies listenerP = new ListenerProxies();
	JFrame frame = new JFrame("Menu");
	// Each button has his own ActionListener that executes a specific method
	bEx1.addActionListener(listenerP.actionListener(utilM, "redirect", obj.getClass(), "eX1Window", frame));
	bEx2.addActionListener(listenerP.actionListener(utilM, "redirect", obj.getClass(), "eX2Window", frame));
	JPanel bPanel = new JPanel();
	bPanel.add(bEx1);
	bPanel.add(bEx2);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container containerPane = frame.getContentPane();
	containerPane.add(panel, BorderLayout.NORTH);
	containerPane.add(bPanel, BorderLayout.SOUTH);
	frame.setPreferredSize(new Dimension(400, 300));
	frame.pack();
	frame.setVisible(true);

  }
  
  public static void main(String[] arg)
  {
    mainWindow();
    System.out.println("New Window");
  }

}