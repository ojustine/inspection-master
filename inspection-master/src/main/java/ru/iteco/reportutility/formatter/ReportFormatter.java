package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

/*
 * Тут цепочка обязанностей. Сама по себе вроде получилась, но то что вышло конкретно в этом классе - фу.
 * Плохо спроектировал, а переделать уже некогда.
 */
public class ReportFormatter {
	private final String[] HEADER = {
										"№", "Наименование", "Объём упаковки", "Масса упаковки", "Стоимость",
										"Количество", "Суммарный объём", "Суммарный вес"
									};
	StringBuilder strReport;
	private String colSeparator;
	private int colWidth;
	private int index;

	protected ReportFormatter(String colSeparator, int colWidth) {
		this.colSeparator = colSeparator;
		this.colWidth = colWidth;
		this.strReport = new StringBuilder();
	}

	public String formatReport(Report report) {
		formatHeader(report);
		formatDataRows(report);
		formatReportRows(report);
		return strReport.toString();
	}

	private void formatHeader(Report report) {
		if (report.getConfig().isWithIndex()) {
			this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[0]));
		}
		this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[1]));
		if (!report.getConfig().isNoVolume()) {
			this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[2]));
		}
		if (!report.getConfig().isNoWeight()) {
			this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[3]));
		}
		if (!report.getConfig().isNoCost()) {
			this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[4]));
		}
		if (!report.getConfig().isNoCount()) {
			this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[5]));
		}
		if (report.getConfig().isWithTotalVolume()) {
			this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[6]));
		}
		if (report.getConfig().isWithTotalWeight()) {
			this.strReport.append(String.format("%" + colWidth + '.' + colWidth + "s", HEADER[7]));
		}
		strReport.append(System.lineSeparator());
	}

	private void formatDataRows(Report report) {
		DataRowsHandler handlers;
		if (report.getConfig().isWithIndex()) {
			handlers = new DataRowsHandlerIndex();
			handlers.add(new DataRowsHandlerName());
		} else {
			handlers = new DataRowsHandlerName();
		}
		if (!report.getConfig().isNoVolume()) {
			handlers.add(new DataRowsHandlerVolume());
		}
		if (!report.getConfig().isNoWeight()) {
			handlers.add(new DataRowsHandlerWeight());
		}
		if (!report.getConfig().isNoCost()) {
			handlers.add(new DataRowsHandlerCost());
		}
		if (!report.getConfig().isNoCount()) {
			handlers.add(new DataRowsHandlerCount());
		}
		if (report.getConfig().isWithTotalVolume()) {
			handlers.add(new DataRowsHandlerTotalVolume());
		}
		if (report.getConfig().isWithTotalWeight()) {
			handlers.add(new DataRowsHandlerTotalWeight());
		}
		for (int i = 0; i < report.getData().length; i++) {
			handlers.handle(strReport, colSeparator, colWidth, index++, report);
			strReport.append(System.lineSeparator());
		}
	}

	private void formatReportRows(Report report) {
		if (report.getRows() != null && report.getRows().size() != 0) {
			strReport.append("Итого:").append(System.lineSeparator());
			for (ReportRow reportRow : report.getRows()) {
				strReport.append(reportRow.getName()).append(" ").append(reportRow.getValue()).append(System.lineSeparator());
			}
		}
	}
}
