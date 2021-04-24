package statstic;

public class StatsticApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(model, view);

		view.registerController(controller);
	}

}
