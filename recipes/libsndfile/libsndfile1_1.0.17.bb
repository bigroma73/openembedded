DESCRIPTION = "An audio format Conversion library"
HOMEPAGE = "http://www.mega-nerd.com/libsndfile"
AUTHOR = "Erik de Castro Lopo"
SECTION = "libs/multimedia"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "http://www.mega-nerd.com/libsndfile/libsndfile-${PV}.tar.gz \
           file://configure-fix.patch;patch=1"

S = "${WORKDIR}/libsndfile-${PV}"

inherit autotools lib_package pkgconfig

do_configure_prepend_arm() {
	export ac_cv_sys_largefile_source=1
	export ac_cv_sys_file_offset_bits=64
	ac_cv_sizeof_off_t=8
}

do_stage() {
	oe_libinstall -a -so -C src libsndfile ${STAGING_LIBDIR}
	install -m 0644 ${S}/src/sndfile.h ${STAGING_INCDIR}/
}

PACKAGES =+ "${PN}-octave"
FILES_${PN}-octave += "/usr/share/octave/site/m"
