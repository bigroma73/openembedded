DESCRIPTION = "Python Bindings for GTK+ 1.2"
HOMEPAGE = "http://www.gtk.org"
SECTION = "devel/python"
LICENSE = "LGPL"
DEPENDS = "gtk+-1.2"
RDEPENDS = "python-shell python-re"
SRCNAME = "pygtk"
PR = "r3"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/python/v1.2/${SRCNAME}-${PV}.tar.gz \
           file://remove-imlib-et-al.patch;patch=1 \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools_stage pkgconfig distutils-base

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
	echo ${LDFLAGS} > /tmp/ldflags
	rm -f aclocal.m4
}

FILES_${PN}-dev += "${datadir}/pygtk"
