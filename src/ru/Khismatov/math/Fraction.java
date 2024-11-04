package ru.Khismatov.math;

import java.util.Objects;

public final class Fraction extends Number implements Cloneable {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {throw new IllegalArgumentException("Denominator cannot be zero");}
        int nod = nod(Math.abs(numerator), Math.abs(denominator));
        numerator /= nod;
        denominator /= nod;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int nod(int a, int b) {
        if (b == 0) {return a;}
        else {return nod(b, a % b);}
    }

    public Fraction sum(Fraction other) {return new Fraction(this.numerator * other.denominator + this.denominator * other.numerator, this.denominator * other.denominator);}

    public Fraction sum(int value) {return new Fraction(this.numerator + this.denominator * value, this.denominator);}

    public Fraction minus(Fraction other) {return new Fraction(numerator * other.denominator - this.denominator * other.numerator, this.denominator * other.denominator);}

    public Fraction minus(int value) {return new Fraction(this.numerator - this.denominator * value, this.denominator);}

    public Fraction multiply(Fraction other) {return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);}

    public Fraction multiply(int value) {return new Fraction(this.numerator * value, this.denominator);}

    public Fraction divide(Fraction other) {return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);}

    public Fraction divide(int value) {return new Fraction(this.numerator, this.denominator * value);}

    @Override
    public String toString() {return numerator + "/" + denominator;}

    @Override
    public int intValue() {return numerator/denominator;}

    @Override
    public long longValue() {return (long) numerator/denominator;}

    @Override
    public float floatValue() {return (float) numerator/denominator;}

    @Override
    public double doubleValue() {return (double) numerator/denominator;}

    @Override
    public int hashCode() {return Objects.hash(numerator, denominator);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction other)) return false;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public Fraction clone() {
        try{
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
