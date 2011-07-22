DEPENDS = "freetype dreambox-dvbincludes libtuxtxt"
DESCRIPTION = "tuxbox tuxtxt for 32bit framebuffer"
MAINTAINER = "Sven Karschewski <seddi@i-have-a-dreambox.com>"

SRCDATE = "20090130"
PV = "0.0+cvs${SRCDATE}"
PR = "r2"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins/tuxtxt;method=ext \
	file://makefiles.diff;patch=1;pnum=1 \
	file://nonblocking.diff;patch=1 \
	file://32bpp.diff;patch=1;pnum=1 \
	file://add_new_default_conf.diff;patch=1;pnum=1 \
	file://add_advanced_rc.diff;patch=1 \
	file://allow_different_demux.diff;patch=1 \
	file://plugin.py"

FILES_${PN} = "/usr/bin/tuxtxt /usr/share/fonts/tuxtxt.otb /usr/lib/enigma2/python/Plugins/Extensions/Tuxtxt /etc/tuxtxt"

# tuxtxt.ttf comes from enigma2 git now
FILES_${PN}_append_powerpc = " /usr/share/fonts/tuxtxt.ttf"
RDEPENDS_${PN}_append_mipsel = " enigma2"

S = "${WORKDIR}/tuxtxt"

CFLAGS_append = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native"

do_configure_prepend() {
	touch ${S}/python/__init__.py
	install -m 0644 ${WORKDIR}/plugin.py ${S}/python
}

do_stage() {
	install -m 0644 tuxtxt.h ${STAGING_INCDIR}/
}
