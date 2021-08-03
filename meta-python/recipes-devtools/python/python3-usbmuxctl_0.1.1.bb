SUMMARY = "Tool to control an USB-Mux from the command line"
HOMEPAGE = "https://github.com/linux-automation/usbmuxctl"
LICENSE = "LGPLv2.1 & LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[sha256sum] = "e4f3d4b9d37e01550ed7b777895f6c73543594d1ea34ab209d79f882a17a392d"
SRC_URI = " \
    file://99-usbmux.rules \
    "

do_install_append() {
    install -D -m0644 ${WORKDIR}/99-usbmux.rules ${D}${libdir}/udev/rules.d/99-usbmux.rules
}

FILES_${PN} += "${libdir}"

inherit pypi setuptools3

RDEPENDS_${PN} += "python3-core python3-json python3-logging python3-pyusb python3-termcolor"
