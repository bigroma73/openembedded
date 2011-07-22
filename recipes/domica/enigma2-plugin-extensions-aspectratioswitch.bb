DESCRIPTION = "enigma2-plugin-extensions-secondinfobar"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "schaumkeks <schaumkeks@yahoo.de>"
DEPENDS = "enigma2"
RDEPENDS = "enigma2"

#PR = "r6"

SRC_URI="file://__init__.py \
	file://keymap-bouquet.xml \
	file://keymap-help.xml \
	file://keymap-stop.xml \
	file://plugin.py \
"

S = "${WORKDIR}/aspectratioswitch"

addtask movespin after do_unpack before do_patch

do_movespin () {
    mkdir -p  ${S}/usr/lib/enigma2/python/Plugins/Extensions/AspectRatioSwitch
    mv ${WORKDIR}/*.py ${S}/usr/lib/enigma2/python/Plugins/Extensions/AspectRatioSwitch
    mv ${WORKDIR}/*.xml ${S}/usr/lib/enigma2/python/Plugins/Extensions/AspectRatioSwitch
}

do_configure() {
}

do_compile() {
}


FILES_${PN} = "/"

do_install() {
	
	install -d ${D}/usr
	cp -r ${S}/usr/* ${D}/usr/
}
