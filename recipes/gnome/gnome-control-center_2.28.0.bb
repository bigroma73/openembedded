DESCRIPTION = "GNOME control center"
LICENSE = "GPL"

PR = "r1"

DEPENDS = "metacity eel gstreamer libcanberra gnome-settings-daemon libgnomeui gnome-doc-utils gtk+ libglade libgnomecanvas librsvg libxml2 libart-lgpl atk"

inherit gnome

LDFLAGS += "-lgthread-2.0 -lxml2"

do_configure_prepend() {
	sed -i s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icon* \
                ${datadir}/xsession* \
                ${libdir}/window-manager-settings/*.so \
                ${datadir}/gnome \
                ${datadir}/desktop-directories \
               "
FILES_${PN}-dbg += "${libdir}/window-manager-settings/.debug"
FILES_${PN}-dev += "${libdir}/window-manager-settings/*a"




