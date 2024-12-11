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
