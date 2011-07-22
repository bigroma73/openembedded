DESCRIPTION = "Python Vorbis Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libvorbis python-ogg"
SRCNAME = "pyvorbis"
PR = "ml0"

SRC_URI = "http://www.andrewchatham.com/pyogg/download/${SRCNAME}-${PV}.tar.gz \
           file://disable-oggcheck.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	touch Setup
	echo "ogg_libs = ogg" >>Setup
	echo "ogg_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "ogg_include_dir = ${STAGING_INCDIR}" >>Setup
	echo "vorbis_libs = vorbis vorbisfile vorbisenc" >>Setup
	echo "vorbis_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "vorbis_include_dir = ${STAGING_INCDIR}" >>Setup
}
