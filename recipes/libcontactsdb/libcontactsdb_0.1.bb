LICENSE = "LGPL"
DESCRIPTION = "Database access library for GPE contacts"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

PR = "r0"
GPE_TARBALL_SUFFIX = "bz2"

inherit autotools gpe pkgconfig

do_stage () {
autotools_stage_all
}
