import java.util.Scanner;

public class SameDayDelivery{

    static double total=0;

    public static void main(String[]args){
        Table();
        QuestionB();
        Array();

    }

    public static void Table() {

        String myFormat = "%-12s%17s%17s%17s%17s%17s%17s\n";
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("%8s%45s%45s\n","WEIGHT","LOCAL TOWN","CROSS TOWN");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf(myFormat,"","Domestic Charge","Surcharge","Total","Domestic Charge","Surcharge","Total");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf(myFormat,"Below 500gm","4.90","6.00","10.90","5.40","7.50","12.90");
        System.out.printf(myFormat,"500gm-750gm","5.70","6.00","11.70","6.40","7.50","13.90");
        System.out.printf(myFormat,"750gm-1kg","6.50","6.00","12.50","7.40","7.50","14.90");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------\n\n");

    }

    public static void QuestionB(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which town you want to delivery?");
        System.out.println("1. Local Town");
        System.out.println("2. Cross Town");
        int my = sc.nextInt();

        switch(my){
            case 1:
                QuestionC();
                break;
            case 2:
                QuestionD();
                break;
            default:
                System.out.println("Invalid. Please enter 1 or 2.");
                QuestionB();
        }
    }

    public static void QuestionC(){

        Scanner sc = new Scanner(System.in);
        System.out.println("What is your shipment weight(gm)?");
        double my = sc.nextDouble();
        double price=0;
        double doCharge = 4.90;
        double surcharge = 6.00;

        if (my > 0 && my < 500){
            price = doCharge + surcharge;
        }
        else if (my >= 500 && my < 750){
            price = (doCharge+0.8) + surcharge;
        }
        else if (my >= 750 && my <= 1000){
            price = (doCharge+1.6) + surcharge;
        }
        else {
            System.out.println("Invalid.Please enter valid weight (> 0  to <= 1000).");
            QuestionC();
        }
        System.out.printf("Your Same-Day Delivery: RM"+ "%.2f\n\n",price);
        total+=price;
    }

    public static void QuestionD(){

        Scanner sc = new Scanner(System.in);
        System.out.println("What is your shipment weight(gm)?");
        double my = sc.nextDouble();
        double price=0;
        double doCharge = 5.40;
        double surcharge = 7.50;

        if (my > 0 && my < 500){
            price = doCharge + surcharge;
        }
        else if (my >= 500 && my < 750){
            price = (doCharge+1) + surcharge;
        }
        else if (my >= 750 && my <= 1000){
            price = (doCharge+2) + surcharge;

        }
        else {
            System.out.println("Invalid. Please enter valid weight (> 0  to <= 1000).");
            QuestionD();
        }

        System.out.printf("Your Same-Day Delivery: RM"+ "%.2f\n",price);
        total += price;
    }

    public static double Array() {

        System.out.println("Do you need another Same-Day Delivery?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner sc = new Scanner(System.in);
        int my = sc.nextInt();

        switch(my){
            case 1:
                while (my == 1){
                    QuestionB();
                    System.out.println("Do you need another Same-Day Delivery?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    my = sc.nextInt();   
                }
         
            case 2:
                while (my == 2) {
                    System.out.printf("Total Same-Day Delivery: RM"+ "%.2f\n\n",total);
        
                    break;
                
                }
                break;
        
            default:
                while(my!=1 || my!=2){
                    System.out.println("Invalid. Please enter 1 or 2.");
                    Array();
                }
            }


        return total;
    }
}



