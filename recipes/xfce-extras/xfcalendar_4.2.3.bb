# xfce-calendar OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require ${PN}.inc

PACKAGES += " ${PN}-mcs-plugins"
FILES_${PN}-mcs-plugins += "${libdir}/xfce4/mcs-plugins/*.so"

