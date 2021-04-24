package statstic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener {

	private JButton btnCalculate;
	private JButton btnReset;
	public Controller controller;

	public JTextArea mean;
	public JTextArea median;
	public JTextArea mode;
	public JTextArea range;
	public JTextArea midRange;
	public JTextField input;
	public JTextArea sd;

	public View() {
		this.setBounds(100, 100, 547, 386);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		this.input = new JTextField();
		this.input.setText("0");
		this.input.setBounds(40, 43, 457, 22);
		this.getContentPane().add(this.input);
		this.input.addActionListener(this);

		this.mean = new JTextArea();
		this.mean.setBounds(67, 139, 97, 22);
		this.getContentPane().add(this.mean);
		this.mean.setEditable(false);

		this.median = new JTextArea();
		this.median.setBounds(204, 139, 92, 22);
		this.getContentPane().add(this.median);
		this.median.setEditable(false);

		this.mode = new JTextArea();
		this.mode.setBounds(323, 139, 174, 22);
		this.getContentPane().add(this.mode);
		this.mode.setEditable(false);

		this.range = new JTextArea();
		this.range.setBounds(67, 207, 96, 22);
		this.getContentPane().add(this.range);
		this.range.setEditable(false);

		this.midRange = new JTextArea();
		this.midRange.setBounds(204, 207, 92, 22);
		this.getContentPane().add(this.midRange);
		this.midRange.setEditable(false);

		this.sd = new JTextArea();
		this.sd.setBounds(359, 207, 92, 22);
		this.getContentPane().add(this.sd);
		this.sd.setEditable(false);

		this.btnCalculate = new JButton("calculate");
		this.btnCalculate.setBounds(328, 283, 117, 29);
		this.getContentPane().add(this.btnCalculate);
		this.btnCalculate.addActionListener(this);

		this.btnReset = new JButton("reset");
		this.btnReset.setBounds(107, 283, 117, 29);
		this.getContentPane().add(this.btnReset);
		this.btnReset.addActionListener(this);

		JLabel lblMean = new JLabel("Mean");
		lblMean.setBounds(94, 117, 61, 16);
		this.getContentPane().add(lblMean);

		JLabel lblMedian = new JLabel("Median");
		lblMedian.setBounds(227, 117, 61, 16);
		this.getContentPane().add(lblMedian);

		JLabel lblMode = new JLabel("Mode");
		lblMode.setBounds(393, 117, 61, 16);
		this.getContentPane().add(lblMode);

		JLabel lblRange = new JLabel("Range");
		lblRange.setBounds(94, 187, 61, 16);
		this.getContentPane().add(lblRange);

		JLabel lblMidrange = new JLabel("Mid-Range");
		lblMidrange.setBounds(219, 187, 69, 16);
		this.getContentPane().add(lblMidrange);

		JLabel lblNumbers = new JLabel("Numbers");
		lblNumbers.setBounds(242, 24, 61, 16);
		this.getContentPane().add(lblNumbers);

		JLabel lblStandardDeviation = new JLabel("Population Standard Deviation");
		lblStandardDeviation.setBounds(315, 187, 198, 16);
		this.getContentPane().add(lblStandardDeviation);

		this.setVisible(true);

	}

	public void registerController(Controller controller) {
		this.controller = controller;
	}

	public void updateMean(double mean) {
		this.mean.setText(String.valueOf(mean));
	}

	public void updateMedian(double median) {
		this.median.setText(String.valueOf(median));
	}

	public void updateMode(String mode) {
		this.mode.setText(mode);
	}

	public void updateRange(double range) {
		this.range.setText(String.valueOf(range));
	}

	public void updateMidRange(double midRange) {
		this.midRange.setText(String.valueOf(midRange));
	}

	public void updateSD(double sd) {
		this.sd.setText(String.valueOf(sd));
	}

	public String getInput() {
		return this.input.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == this.btnCalculate || source == this.input) {
			this.controller.processCalculate();
		} else {
			this.controller.processReset();
		}

	}

}
