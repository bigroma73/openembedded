LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "0"

PACKAGES += "gpe-applauncher-config"
PACKAGE_ARCH_gpe-applauncher-config_om-gta01 = "${MACHINE_ARCH}"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libsettings libxsettings-client"
RDEPENDS_${PN} += "gpe-applauncher-config"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

SRC_URI += "file://hotkeys.conf"

FILES_${PN} = '${datadir} ${bindir}'
FILES_gpe-applauncher-config = '${sysconfdir}/gpe/'

do_configure_append () {
	install ${WORKDIR}/hotkeys.conf ${S}
}
