DESCRIPTION = "The sdparm utility accesses SCSI device parameters"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://sg.danny.cz/sg/p/sdparm-${PV}.tgz"

inherit autotools
