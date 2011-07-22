PR         = "r0"
LICENSE    = "GPL"

DEPENDS = "sdk-default-theme"
RDEPENDS = "sdk-default-theme"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/s/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}-1.0"

FILES_${PN} = "${datadir}"


do_install() {

  install -d ${D}/${datadir}
  cp -pPR ${S}/themes/  ${D}/${datadir}/

}

