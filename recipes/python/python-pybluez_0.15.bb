DESCRIPTION = "Python bindings for the Linux Bluetooth stack"
SECTION = "devel/python"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://pybluez.googlecode.com/files/PyBluez-0.15.tar.gz"
S = "${WORKDIR}/PyBluez-${PV}"

inherit distutils
