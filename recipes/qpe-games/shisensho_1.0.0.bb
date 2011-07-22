DESCRIPTION = "Shisensho"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Mario Weilguni"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Shisen-Sho.html"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/shisensho_V1.0.0.tar.gz \
           file://shisen.patch;patch=1"

PV = "1.0.0"
S = "${WORKDIR}/shisensho_V${PV}"

APPNAME = "shisensho"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_compile_prepend() {
	oe_runmake -C images
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}

inherit opie

