DESCRIPTION = "SQLObject is an object-relational mapper. It allows you to translate RDBMS \
table rows into Python objects, and manipulate those objects to transparently \
manipulate the database."
SECTION = "devel/python"
HOMEPAGE = "http://www.sqlobject.org/"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "SQLObject"
PR = "ml0"

SRC_URI = "http://cheeseshop.python.org/packages/source/S/SQLObject/SQLObject-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS = "python-formencode"
