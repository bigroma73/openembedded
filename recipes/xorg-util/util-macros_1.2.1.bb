require xorg-util-common.inc

# Version 1.2.1 uses plain `gcc' for checking the compiler version.
# Instead, the cross compiler must be used. Whenever upgrading to
# a new version, please recheck for this problem, otherwise it breaks
# builds with older gcc versions!
SRC_URI += " file://cross-compiler-for-checking.patch;patch=1"

DESCRIPTION = "X autotools macros"
PE = "1"

ALLOW_EMPTY = "1"
