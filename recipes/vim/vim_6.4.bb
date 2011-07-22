VIMVER = "64"

require vim.inc

PR = "${INC_PR}.1"

EXTRA_OECONF = "--enable-gui=none --disable-gtktest \
		--disable-xim --with-features=normal \
		--disable-gpm --without-x --disable-netbeans \
		--with-tlib=ncurses"

