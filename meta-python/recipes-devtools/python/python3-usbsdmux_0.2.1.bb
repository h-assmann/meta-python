SUMMARY = "Tool to control an usb-sd-mux from the command line"
HOMEPAGE = "https://github.com/pengutronix/usbsdmux"
LICENSE = "LGPLv2.1 & LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[sha256sum] = "802c704798f1ce41f6d81ea7c41c007741e9c163088ffce9e5544e274216abb7"

SRC_URI = " \
    file://99-usbsdmux.rules \
    "

do_install_append() {
    install -D -m0644 ${WORKDIR}/99-usbsdmux.rules ${D}${libdir}/udev/rules.d/99-usbsdmux.rules
}

FILES_${PN} += "${libdir}"

inherit pypi setuptools3

RDEPENDS_${PN} += "python3-core python3-ctypes python3-stringold"


