require rdiff-backup.inc
PR = "r1"

# 1.1.x added the use of sha which we get from python-crypt
RDEPENDS_${PN} += "python-crypt"
