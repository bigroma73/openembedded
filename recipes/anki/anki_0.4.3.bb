require anki.inc

RDEPENDS += "libanki"
PR = "r2"

export PV := "${PV}"

SRC_URI += "file://no-need-for-pyqt-at-buildtime.patch;patch=1"
S = "${WORKDIR}/anki-${PV}"
