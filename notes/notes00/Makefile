.PHONY: purge clean build all

FNAME = notes00.Rmd

all: build

build:
	R --slave -e "rmarkdown::render('$(FNAME)')"
	rm *.html

clean:
	rm -f *.html *.md
	rm -rf rnb_files
