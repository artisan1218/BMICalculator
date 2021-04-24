package bmi;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BMICalcView implements ActionListener {

	public BMICalcController controller;
	private final JButton calculate;
	private final JButton reset;
	private final JTextArea display;
	private final JTextArea inHeight;
	private final JTextArea inWeight;

	private final int displayHeight = 2, displayWidth = 4, inHeightHeight = 1, inHeightWidth = 1, inWeightHeight = 1,
			inWeightWidth = 1;

	public BMICalcView() {
		this.calculate = new JButton("Calculate");
		this.reset = new JButton("Reset");

		this.display = new JTextArea("0", displayHeight, displayWidth);
		this.display.setEditable(false);

		this.calculate.setEnabled(true);
		this.reset.setEnabled(true);

		this.inHeight = new JTextArea("0", inHeightHeight, inHeightWidth);
		this.inWeight = new JTextArea("0", inWeightHeight, inWeightWidth);
		this.inHeight.setEditable(true);
		this.inWeight.setEditable(true);

		JLabel height = new JLabel("Height in m: ");
		JLabel weight = new JLabel("Weight in kg: ");
		JLabel BMI = new JLabel("Your BMI: ", JLabel.CENTER);
		JLabel reference1 = new JLabel("Underweight: BMI<18.5", JLabel.CENTER);
		JLabel reference2 = new JLabel("Healthy: 18.5<BMI<24", JLabel.CENTER);
		JLabel reference3 = new JLabel("Overweight: BMI>24", JLabel.CENTER);
		JPanel reference = new JPanel(new GridLayout(3, 1));
		reference.add(reference1);
		reference.add(reference2);
		reference.add(reference3);

		JPanel text = new JPanel(new GridLayout(1, 4));
		text.add(height);
		text.add(this.inHeight);
		text.add(weight);
		text.add(this.inWeight);

		JPanel button = new JPanel(new GridLayout(1, 2));
		button.add(this.reset);
		button.add(calculate);

		JPanel result = new JPanel(new GridLayout(1, 2));
		result.add(BMI);
		result.add(this.display);

		JFrame window = new JFrame("BMI Calculator");
		window.setLayout(new GridLayout(4, 2));

		window.add(result);
		window.add(reference);
		window.add(text);
		window.add(button);

		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();

		this.calculate.addActionListener(this);
		this.reset.addActionListener(this);

	}

	public void updateResult(double result) {
		this.display.setText(String.valueOf(result));
	}

	public void updateWeight(double weight) {
		this.inWeight.setText(String.valueOf(weight));
	}

	public void updateHeight(double height) {
		this.inHeight.setText(String.valueOf(height));
	}

	public void registerOberver(BMICalcController controller) {
		this.controller = controller;
	}

	public String heightStr() {
		return this.inHeight.getText();
	}

	public String weightStr() {
		return this.inWeight.getText();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == this.reset) {
			this.controller.processReset();
		} else if (source == this.calculate) {
			this.controller.processCalculate();
		}

	}
}
