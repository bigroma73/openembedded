DESCRIPTION = "Mokoko - a simple media player"
HOMEPAGE = "http://code.google.com/p/om-mediaplayer/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "gstreamer"
RDEPENDS = "gstreamer"

PV = "0.1+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://om-mediaplayer.googlecode.com/svn/;module=trunk;proto=http"

S = "${WORKDIR}/trunk/mokoko"

inherit autotools

FILES_${PN} += "${prefix}/etc/*"
