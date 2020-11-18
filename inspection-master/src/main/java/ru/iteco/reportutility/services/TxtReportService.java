package ru.iteco.reportutility.services;

import ru.iteco.reportutility.models.DataRow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TxtReportService.
 *
 * @author Ilya_Sukhachev
 */
public class TxtReportService extends ReportServiceBase {

    public TxtReportService(String[] args) {
        super(args);
    }

    /*
     * Добавил lineSep вместо "\n" для мультиплатформенности
     * Теперь таблица сплитуется по любым blank-символам
     * Убрал бессмысленный лист
     */
    @Override
    protected DataRow[] getDataRows(String text) {
        var dataRows = new ArrayList<>();
        var lines = text.split(System.lineSeparator());

        for (int i = 1; i < lines.length; i++) {
            var items = lines[i].split("\\s+");
            if (items.length >= 5) {
                dataRows.add(new DataRow(items[0], new BigDecimal(items[1]), new BigDecimal(items[2]),
                        new BigDecimal(items[3]), new BigDecimal(items[4])));
            }
        }

        var result = new DataRow[dataRows.size()];
        result = dataRows.toArray(result);
        return result;
    }
}
