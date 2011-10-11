DESCRIPTION = "Open implementation of the AACS specification"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
DEPENDS = "libgcrypt"
PV = "0.0.0+${PR}+gitr${SRCREV}"

SRC_URI = "git://git.videolan.org/${PN}.git;branch=master;protocol=git"

SRCREV = "00b2df2bb7598262da44683509b50a7a983026fd"
S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

do_stage() {
        autotools_stage_all
}
