DESCRIPTION = "Mixed sync-async queue to interoperate between asyncio tasks and classic threads"
HOMEPAGE = "https://pypi.org/project/janus/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=23878c357ebb4c8ce1109be365043349"

SRC_URI[sha256sum] = "4712e0ef75711fe5947c2db855bc96221a9a03641b52e5ae8e25c2b705dd1d0c"

inherit pypi setuptools3

RDEPENDS_${PN} += "${PYTHON_PN}-asyncio ${PYTHON_PN}-core ${PYTHON_PN}-threading"
