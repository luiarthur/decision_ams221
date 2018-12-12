.PHONY: purge clean build all

FNAME = notes00.Rmd

all: build

build:
	R --slave -e "rmarkdown::render('$(FNAME)')"
	rm *.html
	mv *.md README.md

clean:
	rm -f *.html *.md
	rm -rf *_files
