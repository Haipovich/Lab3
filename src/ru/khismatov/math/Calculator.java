/**
 * - Задание 6: Сложение.
 *   - Реализует интерфейс {@link ICalculator}.
 *   - Содержит метод для суммирования набора числовых значений в вещественной форме.
 *     Примеры использования:
 *     - 2 + 3/5 + 2.3
 *     - 3.6 + 49/12 + 3 + 3 2
 *     - 1/3 + 1
 *
 * - Задание 10: Возведение в степень.
 *   - Содержит метод для возведения числа X в степень Y, где X и Y передаются как строки.
 *   - Использует короткие имена статических методов для Integer#parseInt(String) и Math#pow(double, double).
 */

package ru.khismatov.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Calculator implements ICalculator {
  public static double calculate_power(String exp, String power) {
    return pow(parseInt(exp), parseInt(power));
  }

  @Override
  public double sum(Number... numbers) {
    double sum = 0;
    for (Number number : numbers) {
      sum += number.doubleValue();
    }
    return sum;
  }
}
