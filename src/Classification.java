import java.util.*;

public interface Classification {
    static String classify(List<List<Double>> normalizedTable, int k){
        if (k<=0){
            System.out.println("invalid \"k\" value");
            System.exit(-1);
        }

        List<Distance> allNeighbours = new LinkedList<>();

        double distance = 0;
        for(int i=0; i<normalizedTable.size()-1; i++){
            for (int j=0; j<normalizedTable.get(i).size()-1; j++){
                distance += Math.pow((normalizedTable.get(normalizedTable.size()-1).get(j) - normalizedTable.get(i).get(j)), 2);
            }
            allNeighbours.add(new Distance(distance, normalizedTable.get(i).get(normalizedTable.get(i).size()-1)));
            distance=0;
        }

        Collections.sort(allNeighbours);

        List<Integer> as = Arrays.asList(0,0,0);
        for (int i=0; i<k && i<allNeighbours.size(); i++){
            switch ((int)allNeighbours.get(i).getTypeLength()) {
                case 11 -> as.set(0, as.get(0) + 1);
                case 15 -> as.set(1, as.get(1) + 1);
                case 14 -> as.set(2, as.get(2) + 1);
            }
        }
        switch (as.indexOf(Collections.max(as))){
            case 0: return "Iris-setosa";
            case 1: return "Iris-versicolor";
            case 2: return "Iris-virginica";
        }

        /*
//        int amountOfMax = Collections.frequency(as, Collections.max(as));
//        switch (amountOfMax){
//            case 3:
//                return allNeighbours.get(0).getType();
//            case 2:
//                int index = as.indexOf(Collections.max(as));
//                as.set(index, -1);
//                int r=0, t=0;  //first occurrence indexes
//                int sizee = allNeighbours.size();
//                switch (index){
//                    case 0:
//                            for (int i=0; i<k && i<sizee; i++){
//                                if (allNeighbours.get(i).getType().equals("Iris-setosa")){
//                                    r = i;
//                                    i=k;
//                                }
//                            }
//                        break;
//                    case 1:
//                        for (int i=0; i<k && i<sizee; i++){
//                            if (allNeighbours.get(i).getType().equals("Iris-versicolor")){
//                                r = i;
//                                i=k;
//                            }
//                        }
//                        break;
//                    case 2:
//                        for (int i=0; i<k && i<sizee; i++){
//                            if (allNeighbours.get(i).getType().equals("Iris-virginica")){
//                                r = i;
//                                i=k;
//                            }
//                        }
//                        break;
//                }
//
//                switch (as.indexOf(Collections.max(as))){
//                    case 0:
//                        for (int i=0; i<k && i<sizee; i++){
//                            if (allNeighbours.get(i).getType().equals("Iris-setosa")){
//                                t = i;
//                                i=k;
//                            }
//                        }
//                        break;
//                    case 1:
//                        for (int i=0; i<k && i<sizee; i++){
//                            if (allNeighbours.get(i).getType().equals("Iris-versicolor")){
//                                t = i;
//                                i=k;
//                            }
//                        }
//                        break;
//                    case 2:
//                        for (int i=0; i<k && i<sizee; i++){
//                            if (allNeighbours.get(i).getType().equals("Iris-virginica")){
//                                t = i;
//                                i=k;
//                            }
//                        }
//                        break;
//                }
//                if (r<t){
//                    switch (index){
//                        case 0: return "Iris-setosa";
//                        case 1: return "Iris-versicolor";
//                        case 2: return "Iris-virginica";
//                    }
//                } else {
//                    switch (as.indexOf(Collections.max(as))){
//                        case 0: return "Iris-setosa";
//                        case 1: return "Iris-versicolor";
//                        case 2: return "Iris-virginica";
//                    }
//                }
//
//            break;
//            case 1:
//                switch (as.indexOf(Collections.max(as))){
//                    case 0: return "Iris-setosa";
//                    case 1: return "Iris-versicolor";
//                    case 2: return "Iris-virginica";
//                }
//                break;
//        }

         */


    return "Something went wrong";
    }
}
