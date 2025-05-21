public class Demo {
    public static void main(String[] args) {
//        Person son = new Person( "Bob", 6);
//        Person daughter = new Person();
//        System.out.println(son.name);
//        System.out.println(daughter.name);
        Customer customer=new Customer("Trung");
        customer.setPhone("0123456789");
        customer.displayInfo();
        customer.isVIP();
    }
}
