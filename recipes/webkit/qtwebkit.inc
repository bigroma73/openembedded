DESCRIPTION = "Qt port of WebKit"
HOMEPAGE = "http://trac.webkit.org/wiki/QtWebKit"
LICENSE = "LGPLv2.1"
DEPENDS += "fontconfig sqlite3"
INC_PR = "r0"

inherit lib_package pkgconfig

export WEBKITOUTPUTDIR = "${WORKDIR}/qtbuild"

PKGCONFIG_FILE = "${libdir}/pkgconfig/QtWebKit${QT_LIBINFIX}.pc"
PRL_FILE = "${libdir}/libQtWebKit${QT_LIBINFIX}.prl"
QMAKEARG = " \
        INSTALL_HEADERS=${includedir}/${QT_DIR_NAME} \
        INSTALL_LIBS=${libdir} \
        QT_LIBINFIX=${QT_LIBINFIX} \
"

do_configure() {
}
do_compile() {
    ${S}/Tools/Scripts/build-webkit --qt --qmake=${OE_QMAKE_QMAKE} --no-netscape-plugin --qmakearg="${QMAKEARG}"
}
do_install() {
    oe_runmake -C ${WEBKITOUTPUTDIR}/Release install INSTALL_ROOT=${D}
    # fix pkgconfig and prl files
    sed -i -e s#-L${S}/lib##g \
           -e s#-L${STAGING_LIBDIR}##g \
           -e 's#STAGING_LIBDIR}#libdir}'#g \
           -e s#-L${libdir}##g \
           -e s#'$(OE_QMAKE_LIBS_X11)'#"${OE_QMAKE_LIBS_X11}"#g \
           -e s#" -Wl,-rpath-link,${S}/lib"##g \
           -e s#" -Wl,-rpath-link,${libdir}"##g \
           -e 's#I/usr/include#Iincludedir}#g' \
           -e 's#Iin#I${in#g' \
           ${D}${PRL_FILE} ${D}${PKGCONFIG_FILE}
    # fix pkgconfig files
    sed -i -e 's:^prefix=.*:prefix=${prefix}:' \
           -e 's:-L$(OE_QMAKE_LIBDIR_QT)::g' \
           -e '/^Cflags:/s#{includedir}#{includedir} -I${includedir}/${QT_DIR_NAME} -DQT_SHARED#' \
           ${D}${PKGCONFIG_FILE}
    for name in QtCore QtGui QtNetwork; do
           sed -i -e /Requires/s#"${name}"#"${name}${QT_LIBINFIX}"#g ${D}${PKGCONFIG_FILE}
    done
}

FILES_${PN}-dev += "${PRL_FILE}"
