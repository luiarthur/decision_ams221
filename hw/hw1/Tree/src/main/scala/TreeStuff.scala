package Tree

import scala.math

object TreeStuff {
  trait Tree {
    val value: Double 
    val name: String
    val prob: Double
    def isRoot: Boolean
    def isChanceNode: Boolean
    def isDecisionNode: Boolean
    def isEndNode: Boolean
    var parent: Any = 0
    var prepend: String = ""
    var postpend: String = ""
  }

  def indent(s:String, spaces:Int, numChildren:Int) = {
    val lines = s.split("\n")
    val lastLineToPipe = lines.map(_.take(2) == "--").zipWithIndex.filter(_._1).map(_._2).last + 1
    def pipe(n:Int) = n < lastLineToPipe
    def sym(n:Int) = if (pipe(n)) "|" else " "
    Vector.tabulate(lines.size)(n => " " * (spaces - 1) + sym(n) + lines(n)).mkString("\n")
  }

  case class Node(value:Double, name:String, prob:Double, children: Tree*) extends Tree {
    lazy val isRoot = prob < 0 && name.size == 0
    lazy val isEndNode = children.size == 0
    lazy val isChanceNode = !isEndNode && children.exists(_.prob > 0)
    lazy val isDecisionNode = isRoot || !isChanceNode
    parent = this
    children.foreach{
      _.parent = this
    }

    override def toString(): String = {
      val posterity = isEndNode match {
        case true => ""
        case false => children.map(_.toString).mkString("\n")
      }

      val note = if (0 < prob && prob < 1) s"$name ($prob)" else name

      var head = (isRoot, isChanceNode, isEndNode) match {
        // Root node
        case (true, _, _) => ""
        // End node
        case (_, _, true) => s"--$note--: "
        // Chance node
        case (_, true, _) => s"--$note--C: "
        // Decision node
        case (_, false, _) =>  s"--$note--D: "
      }
      head += prepend + value.toString + postpend

      val pT = parent.asInstanceOf[this.type]
      if (pT.isDecisionNode && !this.isRoot) {
        val siblings = pT.children
        val notBestBranch= siblings.map(_.value).max > value
        if (notBestBranch) {
          head = "--//" + head
        }
      }

      isEndNode match {
        case true => head + "\n"
        case _ => head + "\n" + indent(posterity, head.size, children.size) + "\n"
      }
    }
  }

  object Node {
    def apply(value:Double, children: Tree*) = {
      new Node(value, "", -1, children:_*)
    }

    def apply(value:Double, name:String, children: Tree*) = {
      new Node(value, name, -1, children:_*)
    }

    def apply(value:Double, name:String, prob:Double, prepend:String, postpend:String,
              children: Tree*) = {
      val n = new Node(value, name, prob, children:_*)
      n.prepend = prepend
      n.postpend = postpend
      n
    }
  }
}


