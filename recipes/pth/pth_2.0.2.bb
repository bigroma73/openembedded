DESCRIPTION = "GNU Portable Threads"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL FDL"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/pth/pth-${PV}.tar.gz \
	   file://m4-warning.patch;patch=1 \
	   file://ldflags.patch;patch=1 \
	  "

PARALLEL_MAKE=""

inherit autotools

do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
	oe_libinstall -so libpth ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/
	for X in pth.h
	do
		install -m 0644 ${S}/$X ${STAGING_INCDIR}/$X
	done

	install -d ${STAGING_DATADIR}/aclocal
	install pth.m4 ${STAGING_DATADIR}/aclocal/
}
