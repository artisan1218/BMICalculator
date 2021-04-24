package statstic;

public class Model {

	public double mean;
	public double median;
	public String mode;
	public double range;
	public double midRange;
	public double sd;

	public Model() {
		this.mean = 0;
		this.median = 0;
		this.mode = "0.0";
		this.range = 0;
		this.midRange = 0;
		this.sd = 0;
	}

	public double getMean() {
		return this.mean;
	}

	public double getMedian() {
		return this.median;
	}

	public String getMode() {
		return this.mode;
	}

	public double getRange() {
		return this.range;
	}

	public double getMidRange() {
		return this.midRange;
	}

	public double getSD() {
		return this.sd;
	}
}
