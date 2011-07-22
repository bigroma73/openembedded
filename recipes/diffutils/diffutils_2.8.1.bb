SECTION = "base"
LICENSE = "GPL"
DESCRIPTION = "Diffutils contains the GNU diff, diff3, \
sdiff, and cmp utilities. These programs are usually \
used for creating patch files."
PR = "r4"

SRC_URI = "${GNU_MIRROR}/diffutils/diffutils-${PV}.tar.gz"

inherit autotools update-alternatives

# diffutils assumes non-glibc compilation with uclibc and
# this causes it to generate its own implementations of
# standard functionality.  regex.c actually breaks compilation
# because it uses __mempcpy, there are other things (TBD:
# see diffutils.mk in buildroot)
EXTRA_OECONF_linux-uclibc = "--without-included-regex"
EXTRA_OECONF_linux-uclibceabi = "--without-included-regex"

do_install_append () {
        mv ${D}${bindir}/diff ${D}${bindir}/diff.${PN}
        mv ${D}${bindir}/cmp ${D}${bindir}/cmp.${PN}
}

ALTERNATIVE_NAME = "diff"
ALTERNATIVE_PATH = "diff.${PN}"
ALTERNATIVE_PRIORITY = "100"

pkg_postinst_${PN} () {

update-alternatives --install /usr/bin/cmp cmp cmp.diffutils 100

}

pkg_postrm_${PN} () {

update-alternatives --remove cmp cmp.diffutils

}
