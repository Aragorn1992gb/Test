package it.gb.esercitazione.util;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import it.gb.esercitazione.windows.SecondWindow;

public class UtilMethods {
	  // Method used in order to redirect window to another window
	  public void redirect(ActionEvent event, Class secondWindowClass, String MethodName, JFrame frameToClose) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		  frameToClose.setVisible(false);
		  Method m = secondWindowClass.getMethod(MethodName);
	      Object ret = m.invoke(secondWindowClass, new Object[] {});
		  SecondWindow  sw = new SecondWindow();
		  }
}
