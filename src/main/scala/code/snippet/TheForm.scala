package code.snippet

import net.liftweb.common.Logger
import net.liftweb.http.RequestVar
import net.liftweb.http.S
import net.liftweb.util.Helpers._
import net.liftweb.http.LiftScreen

class TheForm extends LiftScreen with Logger {

  private val param = S.param("t").flatMap(asLong(_))
  if (param.isEmpty) S.redirectTo("/index")
  private val tid = param.openOrThrowException("Not empty, see above")

  // Here the value of parameter t is ok.
  info("Value of t = " + (S.param("t").flatMap(asLong(_))))

  private val text = textarea(
      "Enter some unused text",
      "",
      10,
      100)


  def finish() {
    info("in finish")
    redirectTo("/index")
  }
}

object TheForm extends Logger {
}
