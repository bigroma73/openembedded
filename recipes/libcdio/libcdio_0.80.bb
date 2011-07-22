DESCRIPTION = "A library to encapsulate CD-ROM reading and control"
HOMEPAGE = "http://www.gnu.org/software/libcdio/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Andreas Frisch <andreas.frisch@multimedia-labs.de>"
PR="r1"
DEPENDS = "libcddb"

SRC_URI = "http://ftp.gnu.org/pub/gnu/libcdio/${PN}-${PV}.tar.gz\
	    file://${PN}-${PV}-configure-crosscompile.patch;patch=1\
	    file://${PN}-${PV}-minimal-new.patch;patch=1\
	    file://${PN}-${PV}-fix-pkgconfig.patch;patch=1\
	    file://${PN}-${PV}-add-cdtextinfo.patch;patch=1"

inherit pkgconfig autotools

EXTRA_OECONF="--enable-cddb --disable-cpp-progs --disable-vcd-info --disable-maintainer-mode --without-cd-paranoia --without-cdda-player --disable-cxx --disable-example-progs --disable-joliet --without-cd-drive --without-cd-read --without-iso-info --without-iso-read --without-cd-info"

DEPENDS = "libcddb virtual/libintl"

do_compile_append () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/src/.libs/cdtextinfo ${D}${bindir}
}

do_stage () {
	oe_libinstall -so -C lib libcdio ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/cdio
	install -m 0644  ${S}/include/cdio/*.h ${STAGING_INCDIR}/cdio
}
