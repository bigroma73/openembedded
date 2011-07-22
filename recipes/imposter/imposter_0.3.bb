DESCRIPTION =	"Imposter is a standalone viewer for the presentations created by OpenOffice.org Impress software."
LICENSE =	"GPLv2"

SRC_URI	=	"${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"
DEPENDS =	"gtk+"

inherit autotools pkgconfig
