# TODO: port to sdl.bbclass?
DESCRIPTION = "3D arcade space shooter"
HOMEPAGE = "http://www.realtech-vr.com/nogravity/"
LICENSE = "GPL"
SECTION = "x11/games"
DEPENDS = "libsdl-x11 zlib libpng libsdl-mixer libogg libvorbis"
PR = "r1"

SRC_URI = "http://zaurus.vivaphp.net/nogravity.tar.bz2 \
	   ${SOURCEFORGE_MIRROR}/nogravity/rt-nogravity-data.zip"

S = "${WORKDIR}/${PN}/src/Linux/"
PACKAGES += "${PN}-data"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-sound=sdl_mixer  --disable-opengl"

FILES_${PN} += "/usr/games/nogravity/no*"
FILES_${PN}-data = "/usr/games/nogravity/*.RMX"
PACKAGE_ARCH_${PN}-data = "all"
RRECOMMENDS+${PN} = "${PN}-data"

do_install_prepend() {
	install -d  ${D}/usr/games/nogravity/
	install -m 644 ${WORKDIR}/*.RMX ${D}/usr/games/nogravity/
}


