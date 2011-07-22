SRC_URI = "ftp://ftp.trolltech.com/pub/freebies/tmake/tmake-${PV}.tar.gz"
DESCRIPTION = "tmake is an easy-to-use tool for creating and maintaining makefiles across many platforms and compilers."
LICENSE = "Unknown"
DEPENDS = ""
SECTION = "devel"
PRIORITY = "optional"

S = "${WORKDIR}/tmake-${PV}"

# Ick. This .bb file should really have a -native version doing this, even if it is a perl script... RP
do_stage() {
	install -m 0755 bin/tmake bin/progen ${STAGING_BINDIR_NATIVE}/

	install -d ${STAGING_DATADIR}/tmake
	cp -R lib/* ${STAGING_DATADIR}/tmake/
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 bin/tmake bin/progen ${D}${bindir}/

	install -d ${D}${datadir}/tmake
	cp -R lib/* ${D}${datadir}/tmake/
}

PACKAGES = "${PN}-dbg tmake"
FILES = ""
FILES_tmake="${bindir} ${datadir}/tmake"
