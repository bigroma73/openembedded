DESCRIPTION = "Utility that enables basic Ethernet frame filtering on a Linux bridge, MAC NAT and brouting."
PRIORITY = "optional"
LICENSE = "GPL"
SECTION = "console/network"
PR = "r2"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "${SOURCEFORGE_MIRROR}/ebtables/ebtables-v${PV}.tar.gz \
           file://gcc34.patch;patch=1 \
           file://gcc4.patch;patch=1 \
           file://installnonroot.patch;patch=1 \
           file://installcreatedirs.patch;patch=1"
S = "${WORKDIR}/ebtables-v${PV}"

do_compile () {
	oe_runmake 'BINPATH=/sbin/' 'MANDIR=${mandir}/' \
		   'ETHERTYPESPATH=${sysconfdir}/' 'KERNEL_INCLUDES=${STAGING_INCDIR}'
}

do_install () {
	oe_runmake 'BINPATH=${D}${base_sbindir}/' 'MANDIR=${D}${mandir}/' \
		   'ETHERTYPESPATH=${D}${sysconfdir}/' install
}
