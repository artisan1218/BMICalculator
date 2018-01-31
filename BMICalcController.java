package bmi;

public class BMICalcController {

	public BMICalcModel model;
	public BMICalcView view;

	public BMICalcController(BMICalcModel model, BMICalcView view) {
		this.model = model;
		this.view = view;
		/*
		 * initial value
		 */
		updateViewToMatchModel(view, model);
	}

	public void processReset() {
		this.model.height = 0;
		this.model.weight = 0;
		this.model.result = 0;
		updateViewToMatchModel(this.view, this.model);
	}

	public void processCalculate() {
		String heightStr = this.view.heightStr();
		String weightStr = this.view.weightStr();

		double height = Double.parseDouble(heightStr);
		double weight = Double.parseDouble(weightStr);

		double result = weight / Math.pow(height, 2);

		this.model.result = result;
		this.model.height = height;
		this.model.weight = weight;

		updateViewToMatchModel(this.view, this.model);
	}

	public static void updateViewToMatchModel(BMICalcView view, BMICalcModel model) {
		double height = model.height();
		double weight = model.weight();
		double result = model.result();

		view.updateResult(result);
		view.updateHeight(height);
		view.updateWeight(weight);
	}

}
