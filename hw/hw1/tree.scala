import scala.math

trait Tree[+T]

trait NodeBase[T] extends Tree[T] {
  def value: T
  def name: String
  override def toString(): String = value.toString
}

def box(s:String) = {
  val width = s.size + 4
  val hor = "-" * width
  s"${hor}\n| $s |\n${hor}\n"
}

def prepend(s:String) = {
  s.split("\n").map(line => "   |   " + line).mkString("\n")
}

def centerWord(s: String, n: Int) = {
  val sn = s.size
  require(sn < n)
  val leftpad = (n - sn) / 2
  val rightpad = n - leftpad - sn
  " " * leftpad + s + " " * rightpad
}

def drawBranch(name:String, prob:Double) = {
  val lineWidth = math.max(prob.toString.size, name.size) + 4
  val nameLine = centerWord(name, lineWidth)
  val hline = "-" * lineWidth
  val probLine = centerWord(prob.toString, lineWidth)
  List(nameLine, hline, probLine).mkString("\n")
}

def verticalPad(s: String, above: Int, below:Int) = {
  "\n" * above + s + "\n" * below 
}

case class End[T](value:T, name:String, prob:Double) extends NodeBase[T]
case class Decision[T](value:T, name:String, prob:Double, children: Tree[T]*) extends NodeBase[T] {
  override def toString(): String = {
    val posterity = children.size match {
      case 0 => ""
      case _ => prepend(children.map(_.toString).mkString("\n"))
    }

    if (prob >= 0 && name.size > 0) {
      drawBranch(name, prob) + box(value.toString) + posterity
    } else {
      box(value.toString) + posterity
    }
  }

}
case class Chance[T](value:T, name:String, prob:Double, children: Tree[T]*) extends NodeBase[T]

val c = Chance("", "", 1.0, End("", "", 1.0))
val e = End(99.9, "", 1.0)
println(e)

val r = Decision(100, "", -1.0, Decision(100, "Groot", 1.0, Decision(100, "Bla", 1.0), End(99.9, "", 1.0)), End(99.8, "", .99))
println(r)


