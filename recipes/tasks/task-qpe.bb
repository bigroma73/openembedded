DESCRIPTION = "Tasks for programs running on Qt/Embedded based Palmtop Environents like Opie and Qtopia."
SECTION = "opie/base"
LICENSE = "MIT"
PR = "r10"

inherit task

PACKAGES = "task-qpe-applets task-qpe-games task-qpe-inputmethods \
	task-qpe-multimedia task-qpe-emulators task-qpe-applications \
	task-qpe-fonts task-qpe-settings"

RDEPENDS_task-qpe-applets = "\
    subapplet \
    tasklistapplet"

RDEPENDS_task-qpe-applications = "\
    camera-assistant \
    cumulus \
    dviviewer \
    freenote \
    inkwp \
    iqnotes \
    justreader \
    keyring \
    klimt \
    kstars-embedded \
    ktimetrackerpi \
    mileage \
    militaryalphabet \
    notez \
    petitepainture \
    pocketcellar \
    poqetpresenter \
    portabase \
    qpdf2 \
    qpealarmclock \
    qpe-gaim \
    qpegps \
    qpenmapfe \
    qplot \
    qpphoto \
    resistorui \
    shopper \
    sliderulez \
    timesleuth \
    txdrug \
    tximage \
    ubahnnav \
    visiscript \
    xqt2 \
    zbedic \
    zbench \
    zgscore \
    zipsc \
    zlapspeed \
    zroadmap \
    zshopi"

RDEPENDS_task-opie-decorations = "\
    opie-deco-flat \
    opie-deco-liquid \
    opie-deco-polished"

RDEPENDS_task-qpe-games = "\
    aliens \
    aliens-qt \
    atomic \
    billiardz \
    brickout \
    checkers \
    crossword \
    fish \
    froot \
    gemdropx \
    glider \
    hexatrolic \
    iaimaster \
    icebloxx \
    knights \
    labyrinth \
    mahjongg \
    maki \
    nmm \
    pairs \
    pdamaze \
    pipeman \
    pipepanic \
    powermanga \
    puzz-le \
    qfish2 \
    qmatrix \
    shisensho \
    sokoban \
    tickypip \
    tickypip-levels \
    tron \
    vectoroids \
    win4 \
    zauralign \
    zddice \
    ziq \
    zmerlin \
    zrally \
    zrev7 \
    zsubhunt \
    ztappy \
    zudoku"

RDEPENDS_task-qpe-inputmethods = "\
    custominput \
    flexis-zaurus \
    irk-targus \
    irk-belkin"

RDEPENDS_task-qpe-multimedia = "\
    mplayer \
    sidplayer \
    xmms-embedded"

RDEPENDS_task-kdepim = "\
    kopi \
    kapi \
    kopi-applet"

RDEPENDS_task-qpe-emulators = "scummvm"

RDEPENDS_task-qpe-fonts = "\
    qpf-bitstream-vera-large \
    qpf-bitstream-vera-sans-mono-huge \
    qpf-freemono \
    qpf-freeserif \
    ttf-gentium \
    qpf-hunkysans \
    qpf-hunkyserif \
    qpf-qte \
    qpf-helvetica \
    qpf-unifont \
    qpf-utopia \
    qpf-terminus"

RDEPENDS_task-qpe-settings += "\
    qclockchange"

