SECTION = "console/network"
require ethload_${PV}.bb
inherit native

do_stage() {
	install -m 0755 ethload ${STAGING_BINDIR}
}
