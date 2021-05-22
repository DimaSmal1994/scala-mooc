package homeworks.collections

import homeworks.HomeworksUtils.TaskSyntax

object task_caesar {
  val Letter_A: Int = 'A'.toInt

  /**
   * В данном задании Вам предлагается реализовать функции,
   * реализующие кодирование/декодирование строки шифром Цезаря.
   * https://ru.wikipedia.org/wiki/Шифр_Цезаря
   * Алфавит - прописные латинские буквы от A до Z.
   * Сдвиг   - неотрицательное целое число.
   * Пример: при сдвиге 2 слово "SCALA" шифруется как "UECNC".
   */
  /**
   * @param word   входное слово, которое необходимо зашифровать
   * @param offset сдвиг вперёд по алфавиту
   * @return зашифрованное слово
   */
  def encrypt(word: String, offset: Int): String = {
    word.map(charr => {
      val numberCode = charr.toInt - Letter_A
      val encryptedCode = (numberCode + offset % 26) % 26 + Letter_A
      encryptedCode.toChar
    })
  }

  /**
   * @param cipher шифр, который необходимо расшифровать
   * @param offset сдвиг вперёд по алфавиту
   * @return расшифрованное слово
   */
  def decrypt(cipher: String, offset: Int): String = {
    cipher.map(charr => {
      val numberCode = charr.toInt - Letter_A
      if (numberCode - offset >= 0) {
        val encryptedCode = (numberCode - offset % 26) % 26 + Letter_A
        encryptedCode.toChar
      } else {
        val encryptedCode = (numberCode - offset % 26 + 26) % 26 + Letter_A
        encryptedCode.toChar
      }
    })
  }

}
