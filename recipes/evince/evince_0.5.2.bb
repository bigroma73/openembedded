DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "tiff espgs poppler gtk+ libgnomeui libgnomeprint libgnomeprintui"
RDEPENDS = "espgs gconf"
RRECOMMENDS = "gnome-vfs-plugin-file"
PR = "r2"

inherit gnome pkgconfig

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/evince/0.5/${PN}-${PV}.tar.bz2 \
          file://more-no-doc.patch;patch=1"

EXTRA_OECONF = "--disable-tiff"

