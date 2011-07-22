DESCRIPTION = "ZIQ"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Bill Wetter"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-ZIQ.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/ziq_V1.1ern.tar.gz \
           file://ziq.patch;patch=1"

PV = "1.1ern"
PR = "r1"
S = "${WORKDIR}/ziq_V${PV}"


APPNAME = "ziq"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_install () {
	install -d ${D}${palmtopdir}/apps/Games/
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -d ${D}${palmtopdir}/apps/Games
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie
