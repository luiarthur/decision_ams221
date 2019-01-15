import org.scalatest.FunSuite

class TestSuite extends FunSuite {
  import Tree.TreeStuff._

  test("doctor") {
    val die = End(20, "die", 0.8)
    val live = End(70, "live", 0.2)
    val notTreat = Node(30, "not treat", -1, die, live)

    val noEffect = Node(30, "no effect", .5, die, live)
    val cure = End(70, "cure", .5)
    val type1 = Node(30, "Type I", .4, noEffect, cure)
    val type2 = Node(30, "Type II", .6, die, live)
    val surviveDrug = Node(38, "survive drug", .8, type1, type2)
    val dieDrug = End(20, "die", .2)
    val drug = Node(34.4, "Drug", -1, die, surviveDrug)

    val noEffectT1 = Node(30, "no effect", .2, die, live)
    val cureT1 = End(70, "cure", .8)
    val noEffectT2 = Node(30, "no effect", .6, die, live)
    val cureT2 = End(70, "cure", .4)
    val type1Op = Node(62, "Type I", .4, noEffectT1, cureT1)
    val type2Op = Node(46, "Type II", .6, noEffectT2, cureT2)
    val surviveOp = Node(52.4, "survive operation", .5, type1Op, type2Op)
    val dieOp = End(20, "die", .5)
    val operate = Node(36.2, "Operate", -1, dieOp, surviveOp)

    val root = Node(36.2, "", -1, notTreat, drug, operate)
    println(root)
  }
}
