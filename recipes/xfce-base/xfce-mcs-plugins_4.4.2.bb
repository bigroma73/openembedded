# xfce-mcs-plugins OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION = "Common XFCE4 configuration plugins."
DEPENDS = "libxfcegui4 xfce-mcs-manager gtk+"
SECTION = "x11"

inherit xfce

PACKAGES += "${PN}-mcs-plugins"
FILES_${PN}-mcs-plugins = "${libdir}/xfce4/mcs-plugins/*.so"
