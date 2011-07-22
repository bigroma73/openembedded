DESCRIPTION = "Helper lib for keyboard management"
LICENSE = "LGPL"

PR = "r1"

DEPENDS = "xkbcomp gtk+"

inherit gnome

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  libxklavier.pc
}

do_stage() {
	autotools_stage_all
}

