package ru.iteco.reportutility.services;

import ru.iteco.reportutility.infrastructure.DataTransformerCreator;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * ReportServiceBase.
 *
 * @author Ilya_Sukhachev
 */
public abstract class ReportServiceBase implements ReportService {

    private final String[] args;

    protected ReportServiceBase(String[] args) {
        this.args = args;
    }

    @Override
    public Report createReport() {
        var config = parseConfig();
        var dataTransformer = DataTransformerCreator.createTransformer(config);

        var fileName = args[0];
        String text = null;
        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(e);
        }

        var data = getDataRows(text);
        return dataTransformer.transformData(data);
    }

    protected abstract DataRow[] getDataRows(String text);

    /*
     * Хотел здесь добавить Builder, но всё равно получается такой же список параметров.
     * Не вижу смысла в лишней прослойке.
     */
    private ReportConfig parseConfig() {
        var params = Arrays.asList(args);
        var config = new ReportConfig();

        config.setWithData(params.contains("-withData"));
        config.setWithIndex(params.contains("-withIndex"));
        config.setWithTotalVolume(params.contains("-withTotalVolume"));
        config.setWithTotalWeight(params.contains("-withTotalWeight"));
        config.setVolumeSum(params.contains("-volumeSum"));
        config.setWeightSum(params.contains("-weightSum"));
        config.setCostSum(params.contains("-costSum"));
        config.setCountSum(params.contains("-countSum"));
        config.setNoVolume(params.contains("-noVolume"));
        config.setNoWeight(params.contains("-noWeight"));
        config.setNoCost(params.contains("-noCost"));
        config.setNoCount(params.contains("-noCount"));

        return config;
    }

}
