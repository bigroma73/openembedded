DESCRIPTION = "Preloadable library to improve large file operations"
SECTION = "base"

SRCREV = "f6cc8c3dce2f9ac00155ad38dc305996645c4005"

inherit autotools opendreambox-git lib_package

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "libpagecache.so.0.0.0" > ${D}${sysconfdir}/ld.so.preload
}
