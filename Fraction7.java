package com.company;

public class Fraction7 {
	public int numerator;
    public int denominator; 


Fraction7(int numerator, int denominator) {
this.numerator = numerator;
this.denominator = denominator;

}
public Fraction7( ) {
this.numerator = 1;
this.denominator = 1;

}
public static int gcd(int numerator, int denominator) {
while (denominator !=0) {
	int tmp = numerator % denominator;
	numerator = denominator; 
	denominator = tmp;
	
}
return numerator;

}
public static int lcm(int den1, int den2) {
return den1 / gcd(den1, den2)*den2;

}
public static void showReduction(String a, Fraction7 obj) {
while (gcd(obj.numerator, obj.denominator) != 1) {
	int x = gcd(obj.numerator, obj.denominator);
	obj.numerator /= x;
	obj.denominator /=x;
}
to_normal(obj);
System.out.printf("Результат %s %d/%d \n", a, obj.numerator, obj.denominator);}

public static void show(Fraction7 obj) {
String a = "entering fraction values";
showReduction(a, new Fraction7(obj.numerator, obj.denominator));

}
public static void to_normal(Fraction7 obj) {
obj.numerator = obj.denominator < 0 ? -obj.numerator : obj.numerator;
obj.denominator = obj.numerator < 0 ? -obj.denominator : obj.denominator;
}
public static void addition(Fraction7 num1, Fraction7 num2) {
int nok = lcm(num1.denominator, num2.denominator);
int first = nok / num1.denominator * num1.numerator;
int second = nok / num2.denominator * num2.numerator;
int final_numerator = first + second;
String a = "addition";
showReduction(a, new Fraction7(final_numerator, nok));


}
public static void subtraction(Fraction7 obj1, Fraction7 obj2) {
int nok = lcm(obj1.denominator, obj2.denominator);
int first = nok / obj1.denominator * obj1.numerator;
int second = nok / obj2.denominator * obj2.numerator;
int final_numerator = first - second;
String a = "subtraction";
showReduction(a, new Fraction7(final_numerator, nok));
}
public static void multiple(Fraction7 num1, Fraction7 num2) {
int final_numerator = num1.numerator * num2.numerator;
int final_denominator = num1.denominator * num2.denominator;
String a = "multiple";
showReduction(a, new Fraction7(final_numerator, final_denominator));
}
public static void division(Fraction7 num1, Fraction7 num2) throws ExceptionForNull {
	if (num2.numerator == 0) {
		System.out.println("На ноль делить нельзя!");
		throw new ExceptionForNull();
	}
	int final_numerator = num1.numerator * num2.denominator;
	int final_denominator = num1.denominator * num2.numerator;
	String a = "division";
	showReduction(a, new Fraction7(final_numerator, final_denominator));
	}

}




