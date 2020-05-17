package com.rockthejvm
/**
 * Examples usind Scala with
 * Object Oriented Programming
 * @author Brahian VT
 *
 * */

object OppScala extends App {
  // declaring a class
  class Animal {
    val age: Int = 0
    def eat(): Unit = println("I'm eating")
  }
  val animal = new Animal
  println(" Instance of animal Class: and calling a method eat ")
  animal.eat()

  // With Scala also you can implements inheritance
  class Dog(val name: String) extends Animal
  val dog = new Dog("Jack")
  println("  ## Calling method eat from sub class  ##")
  dog.eat()
  println(s"the dog's name: ${dog.name}")

  // polimorphism
  val dogAnimal: Animal  = new Dog("Im a dog")
  println("Example with polimorphism")
  dogAnimal.eat()

  // Example of a abstract class

  abstract class WalkingAnimal {
    val hasLegs = true
    def walk(): Unit  // Here a method with a body like a abstract method in Java
  }

  // trait Element is like a interface in Java
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit  // valid method name
  }

  // inheritance is single and multi-trait (called mixing)
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I'm eating you, animal!")
    override def ?!(thought: String): Unit = println(s" I was thinking : $thought")
  }
  val croco = new Crocodile
  // the infix notation when an object method argument is only one
  println("Infix notation")
  croco eat animal
  croco ?! "What if we could fly?"

  // I was forgetting it this is called a anonymous class
  var dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur")
  }
  println("Example with a anonymous class")
  dinosaur.eat(animal)

  // curious in Scala operators are actually methods
  val basicAdd  = 1 + 1
  val basicAdd2 = 1.+(1)
  println(s"basicAdd2:  $basicAdd2")

  // singleton object
  object MySingleton {
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x + 1
  }
  println("Calling mySpecialMethod of MySingleton's object")
  MySingleton.mySpecialMethod()
  println("Calling apply method of MySingleton's object")
  println(MySingleton.apply(69))
  println(MySingleton(69)) // equivalent with the declaration above

  object Animal{ // Nothing related with the class above it's a companion object
    val canLiveIndefinitely = false
  }
  // You don't need to create a instance, it's more like a static object
  val animalsCanLiveForever = Animal.canLiveIndefinitely
  println(s"Variable Animal.canLiveIndefinitely $animalsCanLiveForever")


  /*
  Case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
   */

   case class Person(name: String, age: Int)
   val bob = Person("Bob", 54)

  // Exceptions are pretty similar to Java Exceptions

  try{
    val x: String = null
    x.length
  } catch {
    case e: RuntimeException => "Runtime Exception :("
  } finally{
    println("finally block")
  }

  // Working with generics

  abstract class MyList[T] {
    def head(): T
  }

  // Using a generic with a concrete type

  val list: List[Int] = List(1,2,3)
  val first = list.head
  val rest = list.tail

  println(s" $list  $first $rest")

  val stringList = List("hello", "world")
  val firstString = stringList.head

  // Important all data is immutable so when you assign again you
  // are creating another object
  val reverseList = stringList.reverse
  println(reverseList)
}
