SECTION = "base"
DESCRIPTION = "Ethernet manufacturer database"
LICENSE = "PD"
SRCDATE = "${PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/etc"
S = "${WORKDIR}/etc"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 manufacturers ${D}${sysconfdir}/
}
