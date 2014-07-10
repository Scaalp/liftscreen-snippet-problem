package code.snippet

import net.liftweb.common.Logger
import net.liftweb.util.Helpers._
import scala.xml.NodeSeq
import net.liftweb.http.{RequestVar, S}


class ShowInfo extends Logger {

  def name = ".name" #> ("the value of parameter t is lost :( : " +
    S.param("t").flatMap(asLong(_)).toString)

  def show(xhtml: NodeSeq): NodeSeq = {
    info("req hash = " + (S.request.map(_.hashCode())))
    info("Value of t = " + (S.param("t").flatMap(asLong(_))))

    // I need the value of the parameter t here, to create the value
    // of the following variable 'page' from a database.

    val page = Seq(
        ("author1", "date1"),
        ("author2", "date2"),
        ("author3", "date3")
      )
      page.flatMap { p =>
        (  ".author" #> p._1 &
           ".date" #> p._2
        ).apply(xhtml)
      }
  }
}
