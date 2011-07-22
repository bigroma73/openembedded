DESCRIPTION = "This package contains some modules used by different \
projects released by Logilab, including abstract syntax \
tree manipulation tools, database helper functions, HTML generation, \
command line argument parsing, logging, and process daemonization."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "logilab-common"
PR = "ml0"

SRC_URI = "ftp://ftp.logilab.fr/pub/common/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
