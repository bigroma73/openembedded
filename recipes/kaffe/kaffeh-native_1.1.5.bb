SRC_URI = "http://www.kaffe.org/ftp/pub/kaffe/v1.1.x-development/kaffe-${PV}.tar.gz"
S = "${WORKDIR}/kaffe-${PV}"
PR = "r3"

require kaffe.inc

RDEPENDS_${PN} = ""

inherit native

EXTRA_OECONF = "--disable-alsatest \
	--disable-esdtest \
	--disable-sound \
	--with-jikes \
	--without-classpath-gtk-awt \
	--without-gmp \
	--enable-pure-java-math \
	--disable-native-awt \
	--disable-sound \
	--without-x \
	--without-kaffe-x-awt \
	--disable-debug \
	--disable-gcj"

do_stage() {
	install -m 0755 kaffe/kaffeh/kaffeh ${STAGING_BINDIR}/

	install -d ${STAGING_DATADIR}/kaffeh
	install -m 0755 libraries/javalib/*.jar ${STAGING_DATADIR}/kaffeh/
}
