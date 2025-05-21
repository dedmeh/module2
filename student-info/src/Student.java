public class Student {
    private String name= "John";
    private String classes= "C02";
    public Student() {}
    public void setName(String name) {
        this.name = name;
    }
    protected void setClass(String classes) {
        this.classes = classes;
    }
    protected void display() {          //only allow to use public or protected
        System.out.println(name);
        System.out.println(classes);
    }
}
