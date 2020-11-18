package ru.iteco.reportutility.formatter;

/*
 * Пример builder'а.
 * Для каждого столбца можно было свои запилить, но уже не успеваю.
 */

public class ReportFormatterBuilder {

	private String colSeparator = " ";
	private int colWidth = 15;

	public ReportFormatterBuilder reset()
	{
		this.colSeparator = " ";
		this.colWidth = 15;
		return this;
	}

	public ReportFormatterBuilder columnSeparator(String separator)
	{
		this.colSeparator = separator;
		return this;
	}

	public ReportFormatterBuilder columnWidth(int width)
	{
		this.colWidth = width;
		return this;
	}

	public ReportFormatter build()
	{
		return new ReportFormatter(colSeparator, colWidth);
	}
}
