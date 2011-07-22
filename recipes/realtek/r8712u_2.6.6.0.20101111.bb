DESCRIPTION = "driver for Realtek USB wireless devices"
HOMEPAGE = "http://www.realtek.com/"
LICENSE = "GPLv2"

SRC_URI = " \
        http://dreamboxupdate.com/download/sources/rtl8712_8188_8191_8192SU_usb_linux_v${PV}.tar.gz \
        file://strcasecmp.patch;patch=1 \
        file://config \
"

S = "${WORKDIR}/rtl8712_8188_8191_8192SU_usb_linux_v${PV}"

inherit module siteinfo

PR = "r0"

do_configure() {
        install -m 644 ${WORKDIR}/config ${S}
}
do_install() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake -C ${STAGING_KERNEL_DIR} M=${S} DEPMOD=echo INSTALL_MOD_PATH="${D}" ${MODULE_MAKE_FLAGS} modules_install
}

MODULE_MAKE_FLAGS += " \
        EXTRA_CFLAGS=-DCONFIG_${@base_conditional('SITEINFO_ENDIANESS', 'le', 'LITTLE', 'BIG', d)}_ENDIAN \
        ARCH=${ARCH} \
        CROSS_COMPILE=${TARGET_PREFIX} \
        KVER=${KERNEL_VERSION} \
        KSRC=${STAGING_KERNEL_DIR} \
"
