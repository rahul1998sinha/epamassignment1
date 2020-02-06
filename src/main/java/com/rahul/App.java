package com.rahul;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
abstract class Gift
{
    String gift_to;
    double feedback_score;
    double weight;
    static double total_weight;
    Gift()
    {
        this.gift_to="children";
        this.feedback_score=10;
        this.weight=0;
    }
    Gift(String gift_to,double feedback_score,double weight)
    {
        this.gift_to=gift_to;
        this.feedback_score=feedback_score;
        this.weight=weight;
        if(this.gift_to.equals("children"))
            Gift.total_weight=Gift.total_weight + this.weight;
    }
    abstract void display_gift();
}
class ChocolateComparatorbyprice implements Comparator<Chocolate>
{
    public int compare(Chocolate choco1,Chocolate choco2)
    {
        return Double.compare(choco1.getprice(), choco2.getprice());
    }
}
class ChocolateComparatorbyweight implements Comparator<Chocolate>
{
    public int compare(Chocolate choco1,Chocolate choco2)
    {
        return Double.compare(choco1.getweight(), choco2.getweight());
    }
}
class Chocolate extends Gift
{
    double price;
    String colour;
    int quantity;
    String chocolate_name;
    Chocolate()
    {
        super();
        this.price=0.0;
        this.colour="Chocolate";
        this.quantity=1;
        this.chocolate_name="Cadbury";
    }
    Chocolate(String gift_to,double feedback_score,double weight,double price,String colour,int quantity,String chocolate_name)
    {
        super(gift_to,feedback_score,weight);
        this.price=price;
        this.colour=colour;
        this.quantity=quantity;
        this.chocolate_name=chocolate_name;
    }
    public double getprice()
    {
        return this.price;
    }
    public double getweight()
    {
        return this.weight;
    }
    void display_gift()
    {
        System.out.println("Chocolate Name:"+this.chocolate_name);
        System.out.println("Chocolate Colour: "+this.colour);
        System.out.println("Quantity:"+this.quantity);
        System.out.println("Weight:"+this.weight);
        System.out.println("Price: "+this.price);
        System.out.println("Gifted to: "+this.gift_to);
        System.out.println("Feedback Score: "+this.feedback_score);
        System.out.println("---------------------");
    }
}
class SweetsComparator implements Comparator<Sweets>
{
    public int compare(Sweets s1,Sweets s2)
    {
        return Double.compare(s1.getprice(), s2.getprice());
    }
}
class Sweets extends Gift
{
    double price;
    String sweet_name;
    String colour;
    int quantity;
    Sweets()
    {
        super();
        this.price=100;
        this.colour="White";
        this.quantity=20;
        this.sweet_name="Sandesh";
    }
    Sweets(String gift_to,double feedback_score,double weight,double price,String sweet_name,String colour,int quantity)
    {
        super(gift_to,feedback_score,weight);
        this.price=price;
        this.colour=colour;
        this.quantity=quantity;
        this.sweet_name=sweet_name;
    }
    public double getprice()
    {
        return this.price;
    }
    void display_gift()
    {
        System.out.println("Sweet Name:"+this.sweet_name);
        System.out.println("Sweet Colour: "+this.colour);
        System.out.println("Quantity:"+this.quantity);
        System.out.println("Weight(In kg): "+this.weight);
        System.out.println("Price: "+this.price);
        System.out.println("Gifted to: "+this.gift_to);
        System.out.println("Feedback Score: "+this.feedback_score);
        System.out.println("---------------------");
    }
}
class CandyComparator implements Comparator<Candy>
{
    public int compare(Candy c1,Candy c2)
    {
        return Double.compare(c1.getprice(), c2.getprice());
    }
}
class Candy extends Gift
{
    String colour;
    double price;
    String taste;
    String candy_name;
    int quantity;
    Candy()
    {
        super();
        this.colour="Red";
        this.price=10;
        this.taste="Sweet";
        this.candy_name="Melody";
        this.quantity=5;
    }
    Candy(String gift_to,double feedback_score,double weight,String colour,double price,String taste,String candy_name,int quantity)
    {
        super(gift_to,feedback_score,weight);
        this.colour=colour;
        this.price=price;
        this.taste=taste;
        this.candy_name=candy_name;
        this.quantity=quantity;
    }
    void display_gift()
    {

        System.out.println("Candy Name:"+this.candy_name);
        System.out.println("Candy Colour: "+this.colour);
        System.out.println("Quantity:"+this.quantity);
        System.out.println("Candy Taste: "+this.taste);
        System.out.println("Price: "+this.price);
        System.out.println("Weight: "+this.weight);
        System.out.println("Gifted to: "+this.gift_to);
        System.out.println("Feedback Score: "+this.feedback_score);
        System.out.println("---------------------");

    }
    public double getprice()
    {
        return this.price;
    }
}
public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int n,gift_record;
        gift_record=0;
        char choiceatend;
        double min,max;
        int choice=1;
        String gift_to;
        double feedback_score;
        double weight;
        double price;
        int count=0;
        String colour;
        int quantity;
        String taste;
        String name;
        do
        {
            System.out.println("\n ##############################");
            System.out.println(" EPAM PEP ASSIGNMENT 1");
            System.out.println(" 1. Create objects of Chocolates and Sort them");
            System.out.println(" 2. Create objects of Sweets");
            System.out.println(" 3. Create objects of Candies and display according to range");
            System.out.println(" 4. Display the total weight of the children gifts");
            System.out.println(" Enter the choice: ");
            choice=sc.nextInt();
            int choice2;
            switch(choice)
            {
                case 1: System.out.println("Enter the numbers of objects of Chocolates");
                    n=sc.nextInt();
                    gift_record=gift_record+n;
                    ArrayList<Chocolate> C=new ArrayList<Chocolate>();
                    for(int i=0;i<n;i++)
                    {
                        System.out.println(" Enter the details for Chocolate "+i+1);
                        System.out.println(" Enter the name of the chocolate ");
                        sc.nextLine();
                        name=sc.nextLine();
                        System.out.println(" Enter the price of the chocolate ");
                        price=sc.nextDouble();
                        System.out.println(" Chocolate gifted to (children/adult) ");
                        sc.nextLine();
                        gift_to=sc.nextLine();
                        System.out.println(" Enter the weight of the chocolate");
                        weight=sc.nextDouble();
                        System.out.println("\n Enter the colour of the chocolate ");
                        sc.nextLine();
                        colour=sc.nextLine();
                        System.out.println("\n Enter the quantity of the chocolate");
                        quantity=sc.nextInt();
                        System.out.println("\n Enter the Feedback of the gift ");
                        feedback_score=sc.nextInt();
                        C.add(new Chocolate(gift_to,feedback_score,weight,price,colour,quantity,name));
                    }
                    System.out.println("\n Objects of Chocolates Created");
                    for(Chocolate ch: C)
                        ch.display_gift();
                    System.out.println("Enter the parameter for sorting the Chocolates");
                    System.out.println("1.Price");
                    System.out.println("2.Weight");
                    System.out.println("Enter the choice");
                    choice2=sc.nextInt();
                    switch(choice2)
                    {
                        case 1: System.out.println("Sorting the Chocolates according to price");
                            Collections.sort(C,new ChocolateComparatorbyprice());
                            System.out.println(" After Sorting");
                            break;
                        case 2:System.out.println("Sorting the Chocolates according to weight");
                            Collections.sort(C,new ChocolateComparatorbyweight());
                            System.out.println(" After Sorting");
                            break;
                        default:System.out.println("Wrong choice");
                    }
                    for(Chocolate ch: C)
                        ch.display_gift();
                    break;
                case 2: System.out.println("Enter the numbers of objects of Sweets");
                    n=sc.nextInt();
                    gift_record=gift_record+n;
                    ArrayList<Sweets> S=new ArrayList<Sweets>();
                    for(int i=0;i<n;i++)
                    {
                        System.out.println(" Enter the details for Sweet "+i+1);
                        System.out.println(" Enter the name of the Sweet ");
                        sc.nextLine();
                        name=sc.nextLine();
                        System.out.println(" Enter the price of the Sweet");
                        price=sc.nextDouble();
                        System.out.println(" Sweets gifted to (children/adult) ");
                        sc.nextLine();
                        gift_to=sc.nextLine();
                        System.out.println(" Enter the weight of the Sweet");
                        weight=sc.nextDouble();
                        System.out.println("\n Enter the colour of the Sweet ");
                        sc.nextLine();
                        colour=sc.nextLine();
                        System.out.println("\n Enter the quantity of the Sweet");
                        quantity=sc.nextInt();
                        System.out.println("\n Enter the Feedback of the gift ");
                        feedback_score=sc.nextInt();
                        S.add(new Sweets(gift_to,feedback_score,weight,price,name,colour,quantity));
                    }
                    System.out.println("\n Objects of Sweets Created");
                    for(Sweets sh: S)
                        sh.display_gift();
                    break;
                case 3: System.out.println("Enter the numbers of objects of Candies");
                    n=sc.nextInt();
                    gift_record=gift_record+n;
                    ArrayList<Candy> Can=new ArrayList<Candy>();
                    for(int i=0;i<n;i++)
                    {
                        System.out.println(" Enter the details for Candy "+i+1);
                        System.out.println(" Enter the name of the Candy ");
                        sc.nextLine();
                        name=sc.nextLine();
                        System.out.println(" Enter the price of the Candy");
                        price=sc.nextDouble();
                        System.out.println(" Candy gifted to (children/adult) ");
                        sc.nextLine();
                        gift_to=sc.nextLine();
                        System.out.println(" Enter the weight of the Candy");
                        weight=sc.nextDouble();
                        System.out.println("\n Enter the colour of the Candy ");
                        sc.nextLine();
                        colour=sc.nextLine();
                        System.out.println("\n Enter the taste of the Candy ");
                        taste=sc.nextLine();
                        System.out.println("\n Enter the quantity of the Candy");
                        quantity=sc.nextInt();
                        System.out.println("\n Enter the Feedback of the gift");
                        feedback_score=sc.nextInt();
                        Can.add(new Candy(gift_to,feedback_score,weight,colour,price,taste,name,quantity));
                    }
                    System.out.println("\n Objects of Sweets Created");
                    for(Candy candy: Can)
                        candy.display_gift();
                    System.out.println("Enter the Range(Price)");
                    System.out.println("Enter the lower limit");
                    min=sc.nextDouble();
                    System.out.println("Enter the upper limit");
                    max=sc.nextDouble();
                    for(Candy candy: Can)
                    {
                        if(min<=candy.getprice() && max>=candy.getprice())
                        {
                            count=1;
                            candy.display_gift();
                        }
                    }
                    if(count==0)
                        System.out.println("No records available according to search conditions");
                    break;
                case 4: if(gift_record==0)
                    System.out.println("No records");
                else
                {
                    System.out.println("Total Weight of Gifts gifted to children "+ Gift.total_weight);
                }
            }
            System.out.println("Do you want to continue (y/n)");
            choiceatend=sc.next().charAt(0);
        }while(choiceatend!='n');
        sc.close();
    }
}