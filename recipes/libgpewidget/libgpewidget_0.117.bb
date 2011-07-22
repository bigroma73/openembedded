LICENSE     = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ cairo libxinerama libxcomposite libxrender gtk-doc"
PR          = "r0"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe pkgconfig autotools

SRC_URI += "file://pkgconfig.patch;patch=1;pnum=0"

PACKAGES =+ "libgpewidget-bin"
FILES_libgpewidget-bin = "${bindir}/*"

EXTRA_OECONF = "--enable-cairo"

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}
