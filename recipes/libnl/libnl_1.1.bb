DESCRIPTION = "libnl is a library for applications dealing with netlink sockets"
SECTION = "libs/network"
LICENSE = "LGPL"
HOMEPAGE = "http://www.infradead.org/~tgr/libnl/"
PR = "r3"

inherit autotools pkgconfig

CFLAGS += '-DVLAN_FLAG_REORDER_HDR=1'

SRC_URI = "\
  http://www.infradead.org/~tgr/libnl/files/libnl-${PV}.tar.gz \
  file://local-includes.patch;patch=1 \
  file://fix-includes.patch;patch=1 \
  file://respect-ldflags.patch;patch=1 \
"

do_stage () {
	autotools_stage_all prefix=${prefix}
}
