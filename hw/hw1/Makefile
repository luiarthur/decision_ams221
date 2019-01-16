.PHONY: drawTrees build
JAR_FILE = Tree/target/scala-2.12/tree_2.12-0.1.0.jar

all: build

drawTrees: results/doctor.txt results/prunejuice.txt results/machine.txt

build: results/alui2.pdf

results/alui2.pdf: alui2.tex drawTrees 
	pdflatex --output-directory results/ alui2.tex 
	rm -f results/alui2.aux results/alui2.log

results/doctor.txt: doctor.scala jar
	scala -cp $(JAR_FILE) doctor.scala

results/prunejuice.txt: prunejuice.scala jar
	scala -cp $(JAR_FILE) prunejuice.scala

results/machine.txt: machine.scala jar
	scala -cp $(JAR_FILE) machine.scala

clean:
	rm -f results/*.*

jar: $(JAR_FILE)

$(JAR_FILE): Tree/src/main/scala/TreeStuff.scala
	cd Tree && sbt package
