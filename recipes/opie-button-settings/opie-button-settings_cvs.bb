require ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/settings/button \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
