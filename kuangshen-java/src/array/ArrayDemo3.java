package array;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 13:34
 **/
public class ArrayDemo3 {
    public static void main(String[] args) {
        int[][] array1 = new int[11][11];
        array1[1][1] = 1;
        array1[1][2] = 2;


        System.out.println("原始数组：");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                System.out.print(array1[i][j] + "\t");
            }
            System.out.println();
        }

        // 原始数组转稀疏数组

        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效值的个数：" + sum);

        int[][] array2 = new int[sum + 1][3];
        array2[0][0] = 11;
        array2[0][1] = 11;
        array2[0][2] = sum;

        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != 0) {
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array1[i][j];
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] + "\t");
            }
            System.out.println();
        }

        // 稀疏数组转原数组
        int[][] array3 = new int[array2[0][0]][array2[0][1]];

        for (int i = 1; i < array2.length; i++) {
            array3[array2[i][0]][array2[i][1]] = array2[i][2];
        }

        System.out.println("还原数组：");
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                System.out.print(array3[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
