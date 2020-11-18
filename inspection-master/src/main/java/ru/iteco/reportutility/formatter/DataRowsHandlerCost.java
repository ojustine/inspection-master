package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

import java.math.BigDecimal;

public class DataRowsHandlerCost extends DataRowsHandlerBase {

	public DataRowsHandlerCost() {
		super();
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (!report.getConfig().isNoCost()) {
			BigDecimal cost = report.getData()[index].getCost();
			strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", cost));
		}
		super.handle(strReport, colSep, colWidth, index, report);
	}
}
