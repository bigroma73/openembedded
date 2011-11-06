DESCRIPTION = "Ralink 3070"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
PR = "r2"

inherit module

SRC_URI = "http://www.ralinktech.com.tw/data/drivers/2009_0525_RT3070_Linux_STA_v${PV}.tar.bz2 \
	   file://makefile.patch;patch=1 \
	   file://config.patch;patch=1 \
	   file://rt3070sta-2.1.1.0-mixed-WPA.patch;patch=1 \
	   file://rt3070sta-2.1.1.0-extra_devices.patch;patch=1 \
	   file://rt3070sta-2.1.1.0-convert-devicename-to-wlanX.patch;patch=1 \
	   file://rt3070sta-2.1.1.0-change-driver-name.patch;patch=1 \
	 "

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

S = "${WORKDIR}/2009_0525_RT3070_Linux_STA_v${PV}"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/os/linux/rt3070sta.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -d ${D}/etc/Wireless/RT3070STA
	install -m 0644 ${S}/RT2870STA.dat ${D}/etc/Wireless/RT3070STA/RT3070STA.dat
}
