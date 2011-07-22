DESCRIPTION = "Python bindings for the sword library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python-core sword"
DEPENDS = "sword-${PV} swig-native"
SRCNAME = "sword"
PR = "r0"

SRC_URI = "http://crosswire.org/ftpmirror/pub/sword/source/v1.5/sword-${PV}.tar.gz"

S = "${WORKDIR}/${SRCNAME}-${PV}/bindings/swig/package"

EXTRA_OECONF = "--with-sword-dir=${STAGING_DIR_HOST}${layout_exec_prefix}"

inherit distutils autotools

PARALLEL_MAKE = ""

do_configure_prepend() {
	touch ltmain.sh
	./autogen.sh
}

do_compile() {
        oe_runmake BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} pythonswig python_make
}

do_install() {
	cd ${S}/python
	distutils_do_install
}
