package io.github.tassiluca

import com.google.gson.{Gson, GsonBuilder}
import io.github.tassiluca.Square.{fromJson, toJson}

/** A simple object using square utils. */
object Launcher:
  def main(args: Array[String]): Unit =
    val gson: Gson = new GsonBuilder().create()
    val personMap = Map("name" -> "Alice", "age" -> 25)
    val personJson = gson.toJson(personMap)
    println(personJson)
    val s = Square(5)
    println(s.side)
    println(s.perimeter)
    val ser = toJson(s)
    println(ser)
    val deser = fromJson(ser)
    println(deser)
