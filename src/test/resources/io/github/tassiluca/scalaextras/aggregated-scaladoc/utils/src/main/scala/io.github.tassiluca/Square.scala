package io.github.tassiluca

/** A square class that takes a side and calculates the area and perimeter
  * @param side the side of the square
  */
case class Square(side: Double):
  /** Calculates the area of the square
    * @return the area of the square
    */
  def area: Double = side * side

  /** Calculates the perimeter of the square
    * @return the perimeter of the square
    */
  def perimeter: Double = 4 * side

object Square:
  import com.google.gson.{Gson, GsonBuilder}
  private val gson: Gson = new GsonBuilder().create()

  /** Serializes a Square object to a JSON string
    * @param square the Square object to serialize
    * @return JSON representation of the Square
    */
  def toJson(square: Square): String = gson.toJson(square)

  /** Deserializes a JSON string to a Square object
    * @param json the JSON string representing a Square
    * @return the Square object created from the JSON string
    */
  def fromJson(json: String): Square = gson.fromJson(json, classOf[Square])
