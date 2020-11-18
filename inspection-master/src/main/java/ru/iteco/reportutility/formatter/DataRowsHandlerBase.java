package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

public abstract class DataRowsHandlerBase implements DataRowsHandler {

	private DataRowsHandler next;

	public DataRowsHandlerBase() {
		this.next = null;
	}

	@Override
	public void add(DataRowsHandler nextHandler) {
		if (this.next != null) {
			this.next.add(nextHandler);
		} else {
			this.next = nextHandler;
		}
	}

	@Override
	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report) {
		if (this.next != null) {
			strReport.append(colSep);
			this.next.handle(strReport, colSep, colWidth, index, report);
		}
	}
}
