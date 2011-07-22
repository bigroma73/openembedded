DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"
PR = "r3"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-desktop/0.9/matchbox-desktop-${PV}.tar.bz2 \
           file://pkgconfig_fix.patch;patch=1 \
           file://mb-desktop-multi-category-matching.patch;patch=1"

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"

inherit autotools pkgconfig

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${libdir}/matchbox/desktop/*.so \
	       ${datadir}/matchbox-desktop \
	       ${datadir}/pixmaps \
	       ${sysconfdir}/matchbox"

FILES_${PN}-dev += "${libdir}/matchbox-desktop \
		   ${includedir}/matchbox-desktop \
		   ${libdir}/matchbox/desktop/*.*a \
		   ${datadir}/matchbox/desktop/modules/*a"

FILES_${PN}-dbg += "${libdir}/matchbox/desktop/.debug/"


do_stage() {
		install -d ${STAGING_INCDIR}/matchbox-desktop/
		install -m 0644 ${S}/src/*.h ${STAGING_INCDIR}/matchbox-desktop/

}
