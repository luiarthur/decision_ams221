import Tree.TreeStuff._
import java.io._

object Doctor extends App {
  val d1 = Node(2, "Market Prunejuice", -1, "", "M")

  val d2 = Node(6.2, "Market Pruneplus", -1, "", "M",
    Node(7, "Successful R&D of Pruneplus", .9, "", "M"),
    Node(-1, "Failed R&D of Pruneplus", .1, "", "M"))

  val d3 = Node(6.6, "Market Superprune", -1, "", "M", 
    Node(13, "Successful R&D of Superprune", .6, "", "M"),
    Node(-3, "Failed R&D of Superprune", .4, "", "M"))

  val d4 = Node(6.48, "Market Pruneplus & Superprune", -1, "", "M",
    Node(10, "Successful R&D of Pruneplus & Superprune", .54, "", "M"),
    Node(2,   "Successful R&D of Pruneplus but not Superprune", .36, "", "M"),
    Node(10, "Successful R&D of Superprune & Pruneplus", .06, "", "M"),
    Node(-6,   "Failed R&D of Pruneplus & Superprune", .04, "", "M"))

  val root = Node(6.6, "", -1, "", "M", d1, d2, d3, d4)

  // Print results
  val pw = new PrintWriter(new File("results/prunejuice.txt" ))
  // pw.write("Prune Juice: \n\n")
  pw.write(root.toString)
  pw.close()
}
