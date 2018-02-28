package controllers.pages

import javax.inject.Inject

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.{ LogoutEvent, Silhouette }
import controllers.AssetsFinder
import org.webjars.play.WebJarsUtil
import play.api.i18n.{ Lang, Langs, I18nSupport, Messages, MessagesApi }
import play.api.mvc.{ Action, AbstractController, AnyContent, ControllerComponents }
import utils.auth.DefaultEnv
import controllers.pages

import scala.concurrent.Future

/**
 * The basic application controller.
 *
 * @param components  The Play controller components.
 * @param silhouette  The Silhouette stack.
 * @param webJarsUtil The webjar util.
 * @param assets      The Play assets finder.
 */
class ApplicationController @Inject() (
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

  /**
   * Handles the index action.
   *
   * @return The result to display.
   */
  def index: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(views.html.home.home()))
  }
  //  def index = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
  //    Future.successful(Ok(views.html.home_(request.identity)))
  //  }

  /**
   * Handles the Sign Out action.
   *
   * @return The result to display.
   */
  def signOut = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val result = Redirect(pages.routes.ApplicationController.index())
    silhouette.env.eventBus.publish(LogoutEvent(request.identity, request))
    silhouette.env.authenticatorService.discard(request.authenticator, result)
  }
}

