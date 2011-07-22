# bootsplash-native OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require bootsplash_${PV}.bb

DEPENDS += "jpeg-native"

inherit native
S="${WORKDIR}/bootsplash-${PV}"

do_compile() {
	oe_runmake splash
}

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 0755 Utilities/splash ${STAGING_BINDIR}/splash
}
