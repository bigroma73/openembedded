require ${PN}.inc


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/apps/${APPNAME} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
