require ${PN}.inc
PR = "r1"

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/inputmethods/dasher \
           ${HANDHELDS_CVS};module=opie/share "
