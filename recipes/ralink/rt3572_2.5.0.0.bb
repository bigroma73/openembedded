DESCRIPTION = "Ralink 3572"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
PR = "r1"

inherit module

SRC_URI = "http://www.upload.metabox.ru/dm800/source/2010_1215_RT3572_Linux_STA_v2.5.0.0.DPO.tar.bz2 \ 
	   file://rt3572sta-2.5.0.0-config.patch;patch=1 \
	   file://rt3572sta-2.5.0.0-makefiles.patch;patch=1 \
	   file://rt3572sta-2.5.0.0-force-5Ghz.patch;patch=1 \
	   file://rt3572sta-2.5.0.0-WPA-mixed.patch;patch=1 \
	   file://rt3572sta-2.5.0.0-convert-devicename-to-wlanX.patch;patch=1 \
	   file://rt3572sta-2.5.0.0-extra_devices.patch;patch=1 \
	   file://rt3572sta-2.5.0.0-remove-potential-conflicts-with-rt2870sta.patch;patch=1 \
	   "

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

S = "${WORKDIR}/2010_1215_RT3572_Linux_STA_v${PV}.DPO"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/os/linux/rt3572sta.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -d ${D}/etc/Wireless/RT3572STA
	install -m 0644 ${S}/RT3572STA.dat ${D}/etc/Wireless/RT3572STA
}
