require ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/datebook \
           ${HANDHELDS_CVS};module=opie/apps"
