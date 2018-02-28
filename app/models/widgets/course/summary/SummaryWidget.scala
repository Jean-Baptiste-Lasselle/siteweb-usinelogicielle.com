package models.widgets.course.summary

import play.api.mvc.Call

/**
 *
 * @param parts List[(String, Call) The list of the parts of the summary, composed by the tile and the link to this part
 * @param active Option[Int] The tab witch is active
 */
case class SummaryWidget(parts: List[(String, Call)], active: Option[Int])

