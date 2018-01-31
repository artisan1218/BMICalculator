package bmi;

public class BMICalcModel {
	public double height, weight, result;

	public BMICalcModel() {
		this.height = 0;
		this.weight = 0;
		this.result = 0;
	}

	public double height() {
		return this.height;
	}

	public double weight() {
		return this.weight;
	}

	public double result() {
		return this.result;
	}

}
