import java.util.Scanner;

public class EmployeePayment implements Payment{
    
    String name;
    int id;
    double pay, discount = 0;
    Scanner sc = new Scanner(System.in);
    public void read(){
    
        System.out.print("Enter the name of Client: ");
        name = sc.nextLine();
        System.out.print("Enter the amount of this payment: ");
        pay = sc.nextInt();
    }

    public void calc(int id){
        discount = pay * 0.2;
        pay = pay - discount;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public double getPay()
    {
        return pay;
    }

    public double getDiscount()
    {
        return discount;
    }
    @Override
    public String toString(){

        return id + "\t\t" +name + "\t\t" + pay + "\t\t" + discount;
    }
  


}
