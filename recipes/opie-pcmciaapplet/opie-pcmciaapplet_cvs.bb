require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/applets/pcmcia \
	   ${HANDHELDS_CVS};module=opie/pics"
