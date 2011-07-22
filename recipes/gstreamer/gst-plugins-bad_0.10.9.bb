require gst-plugins.inc
PR = "r2"

SRC_URI += "file://vorbisenc.h file://vorbisdec.h \
            file://gst-plugins-directfb-fix.patch;patch=1;pnum=2 \
            file://ivorbis-thumb.patch;patch=1"

DEPENDS += "gst-plugins-base openssl"
EXTRA_OECONF += " ac_cv_openssldir=no"

do_compile_prepend() {
	# work around missing files in upstream tarball (upstream bug #454078)
	install -m 0644 ${WORKDIR}/vorbis*.h ${S}/ext/ivorbis/
}
