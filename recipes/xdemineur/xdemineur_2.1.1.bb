inherit gpe
LICENSE = "BSD-X"
PR = "r1"

DEPENDS = "virtual/libx11 libxpm"
SECTION = "gpe/games"
DESCRIPTION = "Mine-sweeper game for GPE."
PRIORITY = "optional"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	   file://Makefile"

do_configure_prepend() {
	mv ${WORKDIR}/Makefile ${S}/
}
