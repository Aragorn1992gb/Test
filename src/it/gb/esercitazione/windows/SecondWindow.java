package it.gb.esercitazione.windows;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.gb.esercitazione.bean.FootballBean;
import it.gb.esercitazione.bean.WeatherBean;
import it.gb.esercitazione.daoImpl.FootballDAOImpl;
import it.gb.esercitazione.daoImpl.WeatherDAOImpl;
import it.gb.esercitazione.util.ListenerProxies;
import it.gb.esercitazione.util.UtilMethods;

public class SecondWindow {
	static ListenerProxies listenerP = new ListenerProxies();
	static UtilMethods utilM = new UtilMethods();
	static Object obj = new MainWindow(); 
	
	// Window of the first exercise
	public static void eX1Window() throws Exception
	  {

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Meteo Data"), BorderLayout.NORTH);
		
		// WeatherDAOImpl contains method that acts on data stored on a file
		WeatherDAOImpl weatherDAOImpl = new WeatherDAOImpl();
		// WeatherBean contains the characteristics of each rows in the file that can be set and get
		ArrayList<WeatherBean> wbList = new ArrayList();
		
		// findWeatherData() is the method that read data from weather file and return a data list
		wbList = weatherDAOImpl.findWeatherData();
		// getDayMinTR is the method that do the calculation
		int day = getDayMinTR(wbList);

		if(day == 0) {
			String e = "eX1Window() - Day variable is 0, problem with data in file";
			System.out.println(e);
			throw new Exception(e);
		}

		panel.add(new JLabel("The day with minimum temperature range is: "+day), BorderLayout.SOUTH);

		JFrame frame = new JFrame("Exercise 1");
		
		JButton bBack = new JButton("BACK");
		
		bBack.addActionListener(listenerP.actionListener(utilM, "redirect", obj.getClass(), "mainWindow", frame));
		JPanel bPanel = new JPanel();
		bPanel.add(bBack);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container containerPane = frame.getContentPane();
		containerPane.add(panel, BorderLayout.NORTH);
		containerPane.add(bPanel, BorderLayout.SOUTH);
		frame.setPreferredSize(new Dimension(400, 300));
		frame.pack();
		frame.setVisible(true);

	  }
	
	// Window of the second exercise (similar considerations of the previous)
	public static void eX2Window() throws Exception
	  {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Fotball Data"), BorderLayout.NORTH);
		
		FootballDAOImpl footbalLDAOImpl = new FootballDAOImpl();
		ArrayList<FootballBean> fbList = new ArrayList();
		
		fbList = footbalLDAOImpl.findFootballData();
		String team = getTeamMinGD(fbList);

		if(team == null) {
			String e = "eX2Window() - Team variable is null, problem with data in file";
			System.out.println(e);
			throw new Exception(e);
		}

		panel.add(new JLabel("The team with the minimum goal difference is: "+team), BorderLayout.SOUTH);

		
		ListenerProxies listenerP = new ListenerProxies();

		JFrame frame = new JFrame("Exercise 2");
		
		JButton bBack = new JButton("BACK");
		bBack.addActionListener(listenerP.actionListener(utilM, "redirect", obj.getClass(), "mainWindow", frame));
		JPanel bPanel = new JPanel();
		bPanel.add(bBack);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container containerPane = frame.getContentPane();
		containerPane.add(panel, BorderLayout.NORTH);
		containerPane.add(bPanel, BorderLayout.SOUTH);
		frame.setPreferredSize(new Dimension(400, 300));
		frame.pack();
		frame.setVisible(true);

	  }
	
	// Do the calculation of exercise1 and return the result
	public static int getDayMinTR(ArrayList<WeatherBean> list) {
		int TR = 999;
		int dayTR = 0;
		for(int i=0; i<list.size(); i++) {
			int day = list.get(i).getDy();
			int mxt = list.get(i).getMxT();
			int mnt = list.get(i).getMnT();
			int newTR = mxt-mnt;
			if(newTR<TR) {
				dayTR = day;
				TR = newTR;
			}
		}
		return dayTR;	
	}
	
	// Do the calculation of exercise2 and return the result
	public static String getTeamMinGD(ArrayList<FootballBean> list) {
		int GD = 999;
		String teamGD = null;
		for(int i=0; i<list.size(); i++) {
			String team = list.get(i).getTeam();
			int f = list.get(i).getF();
			int a = list.get(i).getA();
			int newGD = f-a;
			if(newGD<GD) {
				teamGD = team;
				GD = newGD;
			}
		}
		return teamGD;	
	}
}
