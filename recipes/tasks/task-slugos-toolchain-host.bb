require task-sdk-host.bb
PR = "r1"
DESCRIPTION = "Packages for a standalone SlugOS external toolchain"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS_${PN} += "\
    devio-sdk \
"
