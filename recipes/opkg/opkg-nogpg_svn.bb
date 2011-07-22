require opkg_svn.bb

DEPENDS = "curl"
PROVIDES += "opkg"

PR = "${INC_PR}.4"

SRCREV = "${SRCREV_pn-opkg}"

EXTRA_OECONF += " --disable-gpg \ 
                  --disable-openssl \ 
                  --disable-ssl-curl \
                  --enable-gpg=no \
                  --enable-ssl-curl=no \
                  --enable-openssl=no"

LDFLAGS_append = " -Wl,--as-needed"

PV_opendreambox = "0.1.7+svnr${SRCPV}"
SRC_URI_append_opendreambox = " \
	file://remove_pyc_pyo_hack.patch;patch=1 \
	file://r531-fix-remove.patch;patch=1 \
	file://r599-fix-depmod.patch;patch=1 \
"

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}
do_configure_prepend_nylon() {
	LDFLAGS="`echo "$LDFLAGS" | sed "s/ -Wl,--as-needed//"`"
}

DEFAULT_PREFERENCE = "-1"
