require linux-opendreambox-2.6.18.inc

PR="${PR_INC}.2"

SRC_URI += "\
	file://linux-2.6.18-fix-serial.patch;patch=1 \
	file://linux-2.6.18-256MB-nand-support.patch;patch=1 \
	file://linux-2.6.18-big-summary.patch;patch=1 \
	file://linux-2.6.18-nand-fixes.patch;patch=1 \
"
