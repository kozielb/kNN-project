import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Data {
    final private List<List<Double>> x;

    public Data(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);
        x = new LinkedList<>();
        while (scanner.hasNext()){
            List<Double> row = new LinkedList<>();
            String line = scanner.nextLine();
            line = line.replaceAll(",",".");
            LinkedList<String> tmp = new LinkedList<>(Arrays.asList(line.trim().split("\\s+")));
            for (int i=0; i < tmp.size()-1; i++){
                row.add(Double.parseDouble(tmp.get(i)));
            }
            row.add((double) tmp.get(tmp.size() - 1).length());
            x.add(row);
        }
        if (x.isEmpty()){
            System.out.println("File is empty");
            System.exit(-1);
        }
    }

    public List<List<Double>> getX() {
        return x;
    }
}
