DESCRIPTION = "Provides common files needed to use IrDA. \
IrDA allows communication over Infrared with other devices \
such as phones and laptops."
SECTION = "base"
LICENSE = "GPL"
PR = "r9"

SRC_URI = "${SOURCEFORGE_MIRROR}/irda/irda-utils-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1 \
	   file://ldflags.patch;patch=1 \
           file://sbindir.patch;patch=1 \
	   file://init"

export SYS_INCLUDES="-I${STAGING_INCDIR}"

inherit autotools

INITSCRIPT_NAME = "irattach"
INITSCRIPT_PARAMS = "defaults 20"

do_compile () {
	oe_runmake -e -C irattach
	oe_runmake -e -C irdaping
}

do_install () {
	install -d ${D}${sbindir}
	oe_runmake -C irattach ROOT="${D}" sbindir="${sbindir}" install
	oe_runmake -C irdaping ROOT="${D}" sbindir="${sbindir}" install

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}
