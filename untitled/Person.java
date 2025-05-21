public class Person {
    public String name;
    public int age;
    public Person(String name, int age){
        this.name= name;
        this.age= age;
    }
    Person(){}
    String speak() {
        return "Hello";
    }
}