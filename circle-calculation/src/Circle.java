public class Circle {
    private double radius = 1;
    private String color = "red";
    public Circle() {}
    public Circle(double r) {
        radius = r;
    }
    protected double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
