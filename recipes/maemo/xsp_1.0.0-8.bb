PR = "r2"
LICENSE= "MIT"
DESCRIPTION = "X Server Nokia 770 extensions library"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libxext xpext"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/x/xsp/${PN}_${PV}.tar.gz \
           file://xsp-fix-pc.patch;patch=1"
S = "${WORKDIR}/Xsp"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
