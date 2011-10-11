DESCRIPTION = "bdremux - a blu-ray movie stream remuxer"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Andreas Frisch <fraxinas@opendreambox.org>"
DEPENDS = "gstreamer gst-plugins-base"
SRCREV = "6b687071f087ff04a876580ca50dc459ae22106d"

inherit autotools pkgconfig opendreambox-git
