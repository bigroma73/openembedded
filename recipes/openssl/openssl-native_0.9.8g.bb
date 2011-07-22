inherit pkgconfig native

require openssl.inc

PR = "${INC_PR}.0"

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

SRC_URI += "file://debian.patch;patch=1 \
            file://configure-targets.patch;patch=1 \
            file://shared-libs.patch;patch=1"

PARALLEL_MAKE = ""

do_install() {
	:
}

PACKAGES = ""
