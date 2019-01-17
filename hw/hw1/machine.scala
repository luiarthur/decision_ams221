import Tree.TreeStuff._
import java.io._
import math.{log, exp, pow, max}

object Doctor extends App {
  def roundAt(n: Double, p:Int): Double = {
   val s = math.pow(10, p)
   math.round(n * s) / s 
  }

  def logFactorial(n:Int, acc:Double=0):Double = n match {
    case 0 => acc
    case _ => logFactorial(n - 1, acc + log(n))
  }

  def logChoose(n:Int, x:Int): Double = {
    require(n >= x && x >= 0)
    logFactorial(n) - logFactorial(x) - logFactorial(n - x)
  }
  
  def logpdfBinomial(x:Int, n:Int, p:Double) = {
    require(x >= 0 && n >= x && p > 0 && p < 1)
    logChoose(n, x) + x * log(p) + (n - x) * log(1 - p)
  }

  def dbinom(x:Int, n:Int, p:Double) = {
    exp(logpdfBinomial(x, n, p))
  }

  def genNodes(scanners: Int,
               pFaulty: Double=.2,
               pAlarmGivenFaulty:Double=.9,
               pAlarmGivenNotFaulty:Double=.4,
               scanCost:Double=50) = {

    val n = scanners

    def pXAlarms(x:Int) = {
      dbinom(x, n, pAlarmGivenFaulty) * pFaulty + 
      dbinom(x, n, pAlarmGivenNotFaulty) * (1 - pFaulty)
    }

    def pFaultyGivenXAlarams(x:Int) = dbinom(x, n, pAlarmGivenFaulty) * pFaulty / pXAlarms(x)

    val payoff = Map(
      ("fix", "faulty") -> 700,
      ("fix", "not faulty") -> 800,
      ("not fix", "faulty") -> 0,
      ("not fix", "not faulty") -> 1000,
    ).mapValues(_ - scanCost * n)

    // Gen Leaf nodes
    val nodes = List.tabulate(scanners + 1){ x =>
      val pxn = pFaultyGivenXAlarams(x)
      val fixFaultyNode = Node(payoff("fix", "faulty"), "faulty", roundAt(pxn, 2))
      val fixNonfaultyNode = Node(payoff("fix", "not faulty"), "not faulty", roundAt(1 - pxn, 2))
      val notfixFaultyNode = Node(payoff("not fix", "faulty"), "faulty", roundAt(pxn, 2))
      val notfixNonfaultyNode = Node(payoff("not fix", "not faulty"), "not faulty", roundAt(1 - pxn, 2))
      val fixEV = roundAt(pxn * payoff("fix", "faulty") + (1 - pxn) * payoff("fix", "not faulty"), 2)
      val notfixEV = roundAt(pxn * payoff("not fix", "faulty") + (1 - pxn) * payoff("not fix", "not faulty"), 2)
      val fixNode = Node(fixEV, "fix" , -1, fixFaultyNode, fixNonfaultyNode)
      val notfixNode = Node(notfixEV, "not fix" , -1, notfixFaultyNode, notfixNonfaultyNode)
      val root = Node(max(fixEV, notfixEV), s"${x} / ${n} alarms", roundAt(pXAlarms(x), 2), fixNode, notfixNode)
      root
    }

    val ev = nodes.map(n => n.prob * n.value).sum

    (nodes, ev)
  }

  val fix = Node(780, "fix", .2, 
    Node(700, "faulty", .2),
    Node(800, "not faulty", .8))

  val notFix = Node(800, "not fix", .2, 
    Node(0, "faulty", .2),
    Node(1000, "not faulty", .8))

  val (nodes1, ev1) = genNodes(1)
  val oneScanner = Node(roundAt(ev1, 2), "one scanner", -1, nodes1:_*)

  val (nodes2, ev2) = genNodes(2)
  val twoScanners = Node(roundAt(ev2, 2), "two scanner", -1, nodes2:_*)

  val root = Node(List(ev1, ev2, 800, 780).max, "", -1, fix, notFix, oneScanner, twoScanners)

  // Print results
  val pw = new PrintWriter(new File("results/machine.txt" ))
  // pw.write("Machine: \n\n")
  pw.write(root.toString)
  pw.close()
}
