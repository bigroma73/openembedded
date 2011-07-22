require xorg-lib-common.inc

DESCRIPTION = "X Composite extension library."
LICENSE= "BSD-X"
DEPENDS += " compositeproto virtual/libx11 libxfixes libxext"
PROVIDES = "xcomposite"
PE = "1"

XORG_PN = "libXcomposite"

SRC_URI += " file://change-include-order.patch;patch=1"
