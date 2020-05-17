package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global
object Advance extends  App {

  // Lazy evaluation
  lazy val lazyVal = 2

  lazy val lazyValueWithSideEffect = {
    println("Hello this a lazy evaluation")
    54  // In a block always the last line is returned
  }
  // you can execute the program here and you won't visualize nothing in the console

  // Now use the element with anything you want for example a simple assignation
  val triggerVal = lazyValueWithSideEffect + 1

  // Option element to avoid null
  def methodWhichCanReturnNull(): String = null
  val optionVal = Option(methodWhichCanReturnNull())

  val stringProcessing = optionVal match {
    case Some(string) => s" This contain a valid string: $string"
    case None => "I obtained nothing"
  }
  println("Example with Option Element")
  println(stringProcessing)

  // A elegant way of exception handling using the Try element
  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException())

  val stringProcess = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(exception)   => s" Opps A exception: ${exception.getMessage}"
  }
  println(stringProcess)

  // working with threads and asynchronous programming
  val future = Future {
    println("Loading ----")
    Thread.sleep(1000)
    println("The output")
    67
  }
  // sleep for 2s to make sure it is done
  Thread.sleep(2000)
  future.onComplete {
    case Success(result) => println("Done !!")
  }

  // Implicit in arguments can help you to link a method with a variable
  // so that method will be executed with that variable as input

  def methodWithImplicitArgs(implicit a: Int) = a + 1
  implicit  val myVal = 50
  println(" The method with a implicit element:")
  println(methodWithImplicitArgs)

   // Implicit conversions
  implicit class IntegerUtil(u: Int){
     def isEven() = u % 2 == 0
     def isOdd() = u % 2 != 0
   }
  val myInt : Int = 345
  println("The element is Even ?")
  println(myInt.isEven())

  println("It is odd?")
  println(myInt.isOdd())
}
