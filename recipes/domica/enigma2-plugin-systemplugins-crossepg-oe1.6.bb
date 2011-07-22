DESCRIPTION = "Read OpenTV epg from sat or import from xmltv or csv"
HOMEPAGE = http://www.crossepg.com
DEPENDS = "libxml2 zlib python"
LICENSE = "GPLv2"

REV ="305"
PR = "r0"
PN = "enigma2-plugin-systemplugins-crossepg"
PV = "0.6.2-svn-${REV}"

SRC_URI = "svn://crossepg.googlecode.com/svn;module=trunk;proto=https;rev=${REV}"

S = "${WORKDIR}/trunk"

FILES_${PN} = "/usr/*"

CFLAGS_append = " -I${STAGING_INCDIR}/libxml2/ -I${STAGING_INCDIR}/python2.6/"

do_compile() {
	oe_runmake SWIG="swig"
}

do_install() {
	oe_runmake 'D=${D}' install
}
