package com.rockthejvm
/**
 * Basic Exampples of Functional programming using Scala
 *
 * @author Brahian VT
 * */

object FunctionalProgramming extends App {

  // Scala is based on JVM so it is based on OOP
  class Person(name: String){
    def apply(age: Int): Unit = println(s" I have aged $age years")
  }
  val  bob = new Person("Bob")
  bob.apply(43)
  bob(43)  // This is basically  the same that the line above

  // In order to implements functional programming use the FunctionX element

  val simpleIncrementer = new Function1[Int, Int]{
    override def apply(arg: Int): Int = arg + 1
  }
  println(simpleIncrementer(23))

  // Example with a Function with 2 arguments and a String return type

  val stringConcatenator = new Function2[String, String, String] {
    def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  println(stringConcatenator("Hello", "Scala o-o" ))

  // I more readable syntax
  val doubler : Int => Int = (x: Int) => 2 * x
  println(doubler(4))

  // higher-order functions: take functions as args/return functions as results
  val mapList: List[Int] = List(1,2,3).map(x => x + 1)
  println(s" List with fp example using map: $mapList")
  val flatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))
  println(s" List with fp example using flataMap $flatMappedList")

  //Filter example
  var list : List[Int] = List(1,2,3,3,4,5)
  val filterExample = list.filter( _ <= 3)  // it is the same (x => x <= 3)

  // Example from the lists [1,2,3] and [a,b,c] return all the combinations
  // Result : [1-a,1-b,1-c,2-a,2-b,...]
  var listA = List(1,2,3)
  var listB = List('a','b','c')

  var combinations = listA.flatMap(number => listB.map( letter => s"$number-$letter"))
  // A more readable answer using a for comprehension
  val combinationsB = for {
    number <- listA
    letter <- listB
  } yield s"$number-$letter"

  println(combinations)
  println(combinationsB)

  // Collections in Scala
  var listE = List(1,2,34,5,6)
  var firstE = listE.head
  var restOfList = listE.tail
  println(s" list: $listE head: $firstE  tail: $restOfList")

  // pre-append to list
  var preAppend = 0 :: listE
  // extend. List append at the start and end
  var extendedList = 0 +: listE :+ 6
  println(s"Pre-append: $preAppend ")
  println(s"ExtendedLsit: $extendedList ")

  // sequences
  val sec : Seq[Int] = Seq(1,2,3)
  println(s"sec: $sec  sec[1] $sec(1)")

  // vectors: fast Seq implementation
  val vec = Vector(1,2,343,4,5)
  println(s"Vector: $vec ")

  // Sets : no duplicates
  val set = Set(1,2,3,4)
  println(s"Set : $set  , search the 5 : ${set.contains(5)}" )
  println(s" remove 2 : ${set - 2} , add 10:  ${set + 10}")

  // ranges
  val range = 1 to 100
  val twoByTwo = range.map(x => 2 * x).toList // 2,4,6,8.....200

  // map
  val map : Map[String, Int] = Map(
     ("Daniel", 345346),
      "Jane" -> 3256
  )
  println(map)

  // Tuple

  val tuple = ("Ver", "Hi", 345)
  println(tuple)
}
