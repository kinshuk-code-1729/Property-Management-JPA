package com.kbcompany.PropertyManagement.Controller;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorController cc = new CalculatorController();
        Double result =cc.add(8.1,10.2,23.1);
        System.out.println(result);
    }
}
