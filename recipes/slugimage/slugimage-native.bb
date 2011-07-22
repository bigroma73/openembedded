# slugimage - a program to construct NSLU2 image files
require slugimage.bb

# slugimage depends on perl, we assume that this is installed.
RDEPENDS = ""

inherit native

do_stage () {
	install -m 0755 slugimage ${STAGING_BINDIR}/
}
