DESCRIPTION = "Screen is a full-screen window manager \
that multiplexes a physical terminal between several \
processes, typically interactive shells."
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "ncurses"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/screen/screen-${PV}.tar.gz \
           file://screen_4.0.2-4.1sarge1.diff.gz;patch=1 \
           file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-pty-mode=0620 --with-pty-group=5"
