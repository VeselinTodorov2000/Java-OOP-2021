public class SquareMatrix {
    private int[][] dataArray;

    public SquareMatrix(int[][] newDataArray) {
        this.setDataArray(newDataArray);
    }

    public SquareMatrix() {
        int[][] newDataArray = new int[2][2];
        this.setDataArray(newDataArray);
    }

    public SquareMatrix(SquareMatrix other) {
        this.setDataArray(other.getDataArray());
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    public void setDataArray(int[][] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public String toString() {
        String converted = "";

        for(int row = 0; row < dataArray.length; row++)
        {
            for (int col = 0; col < dataArray.length; col++)
            {
                converted = String.format("%s%d ", converted, dataArray[row][col]);
            }
            converted = String.format("%s\n", converted);
        }

        return converted;
    }

    public int findMaxSum()
    {
        int maxSum = 0;
        int currentSum = 0;

        for (int row = 0; row < dataArray.length - 1; row++)
        {
            for(int col = 0; col < dataArray[row].length - 1; col++)
            {
                currentSum = dataArray[row][col] + dataArray[row+1][col] + dataArray[row][col+1] + dataArray[row+1][col+1];
                if(currentSum > maxSum)
                {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    public void printAll()
    {
        int maxSum = this.findMaxSum();
        int currentSum = 0;
        System.out.println(maxSum);

        for (int row = 0; row < dataArray.length - 1; row++)
        {
            for(int col = 0; col < dataArray[row].length - 1; col++)
            {
                currentSum = dataArray[row][col] + dataArray[row+1][col] + dataArray[row][col+1] + dataArray[row+1][col+1];
                if(currentSum == maxSum)
                {
                    System.out.printf("[%d, %d]\n", row, col);
                }
            }
        }
    }

}
