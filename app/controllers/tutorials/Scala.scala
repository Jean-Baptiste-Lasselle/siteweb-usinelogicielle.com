package controllers.tutorials

import javax.inject.Inject

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.{ LogoutEvent, Silhouette }
import controllers.AssetsFinder
import org.webjars.play.WebJarsUtil
import play.api.i18n.{ I18nSupport, Lang, Langs, Messages, MessagesApi }
import play.api.mvc.{ AbstractController, Action, AnyContent, ControllerComponents }
import utils.auth.DefaultEnv
import controllers.pages
import models.widgets.course.summary.SummaryWidget
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
class Scala @Inject() (
  components: ControllerComponents,
  silhouette: Silhouette[DefaultEnv],
  langs: Langs,
  messagesApi: MessagesApi
)(
  implicit
  webJarsUtil: WebJarsUtil,
  assets: AssetsFinder
) extends AbstractController(components) with I18nSupport {

  implicit val lang: Lang = langs.availables.head

  val parts = List(
    ("Installer play framework", controllers.tutorials.routes.Scala.installPlay),
    ("Choisir une seed", controllers.tutorials.routes.Scala.installPlay),
    ("Connecter notre seed à une base de donnée", controllers.tutorials.routes.Scala.installPlay))

  def course: Action[AnyContent] = Action.async { implicit request =>
    val summary = SummaryWidget(parts, None)
    Future.successful(Ok(views.html.tutorials.course.course(summary)))
  }

  def installPlay: Action[AnyContent] = Action.async { implicit request =>
    val summary = SummaryWidget(parts, Some(0))
    Future.successful(Ok(views.html.tutorials.installPlay.installPlay(summary)))
  }

}
