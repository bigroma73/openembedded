require dropbear.inc
PR = "r1.02"

SRC_URI += "file://no-host-lookup.patch;patch=1"

EXTRA_OECONF_append = "--disable-wtmp --disable-wtmpx"
