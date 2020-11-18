package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

import java.math.BigDecimal;

public class DataRowsHandlerWeight extends DataRowsHandlerBase {

	public DataRowsHandlerWeight() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (!report.getConfig().isNoWeight()) {
			BigDecimal weight = report.getData()[index].getWeight();
			strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", weight));
		}
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
