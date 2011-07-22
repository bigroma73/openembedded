LICENSE = "GPL"
DESCRIPTION = "procfs tools"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "gtk+ hal gamin startup-notification"
RRECOMMENDS = "pmount-hal"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/pcmanfm/pcmanfm-${PV}.tar.gz \
           file://desired_mount_point.patch;patch=1 \
           file://auto_mount.patch;patch=1 \
	   file://gnome-fs-directory.png \
	   file://gnome-fs-regular.png \
	   file://gnome-mime-text-plain.png \
	   file://emblem-symbolic-link.png \
	   file://desktop.patch;patch=1"

inherit autotools pkgconfig

do_install_append () {
	install -d ${D}/${datadir}
	install -d ${D}/${datadir}/pixmaps/

	install -m 0644 ${WORKDIR}/*.png ${D}/${datadir}/pixmaps
}

FILES_${PN} += "${datadir}/pixmaps/*.png"
