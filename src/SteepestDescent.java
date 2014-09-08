import java.awt.BorderLayout;
import javax.swing.JFrame;

public class SteepestDescent {
	public static void main(String[] args) {
		JFrame window = new JFrame("Steepest Descent - MATH 2605");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TextPanel text = new TextPanel();
		SDAlgorithm sd = new SDAlgorithm();
		window.add(new ControlPanel(text, sd), BorderLayout.WEST);
		window.add(text);
		window.pack();
		window.setVisible(true);
	}
}
