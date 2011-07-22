DESCRIPTION = "OpenDreambox: CD-Player Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-opendreambox-cdplayer
#
DESCRIPTION_${PN} = "OpenDreambox: CD-Player Support"
DEPENDS = "enigma2-plugins"
RDEPENDS_${PN} = "\
 kernel-module-cdfs \
 enigma2-plugin-extensions-cdinfo \
 libcddb \
 libcdio \
"

