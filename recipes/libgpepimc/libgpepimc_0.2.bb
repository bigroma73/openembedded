LICENSE = "LGPL"
DESCRIPTION = "Common code for GPE PIMs"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libdisplaymigration gtk+ sqlite"

inherit pkgconfig gpe

SRC_URI += "file://libgpepimc_pc.patch;patch=1"

headers = "pim-categories.h pim-categories-ui.h"

do_stage () {
	oe_libinstall -so libgpepimc ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}

do_install () {
	gpe_do_install
	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
