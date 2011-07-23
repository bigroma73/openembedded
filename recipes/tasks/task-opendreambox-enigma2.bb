DESCRIPTION = "OpenDreambox: Enigma2 Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r9"

inherit task

PROVIDES = "\
  task-opendreambox-ui \
  ${PACKAGES} \
"

PACKAGES = "\
  task-opendreambox-enigma2 \
"

DEPENDS += "\
  ${@base_contains("MACHINE_FEATURES", "dreambox-libpassthrough", "dreambox-libpassthrough", "", d)} \
"

#
# task-opendreambox-enigma2
#
RPROVIDES_task-opendreambox-enigma2 = "task-opendreambox-ui"
DESCRIPTION_task-opendreambox-enigma2 = "OpenDreambox: Enigma2 Dependencies"
RDEPENDS_task-opendreambox-enigma2 = "\
  dreambox-blindscan-utils \
  enigma2 \
  enigma2-defaultservices \
  enigma2-plugin-extensions-mediascanner \
  enigma2-plugin-systemplugins-frontprocessorupgrade \
  enigma2-plugin-systemplugins-hotplug \
  enigma2-plugin-systemplugins-networkwizard \
  enigma2-plugin-systemplugins-softwaremanager \
  enigma2-plugin-systemplugins-videotune \
  enigma2-plugin-systemplugins-crossepg \
  enigma2-plugin-extensions-secondinfobar \
  enigma2-plugin-extensions-weatherplugin \
  enigma2-streamproxy \
  tuxbox-tuxtxt-32bpp \
  enigma2-meta \
  enigma2-plugins-meta \
  enigma2-skins-meta \
  enigma2-drivers-meta \  
"

RRECOMMENDS_task-opendreambox-enigma2 = "\
  aio-grab \
  python-crypt \
  python-netserver \
  python-twisted-core \
  python-twisted-protocols \
  python-twisted-web \
  enigma2-plugin-extensions-cutlisteditor \
  enigma2-plugin-extensions-graphmultiepg \
  enigma2-plugin-extensions-mediaplayer \
  enigma2-plugin-extensions-pictureplayer \
  enigma2-plugin-extensions-aspectratioswitch \
  enigma2-plugin-extensions-webinterface \
  enigma2-plugin-systemplugins-satfinder \
  enigma2-plugin-systemplugins-positionersetup \
  enigma2-plugin-systemplugins-skinselector \
  enigma2-plugin-systemplugins-networkbrowser \
  enigma2-plugin-systemplugins-autoresolution \
  enigma2-plugin-extensions-moviecut \
  enigma2-plugin-extensions-movieretitle \
  enigma2-plugin-extensions-bitrateviewer \
  ntpdate \
  domica domica-skins domica-skin-hd-line-tvpro \
  enigma2-plugin-systemplugins-crossepg-oe1.6 \
  enigma2-plugin-extensions-zaphistorybrowser \
  ${@base_contains("MACHINE_FEATURES", "wifi", "task-opendreambox-wlan", "", d)} \
  ${@base_contains("MACHINE_FEATURES", "modem", "task-opendreambox-modem", "", d)} \
  ${@base_contains("MACHINE_FEATURES", "dreambox-libpassthrough", "libpassthrough", "", d)} \
"

RDEPENDS_task-opendreambox-enigma2_append_dm500hd = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-tempfancontrol \
"

RDEPENDS_task-opendreambox-enigma2_append_dm800 = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opendreambox-enigma2_append_dm800se = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-tempfancontrol \
"

RDEPENDS_task-opendreambox-enigma2_append_dm8000 = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-commoninterfaceassignment \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-nfiflash \
"

RDEPENDS_task-opendreambox-enigma2_append_dm7020hd = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-commoninterfaceassignment \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-nfiflash \
"

RRECOMMENDS_task-opendreambox-enigma2_append_dm8000 = "\
  task-opendreambox-cdplayer \
  task-opendreambox-dvdplayer \
  task-opendreambox-dvdburn \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
