DESCRIPTION = "domica patch"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Pashaa <caplu@yandex.ru>"
DEPENDS = "ntp enigma2 nfs-utils bash nano ctorrent openvpn djmount ntfs-3g lsof ushare"
RDEPENDS = "enigma2"

PR = "r13"
SRCREV="${AUTOREV}"

SRC_URI="git://github.com/bigroma73/domica-files.git;protocol=git;branch=master" 

FILES_${PN} = "/"

S = "${WORKDIR}/git"

do_compile() {
}

do_configure() {
}

do_install() {
    install -d ${D}/usr
    install -d ${D}/etc/keys
    install -d ${D}/etc/tuxbox/config
    install -d ${D}/media/usb
    ln -s ../etc/keys ${D}/usr/keys
    cp -r ${S}/etc/* ${D}/etc/
    cp -r ${S}/usr/* ${D}/usr/
}

