/**
 * - Задание 1: Дроби.
 *   - Дробь не может быть изменена после создания
 *   - Корректно обрабатывает отрицательные значения (знаменатель всегда положительный).
 *
 * - Задание 4: Запретная Дробь.
 *   - Гарантирует невозможность создания подкласса с изменяемым состоянием
 *
 * - Задание 5: Дробь это число.
 *   - Является подтипом класса Number.
 *
 * - Задание 7: Сравнение дробей.
 *   - Переопределен метод equals(Object) для сравнения по состоянию (числитель и знаменатель).
 *   - Переопределен метод hashCode().
 *
 * - Задание 11: Клонирование Дроби.
 *   - Переопределен метод clone() для создания копии объекта.
 */

package ru.khismatov.math;

import java.util.Objects;

/**
 * Представляет собой неизменяемую дробь с числителем и знаменателем.
 * Класс наследуется от Number и реализует интерфейс Cloneable.
 * Дробь всегда хранится в сокращенном виде с положительным знаменателем.
 * 
 * Особенности:
 * - Неизменяемый класс после создания
 * - Корректно обрабатывает отрицательные значения (знаменатель всегда положительный)
 * - Не может быть унаследован (final класс)
 * - Реализует интерфейс Number для числовых преобразований
 * - Поддерживает клонирование
 * - Реализует equals и hashCode для корректного сравнения
 */
public final class Fraction extends Number implements Cloneable {
  private final int numerator;
  private final int denominator;

  /**
   * Создает новую дробь с указанным числителем и знаменателем.
   * Дробь автоматически сокращается до несократимой.
   * Знаменатель приводится к положительному значению, если он отрицательный.
   *
   * @param numerator числитель дроби
   * @param denominator знаменатель дроби (не должен быть равен нулю)
   */
  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      System.out.println("Error: Denominator cannot be zero");
      this.numerator = 0;
      this.denominator = 1;
      return;
    }
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

  /**
   * Вычисляет наибольший общий делитель (НОД) двух чисел с помощью алгоритма Евклида.
   *
   * @param a первое число
   * @param b второе число
   * @return наибольший общий делитель чисел a и b
   */
  private int nod(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return nod(b, a % b);
    }
  }

  /**
   * Складывает эту дробь с другой дробью.
   *
   * @param other дробь для сложения
   * @return новая дробь, представляющая сумму
   */
  public Fraction sum(Fraction other) {
    return new Fraction(
        this.numerator * other.denominator + this.denominator * other.numerator,
        this.denominator * other.denominator);
  }

  /**
   * Складывает эту дробь с целым числом.
   *
   * @param value целое число для сложения
   * @return новая дробь, представляющая сумму
   */
  public Fraction sum(int value) {
    return new Fraction(this.numerator + this.denominator * value, this.denominator);
  }

  /**
   * Вычитает другую дробь из этой дроби.
   *
   * @param other дробь для вычитания
   * @return новая дробь, представляющая разность
   */
  public Fraction minus(Fraction other) {
    return new Fraction(
        numerator * other.denominator - this.denominator * other.numerator,
        this.denominator * other.denominator);
  }

  /**
   * Вычитает целое число из этой дроби.
   *
   * @param value целое число для вычитания
   * @return новая дробь, представляющая разность
   */
  public Fraction minus(int value) {
    return new Fraction(this.numerator - this.denominator * value, this.denominator);
  }

  /**
   * Умножает эту дробь на другую дробь.
   *
   * @param other дробь для умножения
   * @return новая дробь, представляющая произведение
   */
  public Fraction multiply(Fraction other) {
    return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
  }

  /**
   * Умножает эту дробь на целое число.
   *
   * @param value целое число для умножения
   * @return новая дробь, представляющая произведение
   */
  public Fraction multiply(int value) {
    return new Fraction(this.numerator * value, this.denominator);
  }

  /**
   * Делит эту дробь на другую дробь.
   *
   * @param other дробь-делитель
   * @return новая дробь, представляющая частное
   */
  public Fraction divide(Fraction other) {
    return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
  }

  /**
   * Делит эту дробь на целое число.
   *
   * @param value целое число-делитель
   * @return новая дробь, представляющая частное
   */
  public Fraction divide(int value) {
    return new Fraction(this.numerator, this.denominator * value);
  }

  /**
   * Возвращает строковое представление дроби в виде "числитель/знаменатель".
   *
   * @return строковое представление дроби
   */
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  /**
   * Преобразует эту дробь в целое число путем целочисленного деления.
   *
   * @return целочисленное значение дроби
   */
  @Override
  public int intValue() {
    return numerator / denominator;
  }

  /**
   * Преобразует эту дробь в число типа long путем деления.
   *
   * @return значение дроби типа long
   */
  @Override
  public long longValue() {
    return (long) numerator / denominator;
  }

  /**
   * Преобразует эту дробь в число типа float путем деления.
   *
   * @return значение дроби типа float
   */
  @Override
  public float floatValue() {
    return (float) numerator / denominator;
  }

  /**
   * Преобразует эту дробь в число типа double путем деления.
   *
   * @return значение дроби типа double
   */
  @Override
  public double doubleValue() {
    return (double) numerator / denominator;
  }

  /**
   * Возвращает хеш-код для этой дроби.
   * Хеш-код основан на значениях числителя и знаменателя.
   *
   * @return хеш-код дроби
   */
  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator);
  }

  /**
   * Сравнивает эту дробь с другим объектом на равенство.
   * Две дроби равны, если у них одинаковые числитель и знаменатель.
   *
   * @param obj объект для сравнения
   * @return true, если объекты равны, false в противном случае
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Fraction other)) {
      return false;
    }
    return numerator == other.numerator && denominator == other.denominator;
  }

  /**
   * Создает и возвращает копию этой дроби.
   *
   * @return клон дроби
   */
  @Override
  public Fraction clone() {
    try {
      return (Fraction) super.clone();
    } catch (CloneNotSupportedException e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }
}
