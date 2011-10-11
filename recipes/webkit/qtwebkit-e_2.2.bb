inherit qt4e
require qtwebkit.inc

PR = "${INC_PR}.0"

SRC_URI = " \
        http://pkgs.fedoraproject.org/repo/pkgs/qtwebkit/qtwebkit-2.2.0-rc1.tar.xz/5c1581052ad5bb7aed07a1798a340061/qtwebkit-2.2.0-rc1.tar.xz \
        file://0001-Qt-Fix-build-with-QT_LIBINFIX.patch;patch=1 \
"

S = "${WORKDIR}/webkit-qtwebkit"
