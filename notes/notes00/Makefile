.PHONY: purge clean build

FNAME = notes00.Rmd

build:
	R --slave -e "rmarkdown::render('$(FNAME)')"
	rm *.html

clean:
	rm -f *.html *.md
	rm -rf rnb_files
