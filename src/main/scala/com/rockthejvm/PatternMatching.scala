package com.rockthejvm
/**
 * Fundamentals of pattern Matching
 * @author Brahian VT
 * */
object PatternMatching extends App {
  //A Switch expression is a example of pattern matching
  val integer = 55
  val order = integer match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "third"
    case _ => integer + "th"
  }

  println(order)

  // A pattern Matching is an Expression

  // PM with case class example
  case class Person(name: String , age: Int)
  val bob = Person("Bob", 45)

  val patternMGreeting = bob match {
    case Person(n, a) => s"Hi, My name is $a and  I am $a years old"
    case _ => "Something else"
  }
  println(patternMGreeting)

  // PM using tuples
  val tuple = ("Metallica", "Heavy Metal")
  val bandDescription = tuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "Unknown list"
  }
  // using lists
  var list = List(1,2,3)
  var listDes = list match {
    case List(_, 2,_) => "List contains 2 on its second position"
    case _ => "Unknown List"
  }
  // Watch Out: PM wil throw a Exception if it didn't match anything
  // So always define the default case the pattern matching in test in sequence

}
