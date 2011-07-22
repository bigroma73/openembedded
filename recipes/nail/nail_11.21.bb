DESCRIPTION = "Enhanced mailx client."
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "openssl"
PR = "r2"
LICENSE = "GPL"

SRC_URI = "http://optusnet.dl.sourceforge.net/sourceforge/nail/nail-11.21.tar.bz2 \
	   file://nail.spec.diff;patch=1"

S = "${WORKDIR}/nail-11.21/"

inherit autotools

# EXTRA_OECONF = "ac_cv_func_setpgrp_void=yes"

INHIBIT_AUTO_STAGE = "1"

do_install() {
 	install -d ${D}${bindir} ${D}${mandir} ${D}${sysconfdir}
 	install -m 0755 ${S}nail ${D}${bindir}/nail
 	install -m 0644 ${S}nail.1 ${D}${mandir}/nail.1
 	install -m 0644 ${S}nail.rc ${D}${sysconfdir}/nail.rc
}

CONFFILES_${PN} = "${sysconfdir}/nail.rc"
