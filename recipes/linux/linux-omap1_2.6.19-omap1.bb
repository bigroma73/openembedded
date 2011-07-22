require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.19.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.19-omap1.bz2;patch=1 \
           file://another-ide-cs-ids.patch;patch=1 \
           file://i2c-fix.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.19"
