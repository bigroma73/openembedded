DESCRIPTION = "Madplay is a command-line MPEG audio decoder and player"
SECTION = "console/multimedia"
DEPENDS = "libmad"
LICENSE = "GPL"
AUTHOR = "Robert Leslie <rob@mars.org>"
HOMEPAGE = "http://www.mars.org/home/rob/proj/mpeg/"

SRC_URI = "ftp://ftp.mars.org/pub/mpeg/${PN}-${PV}.tar.gz"

inherit autotools
ARM_INSTRUCTION_SET = "arm"

FILES_${PN} = "${bindir}/madplay"
