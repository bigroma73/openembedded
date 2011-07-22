require vim_${PV}.bb

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/vim-${PV}"

EXTRA_OECONF = "--enable-gui=none --disable-gtktest \
		--disable-xim --with-features=tiny \
		--disable-gpm --without-x --disable-netbeans \
		--with-tlib=ncurses"

