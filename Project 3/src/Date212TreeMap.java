import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.HashMap;
import java.util.Iterator;

public class Date212TreeMap {
	 TreeMap<Date212, String> sorted = new TreeMap<>(new Date212Comparator());
	
	public void store(Date212 dobject) { //treemap keys are stored in treemap already sorted
		sorted.put(dobject, null);
		}
	
	
	public void print(Container myContentPane) { //method of adding sorted treemap values to jframe
		TextArea sortlist = new TextArea();
		myContentPane.add(sortlist,BorderLayout.WEST);
		
		for(Map.Entry<Date212,String> me:sorted.entrySet()) {
			sortlist.append(me.getKey().toString()+"\n");
		}
	}

}
