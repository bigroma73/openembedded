DEFAULT_PREFERENCE = "-1"
LICENSE = "LGPLv2.1 GPLv3"

FILESPATHPKG =. "qt-${PV}:"

SRC_URI = "\
	http://get.qt.nokia.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
	file://0004-no-qmake.patch;patch=1 \
	file://hack-out-pg2-4.7.0.patch;patch=1 \
	file://0006-freetype-host-includes.patch;patch=1 \
	file://0001-Added-Openembedded-crossarch-option.patch;patch=1 \
	file://0010-phonon-gstreamer-rgb-endianess.patch;patch=1 \
	file://fix-translations.patch;patch=1 \
	file://0001-wsegl2-support.patch;patch=1 \
	file://g++.conf \
	file://linux.conf \
	file://blacklist-diginotar-certs.diff;patch=1 \
	"

S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

FILES_${QT_BASE_NAME}-tools                += "${bindir}/qml"

do_configure_prepend() {
    for pro in $(find ${S} -name "*.pro") ; do
        sed -i 's:$$LRELEASE:${STAGING_BINDIR_NATIVE}/lrelease4:g' $pro
    done

    sed -i s:SEDME:${S}: ${WORKDIR}/linux.conf
    sed -i \
    -e /QMAKE_MOC\ /d \
    -e /QMAKE_UIC\ /d \
    -e /QMAKE_UIC3\ /d \
    -e /QMAKE_RCC\ /d \
    ${S}/configure
}

QT_GLFLAGS ?= ""
QT_CONFIG_FLAGS += " -script -scripttools -declarative -xmlpatterns -no-rpath -qt3support -reduce-relocations -silent ${QT_GLFLAGS}"

do_compile() {
    unset CFLAGS CXXFLAGS

    oe_runmake ${EXTRA_ENV}
}

do_install_append() {
	install -d ${D}${bindir}
	for i in rcc uic moc ; do
		install -m 0755 ${S}/bin/$i ${D}${bindir}/
	done

        #Append an E to the qtdemo file
        if [ -n "${QT_LIBINFIX}" ] ; then
                mv ${D}${bindir}/qtdemo ${D}${bindir}/qtdemo${QT_LIBINFIX}
        fi
}

