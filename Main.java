package com.company;
import java.util.Scanner;
import java.util.regex.*;

public class Main {public static void main(String[] args) throws ExceptionForNull {
	Scanner in = new Scanner(System.in);
    System.out.println("Введите две простые дроби и арифметическую операцию между ними по формату \n " +
            "<1/1 + 1/1> (пробел между арифметической операцией и дробью обязателен)");
    String arithmeticExpression = in.nextLine();
    in.close();
    String pattern = "^(-?\\d{1,10})/(-?\\d{1,10})( )[-+*:]( )(-?\\d{1,10})/(-?\\d{1,10})$";
    Pattern pattern1 = Pattern.compile(pattern);
    Matcher matcher1 = pattern1.matcher(arithmeticExpression);
    if (matcher1.matches() == true) {
        String[] partsOfArithmeticExpression = arithmeticExpression.split("[/( )]+");
        String arithmeticOperation = partsOfArithmeticExpression[2];
        int num1numerator = Integer.parseInt(partsOfArithmeticExpression[0]);
        int num1denominator = Integer.parseInt(partsOfArithmeticExpression[1]);
        int num2numerator = Integer.parseInt(partsOfArithmeticExpression[3]);
        int num2denominator = Integer.parseInt(partsOfArithmeticExpression[4]);
        if ((num1denominator == 0) | (num2denominator == 0)) throw new ExceptionForNull();
        Fraction7 obj1 = new Fraction7( num1numerator,num1denominator );
    	Fraction7 obj2 = new Fraction7(num2numerator,num2denominator);
        if (arithmeticOperation.equals("+")) {
        	
        	Fraction7.addition (obj1, obj2);
           
    
            
        } else if (arithmeticOperation.equals("-")) {
            
            Fraction7.subtraction(obj1, obj2);
        } else if (arithmeticOperation.equals("*")) {
            
            Fraction7.multiple(obj1, obj2);
        } else if (arithmeticOperation.equals(":")) {
            if (num2numerator != 0) {
               
                Fraction7.division(obj1, obj2);
            } else {
                System.out.println(" В случае с делением первой простой дроби на вторую числитель второй простой дроби не может быть равен нулю");
            }
        }
    } else {
        System.out.println("Вы ввели выражение НЕ в указанном формате");
    }
}
}





	

