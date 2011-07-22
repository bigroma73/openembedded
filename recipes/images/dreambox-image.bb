export IMAGE_BASENAME = "DOMICA-image"

OPENDREAMBOX_COMMON = "\
	task-boot \
	task-opendreambox-base \
	task-opendreambox-dvbapi \
	task-opendreambox-ui \
"

# add bootstrap stuff
DEPENDS = "${OPENDREAMBOX_COMMON}"
IMAGE_INSTALL = "${OPENDREAMBOX_COMMON}"

# we don't want any locales, at least not in the common way.
IMAGE_LINGUAS = " "

inherit image

opendreambox_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # generate /etc/image-version
    IMAGE_VERSION="000"
    IMAGE_DATE="$(date +%Y%m%d%H%M)"
    IMAGE_TYPE="1"
    echo "version=DOMICA-image-${IMAGE_DATE}" > etc/image-version
    echo "comment=${DISTRO_NAME}" >> etc/image-version
    echo "target=9" >> etc/image-version
    echo "creator=Pashaa <pashaa@domica.biz>" >> etc/image-version
    echo "url=http://www.domica.biz/" >> etc/image-version
    echo "catalog=http://www.upload.metabox.ru/" >> etc/image-version

    # because we're so used to it
    ln -s opkg usr/bin/ipkg || true
    ln -s opkg-cl usr/bin/ipkg-cl || true

    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "opendreambox_rootfs_postprocess; "

export NFO = '${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfo'

generate_nfo() {
    VER=`grep Version: "${IMAGE_ROOTFS}/usr/lib/ipkg/info/enigma2.control" | cut -b 10-12`
    echo "Enigma2: Domica ${VER}" > ${NFO}
    echo "Machine: Dreambox ${MACHINE}" >> ${NFO}
    DATE=`date +%Y-%m-%d' '%H':'%M`
    echo "Date: ${DATE}" >> ${NFO}
    echo "Issuer: Domica-forum" >> ${NFO}
    echo "Link: ${DISTRO_FEED_URI}" >> ${NFO}
    if [ "${DESC}" != "" ]; then
        echo "Description: ${DESC}" >> ${NFO}
        echo "${DESC}" >> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.desc
    fi
    MD5SUM=`md5sum ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfi | cut -b 1-32`
    echo "MD5: ${MD5SUM}" >> ${NFO}
}

do_rootfs_append_dm500hd() {
    generate_nfo
}

do_rootfs_append_dm800() {
    generate_nfo
}

do_rootfs_append_dm800se() {
    generate_nfo
}

do_rootfs_append_dm7020hd() {
    generate_nfo
}

do_rootfs_append_dm8000() {
    generate_nfo
}

do_rootfs_append_dm7025() {
    generate_nfo
}
