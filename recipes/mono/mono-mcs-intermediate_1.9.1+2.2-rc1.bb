# This is a straw-man recipe for step 1 in the two-step build of
# mono. Because it's impossible to build the mcs directory
# in cross-compile mode, this recipe will do a native build,
# then tar the resulting install tree for usage by the mono
# package in step 2.
# See http://www.mono-project.com/Mono:ARM

require mono_2.2.0.inc
require mono-mcs-intermediate.inc

DEFAULT_PREFERENCE = "-1"

#SRC_URI += "file://libgc_cppflags.patch;patch=1"


