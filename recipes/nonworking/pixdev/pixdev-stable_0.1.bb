DESCRIPTION = "Pixil Operating Environment"
SECTION = "gui"
PRIORITY = "optional"
DEPENDS = "microwindows"
RDEPENDS = "microwindows"

SRC_URI = "${SOURCEFORGE_MIRROR}/pixdev/pixdev-stable-${PV}.tar.gz \
          file://${FILESDIR}/braces.patch;patch=1"
export EXTRA_OEMAKE=

inherit autotools

do_compile() {
	if [ "${MACHINE}" = "ipaq" ]; then CONFIG=defconfig_ipaq; fi
	if [ "${MACHINE}" = "collie" ]; then CONFIG=defconfig_zaurus; fi

	if [ -z "$CONFIG" ]; then CONFIG=defconfig; fi

	oe_runmake $CONFIG
	oe_runmake MWDIR=${STAGING_DIR_TARGET} "TARGET_CROSS=${TARGET_PREFIX}" all
}

do_install() {
	install -d ${D}/${prefix}/pixil

	oe_runmake "TARGET_CROSS=${TARGET_PREFIX}" INSTALL_DIR=${D}/${prefix}/pixil \
	DEST_DIR=/${prefix}/pixil install
}
