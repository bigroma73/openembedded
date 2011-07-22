require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc2.tar.gz"

S = "${WORKDIR}/midpath-0.3rc2"

DEPENDS = "classpath pulseaudio"

do_compile() {
  # Only native pulseaudio backend library is enabled
  midpath_build \
    --disable-cldc \
    --disable-midpath \
    --disable-sdljava-cldc \
    --disable-escher-cldc \
    --disable-jlayerme-cldc \
    --disable-jorbis-cldc \
    --disable-avetanabt-cldc \
    --disable-jgl-cldc \
    --disable-web_services-api \
    --disable-location-api \
    --disable-messaging-api \
    --disable-svg-api \
    --disable-opengl-api \
    --disable-m3g-api \
    --disable-demos \
    --pulse
}

do_install() {
	oe_libinstall -C dist -so libmidpathpulse ${D}${libdir_jni}
}

do_stage() {
  :
}
	
PACKAGES = "${PN} ${PN}-dbg"

FILES_${PN} = "${libdir_jni}/lib*.so"
FILES_${PN}-dbg  = "${libdir_jni}/.debug/lib*.so"

