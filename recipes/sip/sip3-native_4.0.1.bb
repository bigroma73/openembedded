DESCRIPTION = "SIP - A Python Wrapper Generator"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.vanille.de/mirror/sip-${PV}.tar.gz"
S = "${WORKDIR}/sip-${PV}/sipgen"

inherit qmake native

EXTRA_QMAKEVARS_POST += "DESTDIR=${STAGING_BINDIR} CONFIG=console"

do_configure_prepend() {
	cat sipgen.sbf | sed s,target,TARGET, | sed s,sources,SOURCES, | sed s,headers,HEADERS, > sipgen.pro
}

