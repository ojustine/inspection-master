package ru.iteco.reportutility.formatter;

import ru.iteco.reportutility.models.Report;

public interface DataRowsHandler {

	public void add(DataRowsHandler nextHandler);

	public void handle(StringBuilder strReport, String colSep, int colWidth, int index, Report report);

}
