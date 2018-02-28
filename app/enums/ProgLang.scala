package enums

case class ProgLang(name: String)

// see:  https://highlightjs.org/
object ProgLang {
  val scala = new ProgLang("scala")
  val bash = new ProgLang("bash")
}

