require ${PN}.inc


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/screenshotapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps                          \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics "
