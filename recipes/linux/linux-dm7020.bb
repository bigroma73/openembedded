DESCRIPTION = "Linux kernel for Dreambox DM7020"
LICENSE = "GPL"
PN = "linux-dm7020"
PV = "2.6.9"
PR = "r6"

# -r1 is the patch revision - it's not related to this package's PR
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.9.tar.bz2 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linuxppc-2.6.9-r1.diff.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linuxppc-2.6.9-dream-s8.diff.bz2;patch=1;pnum=1 \
	file://allow_gcc4.patch;patch=1 \
	file://linux-2.6-trailing-whitespaces-in-params.patch;patch=1"

S = "${WORKDIR}/linux-2.6.9"

inherit kernel

FILES_kernel-image = "/boot/zImage.elf /boot/autoexec.bat"

export OS = "Linux"
ARCH = "ppc"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"

do_configure_prepend() {
	oe_machinstall -m 0644 ${S}/arch/ppc/configs/dm7020_defconfig ${S}/.config || die "no default configuration for ${MACHINE} available."
	oe_runmake oldconfig
}

do_install_append () {
	install -d ${D}/boot
	install -m 0755 arch/ppc/boot/images/zImage.elf ${D}/boot/zImage.elf
	echo "/flash/bootlogo.elf" > ${D}/boot/autoexec.bat
	echo "/flash/zImage.elf" >> ${D}/boot/autoexec.bat
}

pkg_preinst_kernel-image () {
	[ -z "$D" ] && mountpoint -q /boot && mount -o rw,remount /boot
	true
}

pkg_postinst_kernel-image () {
	[ -z "$D" ] && mountpoint -q /boot && mount -o ro,remount /boot
	true
}

pkg_prerm_kernel-image () {
	[ -z "$D" ] && mountpoint -q /boot && mount -o rw,remount /boot
	true
}

pkg_postrm_kernel-image () {
	[ -z "$D" ] && mountpoint -q /boot && mount -o ro,remount /boot
	true
}
