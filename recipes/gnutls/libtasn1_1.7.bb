DESCRIPTION = "Library for ASN.1 and DER manipulation"
LICENSE = "LGPL"

PR = "r1"

SRC_URI = "ftp://ftp.gnutls.org/pub/gnutls/libtasn1/libtasn1-${PV}.tar.gz"

inherit autotools binconfig

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

