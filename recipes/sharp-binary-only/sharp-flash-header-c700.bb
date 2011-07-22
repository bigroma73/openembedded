SECTION = "base"
SRC_URI = "file://header-c700.bin"
LICENSE = "sharp-binary-only"
COMPATIBLE_MACHINE = '(c7x0|spitz|akita)'

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_stage() {
	install -d ${STAGING_LIBDIR}/sharp-flash-header
	install -m 0644 ${WORKDIR}/header-c700.bin ${STAGING_LIBDIR}/sharp-flash-header/header-c700.bin
}
