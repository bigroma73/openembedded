DESCRIPTION = "create Dreambox NAND boot images"
SECTION = "console/utils"
LICENSE = "GPL"

PV="1.2"
SRC_URI = "git://git.opendreambox.org/git/buildimage.git;protocol=git"

SRCREV = "ceb57b73c8025f4caaf0a5ff2294d6c611466b6d"
SRCREV_dm7020hd = "81d4aac6316d2d8c43a1d34d2f8e04a6c5f51e9d"
S = "${WORKDIR}/git"

inherit autotools native

