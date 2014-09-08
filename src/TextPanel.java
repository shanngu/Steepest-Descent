import javax.swing.JApplet;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.TextArea;


public class TextPanel extends JApplet {
	TextArea results;
	JScrollPane scroller;
	
	public TextPanel() {
		setPreferredSize(new Dimension(620, 450));
		results = new TextArea(20,20);
		scroller = new JScrollPane(results);	

		setInstructions();
		add(scroller);
	}

	public void clearText() {
		results.setText("");
	}
	
	public void setInstructions() {
		String output = "Welcome to Shannon Nguyen's Steepest Descent Project for MATH 2605.\n";
		output += "\nExample 1 run will run multiple random examples for the first example provided in the project guidelines.";
		output += "\nThe x matrices used by me for this example are documented in the write-up.\n";
		output += "\nExample 2 run will run multiple random examples for the second example provided in the project guidelines.";
		output += "\nThe x matrices used by me for this example are documented in the write-up.\n";
		output += "\nRandom run will run multiple random examples for 5 random 10x10 matrices.";
		output += "\nThe A, b, and x matrices used by me for this example are documented in the write-up.\n";
		output += "\nThe results are randomly generated each time, so each button press will yield new matrices";
		results.setText(output);
	}
	
	public void setText(String text) {
		results.setText(text);
	}
}
