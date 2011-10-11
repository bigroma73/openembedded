require v4l-dvb-modules.inc

DEPENDS += " mercurial-native"

SRCDATE = "20100904"
SRCREV = "6e0befab696a"
PV = "0.0+hg${SRCDATE}"
PR = "r5"

SRC_URI = "hg://linuxtv.org/hg/;module=v4l-dvb;rev=${SRCREV} \
           file://defconfig \
           file://v4l-dvb-compat.patch;patch=1 \
           file://v4l-2.6.18-compat.patch;patch=1 \
           file://fix-blocking-demux.patch;patch=1 \
           file://basic-dvb-t2-support.patch;patch=1 \
           file://localversion.patch;patch=1 \
           file://fix-strip.patch;patch=1 \
           file://build-fix.patch;patch=1 \
           file://backport-*.patch \
"

S = "${WORKDIR}/v4l-dvb"

do_munge() {
	CUR=`pwd`
	cd ${S}/linux
	oenote "cd to '${S}/linux'";
	for i in `ls ${WORKDIR}/backport-*.patch | sort -n | xargs`; do
		oenote "Applying v4l-dvb backport patch '$i'";
		patch -p1 < $i;
	done;
	cd $CUR
}

addtask munge before do_compile after do_patch

