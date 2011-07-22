DESCRIPTION = "Descriptions for driver packages used by enigma2"
LICENSE = "proprietary"
MAINTAINER = "Mladen Horvat <acid-burn@opendreambox.org>"

PR = "r0"

SRC_URI = "file://genmetaindex.py \
	file://driver_r8712u.xml \
	file://driver_rt3070.xml"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/meta
	install ${WORKDIR}/*.xml ${D}${datadir}/meta
	for f in *.xml; do
		python ${WORKDIR}/genmetaindex.py ${D}${datadir}/meta/driver_*.xml > ${D}${datadir}/meta/index-enigma2-drivers.xml
	done
}

FILES_${PN} = "${datadir}/meta"
PACKAGE_ARCH = "all"
