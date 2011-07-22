DESCRIPTION = "Enchant Spell checker API Library"
PRIORITY    = "optional"
SECTION = "libs"

DEPENDS     = "aspell"
RDEPENDS    = "aspell"

inherit autotools pkgconfig

PR = "r0"

S = "${WORKDIR}/enchant-${PV}"

SRC_URI = "http://download.sourceforge.net/abiword/enchant-1.1.3.tar.gz"

do_stage() {
	oe_runmake install prefix=${STAGING_DIR_HOST}${layout_prefix} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DIR_HOST}${layout_mandir}
}
