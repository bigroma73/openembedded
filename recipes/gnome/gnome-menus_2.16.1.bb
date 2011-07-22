DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"

PR = "r1"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"
FILES_${PN}-dbg += "${libdir}/python*/site-packages/*/.debug \
                    ${libdir}/python*/site-packages/.debug"

