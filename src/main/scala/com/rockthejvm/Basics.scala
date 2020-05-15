package com.rockthejvm


/**
 * Learn fundamental topic about
 * Scala.
 * @author Brahian VT
 */

/* Extends from App that means the object will execute as a standalone application


*/
object Basics extends App {
  // define a Value
  val meaningOfLife: Int = 42  // const int meaningOfLife = 42;
  val aBoolean = false  // type is optional
  val aString = "I love Scala"
  val aComposedString = "Hi" + " " + "I love" + "Scala!!!"
  val anInterpolatedString = s"Guess something : $aComposedString"


  // expressions in Scala are structures that can be reduced to a value
  val anExpression = 2 + 3;

  // if expression
  val ifExpression = if (meaningOfLife > 43) 56 else 987
  // if expression Another Example

  val chainedIfExpression = if (meaningOfLife > 43) 56
  else if (meaningOfLife < 0) -2
  else if (meaningOfLife > 999) 78
  else 0

  // code blocks assigned to a variable
  val aCodeBlock = {
    val aLocalValue = 67

    aLocalValue + 3
  }

  // define a function

  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // Recursive Functions
  def factorial(n: Int): Int =
    if(n <= 1) 1
    else n * factorial(n - 1)

  /*
   factorial(5) = 5 * factorial(4) = 5 * 24 = 120
   factorial(4) = 4 * factorial(3) = 4 * 6
   factorial(3) = 3 * factorial(2) = 3 * 2
   factorial(2) = 2 * factorial(1) = 2 * 1
   factorial(1) = 1
  */

  // As a typical functional programming , Here in Scala we don't use lopps

  // The "Unit" Type is equals to avoid

  println("Hello World");

  def exampleUnitTypeReturning(): Unit = {
    println("Example returning Unit")
  }
}
