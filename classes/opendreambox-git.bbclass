OPENDREAMBOX_PROJECT ?= "${BPN}"

SRC_URI += "git://git.opendreambox.org/git/${OPENDREAMBOX_PROJECT}.git;protocol=git"

S = "${WORKDIR}/git"

inherit gitpkgv

RECIPE_PV := "${PV}"
PV = "${RECIPE_PV}+gitr${SRCPV}"
PKGV = "${RECIPE_PV}+gitr${GITPKGV}"
