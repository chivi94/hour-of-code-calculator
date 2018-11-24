package uva.inf.ivagonz.mycalculator;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculadora{

    private double a;
    private double b;

	public Calculadora(){
	    a = Double.NaN;
	    b = 0;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        return a / b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
