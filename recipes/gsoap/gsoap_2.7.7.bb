DESCRIPTION = "The gSOAP toolkit provides a unique SOAP-to-C/C++ language binding \
for the development of SOAP Web Services and clients."
SECTION = "devel"
LICENSE = "GPL"
DEPENDS = "gsoap-native"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/gsoap2/gsoap_${PV}.tar.gz \
           file://rename_bogus_ldflags.patch;patch=1"
S = "${WORKDIR}/gsoap-2.7"

inherit autotools_stage

PARALLEL_MAKE = ""

EXTRA_OEMAKE = "SOAP=${STAGING_BINDIR_NATIVE}/soapcpp2"

do_install_append() {
	install -d ${D}${libdir}
	for lib in libgsoapssl libgsoapssl++ libgsoap libgsoapck++ libgsoap++ libgsoapck
	do
		oe_libinstall -C soapcpp2 $lib ${D}${libdir}
	done
}

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"
FILES_gsoap-dev = "${bindir}/wsdl2h ${bindir}/soapcpp2 ${libdir}"
