package ru.grutsinav;

class StringToMatrix {
    private String newString;
    private String[][] secondString;
    private int[][] intMatrix;
    private int sum = 0;

    public StringToMatrix(String s) {
        this.newString = s;
    }

    private String[][] getStringDoubleArr() throws IndexOutOfBoundsException {
            String[] firstString = newString.split("\n");
            secondString = new String[firstString.length][];
            for (int i = 0; i < firstString.length; i++) {
                secondString[i] = firstString[i].split(" ");
            }


            if (4 != secondString.length){
                throw new IndexOutOfBoundsException("Массив не равен 4х4");
            }

            for (String[] x : secondString){
                if (x.length != 4){
                    throw new IndexOutOfBoundsException("Массив не равен 4х4");
                }
            }
            return secondString;
    }


    private int[][] convertStringArrToIntArr() throws NumberFormatException {
        intMatrix = new int[getStringDoubleArr().length][];
        for (int i = 0; i < getStringDoubleArr().length; i++) {
            intMatrix[i] = new int[getStringDoubleArr()[i].length];
            if(intMatrix.length != 4){
                throw new NumberFormatException("В массиве не все элементы - числа");
            }
            for (int j = 0; j < secondString[i].length; j++) {
                intMatrix[i][j] = Integer.parseInt(secondString[i][j]);
                if (intMatrix[i].length !=4 ) {
                    throw new NumberFormatException("В массиве не все элементы - числа");
                }
            }
        }
        return intMatrix;
    }

    private int getSumOfMatrix(){
        for (int[] x: convertStringArrToIntArr()) {
            for (int y : x) {
                sum += y;
            }
        }
        return sum;
    }

    public float getDivision() {
        return (float)getSumOfMatrix()/2;
    }
}









