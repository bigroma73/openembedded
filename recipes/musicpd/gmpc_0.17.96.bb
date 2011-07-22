DESCRIPTION = "GTK+ Frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/gmpc.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "curl libsexy gob2-native gob2 libmpd gtk+ libglade gnome-vfs"
PR = "r0"

inherit gnome

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/gmpc-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

do_configure() {
	sed -i -e s:'head -1':'head -n1':g configure
    gnu-configize
	oe_runconf
}

FILES_${PN} += "${datadir}/icons"


