SECTION = "console/utils"
DESCRIPTION = 'The PCI Utilities package contains a library for portable access \
to PCI bus configuration space and several utilities based on this library.'
DESCRIPTION_pciutils-ids = 'The list of PCI IDs for pciutils'
HOMEPAGE = "http://atrey.karlin.mff.cuni.cz/~mj/pciutils.shtml"
LICENSE = "GPLv2"

PR ="r3"

PARALLEL_MAKE = ""
FILES_pciutils-ids="${prefix}/share/pci.ids"
PACKAGES =+ "pciutils-ids"
SRC_URI = "${KERNELORG_MIRROR}/pub/software/utils/pciutils/pciutils-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://configure-uclibc.patch;patch=1 \
	   file://pcimodules-pciutils-2.1.11.diff;patch=1"

do_configure () {
	(cd lib && ./configure ${datadir} ${PV} ${TARGET_OS} 2.4.21 ${TARGET_ARCH})
}

export PREFIX = "${D}${prefix}"
export SBINDIR = "${D}${sbindir}"
export SHAREDIR = "${D}${datadir}"
export MANDIR = "${D}${mandir}"

do_install () {
	oe_runmake install
}
do_install_append () {
	install -d ${D}/${prefix}/share
	install -m 6440 ${WORKDIR}/${PN}-${PV}/pci.ids ${D}/${prefix}/share
}

