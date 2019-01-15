package Tree

import scala.math

object TreeStuff {
  trait Tree[+T]

  trait NodeBase[T] extends Tree[T] {
    def value: T
    def name: String
    override def toString(): String = value.toString
  }


  def prepend(s:String, spaces:Int, numChildren:Int) = {
    val lines = s.split("\n")
    val lastLineToPipe = lines.map(_.take(3) == "---").zipWithIndex.filter(_._1).map(_._2).last + 1
    def pipe(n:Int) = n < lastLineToPipe
    def sym(n:Int) = if (pipe(n)) "|" else " "
    Vector.tabulate(lines.size)(n => " " * (spaces - 1) + sym(n) + lines(n)).mkString("\n")
  }


  case class End[T](value:T, name:String, prob:Double) extends NodeBase[T] {
    override def toString(): String = {
      s"--- $name ($prob) --- " + value.toString
    }
  }

  case class Node[T](value:T, name:String, prob:Double, children: Tree[T]*) extends NodeBase[T] {
    lazy val isRoot = prob < 0 && name.size == 0
    lazy val isChanceNode = prob >= 0

    override def toString(): String = {
      val posterity = children.size match {
        case 0 => ""
        case _ => "\n" + children.map(_.toString).mkString("\n\n")
      }

      val head = if (isRoot) {
        s"${value.toString}"
      } else {
        val p = if (isChanceNode) s"($prob) " else ""
        s"--- $name $p--- ${value.toString}"
      }
      head + "\n" + prepend(posterity, head.size, children.size) + "\n"
    }
  }
}


