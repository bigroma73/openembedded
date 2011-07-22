DEPENDS = "clutter-box2d"

PV = "0.0+gitr${SRCREV}"
PR = "r1"
PE = "1"

SRC_URI = "git://git.moblin.org/repos/users/pippin/prototype.git/;protocol=http \
           file://paths.patch;patch=1"

S = "${WORKDIR}/git"

do_install () {
	install -d ${D}${bindir}
	install ${S}/moblin-proto ${D}${bindir}

	install -d ${D}${datadir}/moblin-proto/
        cp -a ${S}/assets ${D}${datadir}/moblin-proto/
        cp -a ${S}/layouts ${D}${datadir}/moblin-proto/
}
