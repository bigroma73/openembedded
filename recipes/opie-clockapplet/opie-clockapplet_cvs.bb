require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/clockapplet \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
