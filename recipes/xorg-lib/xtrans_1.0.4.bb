require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
PE = "1"

ALLOW_EMPTY = "1"

XORG_PN = "xtrans"

SRC_URI += "file://fix-missing-includepath.patch;patch=1"
