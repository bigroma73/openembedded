require libxine.inc

PPDIR = "1.25"
PR = "r0"


SRC_URI += " \
    	file://libxine-arm-configure.patch;patch=1 \
	file://iconv.patch;patch=1 \
	file://libpostproc.patch;patch=1 \
	file://libavcodec.patch;patch=1 \
        "

python populate_packages_prepend () {
        bb.data.setVar('PKG_libxine', 'libxine', d)

        plugindir = bb.data.expand('${libdir}/xine/plugins/${PPDIR}', d)
        do_split_packages(d, plugindir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

	vidixdir = bb.data.expand('${libdir}/xine/plugins/${PPDIR}/vidix', d)
        do_split_packages(d, vidixdir, '^(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

        postdir = bb.data.expand('${libdir}/xine/plugins/${PPDIR}/post', d)
        do_split_packages(d, postdir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

        fontdir = bb.data.expand('${datadir}/xine/libxine1/fonts', d)
        do_split_packages(d, fontdir, '^(.*).xinefont.gz$', 'libxine-font-%s', 'Xine font %s', extra_depends='' )

}

FILES_${PN}-dbg =+ "${libdir}/xine/plugins/${PPDIR}/.debug \
		    ${libdir}/xine/plugins/${PPDIR}/post/.debug \
		    ${libdir}/xine/plugins/${PPDIR}/vidix/.debug \
	           "

FILES_${PN}-dev =+ "${libdir}/xine/plugins/${PPDIR}/*.a \
                    ${libdir}/xine/plugins/${PPDIR}/post/*.a \
                    ${libdir}/xine/plugins/${PPDIR}/vidix/*.a \
                   "
