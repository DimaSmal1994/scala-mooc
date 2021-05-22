package homeworks.futures

import scala.concurrent.{ExecutionContext, Future}

object task_futures_sequence {

  /**
   * В данном задании Вам предлагается реализовать функцию fullSequence,
   * похожую на Future.sequence, но в отличии от нее,
   * возвращающую все успешные и не успешные результаты.
   * Возвращаемое тип функции - кортеж из двух списков,
   * в левом хранятся результаты успешных выполнений,
   * в правово результаты неуспешных выполнений.
   * Не допускается использование методов объекта Await и мутабельных переменных var
   */
  /**
   * @param futures список асинхронных задач
   * @return асинхронную задачу с кортежом из двух списков
   */
  def fullSequence[A](futures: List[Future[A]])
                      (implicit ex: ExecutionContext): Future[(List[A], List[Throwable])] =
    futures.foldLeft(Future {
      (Nil, Nil)
    }: Future[(List[A], List[Throwable])]) {
      (acc, future) =>
        future.flatMap({
          result =>
            acc.map(pair => (pair._1 :+ result, pair._2))
        }).recoverWith({
          case exception: Throwable => acc.map(pair => (pair._1, pair._2 :+ exception))
        })
    }
}
