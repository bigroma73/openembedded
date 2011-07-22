require linux-libc-headers.inc

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PR = "r4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2 \
           file://arm-syscall-define.patch;patch=1"

SRC_URI_append_mipsel = " file://mips-add-missing-headers.patch;patch=1 \
           file://mips-fix-ptrace-header.patch;patch=1"

SRC_URI_append_opendreambox = " file://mips-brcm-add-missing-syscalls.patch;patch=1 \
           file://dvb-api-2.6.18-5.3.patch;patch=1"

S = "${WORKDIR}/linux-2.6.18"

set_arch() {
	case ${TARGET_ARCH} in
		alpha*)   ARCH=alpha ;;
		arm*)     ARCH=arm ;;
		cris*)    ARCH=cris ;;
		hppa*)    ARCH=parisc ;;
		i*86*)    ARCH=i386 ;;
		ia64*)    ARCH=ia64 ;;
		mips*)    ARCH=mips ;;
		m68k*)    ARCH=m68k ;;
		powerpc*) ARCH=powerpc ;;
		s390*)    ARCH=s390 ;;
		sh*)      ARCH=sh ;;
		sparc64*) ARCH=sparc64 ;;
		sparc*)   ARCH=sparc ;;
		x86_64*)  ARCH=x86_64 ;;
	esac
}

do_configure() {
	set_arch
	oe_runmake allnoconfig ARCH=${ARCH}
}

do_compile () {
}

do_install() {
	set_arch
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=${ARCH}
}

do_install_append_arm() {
	cp include/asm-arm/procinfo.h ${D}${includedir}/asm
}

STAGE_TEMP="${WORKDIR}/temp-staging"

do_stage () {
	set_arch
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	oe_runmake headers_install INSTALL_HDR_PATH=${STAGE_TEMP}${exec_prefix} ARCH=${ARCH}
	if [ "${ARCH}" == "arm" ]; then
		cp include/asm-arm/procinfo.h ${STAGE_TEMP}${includedir}/asm
	fi
	install -d ${STAGING_INCDIR}
	for x in linux asm asm-generic linux mtd rdma scsi sound video; do
		rm -rf ${STAGING_INCDIR}/$x;
		cp -pfLR ${STAGE_TEMP}${includedir}/$x ${STAGING_INCDIR}/;
	done
	# Add UTS_RELEASE to version.h. UTS_RELEASE was moved from version.h to 
	# utsrelease.h in order to avoid recompiling a kernel every time a localversion
	# changed. Since the our headers are static and we're not compiling an 
	# actual kernel, re-adding UTS_RELEASE does't hurt, and it allows uclibc to 
	# compile with kernel headers that work with EABI on ARM
	echo '#define UTS_RELEASE "2.6.18"' >> ${STAGING_INCDIR}/linux/version.h
}

do_stage_append_nylon () {
	install -d ${STAGING_INCDIR}/asm/
	cp -vpPR include/asm-${ARCH}/* ${STAGING_INCDIR}/asm/
	install -d ${CROSS_DIR}/${TARGET_SYS}/include/asm/
	cp -vpPR include/asm-${ARCH}/* ${CROSS_DIR}/${TARGET_SYS}/include/asm/
	cp -vpPR include/linux/* ${STAGING_INCDIR}/linux/
	install -d ${CROSS_DIR}/${TARGET_SYS}/include/linux/
	cp -vpPR include/linux/* ${CROSS_DIR}/${TARGET_SYS}/include/linux/
}

