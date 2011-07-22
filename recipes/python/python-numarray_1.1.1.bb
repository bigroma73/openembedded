DESCRIPTION = "Next Generation sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PYRAF"
SRCNAME = "numarray"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/numpy/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/numarray/examples/*/.debug"
