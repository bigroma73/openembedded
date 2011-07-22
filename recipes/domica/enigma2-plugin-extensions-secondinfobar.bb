DESCRIPTION = "enigma2-plugin-extensions-secondinfobar"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Vali"
DEPENDS = "enigma2"
RDEPENDS = "enigma2"

#PR = "r6"
PV="2.7"

SRC_URI="file://plugin.py \
	 file://__init__.py \
	 file://keymap.xml \
	 "

S = "${WORKDIR}/secondinfobar"

addtask movespin after do_unpack before do_patch

do_movespin () {
    mkdir -p  ${S}/usr/lib/enigma2/python/Plugins/Extensions/2IB
    mv ${WORKDIR}/*.py ${S}/usr/lib/enigma2/python/Plugins/Extensions/2IB
    mv ${WORKDIR}/*.xml ${S}/usr/lib/enigma2/python/Plugins/Extensions/2IB
}

FILES_${PN} = "/"

do_configure() {
}

do_compile() {
}

do_install() {
	
	install -d ${D}/usr
	cp -r ${S}/usr/* ${D}/usr/
}
