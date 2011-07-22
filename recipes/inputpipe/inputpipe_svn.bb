SECTION = "base"
PRIORITY = "optional"
DESCRIPTION = "Inputpipe is a network transparency layer for linux input devices"
LICENSE = "GPL"
#Remove the dash below when 0.5 changes in PV
PV = "0.5+svn-${SRCDATE}"
SRC_URI = "svn://svn.navi.cx/misc/trunk;module=inputpipe;proto=http"

S = "${WORKDIR}/inputpipe"

do_compile() {
	oe_runmake CC="${CC}" CFLAGS="-I ${WORKDIR}/inputpipe/uinput ${CFLAGS}"
}

do_install() {
        install -d ${D}${bindir}
	install	inputpipe-server ${D}${bindir}
	install	inputpipe-client ${D}${bindir}
}

PACKAGES = "${PN}-dbg inputpipe-server inputpipe-client ${PN}"

FILES_inputpipe-client = "${bindir}/inputpipe-client"
FILES_inputpipe-server = "${bindir}/inputpipe-server"
