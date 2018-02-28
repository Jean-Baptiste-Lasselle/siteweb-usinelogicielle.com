package controllers.pages

import javax.inject.Inject

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.{ LogoutEvent, Silhouette }
import controllers.AssetsFinder
import forms.ContactData
import org.webjars.play.WebJarsUtil
import play.api.i18n.{ Lang, Langs, I18nSupport, Messages, MessagesApi }
import play.api.mvc.{ Action, AbstractController, AnyContent, ControllerComponents }
import play.api.libs.mailer.{ Email, MailerClient }
import utils.auth.DefaultEnv
import controllers.pages
import play.api.i18n.Lang

import scala.concurrent.Future

/**
 * The basic application controller.
 *
 * @param components  The Play controller components.
 * @param silhouette  The Silhouette stack.
 * @param webJarsUtil The webjar util.
 * @param assets      The Play assets finder.
 */
class Contact @Inject() (
  components: ControllerComponents,
  silhouette: Silhouette[DefaultEnv],
  mailerClient: MailerClient,
  langs: Langs,
  messagesApi: MessagesApi
)(
  implicit
  webJarsUtil: WebJarsUtil,
  assets: AssetsFinder
) extends AbstractController(components) with I18nSupport {

  implicit val lang: Lang = langs.availables.head

  def view: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(views.html.contactUs.contactUs(ContactData.form)))
  }

  /**
   * Action to send a email to the company, Form: ContactData.form
   *
   * @return
   */
  def submit = Action { implicit request =>
    ContactData.form.bindFromRequest.fold(
      errorForm => {
        BadRequest(views.html.contactUs.contactUs(errorForm))
      },
      contactData => {
        val email_to_lauriane = Email(
          "Simple email",
          "Square it FROM <" + contactData.email + ">",
          Seq("Miss TO <mollierlauriane@gmail.com>"),
          bodyText = Some("From:" + contactData.email + " \n \n " + contactData.text)
        )
        mailerClient.send(email_to_lauriane)

        val email_to_jb = Email(
          "Test Email",
          "Square it FROM <" + contactData.email + ">",
          Seq("Miss TO <jean.baptiste.lasselle@gmail.com>"),
          bodyText = Some("From:" + contactData.email + " \n \n " + contactData.text)
        )
        mailerClient.send(email_to_jb)

        Redirect(pages.routes.Contact.view()).flashing(
          "emailSend" -> "Email send"
        )
      }
    )
  }
}
