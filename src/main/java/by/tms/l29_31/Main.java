package by.tms.l29_31;

public class Main {
    public static void main(String[] args) {

        MatrixCollection matrixCollection = new MatrixCollection();

        matrixCollection.add(1, 0, 0);
        matrixCollection.add(1, 0, 1);
        matrixCollection.add(1, 1, 0);
        matrixCollection.add(1, 1, 1);
        matrixCollection.add(1, 2, 0);
        matrixCollection.add(1, 2, 1);

        //Работа с итератором:
        for (int i : matrixCollection) {
            System.out.println(i);
        }

        //Переопределен метод ToString:
        System.out.println(matrixCollection);
    }
}