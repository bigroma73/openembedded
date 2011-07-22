HOMEPAGE = "http://tapioca-voip.sourceforge.net/wiki/index.php/Tapioca"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 dbus gconf tapioca-xmpp tapioca farsight gst-plugins-farsight"
RDEPENDS = "tapioca-xmpp"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/dbus*"
