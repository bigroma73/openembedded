SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/${P}.tar.gz"


LICENSE = "LGPL"
DEPENDS = "libopensync openobex bluez-libs"
RRECOMMENDS = "multisync"
HOMEPAGE = "http://www.opensync.org/"

inherit autotools pkgconfig

FILES_${PN} += "${datadir} ${libdir}"

do_install() {
install -d ${D}${datadir}/opensync/defaults
install -d ${D}${libdir}/opensync/plugins
install -m 644 src/irmc-sync ${D}${datadir}/opensync/defaults
install -m 755 src/.libs/irmc_sync.so ${D}${libdir}/opensync/plugins/
}
