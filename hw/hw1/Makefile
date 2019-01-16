.PHONY: drawTrees build

AWS_BUCKET = s3://decision-theory/hw1/
JAR_FILE = Tree/target/scala-2.12/tree_2.12-0.1.0.jar

all: build

drawTrees: results/doctor.txt results/prunejuice.txt results/machine.txt

build: results/alui2_hw1.pdf

results/alui2_hw1.pdf: alui2_hw1.tex drawTrees 
	pdflatex --output-directory results/ alui2_hw1.tex 
	rm -f results/alui2_hw1.aux results/alui2_hw1.log

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

send:
	aws s3 sync results/ $(AWS_BUCKET)

retrive:
	aws s3 sync $(AWS_BUCKET) results/

