# This is the support library for reiser4progs, required when
# building that package.  The libraries from this build must
# be installed on the system to use the reiser4progs programs
PR = "r1"
DESCRIPTION = "Library for user-level code accessing Reiser4 filesystems"
HOMEPAGE = "http://www.namesys.com"
SECTION = "base"
LICENSE = "GPLv2"

SRC_URI = "ftp://ftp.namesys.com/pub/reiser4progs/old-versions/${P}.tar.gz"

inherit autotools

# This disables anything which uses libminimal - that library
# is used for boot loader stuff and so is not required unless
# the system will boot from a Reiser4 file system, the same
# setting must exist for the reiser4progs build
DISABLE_LIBMINIMAL ?= "--disable-libminimal"
EXTRA_OECONF = "${DISABLE_LIBMINIMAL}"

do_stage() {
	echo "NOTE: stage package ${PF} is: (${PN},${PV},${PR})"
	autotools_stage_all
}
