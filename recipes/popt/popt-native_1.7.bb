require popt_${PV}.bb
DEPENDS = "gettext-native"
inherit native

S = "${WORKDIR}/popt-${PV}"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/popt-${PV}"
