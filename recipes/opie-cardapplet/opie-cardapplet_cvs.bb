require ${PN}.inc

PV = "${OPIE_CVS_PV}"

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/applets/cardapplet \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/sounds \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/etc"
