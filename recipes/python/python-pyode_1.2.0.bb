DESCRIPTION = "PyODE is a set of open-source Python bindings for The Open Dynamics Engine, \
an open-source physics engine. PyODE also includes an XODE parser."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "ode"
SRCNAME = "PyODE"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyode/${SRCNAME}-${PV}.tar.bz2 \
           file://install.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	ln -s ${STAGING_LIBDIR}/.. ../ode
}

