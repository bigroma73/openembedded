PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name.patch;patch=1"

require gaim.inc
