package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;

import java.math.BigDecimal;

public class DataRowsHandlerTotalVolume extends DataRowsHandlerBase {

	public DataRowsHandlerTotalVolume() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (!report.getConfig().isWithTotalVolume()) {
			DataRow row = report.getData()[index];
			BigDecimal totalVolume = row.getVolume().multiply(row.getCount());
			strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", totalVolume));
		}
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
