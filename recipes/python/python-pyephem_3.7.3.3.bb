DESCRIPTION = "PyEphem provides scientific-grade astronomical computations \
for the Python programming language."
HOMEPAGE = "http://www.rhodesmill.org/brandon/projects/pyephem.html"
LICENSE = "PSF"
AUTHOR = "Brandon Craig Rhodes"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/p/pyephem/pyephem-${PV}.tar.gz"
S = "${WORKDIR}/pyephem-${PV}"

inherit distutils
