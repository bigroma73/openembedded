DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opieplayer2"
RPROVIDES = "opie-mediaplayer2-skin"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/pics"

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/techno/*.png"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/techno/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/techno/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/techno/
}
