SECTION = "libs"
LICENSE = "freetype"
DESCRIPTION = "Freetype font rendering library"

SRC_URI = "${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
	   file://install.mk.patch;patch=1"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += " ${bindir}"

inherit autotools  pkgconfig

LIBTOOL = "${S}/builds/unix/${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"

do_configure () {
	cd builds/unix
	libtoolize --force
	gnu-configize
	aclocal -I .
	autoconf
	cd ${S}
	oe_runconf
}

do_stage () {
	oe_libinstall -so -a -C objs libfreetype ${STAGING_LIBDIR}

	cp -a ${S}/include/*.h ${STAGING_INCDIR}
	install -d ${STAGING_INCDIR}/freetype2
	cp -a ${S}/include/freetype ${STAGING_INCDIR}/freetype2/

	sed -e 's,${prefix},${STAGING_LIBDIR}/..,' < builds/unix/freetype-config > ${STAGING_BINDIR_CROSS}/freetype-config
	chmod u+x ${STAGING_BINDIR_CROSS}/freetype-config
}
