PR = "r3"
SRCDATE_${PN} = "20050904"
#Change to x.y.z+cvs${SRCDATE}-mco1 when 2.0.0 changes
PV = "2.0.0-cvs-mco1-${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

WEBCVSURL = "http://handhelds.org/cgi-bin/cvsweb.cgi/~checkout~/gaim"

SRC_URI = "cvs://anonymous@gaim.cvs.sourceforge.net/cvsroot/gaim;module=gaim \
	${WEBCVSURL}/no-superimposed-version-on-logo.patch;patch=1 \
	${WEBCVSURL}/01-optional-icons-in-dialogs.patch;patch=1 \
	${WEBCVSURL}/02-request-field-dialogs.patch;patch=1 \
	${WEBCVSURL}/03-blist-dialogs.patch;patch=1 \
	${WEBCVSURL}/04-saved-status-dialogs.patch;patch=1 \
	${WEBCVSURL}/05-statusbox-icon-size.patch;patch=1 \
	${WEBCVSURL}/06-account-dialogs.patch;patch=1 \
	${WEBCVSURL}/07-roomlist-dialog.patch;patch=1 \
	${WEBCVSURL}/define-pda-mode.patch;patch=1 \
	${WEBCVSURL}/desktop-name-2.0.0.patch;patch=1 \
	${WEBCVSURL}/docklet-icon-size.patch;patch=1 \
	${WEBCVSURL}/08-prefs-dialog.patch;patch=1 \
	${WEBCVSURL}/09-filetransfer-dialog.patch;patch=1 \
	${WEBCVSURL}/10-pda-default-settings.patch;patch=1 \
	file://gaim-OE-branding.patch;patch=1 \
	"

require gaim.inc

S = "${WORKDIR}/gaim"

CFLAGS += "-D_GNU_SOURCE"


DEPENDS += "startup-notification"

#include autopoint (gettext)
EXTRA_AUTORECONF = ""

#disable "X Session Management"... It is EVIL
EXTRA_OECONF += "--disable-sm --enable-startup-notification \
                 --with-gnutls-includes=${STAGING_INCDIR}"


