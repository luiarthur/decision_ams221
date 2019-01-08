.PHONY: purge clean build all

FNAME = notes01

all: build

build:
	R --slave -e "rmarkdown::render('$(FNAME).Rmd')"
	rm -f *.html
	# mv $(FNAME).md README.md

clean:
	rm -f *.html *.md
	rm -rf $(FNAME)_files
