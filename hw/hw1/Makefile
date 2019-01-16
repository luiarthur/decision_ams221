.PHONY: drawTrees

drawTrees: results/doctor.txt results/prunejuice.txt results/machine.txt

results/doctor.txt: doctor.scala
	scala -cp tree_2.12-0.1.0.jar doctor.scala

results/prunejuice.txt: prunejuice.scala
	scala -cp tree_2.12-0.1.0.jar prunejuice.scala

results/machine.txt: machine.scala
	scala -cp tree_2.12-0.1.0.jar machine.scala

clean:
	rm -f results/*.txt

bind:
	pdftk results/*.pdf cat output results/merged.pdf
