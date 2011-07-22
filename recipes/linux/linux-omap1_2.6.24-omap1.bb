require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.24-omap1.bz2;patch=1 \
           file://binutils-buildid-arm.patch;patch=1 \
           file://timespec_add_ns_avoid_udivdi3.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.24"
