DESCRIPTION = "The official Python interface to the Flickr API"
HOMEPAGE = "http://stuvel.eu/flickrapi"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "flickrapi"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/f/flickrapi/${SRCNAME}-${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

# NOTE: requires python-misc for webbrowser and subprocess as missing dependency of the webbrowser
RDEPENDS = "\
  python-core \
  python-elementtree \
  python-logging \
  python-misc \
  python-netclient \
  python-subprocess \
  python-threading \
  python-xml \
"

SRC_URI[md5sum] = "90dca08a45968b18da0894887f3e59b3"
SRC_URI[sha256sum] = "ac9304f571175b8af4fc2ee17d3e110847b526640665ca53d97bbf9df98329bc"
