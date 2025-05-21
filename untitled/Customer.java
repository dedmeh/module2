public class Customer {
    public int id;
    public String name;
    public String email;
    public String phone;
    public String joinDate;
    public double totalPurchases;
    public Customer(){}
    public Customer(String name){
        this.name= name;
    }
    public Customer(String name, String email,String phone){
        this.name= name;
        this.email= email;
        this.phone= phone;
    }
    public Customer(int id, String name, String email, String phone, String joinDate,double totalPurchases){
        this.id = id;
        this.name = name;
        this.email= email;
        this.phone= phone;
        this.joinDate = joinDate;
        this.totalPurchases = totalPurchases;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getJoinDate(){
        return joinDate;
    }
    public void setJoinDate(String joinDate){
        this.joinDate = joinDate;
    }
    public double getTotalPurchases(){
        return totalPurchases;
    }
    public void setTotalPurchases(double totalPurchases){
        this.totalPurchases = totalPurchases;
    }
    public void makePurchases(double amount){
        this.totalPurchases+=amount;
    }
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Join date: " + joinDate);
        System.out.println("Total purchases: " + totalPurchases);
    }
    public boolean isVIP(){
        return getTotalPurchases()>10000000;
    }
}
