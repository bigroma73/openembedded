DESCRIPTION = "Terminal emulator for the Xfce desktop environment"
DEPENDS = "exo vte dbus-glib gtk+"
RDEPENDS += "gnome-pty-helper"
PR = "r2"

inherit xfce

SRC_URI = "http://www.us.xfce.org/archive/xfce-4.4.2/src/Terminal-${PV}.tar.bz2 \
           file://into-support.patch;patch=1"

S = "${WORKDIR}/Terminal-${PV}"
