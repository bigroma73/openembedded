inherit gpe

DEPENDS = "libxsettings glib-2.0 sqlite"
SECTION = "gpe"
DESCRIPTION = "GPE configuration daemon"
LICENSE = "GPL"
PR = "r1"

SRC_URI += "file://makefile-fix.patch;patch=1"
