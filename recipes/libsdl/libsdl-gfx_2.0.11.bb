DESCRIPTION = "Simple DirectMedia Layer graphic primitives library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib libpng jpeg virtual/libsdl"
LICENSE = "LGPL"

SRC_URI = "http://www.ferzkopp.net/~aschiffler/Software/SDL_gfx-2.0/SDL_gfx-${PV}.tar.gz"
S = "${WORKDIR}/SDL_gfx-${PV}"

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF = "--disable-mmx"

do_stage() {
	oe_libinstall -so libSDL_gfx ${STAGING_LIBDIR}
	install -m 0644 *.h ${STAGING_INCDIR}/SDL/
}

