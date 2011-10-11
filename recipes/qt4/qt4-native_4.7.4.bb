require qt4-native.inc
LICENSE = "LGPLv2.1 GPLv3"

PR = "${INC_PR}.0"

# Find the g++.conf/linux.conf in the right directory.
FILESPATHPKG =. "qt-${PV}:"
SRC_URI = "http://get.qt.nokia.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://qt-config.patch;patch=1 \
           file://g++.conf \
           file://linux.conf"
S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

EXTRA_OECONF += " -no-fast -silent -no-rpath"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"
