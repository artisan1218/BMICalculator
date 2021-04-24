package statstic;

import java.util.ArrayList;
import java.util.Comparator;

public class Controller {

	public Model model;
	public View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		updateViewToMatchModel(view, model);
	}

	public void updateViewToMatchModel(View view, Model model) {
		double mean = model.getMean();
		double median = model.getMedian();
		String mode = model.getMode();
		double range = model.getRange();
		double midRange = model.getMidRange();
		double sd = model.getSD();

		view.updateMean(mean);
		view.updateMedian(median);
		view.updateMode(mode);
		view.updateRange(range);
		view.updateMidRange(midRange);
		view.updateSD(sd);
	}

	public void processCalculate() {
		String input = view.getInput();
		ArrayList<Double> numbers = ConvertToNumbers(input);

		double mean = mean(numbers);
		double median = median(numbers);
		String mode = mode(numbers);
		double range = range(numbers);
		double midRange = midRange(numbers);
		double sd = sd(numbers, mean);

		this.model.mean = mean;
		this.model.median = median;
		this.model.mode = mode;
		this.model.range = range;
		this.model.midRange = midRange;
		this.model.sd = sd;

		updateViewToMatchModel(view, model);
	}

	public void processReset() {
		this.model.mean = 0;
		this.model.median = 0;
		this.model.mode = "0.0";
		this.model.range = 0;
		this.model.midRange = 0;
		this.model.sd = 0;
		view.input.setText("0");

		updateViewToMatchModel(view, model);
	}

	public static ArrayList<Double> ConvertToNumbers(String input) {
		ArrayList<Double> numbers = new ArrayList<>();
		String num = "";

		for (int i = 0; i < input.length(); i++) {

			char check = input.charAt(i);
			if (Character.isDigit(check) || check == '.' || check == '-') {
				num = num + check;
				if (i == input.length() - 1) {
					numbers.add(Double.parseDouble(num));
				}
			} else if (!num.isEmpty()) {
				numbers.add(Double.parseDouble(num));
				num = "";
			}

		}

		Comparator<Double> c = new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				if ((double) o1 > (double) o2)
					return 1;
				else
					return -1;
			}
		};

		numbers.sort(c);
		return numbers;
	}

	public static double mean(ArrayList<Double> numbers) {
		double mean = 0;

		for (int i = 0; i < numbers.size(); i++) {
			mean = mean + numbers.get(i);
		}

		mean = mean / numbers.size();
		return mean;
	}

	public static double meanWithSizeMinusOne(ArrayList<Double> numbers) {
		double mean = 0;

		for (int i = 0; i < numbers.size(); i++) {
			mean = mean + numbers.get(i);
		}

		mean = mean / (numbers.size() - 1);
		return mean;
	}

	public static double median(ArrayList<Double> numbers) {
		double median = 0;

		if (numbers.size() % 2 == 0) {
			double first = numbers.get(numbers.size() / 2);
			double second = numbers.get((numbers.size() / 2) - 1);
			median = (first + second) / 2;
		} else {
			median = numbers.get(numbers.size() / 2);
		}
		return median;
	}

	public static String mode(ArrayList<Double> numbers) {

		String mode = "";
		if (numbers.size() == 1) {
			mode = String.valueOf(numbers.get(0));
		} else {
			ArrayList<Double> allNumOnce = new ArrayList<>();
			allNumOnce.add(numbers.get(0));
			for (int i = 1; i < numbers.size(); i++) {
				double check = numbers.get(i);
				if (check != numbers.get(i - 1)) {
					allNumOnce.add(numbers.get(i));
				}
			}

			ArrayList<Integer> counts = new ArrayList<>();
			int count = 1;
			for (int j = 1; j < numbers.size(); j++) {
				double check = numbers.get(j);
				if (check == numbers.get(j - 1)) {
					count++;
				} else {
					counts.add(count);
					count = 1;
				}
				if (j == numbers.size() - 1) {
					counts.add(count);
				}
			}

			int biggest = 0;
			for (int k = 0; k < counts.size(); k++) {
				int check = counts.get(k);
				if (check >= biggest) {
					biggest = check;
				}
			}

			int index = counts.indexOf(biggest);
			int count2 = 1;
			boolean one = true;
			double check = counts.get(0);
			for (int k = 1; k < counts.size(); k++) {
				if ((check == counts.get(k)) && check == 1) {
					one = one && true;
				} else {
					one = one && false;
				}
			}

			while (index != -1) {
				double modeTmp = allNumOnce.get(index);
				counts.remove(index);
				allNumOnce.remove(index);
				index = counts.indexOf(biggest);
				if (count2 == 1) {
					mode = String.valueOf(modeTmp);
				} else {
					mode = mode + ", " + String.valueOf(modeTmp);
				}
				count2++;
			}

			if (counts.isEmpty() && one) {
				mode = "All of them";
			}
		}

		return mode;
	}

	public static double range(ArrayList<Double> numbers) {
		return (numbers.get(numbers.size() - 1) - numbers.get(0));
	}

	public static double midRange(ArrayList<Double> numbers) {
		return ((numbers.get(numbers.size() - 1) + numbers.get(0)) / 2);
	}

	public static double sd(ArrayList<Double> numbers, double mean) {
		ArrayList<Double> squaredDeviation = new ArrayList<>();

		for (int i = 0; i < numbers.size(); i++) {
			double num = numbers.get(i);
			double distance = mean - num;
			distance = Math.pow(distance, 2);
			squaredDeviation.add(distance);
		}

		double variance = meanWithSizeMinusOne(squaredDeviation);

		return Math.sqrt(variance);

	}
}
