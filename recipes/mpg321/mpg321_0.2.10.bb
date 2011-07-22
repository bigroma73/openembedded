DESCRIPTION = "mpg321 is a replacement for mpg123, a very popular command-line mp3 player."
SECTION = "console/multimedia"
DEPENDS = "libmad libao"
LICENSE = "GPL"
AUTHOR = "Joe Drew <hoserhead@woot.net>"
HOMEPAGE = "http://mpg321.sourceforge.net/"
RCONFLICTS_${PN} = "mpg123"
RREPLACES_${PN} = "mpg123"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mpg321/mpg321-0.2.10.tar.gz \
           file://libao.m4.patch;patch=1"

inherit autotools

EXTRA_OECONF="--with-ao-includes=${STAGING_INCDIR} --with-ao-libraries=${STAGING_LIBDIR}"
