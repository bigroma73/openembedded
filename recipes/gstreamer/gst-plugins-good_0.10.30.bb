require gst-plugins.inc

PR = "${INC_PR}.0"

DEPENDS += "gst-plugins-base"

RREPLACES_gst-plugin-audioparsers = "gst-plugin-audioparsersbad"
RCONFLICTS_gst-plugin-audioparsers = "gst-plugin-audioparsersbad"
RREPLACES_gst-plugin-isomp4 = "gst-plugin-qtdemux"
RCONFLICTS_gst-plugin-isomp4 = "gst-plugin-qtdemux"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

