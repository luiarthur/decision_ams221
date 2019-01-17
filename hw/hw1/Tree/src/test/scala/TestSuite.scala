import org.scalatest.FunSuite

class TestSuite extends FunSuite {
  import Tree.TreeStuff._
  import java.io._

  test("end Node") {
    val end1 = Node(22, "hi")
    val end = Node(22, "hi", .9, "pop", "prp")
    val x = Node(999, "Bla", end)
    val d = Node(23, "Bla", x)
    val d2 = Node(32, "Bla", x)
    val a = Node(30, end1, d, d2)
    println(a)
  }

  test("doctor") {
    val die = Node(20, "die", 0.8)
    val live = Node(70, "live", 0.2)
    val notTreat = Node(30, "not treat", -1, die, live)

    val noEffect = Node(30, "no effect", .5, die, live)
    val cure = Node(70, "cure", .5)
    val type1 = Node(50, "Type I", .4, noEffect, cure)
    val type2 = Node(30, "Type II", .6, die, live)
    val surviveDrug = Node(38, "survive drug", .8, type1, type2)
    val dieDrug = Node(20, "die", .2)
    val drug = Node(34.4, "Drug", -1, dieDrug, surviveDrug)

    val noEffectT1 = Node(30, "no effect", .2, die, live)
    val cureT1 = Node(70, "cure", .8)
    val noEffectT2 = Node(30, "no effect", .6, die, live)
    val cureT2 = Node(70, "cure", .4)
    val type1Op = Node(62, "Type I", .4, noEffectT1, cureT1)
    val type2Op = Node(46, "Type II", .6, noEffectT2, cureT2)
    val surviveOp = Node(52.4, "survive operation", .5, type1Op, type2Op)
    val dieOp = Node(20, "die", .5)
    val operate = Node(36.2, "Operate", -1, dieOp, surviveOp)

    val root = Node(36.2, "", -1, notTreat, drug, operate)
    println(root)

    // Print results
    val pw = new PrintWriter(new File("../results/doctor.txt" ))
    pw.write(root.toString)
    pw.close
  }

  test("R&D") {
    val d1 = Node(2, "Market Prunejuice")

    val d2 = Node(6.2, "Market Pruneplus",
      Node(7, "Successful R&D of Pruneplus", .9),
      Node(-1, "Failed R&D of Pruneplus", .1))

    val d3 = Node(6.6, "Market Superprune", 
      Node(13, "Successful R&D of Superprune", .6),
      Node(-3, "Failed R&D of Superprune", .4))

    val d4 = Node(6.48, "Market Pruneplus & Superprune",
      Node(10, "Successful R&D of Pruneplus & Superprune", .54, "", "M"),
      Node(2,   "Successful R&D of Pruneplus but not Superprune", .36, "", "M"),
      Node(10, "Successful R&D of Superprune & Pruneplus", .06, "", "M"),
      Node(2,   "Failed R&D of Pruneplus & Superprune", .04, "", "M"))

    val root = Node(6.6, d1, d2, d3, d4)
    println(root)
  }

}
