require scummvm.inc
DEPENDS = "virtual/libsdl tremor libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"
SRC_URI += " file://mouse.patch;patch=1 \
             file://gcc-4.x.x-accept.patch;patch=1 \
	     file://sh3-linux-new-arch.patch;patch=1 \
	     file://tail-obselete-fix.patch;patch=1 \
	     file://tremor.patch;patch=1"

