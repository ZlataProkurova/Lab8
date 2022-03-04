package com.company;

public class ExceptionForNull extends Exception { 

public ExceptionForNull() {
    System.out.println("Знаменатель простой дроби не может быть нулём");
    System.exit(1);
}
}


