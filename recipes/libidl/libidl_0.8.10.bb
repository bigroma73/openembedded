require libidl.inc

DEPENDS = "glib-2.0 flex-native libidl-native"

PR = "r0"

BINCONFIG_GLOB = "*-config-2"
inherit autotools pkgconfig binconfig
