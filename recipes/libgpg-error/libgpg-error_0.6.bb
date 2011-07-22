DESCRIPTION = "GPG-Error library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL FDL"
PR = "${INC_PR}.1"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/alpha/libgpg-error/libgpg-error-${PV}.tar.gz"

inherit autotools binconfig

do_stage() {
	oe_libinstall -so -C src libgpg-error ${STAGING_LIBDIR}
	install -d ${STAGING_BINDIR_CROSS}/
	install -m 0755 src/gpg-error-config ${STAGING_BINDIR_CROSS}/

	install -d ${STAGING_INCDIR}/
	for X in gpg-error.h
	do
		install -m 0644 src/${X} ${STAGING_INCDIR}/${X}
	done

}
