SECTION = "x11/base"
require libx11_${PV}.bb

EXTRA_OECONF += "--disable-udc --enable-xcms --disable-xlocale --disable-xkb"
CFLAGS += "-D_GNU_SOURCE"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

SRC_URI += "file://X18NCMSstubs.diff;patch=1 \
	    file://fix-disable-xlocale.diff;patch=1 \
            file://fix-utf8-wrong-define.patch;patch=1 \
	    file://xim.patch;patch=1 \
	    file://xchar2b.patch;patch=1"
