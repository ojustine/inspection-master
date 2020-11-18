package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

public class DataRowsHandlerName extends DataRowsHandlerBase {

	public DataRowsHandlerName() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		String name = report.getData()[index].getName();
		strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", name));
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
