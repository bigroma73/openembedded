LICENSE	=	""

DEPENDS =	"nxcomp"

SRC_URI = 	"http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"

inherit autotools
S = "${WORKDIR}/${PN}"
