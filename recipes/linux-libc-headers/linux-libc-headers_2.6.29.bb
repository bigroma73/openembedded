require linux-libc-headers.inc

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	  "

S = "${WORKDIR}/linux-${PV}"

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
	        avr32*)   ARCH=avr32 ;;
                bfin*)    ARCH=blackfin ;;
	esac
}

do_unpack_append() {
	bb.build.exec_func('do_replace_linux_types', d)
}

do_replace_linux_types() {
	# linux/types.h conflicts with glibc headers
	sed -i 's,^#include <linux/types.h>,#include <asm/types.h>,' ${S}/include/linux/dvb/*.h
}

do_configure() {
	set_arch
	oe_runmake allnoconfig ARCH=$ARCH
}

do_compile () {
}

do_install() {
	set_arch
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=$ARCH
}

do_stage () {
	set_arch
	oe_runmake headers_install INSTALL_HDR_PATH=${STAGING_DIR_HOST}${layout_prefix} ARCH=$ARCH
}
