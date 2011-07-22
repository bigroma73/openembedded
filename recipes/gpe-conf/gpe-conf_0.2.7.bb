DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ esound audiofile libgpewidget libxsettings libxsettings-client libxrandr"
RDEPENDS_${PN} = "xst gpe-confd xset ntpdate gpe-icons tzdata xrandr"
RDEPENDS_gpe-conf-panel = "gpe-conf"

RPROVIDES_${PN} += " bl"
RCONFLICTS_${PN} = "bl"

PR = "r2"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig

SRC_URI += "file://poweroff.patch;patch=1 \
            file://wifi-key.patch;patch=1;pnum=0"

PACKAGES += "gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"

