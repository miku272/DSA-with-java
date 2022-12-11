public class SmitAssign {
    public static void main(String[] args) {
        int characters = 40, count = 0;
        String[][] data = {{"Country", "Province", "State"}, {"Dog", "Giraffe", "Mouse"}};

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                count = characters - data[i][j].length() - 1;

                System.out.print(data[i][j] + " ");

                while (count > 0) {
                    System.out.print('*');
                    count--;
                }
                System.out.print('\n');
            }
        }
    }
}
