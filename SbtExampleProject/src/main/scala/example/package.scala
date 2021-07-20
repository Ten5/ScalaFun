package object domain {

  class IllegalTypeException(message: String) extends RuntimeException(message)

  implicit class Ternary[T](condition: Boolean) {
    implicit def ??(a: => T, b: => T): T = if (condition) a else b
  }

  def isEmptyOrInsert[T](value: T): String =
    value match {
      case string: String => string.isBlank ?? ("", string)
      case integer: Int   => (integer == 0) ?? ("", integer.toString)
      case _ =>
        throw new IllegalTypeException(
          "Value obtained is neither String nor Int"
        )
    }
}
