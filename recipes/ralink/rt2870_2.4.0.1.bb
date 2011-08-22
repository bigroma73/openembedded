DESCRIPTION = "Ralink 2870"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
PR = "r1"

inherit module

SRC_URI = "http://www.upload.metabox.ru/dm800/source/2010_0709_RT2870_Linux_STA_v2.4.0.1.tar.bz2 \
           file://rt2870sta-2.4.0.1-config.patch;patch=1 \
	   file://rt2870sta-2.4.0.1-convert-devicename-to-wlanX.diff;patch=0 \
	   file://rt2870sta-2.4.0.1-remove_duplicate_device_ID.patch;patch=0 \
	   file://rt2870sta-2.4.0.1-WPA-mixed.patch;patch=0 \
	 "

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

S = "${WORKDIR}/2010_0709_RT2870_Linux_STA_v2.4.0.1"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/os/linux/rt2870sta.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -d ${D}/etc/Wireless/RT2870STA
	install -m 0644 ${S}/RT2870STA.dat ${D}/etc/Wireless/RT2870STA
}
