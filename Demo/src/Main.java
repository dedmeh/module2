public class Main {
    public static void main(String[] args) {
        LuxuryCar lx =  new LuxuryCar("Lexus");
        lx.massage();
        lx.driving();
        System.out.println(lx.getColor());
        System.out.println(lx.getName());
        Car vin1 = new Car();
        vin1.setName("VF 5");
        vin1.setColor("Red");
        System.out.println(vin1.getColor());
        System.out.println(vin1.getName());
    }
}
