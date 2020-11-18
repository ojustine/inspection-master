package ru.iteco.reportutility;

import ru.iteco.reportutility.formatter.ReportFormatter;
import ru.iteco.reportutility.formatter.ReportFormatterBuilder;
import ru.iteco.reportutility.services.CsvReportService;
import ru.iteco.reportutility.services.ReportService;
import ru.iteco.reportutility.services.TxtReportService;
import ru.iteco.reportutility.services.XlsxReportService;

import java.util.Scanner;

/**
 * Main.
 *
 * @author Ilya_Sukhachev
 */
public class Main {

    public static void main(String[] args) {
        ReportService service;
        try {
            System.out.println();
            System.out.println("Enter the data for the report:");
            var input = new Scanner(System.in);
            var str = input.nextLine();
            System.out.println(str);

            var array = str.split(" ");

            service = getReportService(array);
            var report = service.createReport();

            ReportFormatterBuilder builder = new ReportFormatterBuilder().columnSeparator("\t").columnWidth(15);
            ReportFormatter formatter = builder.build();
            System.out.println(formatter.formatReport(report));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static ReportService getReportService(String[] args) throws Exception {
        var filename = args[0];

        if (filename.endsWith(".txt")) {
            return new TxtReportService(args);
        }

        if (filename.endsWith(".csv")) {
            return new CsvReportService(args);
        }

        if (filename.endsWith(".xlsx")) {
            return new XlsxReportService(args);
        }

        throw new Exception("this extension not supported");
    }
}
