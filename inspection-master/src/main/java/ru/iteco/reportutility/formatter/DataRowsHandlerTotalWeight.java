package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;

import java.math.BigDecimal;

public class DataRowsHandlerTotalWeight extends DataRowsHandlerBase {

	public DataRowsHandlerTotalWeight() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (!report.getConfig().isWithTotalWeight()) {
			DataRow row = report.getData()[index];
			BigDecimal totalWeight = row.getWeight().multiply(row.getCount());
			strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", totalWeight));
		}
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
