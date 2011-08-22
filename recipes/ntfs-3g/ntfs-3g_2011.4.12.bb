DESCRIPTION = "The NTFS-3G driver is an open source, freely available NTFS driver for Linux with read and write support."
HOMEPAGE = "http://www.ntfs-3g.org/"
LICENSE = "GPLv2"
DEPENDS = "fuse"
RDEPENDS = "fuse"

SRC_URI = http://tuxera.com/opensource/ntfs-3g_ntfsprogs-2011.4.12.tgz

inherit autotools

EXTRA_OEMAKE = "LDCONFIG=echo"
