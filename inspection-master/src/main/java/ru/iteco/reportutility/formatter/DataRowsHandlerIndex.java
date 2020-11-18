package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

public class DataRowsHandlerIndex extends DataRowsHandlerBase {

	public DataRowsHandlerIndex() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (report.getConfig().isWithIndex()) {
			strReport.append(String.format("%" + colWidth + '.' + colWidth + "d", index + 1));
		}
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
