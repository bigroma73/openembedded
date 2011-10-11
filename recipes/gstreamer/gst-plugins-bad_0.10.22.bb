require gst-plugins.inc

PR = "${INC_PR}.1"

do_configure_prepend() {
    sed -i -e s:docs::g Makefile.am
}

DEPENDS += "gst-plugins-base"

EXTRA_OECONF_opendreambox += "--disable-apexsink --disable-dvdnav --disable-cdaudio --disable-mpeg2enc --disable-mplex --disable-librfb"

SRC_URI_append_opendreambox += " \
				 file://mpegtsdemux-fix-bd-streamtype-detection.diff;patch=1;pnum=1 \
				 file://mpegpsdemux-speedup.diff;patch=1;pnum=0 \
				 file://mpegtsmux_indexing_alignment.diff;patch=1;pnum=1 \
"
