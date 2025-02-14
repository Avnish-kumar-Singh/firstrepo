import java.util.Scanner;

class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value a and b");
        int a=sc.nextInt();
        int b=sc.nextInt();

        int sum=a+b;
        int sub=a-b;
        int multiply=a*b;
        int divide=a/b;
        System.out.println("\n SUM is:"+sum + "\n Subtract is:"+sub+ "\n Multiply is:"+ multiply+ "\n DIVIDE is:"+divide);
        sc.close();
        
    }
}   