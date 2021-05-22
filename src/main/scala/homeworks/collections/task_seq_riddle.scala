package homeworks.collections

import homeworks.HomeworksUtils.TaskSyntax

import scala.collection.mutable.ArrayBuffer

object task_seq_riddle {

  /**
   * Рассмотрим последовательность с числами:
   *
   * 1
   * 1 1
   * 2 1
   * 1 2 1 1
   * 1 1 1 2 2 1
   * 3 1 2 2 1 1
   * ...........
   *
   * 1. Реализуйте функцию генерирующую след последовательность из текущей
   * */

  def nextLine(currentLine: List[Int]): List[Int] = {
    val result = new ArrayBuffer[Int]()

    var lastNumber: Int = 0
    var counter: Int = 0
    currentLine.foreach(x => {
      if (lastNumber == 0) {
        lastNumber = x
        counter += 1
      } else if (x == lastNumber) {
        counter += 1
      } else {
        result.append(counter)
        result.append(lastNumber)
        lastNumber = x
        counter = 1
      }
    })

    result.append(counter)
    result.append(lastNumber)

    result.toList
  }

  /**
   * 2. Реализуйте ленивый список, который генерирует данную последовательность
   * Hint: см. LazyList.cons
   *
   * lazy val funSeq: LazyList[List[Int]]  ...
   *
   */

  val funSeq: LazyList[List[Int]] = LazyList.cons(List(1), funSeq.map(line => nextLine(line)))
}