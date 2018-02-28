package enums

case class OS(name: String)

object OS {
  val ubuntu = new OS("ubuntu")
  val mac = new OS("mac")
}
