require ${PN}.inc

PR = r3

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/irdaapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/sounds \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	  "
