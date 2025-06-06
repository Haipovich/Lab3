/**
 * Задание 2: Непустые Имена.
 * Измените сущность Имя из задачи 1.4.5. Гарантируйте, что:
 * - Как минимум один параметр будет иметь не null значение и не пустую строку.
 * - Имя неизменяемо.
 * Продемонстрируйте работоспособность решения на примерах
 */

package ru.khismatov.data;

/**
 * Представляет собой неизменяемое имя человека, состоящее из фамилии, имени и отчества.
 * Класс гарантирует, что хотя бы один из компонентов имени не будет пустым.
 */
public class Name {
  private final String last_name;
  private final String first_name;
  private final String middle_name;

  /**
   * Создает новое полное имя с фамилией, именем и отчеством.
   * Хотя бы один из параметров должен быть непустым.
   *
   * @param last_name фамилия
   * @param first_name имя
   * @param middle_name отчество
   */
  public Name(String last_name, String first_name, String middle_name) {
    if (is_null_or_empty(last_name)
        && is_null_or_empty(first_name)
        && is_null_or_empty(middle_name)) {
      System.out.println("Error: At least one name parameter must not be empty");
      return;
    }
    this.last_name = last_name;
    this.first_name = first_name;
    this.middle_name = middle_name;
  }

  /**
   * Создает новое имя с фамилией и именем (без отчества).
   *
   * @param last_name фамилия
   * @param first_name имя
   */
  public Name(String last_name, String first_name) {
    this(last_name, first_name, null);
  }

  /**
   * Создает новое имя, содержащее только имя человека.
   *
   * @param first_name имя
   */
  public Name(String first_name) {
    this(null, first_name, null);
  }

  /**
   * Проверяет, является ли строка null или пустой.
   *
   * @param str проверяемая строка
   * @return true, если строка null или пустая, false в противном случае
   */
  private boolean is_null_or_empty(String str) {
    return str == null || str.trim().isEmpty();
  }

  /**
   * Возвращает строковое представление имени.
   * Компоненты имени выводятся в порядке: фамилия, имя, отчество.
   * Пустые компоненты пропускаются.
   *
   * @return строковое представление имени
   */
  @Override
  public String toString() {
    String result = "";
    if (last_name != null && !last_name.isEmpty()) {
      result += last_name + " ";
    }
    if (first_name != null && !first_name.isEmpty()) {
      result += first_name + " ";
    }
    if (middle_name != null && !middle_name.isEmpty()) {
      result += middle_name;
    }
    return result.trim();
  }
}
