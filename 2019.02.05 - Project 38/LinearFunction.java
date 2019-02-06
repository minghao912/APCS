public class LinearFunction implements LinearFunctionMethods {
    private double slope, yIntecept;

    public LinearFunction(double m, double b) {
        slope = m;
        yIntecept = b;
    }

    public double getSlope() {
        return slope;
    }

    public double getYintercept() {
        return yIntecept;
    }

    public double getRoot() {
        return getXvalue(0);
    }

    public double getYvalue(double x) {
        return (slope * x) + yIntecept;
    }

    public double getXvalue(double y) {
        return (y - yIntecept) / slope;
    }
}