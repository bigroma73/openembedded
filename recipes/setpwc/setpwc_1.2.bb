DESCRIPTION = "Set various aspects of Philips (and compatible) WebCams."
SECTION = "console"
PRIORITY = "optional"
HOMEPAGE = "http://www.vanheusden.com/setpwc/"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.vanheusden.com/setpwc/setpwc-${PV}.tgz"

TARGET_CC_ARCH += " ${LDFLAGS}"

inherit autotools

INHIBIT_AUTO_STAGE = "1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/setpwc ${D}${bindir}/setpwc
}
