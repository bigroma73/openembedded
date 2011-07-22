DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
DEPENDS = "libmatchbox startup-notification"
SECTION = "x11/wm"
PV = "0.9.1+svn${SRCDATE}"
DEFAULT_PREFERENCE = "-1"

PR = "r1"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http"

EXTRA_OECONF = "--enable-startup-notification --enable-dnotify"

S = "${WORKDIR}/${PN}"

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

