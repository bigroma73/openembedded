inherit gpe pkgconfig

PR = "r1"

DESCRIPTION = "GPE wireless LAN communication applet"
DEPENDS = "gtk+ libgpewidget prismstumbler"
RDEPENDS = "prismstumbler"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI += "file://iconlist.patch;patch=1;pnum=0 \
	    file://fix_makefile.patch;patch=1"
