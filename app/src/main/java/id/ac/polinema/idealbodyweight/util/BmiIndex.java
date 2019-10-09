package id.ac.polinema.idealbodyweight.util;

public class BmiIndex {
    private float height;
    private float weight;
    private float index;
    private String type;

    public BmiIndex(float height, float weight) {
        this.weight = weight;
        this.height = (height / 100) * (height / 100) ;
        this.index = calculate();

    }

    public String getType() {
        return type;
    }

    private float calculate() {
        double result = weight / height;
        if (result < 18.50) {
            type = "Underweight";
        } else if (result >= 18.50 && result <= 24.99 ) {
            type = "Normal BMI Range";
        } else if (result >= 25 && result <= 29.99) {
            type = "Pre-Obese";
        } else if (result >= 30 && result <= 34.99) {
            type = "Obese Class 1";
        } else if (result >= 35 && result <= 39.99) {
            type = "Obese Class 2";
        } else if (result > 40) {
            type = "Obese Class 3";
        }
        return (float) result;
    }

    public float getIndex() {
        return index;
    }

}
