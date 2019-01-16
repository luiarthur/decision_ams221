.PHONY: drawTrees build

all: build

drawTrees: results/doctor.txt results/prunejuice.txt results/machine.txt

build: results/alui2.pdf

results/alui2.pdf: alui2.tex drawTrees
	pdflatex --output-directory results/ alui2.tex 
	rm -f results/alui2.aux results/alui2.log

results/doctor.txt: doctor.scala
	scala -cp tree_2.12-0.1.0.jar doctor.scala

results/prunejuice.txt: prunejuice.scala
	scala -cp tree_2.12-0.1.0.jar prunejuice.scala

results/machine.txt: machine.scala
	scala -cp tree_2.12-0.1.0.jar machine.scala

clean:
	rm -f results/*.*

