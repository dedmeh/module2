public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("The radius of the circle is: " + c1.getRadius());
        System.out.println("The area of the circle is: " + c1.getArea());
        Circle c2 = new Circle(2);
        System.out.println("The radius of the circle is: " + c2.getRadius());
        System.out.println("The area of the circle is: " + c2.getArea());
    }
}