LICENSE = "LGPL"
DESCRIPTION = "Gtk+ display migration library (dummy version)"
DEPENDS = "gtk+"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r0"

inherit pkgconfig gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

headers = "displaymigration.h auth.h crypt.h"

do_install() {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}

do_stage () {
	oe_libinstall -so libdisplaymigration ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/libdisplaymigration
	for h in ${headers}; do
		install -m 0644 ${S}/libdisplaymigration/$h ${STAGING_INCDIR}/libdisplaymigration/${h}
	done
}
