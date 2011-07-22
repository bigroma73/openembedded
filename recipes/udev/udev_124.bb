DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug package and requires a kernel not older than 2.6.12."
RPROVIDES_${PN} = "hotplug"
PR = "r20"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://noasmlinkage.patch;patch=1 \
	   file://flags.patch;patch=1 \
	   file://vol_id_ld.patch;patch=1 \
	   file://udevtrigger_add_devname_filtering.patch;patch=1 \
	   file://libvolume-id-soname.patch;patch=1 \
	   file://mtd-exclude-persistent.patch;patch=1 \
	   file://mount.blacklist \
	   file://run.rules \
	   file://default \
	   file://local.rules \
	   "

SRC_URI_append_h2200 = " file://50-hostap_cs.rules "
PACKAGE_ARCH_h2200 = "h2200"

SRC_URI_append_opendreambox = " file://40-od-devfs-compatibility.rules \
	   file://42-od-oled-compatibility.rules"

SRC_URI_append_dm8000 = " ${@base_contains('PREFERRED_VERSION_linux-dm8000', '2.6.18', 'file://41-od-linux-2.6.18-misc.rules', '', d)}"
SRC_URI_append_dm800 = " ${@base_contains('PREFERRED_VERSION_linux-dm800', '2.6.18', 'file://41-od-linux-2.6.18-misc.rules', '', d)}"
SRC_URI_append_dm800se = " ${@base_contains('PREFERRED_VERSION_linux-dm800se', '2.6.18', 'file://41-od-linux-2.6.18-misc.rules', '', d)}"
SRC_URI_append_dm7020hd = " ${@base_contains('PREFERRED_VERSION_linux-dm7020hd', '2.6.18', 'file://41-od-linux-2.6.18-misc.rules', '', d)}"
SRC_URI_append_dm500hd = " ${@base_contains('PREFERRED_VERSION_linux-dm500hd', '2.6.18', 'file://41-od-linux-2.6.18-misc.rules', '', d)}"

require udev.inc

INITSCRIPT_PARAMS = "start 03 S ."

FILES_${PN} += "${base_libdir}/udev/*"
FILES_${PN}-dbg += "${base_libdir}/udev/.debug"
UDEV_EXTRAS = "extras/firmware/ extras/scsi_id/ extras/volume_id/"
EXTRA_OEMAKE += "libudevdir=/lib/udev libdir=${base_libdir} prefix="

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev

	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/default ${D}${sysconfdir}/default/udev

	install -d ${D}${sysconfdir}/udev/rules.d/

	install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/
	install -m 0644 ${WORKDIR}/local.rules         ${D}${sysconfdir}/udev/rules.d/local.rules
	install -m 0644 ${WORKDIR}/permissions.rules   ${D}${sysconfdir}/udev/rules.d/permissions.rules
	install -m 0644 ${WORKDIR}/run.rules          ${D}${sysconfdir}/udev/rules.d/run.rules
	install -m 0644 ${WORKDIR}/udev.rules          ${D}${sysconfdir}/udev/rules.d/udev.rules
	install -m 0644 ${WORKDIR}/links.conf          ${D}${sysconfdir}/udev/links.conf
	if [ "${UDEV_DEVFS_RULES}" = "1" ]; then
		install -m 0644 ${WORKDIR}/devfs-udev.rules ${D}${sysconfdir}/udev/rules.d/devfs-udev.rules
	fi

	touch ${D}${sysconfdir}/udev/saved.uname
	touch ${D}${sysconfdir}/udev/saved.cmdline
	touch ${D}${sysconfdir}/udev/saved.atags

	install -d ${D}${sysconfdir}/udev/scripts/

	install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
	install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts

	install -d ${D}${base_libdir}/udev/
}

do_install_append_h2200() {
	install -m 0644 ${WORKDIR}/50-hostap_cs.rules         ${D}${sysconfdir}/udev/rules.d/50-hostap_cs.rules
}

do_install_append_opendreambox() {
	install -m 0644 ${WORKDIR}/??-od-*.rules ${D}${sysconfdir}/udev/rules.d/
}
