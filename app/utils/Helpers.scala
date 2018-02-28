package utils

object Helpers {
  import views.html.helper.FieldConstructor
  implicit val myFields = FieldConstructor(utils.html.fieldConstructorTemplate.f)
}
