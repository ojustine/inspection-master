package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

import java.math.BigDecimal;

public class DataRowsHandlerCount extends DataRowsHandlerBase {

	public DataRowsHandlerCount() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (!report.getConfig().isNoCount()) {
			BigDecimal count = report.getData()[index].getCount();
			strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", count));
		}
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
