DESCRIPTION = "OpenDreambox: Base Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r7"

inherit task

#
# task-opendreambox-base
#
DESCRIPTION_${PN} = "OpenDreambox: Basesystem utilities"

OPENDREAMBOX_BASE_ESSENTIAL = "\
  autofs \
  base-files-doc \
  dreambox-bootlogo \
  dreambox-compat \
  dreambox-wdog \
  ${@base_contains('MACHINE', 'dm7025', '', 'dreambox-tpmd', d)} \
  dreambox-feed-configs \
  e2fsprogs-e2fsck \
  e2fsprogs-mke2fs \
  fakelocale \
  netkit-base \
  opkg-nogpg \
  ppp \
  timezones-alternative \
  tuxbox-common \
  util-linux-sfdisk \
  vsftpd \
  hdparm \
"

OPENDREAMBOX_BASE_RECOMMENDS = "\
  dropbear \
  sambaserver \
  zeroconf \
"

OPENDREAMBOX_BASE_OPTIONAL_RECOMMENDS = "\
  gdbserver \
  hddtemp \
  joe \
  mc \
  ncdu \
  ppp \
  smartmontools \
  avahi-daemon \
  kernel-module-usbhid \
"

RDEPENDS_${PN} = "\
	${OPENDREAMBOX_BASE_ESSENTIAL} \
"

RRECOMMENDS_${PN} = "\
	${OPENDREAMBOX_BASE_RECOMMENDS} \
	${OPENDREAMBOX_BASE_OPTIONAL_RECOMMENDS} \
"

RRECOMMENDS_${PN}_dm7025 = "\
	${OPENDREAMBOX_BASE_RECOMMENDS} \
"
