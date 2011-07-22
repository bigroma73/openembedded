LICENSE     = "LGPL"
PR          = "r0"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libxrender gtk-doc intltool-native sdk-default-icons"
PROVIDES    = "libgpewidget"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig

SRC_URI     = "${GPE_MIRROR}/libgpewidget-${PV}.tar.bz2"
S = "${WORKDIR}/libgpewidget-${PV}"

EXTRA_OECONF = "--enable-hildon"

do_stage () {
	oe_libinstall -C .libs -so libgpewidget ${STAGING_LIBDIR}
	autotools_stage_includes
}

RDEPENDS = "sdk-default-icons"
RPROVIDES = "libgpewidget"
