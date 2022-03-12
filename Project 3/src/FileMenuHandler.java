import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.*;
import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.StringTokenizer;


public class FileMenuHandler implements ActionListener{
	static JFrame jframe;
	static Date212 dobject;
	public static StringTokenizer myToken;
	static Date212TreeMap tmap;
	public FileMenuHandler(JFrame jf) {
		jframe=jf;
	}
	
	public void actionPerformed(ActionEvent event) {
		String menuName;
		menuName=event.getActionCommand();
		if(menuName.equals("Open"))
			openFile();
		else if(menuName.equals("Quit"))
			System.exit(0);
	}
	
	private void openFile() { //allows user to open and choose a file from their own computer
		JFileChooser jchooser;
		int status;
		jchooser= new JFileChooser();
		status = jchooser.showOpenDialog(null);
		if(status == JFileChooser.APPROVE_OPTION) {
			readSource(jchooser.getSelectedFile());
		}
		else {
			JOptionPane.showMessageDialog(null, "Cancelled");
		}
	}
	
	private void readSource(File file) { //reads file and stores the data into a treemap to be sorted and a text area for the unsorted
		String date;
		Date212TreeMap tmap= new Date212TreeMap();
		TextArea unsorted = new TextArea();
		TextArea sorted = new TextArea();
		Container myContentPane=jframe.getContentPane();
		myContentPane.add(unsorted, BorderLayout.EAST);
		myContentPane.add(sorted,BorderLayout.WEST);
		
		try {
			Scanner files = new Scanner(file);
			date=files.nextLine();
			while(date!=null) {
				
				myToken= new StringTokenizer(date,",");   //string tokenizer is established to separate the dates by commas
				
				while(myToken.hasMoreTokens()) { //
					date=myToken.nextToken();
					dobject=new Date212(date); //date212 object is created for each date input from file
					if(dobject.isValidDate()) {
						tmap.store(dobject);
						unsorted.append(dobject.toString()+"\n");
					}    //objects are added to their according lists
				} //checks if the file has another line to input
				if(files.hasNextLine())
					date=files.nextLine();
				else
					date=null;
			}
		} catch (FileNotFoundException e) {//in case file cannot be found
			System.out.println("Wrong pathway name.");
		}
		
		tmap.print(myContentPane);
		jframe.pack();
		jframe.setVisible(true);
	}

}

