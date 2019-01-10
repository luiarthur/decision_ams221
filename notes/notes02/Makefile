.PHONY: clean preview all githubify

FNAME = notes02

all: preview

preview:
	#R --slave -e "rmarkdown::render('$(FNAME).Rmd')"
	R --slave -e "rmarkdown::render('$(FNAME).Rmd', rmarkdown::pdf_document())"
	rm -f *.html
	# mv $(FNAME).md README.md

clean:
	rm -f *.html *.md *.pdf
	rm -rf $(FNAME)_files

githubify:
	time R --slave -e "rmarkdown::render('$(FNAME).Rmd', rmarkdown::github_document(pandoc_args='--webtex'))"
	rm -f *.html
	mv $(FNAME).md README.md

