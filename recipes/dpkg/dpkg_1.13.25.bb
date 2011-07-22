require dpkg.inc
PR = "r2"
DEPENDS += "zlib bzip2"
SRC_URI += "file://noman.patch;patch=1"

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-sgml-doc \
		PERL=/usr/bin/perl"
