DESCRIPTION = "Library to access Blu-Ray disks"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
PV = "0.0.0+${PR}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "git://git.videolan.org/${PN}.git;branch=master;protocol=git"

SRCREV = "8e5d241ea1ebb131941c3279b2363d4eb2479eca"
S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

do_stage() {
        autotools_stage_all
}
