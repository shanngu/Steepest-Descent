import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton example1, example2, random, instructions;
	private String action;
	private TextPanel t;
	private SDAlgorithm sd;
	
	public ControlPanel(TextPanel text, SDAlgorithm sdalg) {
		t = text;
		sd = sdalg;
		setPreferredSize(new Dimension(150, TextPanel.HEIGHT));
		
		instructions = new JButton("Instructions");
		instructions.addActionListener(new ButtonListener("Instructions"));
		add(instructions);
		
		example1 = new JButton("Example 1");
		example1.addActionListener(new ButtonListener("Example 1"));
		add(example1);
		
		example2 = new JButton("Example 2");
		example2.addActionListener(new ButtonListener("Example 2"));
		add(example2);
		
		random = new JButton("Random");
		random.addActionListener(new ButtonListener("Random"));
		add(random);
	}
	
	public String getAction() {
		return action;
	}
	
	public class ButtonListener implements ActionListener {
		String name;
		
		public ButtonListener(String name) {
			this.name = name;
		}
		
		public void actionPerformed(ActionEvent e) {
			action = name;
			t.clearText();
			t.setText("Calculating...");
			if (name.equals("Example 1")) {
				t.setText(sd.example1());
			} else if (name.equals("Example 2")) {
				t.setText(sd.example2());
			} else if (name.equals("Random")) {
				t.setText("Calculating...\n" + "Warning: may take more than a minute to complete.");
				t.setText(sd.example3());
			} else if (name.equals("Instructions")) {
				t.setInstructions();
			}
		}
	}
}
