require ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/rotateapplet \
           ${HANDHELDS_CVS};module=opie/apps"
