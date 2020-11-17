package ru.iteco.reportutility;

import org.apache.commons.lang.StringUtils;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;
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

    private static final String TAB = "\t";

    // //opt/git/iteco/dp/inspection/src/main/resources/table.txt -withData -weightSum -costSum
    // //opt/git/iteco/dp/inspection/src/main/resources/table.csv -withData -weightSum -costSum
    public static void main(String[] args) {
        ReportService service;
        try {
            System.out.println("");
            System.out.println("Enter the data for the report.");
            var input = new Scanner(System.in);
            var str = input.nextLine();
            System.out.println(str);
            var array = str.split(" ");

            service = getReportService(array);
            var report = service.createReport();
            printReport(report);
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

    private static void printReport(Report report) {
        if (report.getConfig().isWithData() && report.getData() != null && report.getData().length != 0) {
            var headerRow = "Наименование\tОбъём упаковки\tМасса упаковки\tСтоимость\tКоличество";

            if (report.getConfig().isWithIndex()) {
                headerRow = "№\t" + headerRow;
            }
            if (report.getConfig().isWithTotalVolume()) {
                headerRow = headerRow + "\tСуммарный объём";
            }
            if (report.getConfig().isWithTotalWeight()) {
                headerRow = headerRow + "\tСуммарный вес";
            }

            System.out.println(headerRow);
            for (int i = 0; i < report.getData().length; i++) {
                var dataRow = report.getData()[i];
                var str = (i + 1 + TAB + dataRow.getName() + ((i != 0) ? StringUtils.repeat(TAB, 2) : TAB)
                        + dataRow.getVolume() + StringUtils.repeat(TAB, 4) + dataRow.getWeight()
                        + StringUtils.repeat(TAB, 4) + dataRow.getCost() + StringUtils.repeat(TAB, 3)
                        + dataRow.getCount() + StringUtils.repeat(TAB, 3) + dataRow.getVolume().multiply(dataRow.getCount())
                        + StringUtils.repeat(TAB, 2) + dataRow.getWeight().multiply(dataRow.getCount()));
                System.out.println(str);
            }

            System.out.println();
        }

        if (report.getRows() != null && report.getRows().size() != 0) {
            System.out.println("Итого:");
            for (ReportRow reportRow : report.getRows()) {
                System.out.println(reportRow.getName() + TAB + reportRow.getValue());
            }
        }
    }


}
