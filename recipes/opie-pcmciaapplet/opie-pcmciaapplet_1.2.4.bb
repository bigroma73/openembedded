require ${PN}.inc

PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/applets/pcmcia \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
