DEPENDS = "adns ncurses virtual/libx11"
SECTION = "x11/games"
LICENSE = "LGPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/bzflag/bzflag-${PV}.tar.bz2"
S = "${WORKDIR}/bzflag-${PV}"

inherit autotools

EXTRA_OECONF = "--enable-bzadmin \
		--enable-client"
