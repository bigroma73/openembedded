require xorg-driver-video.inc
PE = "1"

SRC_URI += "file://fix-includepath.patch;patch=1 \
            file://fix-configure-includes.patch;patch=1"

#DESCRIPTION = ""

RDEPENDS += "xserver-xorg-module-libint10 "
PR = "r2"
