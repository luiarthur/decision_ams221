import Tree.TreeStuff._
import java.io._

object Doctor extends App {
  val d1 = End("2M - 0 = 2M", "Market Prunejuice", -1)

  val d2 = Node("6.2M", "Market Pruneplus", -1,
    End("10M - 3M = 7M", "Successful R&D of Pruneplus", .9),
    End("2M - 3M = -1M", "Failed R&D of Pruneplus", .1))

  val d3 = Node("6.6M", "Market Superprune", -1, 
    End("18M - 5M = 13M", "Successful R&D of Superprune", .6),
    End("2M - 5M = -3M", "Failed R&D of Superprune", .4))

  val d4 = Node("6.48M", "Market Pruneplus & Superprune", -1,
    End("18M - 8M = 10M", "Successful R&D of Pruneplus & Superprune", .54),
    End("10M - 8M = 2",   "Successful R&D of Pruneplus but not Superprune", .36),
    End("18M - 8M = 10M", "Successful R&D of Superprune & Pruneplus", .06),
    End("10M - 8M = 2",   "Failed R&D of Pruneplus & Superprune", .04))

  val root = Node("6.6M", "", -1, d1, d2, d3, d4)
  //println(root)

  // Print results
  val pw = new PrintWriter(new File("results/prunejuice.txt" ))
  pw.write("Prune Juice: \n\n")
  pw.write(root.toString)
  pw.close()
}
