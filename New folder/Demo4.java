import java.util.Scanner;

class Solution {

    public int romanToInt(String s) {
        int[] intt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romns = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        int i = 0;

        while (i < s.length()) {
            for (int j = 0; j < romns.length; j++) {
                if (s.startsWith(romns[j], i)) {
                    result += intt[j];
                    i += romns[j].length();
                    break;
                }
            }
        }
        return result;
    }

    
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        switch (num / 1000) {
            case 1: roman.append("M"); num -= 1000; break;
            case 2: roman.append("MM"); num -= 2000; break;
            case 3: roman.append("MMM"); num -= 3000; break;
        }

        switch (num / 900) {
            case 1: roman.append("CM"); num -= 900; break;
        }

        switch (num / 500) {
            case 1: roman.append("D"); num -= 500; break;
        }

        switch (num / 400) {
            case 1: roman.append("CD"); num -= 400; break;
        }

        switch (num / 100) {
            case 1: roman.append("C"); num -= 100; break;
            case 2: roman.append("CC"); num -= 200; break;
            case 3: roman.append("CCC"); num -= 300; break;
        }

        switch (num / 90) {
            case 1: roman.append("XC"); num -= 90; break;
        }

        switch (num / 50) {
            case 1: roman.append("L"); num -= 50; break;
        }

        switch (num / 40) {
            case 1: roman.append("XL"); num -= 40; break;
        }

        switch (num / 10) {
            case 1: roman.append("X"); num -= 10; break;
            case 2: roman.append("XX"); num -= 20; break;
            case 3: roman.append("XXX"); num -= 30; break;
        }

        switch (num / 9) {
            case 1: roman.append("IX"); num -= 9; break;
        }

        switch (num / 5) {
            case 1: roman.append("V"); num -= 5; break;
        }

        switch (num / 4) {
            case 1: roman.append("IV"); num -= 4; break;
        }

        switch (num / 1) {
            case 1: roman.append("I"); num -= 1; break;
            case 2: roman.append("II"); num -= 2; break;
            case 3: roman.append("III"); num -= 3; break;
        }

        return roman.toString();
    }
}

    public class Demo4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        
        System.out.println("Choose an option:");
        System.out.println("1. Roman to Integer");
        System.out.println("2. Integer to Roman");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();  
        
        switch (choice) {
            case 1: 
                System.out.print("Enter a Roman numeral: ");
                String roman = scanner.nextLine();
                int result = solution.romanToInt(roman);
                System.out.println("The integer value is: " + result);
                break;
            
            case 2: 
                System.out.print("Enter an integer: ");
                int number = scanner.nextInt();
                String romanNumeral = solution.intToRoman(number);
                System.out.println("The Roman numeral is: " + romanNumeral);
                break;

            case 3:
            System.out.println("Exit");    
            
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
                break;
        }

        scanner.close();
    }
}
