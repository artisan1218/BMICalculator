import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Chengyuan Zhou
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        NaturalNumber bottom = model.bottom();
        NaturalNumber top = model.top();

        view.updateBottomDisplay(bottom);
        view.updateTopDisplay(top);

        if (bottom.isZero()) {
            view.updateDivideAllowed(false);
            view.updateRootAllowed(false);
        } else {
            view.updateDivideAllowed(true);
            view.updateRootAllowed(true);
        }

        if (bottom.compareTo(top) > 0) {
            view.updateSubtractAllowed(false);
        } else {
            view.updateSubtractAllowed(true);
        }

        if (bottom.compareTo(new NaturalNumber1L(2)) >= 0) {
            view.updateRootAllowed(true);
        } else {
            view.updateRootAllowed(false);
        }

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        NaturalNumber bottomNum = this.model.bottom();
        NaturalNumber topNum = this.model.top();

        NaturalNumber temp = bottomNum.newInstance();
        temp.copyFrom(bottomNum);

        topNum.transferFrom(temp);

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        bottom.add(top);

        top.clear();

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        top.subtract(bottom);

        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);

        top.clear();

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processMultiplyEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        bottom.multiply(top);

        top.clear();

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processDivideEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        NaturalNumber remainder = top.divide(bottom);

        bottom.transferFrom(top);
        top.transferFrom(remainder);

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        NaturalNumber count = new NaturalNumber1L(1);

        NaturalNumber shadowTop = top.newInstance();
        shadowTop.copyFrom(top);

        while (count.compareTo(bottom) < 0) {
            top.multiply(shadowTop);
            count.increment();
        }

        if (count.compareTo(new NaturalNumber1L(1)) == 0) {
            top.copyFrom(new NaturalNumber1L(1));
        }

        bottom.clear();

        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRootEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        top.root(bottom.toInt());

        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);

        top.clear();

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        NaturalNumber bottom = this.model.bottom();
        bottom.multiplyBy10(digit);

        updateViewToMatchModel(this.model, this.view);
    }

}
