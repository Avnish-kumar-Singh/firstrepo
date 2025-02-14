import java.util.Scanner;

class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the required values:");
        
        System.out.print("Name: ");
        String name = sc.nextLine(); 
        
        System.out.print("Age: ");
        int age = sc.nextInt(); 
        
        sc.nextLine(); 
        
        System.out.print("Gender: ");
        String gender = sc.nextLine(); 
        
        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender); 
        
        sc.close(); 
    }
}
