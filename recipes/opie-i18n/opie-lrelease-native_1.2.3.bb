require ${PN}.inc

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/development/translation/opie-lrelease \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/development/translation/shared"
