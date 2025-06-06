/**
 * Задание 3: Секреты.
 * Секреты никому нельзя рассказывать. Никому кроме одного самого близкого друга!
 * Необходимо описать сущность Секрет, которая будет позволять хранить и передавать
 * некоторый текст только одному другому хранителю. Состояние сущности описывают
 * следующие сведения:
 * - Текст секрета, в виде строки.
 * - Имя хранителя секрета, в виде строки
 * Инициализация сущности может быть выполнена следующим образом:
 * - С указанием имени хранителя секрета и текста секрета, это будет означать создание
 *   нового секрета.
 * - С указанием другого Секрета и именем хранителя секрета. В этом случае мы считаем,
 *   что секрет был рассказан другому человеку. При передаче секрета должно произойти
 *   следующее: во-первых, на консоль выводится текст вида "Имя сказал что Секрет",
 *   где Имя и Секрет представляют собой имя того кто рассказывает секрет и текст секрета
 *   соответственно. Во-вторых, текст секрета у нового хранителя должен представлять собой
 *   копию текста предыдущего хранителя, но с добавлением Х случайных символов в Х случайных
 *   мест, где Х — это число в диапазоне от 0 до N, а N в свою очередь это 10% от размера
 *   исходного текста.
 * Поведение сущности описывают следующие действия:
 * - Может быть приведен к строке, строковое преставление вида "Имя: это секрет!",
 *   где Имя – это конкретное имя хранителя секрета, а остальное простой текст.
 * - Можно узнать каким по очереди был данных хранитель секрета.
 * - Можно узнать сколько еще человек узнали секрет после текущего хранителя
 * - Можно получить имя N-го человек узнавшего секрет, причем N будет положительным для
 *   случая, когда мы хотим узнать имя следующего узнавшего секрет, и отрицательным если
 *   предыдущего.
 * - Можно узнать разницу в количестве символов текста секрета с N-ым человеком
 * Необходимо учесть следующие требования к инкапсуляции:
 * - Единственным способом получить текст секрета может быть его вывод на экран при
 *   инициализации объекта.
 */

package ru.khismatov.secret;

import java.util.Random;

/**
 * Представляет собой секрет, который может быть передан только одному человеку.
 * При передаче секрета его текст модифицируется путем добавления случайных символов.
 * 
 * Особенности:
 * - Секрет может быть передан только одному человеку
 * - При передаче секрета его текст модифицируется
 * - Хранит цепочку передачи секрета
 * - Позволяет отслеживать порядок передачи секрета
 * - Поддерживает получение информации о предыдущих и следующих хранителях
 */
public class Secret {
  private final String secret;
  private final String name_guard;
  private final int order;
  private Secret next_guard;
  private final Secret previous_guard;

  /**
   * Создает новый секрет с указанным текстом и именем первого хранителя.
   *
   * @param secret текст секрета
   * @param name_guard имя хранителя секрета
   */
  public Secret(String secret, String name_guard) {
    if (name_guard == null || name_guard.isEmpty()) {
      System.out.println("Error: Name guard cannot be empty or null");
      this.secret = null;
      this.name_guard = null;
      this.order = 0;
      this.next_guard = null;
      this.previous_guard = null;
      return;
    }
    if (secret == null || secret.isEmpty()) {
      System.out.println("Error: Secret text cannot be empty or null");
      this.secret = null;
      this.name_guard = null;
      this.order = 0;
      this.next_guard = null;
      this.previous_guard = null;
      return;
    }
    this.secret = secret;
    this.name_guard = name_guard;
    this.order = 1;
    this.next_guard = null;
    this.previous_guard = null;
  }

