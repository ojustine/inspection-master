package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

import java.math.BigDecimal;

public class DataRowsHandlerVolume extends DataRowsHandlerBase {

	public DataRowsHandlerVolume() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (!report.getConfig().isNoVolume()) {
			BigDecimal volume = report.getData()[index].getVolume();
			strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", volume));
		}
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
