PR = "r3"

SRC_URI = "http://ftp.sudo.ws/sudo/dist/sudo-${PV}.tar.gz \
           file://nonrootinstall.patch;patch=1 \
           file://nostrip.patch;patch=1 \
           file://autofoo.patch;patch=1 \
           file://noexec-link.patch;patch=1"

require sudo.inc
