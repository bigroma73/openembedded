# cppunit OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Unit Testing Library for C++"
HOMEPAGE = "http://cppunit.sourceforge.net/"
LICENSE = "LGPL"
SECTION = "devel"

SRC_URI = "${SOURCEFORGE_MIRROR}/cppunit/cppunit-${PV}.tar.gz"

inherit autotools binconfig

CXXFLAGS_powerpc += "-lstdc++"

do_stage () {
	autotools_stage_includes
	cd ./src/cppunit/.libs/
	oe_libinstall -a -so libcppunit ${STAGING_LIBDIR}
}
