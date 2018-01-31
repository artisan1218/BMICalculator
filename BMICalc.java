package bmi;

public class BMICalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BMICalcView view = new BMICalcView();
		BMICalcModel model = new BMICalcModel();
		BMICalcController controller = new BMICalcController(model, view);

		view.registerOberver(controller);
	}

}
