import java.util.LinkedList;
import java.util.List;

public interface Normalization {

    static List<List<Double>>  normalize(List<List<Double>> trainingTable, List<Double> observation){
        if (observation == null || observation.isEmpty() || trainingTable==null || trainingTable.isEmpty()){
            return trainingTable;
        }
        // I don't want to work on originals lists
        List<List<Double>> normalizedTable = new LinkedList<>();
        List<Double> copyList = new LinkedList<>(observation);
        for (List<Double> c1 : trainingTable){
            List<Double> tmp = new LinkedList<>(c1);
            normalizedTable.add(tmp);
        }
        normalizedTable.add(copyList);

        List<Double> maxValue = new LinkedList<>();
        List<Double> minValue = new LinkedList<>();
        for (int i=0; i<normalizedTable.get(0).size()-1; i++){
            maxValue.add(normalizedTable.get(0).get(i));
            minValue.add(normalizedTable.get(0).get(i));
        }

        for (int i=1; i<normalizedTable.size(); i++){
            for (int j=0; j<normalizedTable.get(0).size()-1; j++){
                if (maxValue.get(j)<normalizedTable.get(i).get(j)){
                        maxValue.set(j, normalizedTable.get(i).get(j));
                }
                if (minValue.get(j)>normalizedTable.get(i).get(j)){
                        minValue.set(j, normalizedTable.get(i).get(j));
                }
            }
        }

        double result;
        double x;

        for (List<Double> doubles : normalizedTable) {
            for (int j = 0; j < normalizedTable.get(0).size() - 1; j++) {
                x = doubles.get(j);
                result = (x - minValue.get(j)) / (maxValue.get(j) - minValue.get(j));
                doubles.set(j, result);
            }
        }

        return normalizedTable;
    }


}
