DESCRIPTION = "Skins for Domica"
MAINTAINER = "Pashaa"

PACKAGES_DYNAMIC = "domica-skin-*"

# if you want experimental, use:
SRCREV="${AUTOREV}"
#"de610a460bec046f0dca9987ecba458303daaf1d"
#SRCDATE="20110128"
#BRANCH="master"
#PV = ""

PR = "r0"
SRC_URI="git://github.com/bigroma73/domica-skins.git;protocol=git;branch=master"

FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts /usr/lib/enigma2/python/"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "all"

inherit autotools

S = "${WORKDIR}/git"

python populate_packages_prepend () {
	enigma2_skindir = bb.data.expand('${datadir}/enigma2', d)

	do_split_packages(d, enigma2_skindir, '(.*?)/.*', 'domica-skin-%s', 'Domica Skin: %s', recursive=True, match_path=True, prepend=True)
}

python populate_packages_append () {
	enigma2_skindir = bb.data.expand('${datadir}/enigma2', d)

	#clear rdepends by default
	for package in bb.data.getVar('PACKAGES', d, 1).split():
		bb.data.setVar('RDEPENDS_' + package, '', d)

	#todo add support for control files in skindir.. like plugins
}
