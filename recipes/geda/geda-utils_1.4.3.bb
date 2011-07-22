DESCRIPTION = "gEDA/gaf's Utilities"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA"
PR = "r1"

DEPENDS = "libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig
