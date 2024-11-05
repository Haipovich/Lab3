package ru.Khismatov.main;

import java.util.Scanner;
import ru.Khismatov.math.*;
import ru.Khismatov.data.*;
import ru.Khismatov.secret.Secret;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of task(8 is exit): ");
        int task_num = scan.nextInt();
        while (task_num != 8) {
            switch (task_num) {
                case 1:
                    System.out.println("Enter 2 fractions(1 5 is mean 1/5): ");
                    Fraction frac1 = new Fraction(scan.nextInt(), scan.nextInt());
                    Fraction frac2 = new Fraction(scan.nextInt(), scan.nextInt());
                    System.out.println(frac1 + " + " + frac2 + " = " + frac1.sum(frac2));
                    System.out.println(frac1 + " + 5 = " + frac1.sum(5));
                    System.out.println("After operations, original fractions remain unchanged:");
                    System.out.println("First fraction: " + frac1);
                    System.out.println("Second fraction: " + frac2);
                    System.out.println("Demonstration of type conversion:");
                    System.out.println("First fraction as int: " + frac1.intValue());
                    System.out.println("First fraction as long: " + frac1.longValue());
                    System.out.println("First fraction as float: " + frac1.floatValue());
                    System.out.println("First fraction as double: " + frac1.doubleValue());
                    break;
                case 2:
                    Name full_name = new Name("Иванов", "Иван", "Иванович");
                    System.out.println("Full name: " + full_name);
                    Name name_without_middle = new Name("Петров", "Петр");
                    System.out.println("Without middle name: " + name_without_middle);
                    Name only_first_name = new Name("Александр");
                    System.out.println("Only name: " + only_first_name);
                    try {
                        Name invalid_name = new Name("", "", "");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    Secret secret1 = new Secret("Seva likes to talk behind your back", "Andrey");
                    System.out.println("Secret: " + secret1);
                    Secret secret2 = new Secret(secret1, "Polina");
                    Secret secret3 = new Secret(secret2, "Ilya");
                    Secret secret4 = new Secret(secret3, "Cirk");
                    System.out.println("Ilya was told the secret in order: " + secret3.get_order());
                    System.out.println("The number of people Ilya told the secret to: " + secret3.get_count_next_guards());
                    System.out.println("The previous guard of Ilya secret's: " + secret3.get_guard_by_order(-1));
                    System.out.println("The next guard of Ilya secret's: " + secret3.get_guard_by_order(1));
                    System.out.println("Difference in length of secret between Ilya and Polina: " + secret2.get_delta_length(-1));
                    System.out.println("Difference in length of secret between Ilya and Cirk: " + secret2.get_delta_length(1));
                    try {
                        Secret secret5 = new Secret(secret1, "Egor");
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    ICalculator calc = new Calculator();
                    double result1 = calc.sum(2, new Fraction(3, 5), 2.3);
                    System.out.println("2 + 3/5 + 2.3 = " + result1);
                    double result2 = calc.sum(3.6, new Fraction(49, 12), new Fraction(3, 2));
                    System.out.println("3.6 + 49/12 + 3/2 = " + result2);
                    double result3 = calc.sum(new Fraction(1, 3), 1);
                    System.out.println("1/3 + 1 = " + result3);
                    break;
                case 5:
                    System.out.println("Enter 2 fractions(1 5 is mean 1/5): ");
                    frac1 = new Fraction(scan.nextInt(), scan.nextInt());
                    frac2 = new Fraction(scan.nextInt(), scan.nextInt());
                    if (frac1.equals(frac2)) {System.out.println("Fraction equals: " + frac1);}
                    else {System.out.println("Fraction not equals: " + frac1 + " != " + frac2);}
                    break;
                case 6:
                    calc = new Calculator();
                    System.out.println("Enter base of degree:");
                    String base = scan.next();
                    System.out.println("Enter exponent of degree:");
                    String exp = scan.next();
                    System.out.println("Result:" + Calculator.calculate_power(base, exp));
                    break;
                case 7:
                    Fraction original = new Fraction(3, 4);
                    Fraction cloned = original.clone();
                    System.out.println("Original: " + original);
                    System.out.println("Cloned: " + cloned);
                    System.out.println("Fractions have equals value: "+ original.equals(cloned));
                    System.out.println("Fractions is same objects: "  + (original.getClass() == cloned.getClass()));
                    break;
            }
            System.out.println("Enter the number of task(8 is exit): ");
            task_num = scan.nextInt();
        }
    }
}