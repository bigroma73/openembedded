require glib.inc
PR = "${INC_PR}.0"

# This version requires a newer libtool that isn't default yet 
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.16/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
          "

SRC_URI_append_arm = "file://atomic-thumb.patch;patch=1"
