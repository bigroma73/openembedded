/*  FreeNote for Sharp SLA300, B500, C7x0, C860 Linux PDA
	Copyright (C) 2003-2005 Joe Kanemori.<kanemori@ymg.urban.ne.jp>

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
/*
2005/02/27 FreeNote 1.11.10pre
�EPDF�̏o�͌`�����ꕔ�ύX
�E�C���|�[�g���̃o�Ofix

2005/01/04 FreeNote 1.11.6pre
�E�J�[�u���[�h�łW�̎���������悤�ɐ��`�G���W�������P

2004/10/17 FreeNote 1.10.0�����[�X
2004/02/12 ver 1.7.1pre
�E�t�H���g�d�l�̕ύX
�E�e�L�X�g�����̍�����
�E�e�L�X�g�{�b�N�X�̑��@�\��
*/
#include "fntextdialog.h"
#include <stdio.h>
#include <qcombobox.h>
#include <qfontdatabase.h>
#include <qcolor.h>
#include <qtoolbutton.h>
#include <qpalette.h>
#include <qmultilineedit.h>
#include "fncolordialog.h"

FNTextDialog::FNTextDialog(const QString& fontname, FNColorDialog* dlg, QWidget* parent, const char* name )
	:FNTextDialogBase(parent, name, true, 0), _pen(1), _colorSelector(dlg)
{
	static QFontDatabase fbase;
	QValueList<int> sizes = fbase.pointSizes(fontname);
	char buf[10];
	for (uint i = 0; i < sizes.count(); ++i) {
		sprintf(buf, "%d", sizes[i]);
		cboFontSize->insertItem(buf);
	}
	lines->setFont(QFont(fontname, 20));
}


FNTextDialog::~FNTextDialog()
{
}

void FNTextDialog::changeColor(QRgb c)
{
	fraColor->setBackgroundColor(QColor(c));
	_pen.setColor(QColor(c));
}

void FNTextDialog::choose(int v)
{
	_pen.setWidth(v);
}

void FNTextDialog::btnColor_Clicked()
{
	_colorSelector->setColor(_pen.color());
	_colorSelector->show();
	if (_colorSelector->exec()) {
		changeColor(_colorSelector->color().rgb());
	}
}

void FNTextDialog::setPen(const QPen& pen)
{
	_pen = pen;
	if (cboFontSize->count() <= (int)pen.width()) {
		_pen.setWidth(cboFontSize->count()-1);
	}
	cboFontSize->setCurrentItem(_pen.width());
	fraColor->setBackgroundColor(_pen.color());
}

const QPen& FNTextDialog::pen() const
{
	return _pen;
}
