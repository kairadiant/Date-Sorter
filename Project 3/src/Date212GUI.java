/*
 * Methods for creating a GUI, taking the dates from the files and declaring them as date212 objects, creating sorted and unsorted lists, 
 * and displaying them in the GUI in a dual column
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.*;

public class Date212GUI extends JFrame {
	static String date;
	static JFrame jframe;
	static FileMenuHandler fmh;
	static JMenuBar jbar;
	static JMenu jmenu;
	static JMenuItem it;
	
	public Date212GUI() { //runs this menu every time a GUI is instantiated
		jframe = new JFrame();
		jframe.setTitle("Dates");
		jframe.setSize(300,200);
		createMenu();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	
	private static void createMenu() {
		jbar = new JMenuBar();
		jmenu = new JMenu("File");
		
		fmh = new FileMenuHandler(jframe);
		
		it = new JMenuItem("Open");
		it.addActionListener(fmh);
		jmenu.add(it);
		jmenu.addSeparator();
		it = new JMenuItem("Quit");
		it.addActionListener(fmh);
		jmenu.add(it);
		jframe.setJMenuBar(jbar);
		jbar.add(jmenu);
	}
}
