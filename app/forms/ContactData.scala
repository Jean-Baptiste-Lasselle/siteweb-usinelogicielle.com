package forms

import play.api.data.Form
import play.api.data.Forms._

case class ContactData(email: String, text: String)

object ContactData {
  def form: Form[ContactData] = Form {
    mapping(
      "email" -> email,
      "text" -> nonEmptyText
    )(ContactData.apply)(ContactData.unapply)
  }
}

