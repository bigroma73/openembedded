DESCRIPTION = "Driver for Ralink RT8070/RT3070/RT3370 USB 802.11abgn WiFi sticks"
SECTION = "kernel/modules"
LICENSE = "GPL"
SRCNAME = "rt3070"

inherit module

PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/sources/2011_0107_RT3070_RT3370_Linux_STA_v${PV}_DPO.tar.gz;name=tarball \
	          file://makefile_2.5.0.1.patch;patch=1 \
	          file://config_2.5.0.1.patch;patch=1"

SRC_URI[tarball.md5sum] = "e2d8fc593351c1d79af09f2b51aa046d"
SRC_URI[tarball.sha256sum] = "e1024ef0c0d2ae5f87cf955d57b13f428f4f43ed5bd9d12a9bdb135fa372af24"

FILES_${PN} += " /lib/firmware/rt2870.bin"

S = "${WORKDIR}/2011_0107_RT3070_RT3370_Linux_STA_v${PV}_DPO"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless
	install -d ${D}${sysconfdir}/Wireless/RT2870STA
	install -m 0644 ${S}/${PN}sta${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless
	install -m 0644 ${S}/RT2870STA.dat ${D}${sysconfdir}/Wireless/RT2870STA/
  install -d ${D}/lib/firmware
  install -m 0644 ${S}/common/rt2870.bin ${D}/lib/firmware/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
