require ntp.inc

PR = "r5"

SRC_URI = "http://www.eecis.udel.edu/~ntp/ntp_spool/ntp4/ntp-4.1/ntp-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://readline.patch;patch=1 \
	   file://ntpdate \
	   file://ntp"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/ntpdate ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/ntp ${D}${sysconfdir}/init.d
	echo "server pool.ntp.org" >${D}${sysconfdir}/ntp.conf
}

pkg_postinst_ntpdate() {
if test "x$D" != "x"; then
	exit 1
else
	if ! grep -q ntpdate /etc/cron/crontabs/root >/dev/null 2>&1; then
		echo "adding crontab"
		test -d /etc/cron/crontabs || mkdir -p /etc/cron/crontabs
		echo "30 * * * *    ${bindir}/ntpdate -s -u pool.ntp.org" >> /etc/cron/crontabs/root
	fi

	# Dunno why this is here, ask the "nylon" guys :)
	test -x /etc/init.d/busybox-cron && update-rc.d -s busybox-cron defaults

	update-rc.d -s ntpdate defaults 30
fi
}

pkg_postrm_ntpdate() {
	update-rc.d -f ntpdate remove
}

pkg_postinst_ntp() {
	update-rc.d -s ntp defaults 31
}

pkg_postrm_ntp(){
	update-rc.d -f ntp remove
}

