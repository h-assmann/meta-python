SUMMARY = "Linux Automation iobus"
HOMEPAGE = "https://github.com/linux-automation/lxa-iobus"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0674f4b6076ccd96a8b400a746f71dd3"

SRC_URI[sha256sum] = "76cf039d5ae02897f77c031f90fac20cdce9774099322d4f3cd145dce5b0c46f"

SRC_URI = " \
    file://80-can0-iobus.link \
    file://80-can0-iobus.network \
    file://lxa-iobus.service \
    "

do_install_append() {
    install -D -m0644 ${WORKDIR}/80-can0-iobus.link ${D}${libdir}/systemd/network/80-can0-iobus.link
    install -D -m0644 ${WORKDIR}/80-can0-iobus.network ${D}${libdir}/systemd/network/80-can0-iobus.network
    install -D -m0644 ${WORKDIR}/lxa-iobus.service ${D}${libdir}/systemd/system/lxa-iobus.service
}

FILES_${PN} += "${libdir}"

inherit pypi setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "full server shell"
PACKAGECONFIG[full] = ",,,python3-aiohttp-json-rpc python3-ipython"
PACKAGECONFIG[server] = ",,,python3-aiohttp-json-rpc"
PACKAGECONFIG[shell] = ",,,python3-ipython"

RDEPENDS_${PN} += "bash python3-aiohttp python3-aiohttp-json-rpc python3-asyncio python3-can python3-core python3-datetime python3-janus python3-json python3-logging python3-pprint"
