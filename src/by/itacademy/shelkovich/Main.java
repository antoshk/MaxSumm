package by.itacademy.shelkovich;

public class Main {

    public static void main(String[] args) {
        int digits[] = {-10, 1,-2, 9, 15, -186, 250, -5, -17, 1, -258, 25, 70, -10, 17, 18, -19, -20, 50, 51, 47, -200, 200, -1, 1, 60};
        int start = 0, end = 0, startRes = 0, endRes = 0, sum = 0, sumEnd = Integer.MIN_VALUE, buffer = 0;

        for (int i = 0; i < digits.length; i++) {
            if (sum + digits[i] > 0) { //Если новый элемент группы не делает сумму элементов группы меньше ноля, то добавляем его в группу.
                if (sum == 0) start = i;
                else {
                    if (digits[i] > 0 && buffer + digits[i] > 0) {
                        end = i;
                        buffer = 0;
                    }
                    else if (digits[i] < 0 || buffer + digits[i] <= 0) buffer += digits[i]; //Если попадается отрицательный элемент, то не двигаем правую границу группы, пока не убедимся, что следом идут положительные числа, которые его компенсируют
                }
                sum += digits[i];
            } else { //Если новый элемент группы делает сумму меньше ноля, значит считаем сумму элементов этой группы, запоминаем границы, если сумма больше, чем у предыдущей группы и начинаем собирать новую группу.
                sum = 0;
                for(int k=start; k<=end; k++) sum+=digits[k];
                if (sum > sumEnd) {
                    sumEnd = sum;
                    startRes = start;
                    endRes = end;
                }
                buffer = 0;
                sum = 0;
                end = i+1;
            }
        }
        sum=0;
        for(int k=start; k<=end; k++) sum+=digits[k];
        if (sum > sumEnd) System.out.println(start+" "+end + " "+ sum);
        else System.out.println(startRes+" "+endRes + " "+ sumEnd);
    }
}
