DESCRIPTION = "SHR Lite Image Feed"
PR = "r20"
PV = "2.0"
LICENSE = "GPL"

inherit task

def get_rdepends(bb, d):
    enabled = bb.data.getVar("ENABLE_BINARY_LOCALE_GENERATION", d, 1)

    # If locale is disabled, bail out
    if not enabled:
        return

    locales = bb.data.getVar("GLIBC_GENERATE_LOCALES", d, 1)
    if not locales or locales == "all":
        locales = bb.data.getVar("IMAGE_LINGUAS", d, 1);

    libc = bb.data.getVar('LIBC', d, 1)
    import re

    rdepends = ""
    if not locales or locales == "all":
        # if locales aren't specified, or user has written "all"
        import os
        ipkdir = bb.data.getVar('DEPLOY_DIR_IPK', d, 1)

        regexp1 = re.compile(libc+"-binary-localedata-.*") # search pattern
        regexp2 = re.compile("_.*") # we want to remove all version info and file extension

        for root, subFolders, files in os.walk(ipkdir):
            for file in files:
                if regexp1.search(file):
                    file = regexp2.sub("", file)
                    rdepends = "%s %s" % (rdepends, file)

    else:
        # if locales are specified
        regexp1 = re.compile("\\..*") # We want to turn en_US.UTF-8 into en_US
        regexp2 = re.compile("_")     # We want to turn en_US into en-US


        for locale in locales.split(" "):
            locale = regexp1.sub("", locale)
            locale = regexp2.sub("-", locale)
            locale = str.lower(locale)
            rdepends = "%s %s-binary-localedata-%s" % (rdepends, libc, locale)
    return rdepends




PACKAGES += "\
	${PN}-base \
	${PN}-cli \
	${PN}-fso \
	${PN}-audio \
	${PN}-x \
	${PN}-apps \
	${PN}-gtk \
"



RDEPENDS_${PN}-base = "\
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
  openssh-sftp-server \
  cron \
  logrotate\
  util-linux-ng-fdisk \
  shr-splash \
"

RDEPENDS_${PN}-cli = "\
  screen \
  nano \
  iptables \
  mtd-utils \
  s3c24xx-gpio \
  mickeydbus \
  mickeyterm \
"

RDEPENDS_${PN}-fso = "\
  fsoraw \
  opimd-utils-cli \
  python-codecs \
  python-gst \
"


#FIXME: libcanberra-alsa should be pulled in by fsodeviced but isn't
RDEPENDS_${PN}-audio = "\
  alsa-utils-aplay \
  alsa-utils-amixer \
  libcanberra-alsa \
"

RDEPENDS_${PN}-audio_append_om-gta01 = "\
  alsa-scenarii-shr \
"

RDEPENDS_${PN}-audio_append_om-gta02 =  "\
  alsa-scenarii-shr \
"

RDEPENDS_${PN}-x = "\
  glibc-utils \
  glibc-charmap-utf-8 \
  e-wm-menu-shr \
  shr-wizard \
  shr-theme-gry \
  etk-theme-shr \
  ${@get_rdepends(bb, d)} \
  libx11-locale \
  libmokoui2 \
  xcursor-transparent-theme \
  xinput-calibrator \
"

RDEPENDS_${PN}-apps = "\
  fso-abyss \
  phoneui-apps-messages \
  phoneui-apps-contacts \
  phoneui-apps-dialer \
  phonefsod \
  phoneuid \
  libphone-ui \
  libphone-ui-shr \
  ffalarms \
  shr-settings \
  shr-theme \
  calc \
"


RDEPENDS_${PN}-gtk = "\
  openmoko-icon-theme-standard2 \
  shr-theme-gtk-e17lookalike \
  vala-terminal \
  tangogps \
  pyphonelog \
  matchbox-keyboard-im \
"

