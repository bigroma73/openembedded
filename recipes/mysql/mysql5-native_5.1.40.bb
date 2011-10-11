require mysql5_${PV}.inc
inherit native
PR ="r2"

SRC_URI = "http://downloads.mysql.com/archives/mysql-5.1/mysql-${PV}.tar.gz \
           file://fix-abi-check-gcc45.patch;patch=1"

RDEPENDS_${PN} = ""
PACKAGES = ""
DEPENDS = "ncurses-native"
EXTRA_OEMAKE = ""
EXTRA_OECONF = " --with-embedded-server "

do_install() {
        oe_runmake 'DESTDIR=${D}' install
        mv -f ${D}${libdir}/mysql/* ${D}${libdir}
        rmdir ${D}${libdir}/mysql

        install -d ${D}${bindir}
        install -m 0755 sql/gen_lex_hash ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"

PSTAGING_DISABLED = "1"