  /**
   * Создает новую копию секрета для следующего хранителя.
   * При передаче секрета его текст модифицируется.
   * Выводит сообщение о передаче секрета.
   *
   * @param previous_guard предыдущий хранитель секрета
   * @param name_guard имя нового хранителя
   */
  public Secret(Secret previous_guard, String name_guard) {
    if (name_guard == null || name_guard.isEmpty()) {
      System.out.println("Error: Name guard cannot be empty or null");
      this.secret = null;
      this.name_guard = null;
      this.order = 0;
      this.next_guard = null;
      this.previous_guard = null;
      return;
    }
    if (previous_guard == null) {
      System.out.println("Error: Previous guard cannot be null");
      this.secret = null;
      this.name_guard = null;
      this.order = 0;
      this.next_guard = null;
      this.previous_guard = null;
      return;
    }
    if (previous_guard.next_guard != null) {
      System.out.println("Error: The secret has already been passed on to another guard");
      this.secret = null;
      this.name_guard = null;
      this.order = 0;
      this.next_guard = null;
      this.previous_guard = null;
      return;
    }
    this.name_guard = name_guard;
    this.previous_guard = previous_guard;
    this.order = previous_guard.order + 1;
    this.secret = modify_secret(previous_guard.secret);
    previous_guard.next_guard = this;
    System.out.println(previous_guard.name_guard + " told that " + previous_guard.secret);
  }

  /**
   * Модифицирует текст секрета путем добавления случайных символов.
   * Количество добавляемых символов - случайное число от 0 до 10% длины текста.
   *
   * @param secret исходный текст секрета
   * @return модифицированный текст секрета
   */
  private String modify_secret(String secret) {
    StringBuilder modified_secret = new StringBuilder(secret);
    Random rand = new Random();
    for (int i = 0; i < (rand.nextInt(Math.max(1, secret.length() / 10) + 1)); i++) {
      modified_secret.insert(
          rand.nextInt(modified_secret.length()), (char) ('a' + rand.nextInt(26)));
    }
    return modified_secret.toString();
  }

  /**
   * Возвращает строковое представление секрета в формате "Имя: это секрет!".
   *
   * @return строковое представление секрета
   */
  @Override
  public String toString() {
    return name_guard + ": it's a secret!";
  }

  /**
   * Возвращает порядковый номер текущего хранителя в цепочке передачи.
   *
   * @return порядковый номер хранителя
   */
  public int get_order() {
    return order;
  }

  /**
   * Возвращает количество людей, которым был передан секрет после текущего хранителя.
   *
   * @return количество следующих хранителей
   */
  public int get_count_next_guards() {
    Secret current_guard = this;
    while (current_guard.next_guard != null) {
      current_guard = current_guard.next_guard;
    }
    return current_guard.order - this.order;
  }

  /**
   * Возвращает имя хранителя секрета по его порядковому номеру относительно текущего.
   * Положительное N означает поиск следующего хранителя, отрицательное - предыдущего.
   *
   * @param N смещение относительно текущего хранителя
   * @return имя хранителя или null, если такого хранителя нет
   */
  public String get_guard_by_order(int N) {
    Secret current_guard = this;
    if (N > 0) {
      for (int i = 0; i < N; i++) {
        if (current_guard.next_guard == null) {
          return null;
        }
        current_guard = current_guard.next_guard;
      }
    } else {
      for (int i = 0; i < -N; i++) {
        if (current_guard.previous_guard == null) {
          return null;
        }
        current_guard = current_guard.previous_guard;
      }
    }
    return current_guard.name_guard;
  }

  /**
   * Возвращает разницу в длине текста секрета между текущим хранителем и хранителем,
   * отстоящим на N позиций в цепочке передачи.
   *
   * @param N смещение относительно текущего хранителя
   * @return разница в длине текста или -1, если такого хранителя нет
   */
  public int get_delta_length(int N) {
    Secret current_guard = this;
    if (N > 0) {
      for (int i = 0; i < N; i++) {
        if (current_guard.next_guard == null) {
          return -1;
        }
        current_guard = current_guard.next_guard;
      }
    } else {
      for (int i = 0; i < -N; i++) {
        if (current_guard.previous_guard == null) {
          return -1;
        }
        current_guard = current_guard.previous_guard;
      }
    }
    return Math.abs(current_guard.secret.length() - this.secret.length());
  }
}
