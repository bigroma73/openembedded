require linux-opendreambox.inc

SRCREV = "ac6cc9511a5f70eaa584c63fc5c3de33cae1d0e7"
PR_INC = "r14"

RREPLACES_kernel = "kernel-2.6.18-7.1-${MACHINE}"
RCONFLICTS_kernel = "kernel-2.6.18-7.1-${MACHINE}"
RREPLACES_kernel-image = "kernel-image-2.6.18-7.1-${MACHINE}"
RCONFLICTS_kernel-image = "kernel-image-2.6.18-7.1-${MACHINE}"

SRC_URI += " http://trappist.elis.ugent.be/~mronsse/cdfs/download/cdfs-2.6.18.tar.bz2 \
	file://stblinux-2.6.18-cdfs.patch \
	file://stblinux-2.6.18-extra-version-7.4.patch;patch=1 \
	file://stblinux-2.6.18-brcmnand-oob-raw-write-fix.patch;patch=1 \
	file://linux-2.6.18-fix-mips-crosscompile.patch;patch=1 \
	file://linux-2.6.18-fix-proc-cputype.patch;patch=1 \
	file://dvb-api-2.6.18-5.3.patch;patch=1 \
	file://linux-2.6.18-dvb-core-headers-20100904.patch;patch=1 \
	file://linux-2.6.18-dvb-frontends-headers-20100904.patch;patch=1 \
	${@base_contains('MACHINE', 'dm7020hd', '', 'file://stblinux-2.6.18-hw-ecc-compatibility.patch;patch=1', d)} \
	file://stblinux-2.6.18-fixed-brcmnand-buffer-overflow.patch;patch=1 \
	file://stblinux-2.6.18-brcmnand-fixed-dm7020hd-oob-write-op.patch;patch=1 \
"

do_configure_prepend() {
	if [ -d ${WORKDIR}/cdfs-${PV} ]; then
		mv ${WORKDIR}/cdfs-${PV} ${S}/fs/cdfs
		cd ${S} & patch -p1 < ${WORKDIR}/stblinux-2.6.18-cdfs.patch
	fi;
}
