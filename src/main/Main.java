package main;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n");
        // 1.
        System.out.printf("\nresult4_1 = " + getDayOfTheWeek(2));
        // 2.
        System.out.printf("\nresult4_2 = " + getString(101));
        // 3.
        System.out.printf("\nresult4_3 = " + getNumber("Сто Один"));
        // 4.
        System.out.printf("\nresult4_4 = " + getCartesianDistance(3, 5, -2, 7));
        // 5.
        // undefined
        // 6.
        // undefined
    }
    
    public static int getCartesianDistance(int a, int b, int c, int d) {
        int P = (c - a);
        int Q = (d - b);
        return getSqrt(P*P - Q*Q);
    }

    public static int getSqrt(int number) {
        int i = 0;
        int temp = 0;

        while(temp < number) {
            i++;
            temp = i*i;
        }

        return i - 1;
    }
    
    public static int getNumber(String str) {
        String zero   = "Ноль";
        int[] arrayResNumber = {};
        int resultNumber = 0;
        int fstNumber = 0;
        int scdNumber = 0;
        int thdNumber = 0;

        String[] parts = str.split(" ");
        int calcAmount = parts.length;
        
        if (str.equals(zero)) {
            resultNumber = 0;
        }

        else if(calcAmount == 1) {

            arrayResNumber = getNumber_1_9(str);

            if(arrayResNumber[0] != 1) {
                arrayResNumber = getNumber_10_90(str);
            }

            if(arrayResNumber[0] != 1) {
                arrayResNumber = getNumber_11_19(str);
            }

            resultNumber = arrayResNumber[1];
        }

        else if(calcAmount == 2) {
            String part1 = parts[0];
            String part2 = parts[1];

            arrayResNumber = getNumber_10_90(part1);

            if(arrayResNumber[0] != 1) {
                arrayResNumber = getNumber_100_900(part1);
            }

            fstNumber = arrayResNumber[1];

            /*
            | part2
            */

            arrayResNumber = getNumber_1_9(part2);

            if(arrayResNumber[0] != 1) {
                arrayResNumber = getNumber_11_19(part2);
            }

            if(arrayResNumber[0] != 1) {
                arrayResNumber = getNumber_10_90(part2);
            }

            scdNumber = arrayResNumber[1];
            

            resultNumber = fstNumber + scdNumber;
            
        }

        else if(calcAmount == 3) {
            String part1 = parts[0];
            String part2 = parts[1];
            String part3 = parts[2];

            arrayResNumber = getNumber_100_900(part1);
            fstNumber = arrayResNumber[1];

            arrayResNumber = getNumber_10_90(part2);
            scdNumber = arrayResNumber[1];

            arrayResNumber = getNumber_1_9(part3);
            thdNumber = arrayResNumber[1];

            resultNumber = fstNumber + scdNumber + thdNumber;

        }
        else throw new IllegalArgumentException();

        return resultNumber;
    }

    public static int[] getNumber_1_9(String str) {
        String[] arrayString_1_9     = {"Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять"};
        
        int resultNumber = 0;
        int finded = 0;
        
        for(int i=0;i<arrayString_1_9.length;i++) {
            if(str.equals(arrayString_1_9[i])) {
                resultNumber = (i+1);
                finded = 1;
                break;
            }
        }
        return new int[]{finded,resultNumber};
    }

    public static int[] getNumber_10_90(String str) {
        String[] arrayString_10_90   = {"Десять", "Двадцать", "Тридцать", "Сорок", "Пятьдесят", "Шестьдесят", "Семьдесят","Восемьдесят", "Девяносто"};

        int resultNumber = 0;
        int finded = 0;

        for(int i=0;i<arrayString_10_90.length;i++) {
            if(str.equals(arrayString_10_90[i])) {
                resultNumber = (i+1) * 10;
                finded = 1;
                break;
            }
        }
        return new int[]{finded,resultNumber};
    }

    public static int[] getNumber_100_900(String str) {
        String[] arrayString_100_900 = {"Сто", "Двести", "Триста", "Четыреста", "Пятьсот", "Шестьсот", "Семьсот", "Восемьсот", "Девятьсот"};

        int resultNumber = 0;
        int finded = 0;

        for(int i=0;i<arrayString_100_900.length;i++) {
            if(str.equals(arrayString_100_900[i])) {
                resultNumber = (i+1) * 100;
                finded = 1;
                break;
            }
        }
        return new int[]{finded,resultNumber};
    }

    public static int[] getNumber_11_19(String str) {
        String[] arrayString_11_19   = {"Одинадцать", "Двенадцать", "Тринадцать", "Четырнадцать", "Пятнадцать", "Шестнадцать", "Семнадцать", "Восемнадцать", "Девятнадцать"};

        int resultNumber = 0;
        int finded = 0;

        for(int i=0;i<arrayString_11_19.length;i++) {
            if(str.equals(arrayString_11_19[i])) {
                resultNumber = (i+1) + 10;
                finded = 1;
                break;
            }
        }
        return new int[]{finded,resultNumber};
    }

    public static String getDayOfTheWeek(int number) {
        String[] week = {"Пон", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"};
        return week[number];
    }
    
    public static String getString(int number) {
        String zero   = "Ноль";
        String result = "";
        int calcAmount = calcAmount(number);

        if(calcAmount == 0) {
            result = zero;
        }
        
        else if(calcAmount == 1) {
            result = getFstString(number);
        }

        else if(calcAmount == 2) {
            result = getScdString(number);
        }
        
        else if(calcAmount == 3) {
            result = getThdString(number);
        } 
        
        else throw new IllegalArgumentException();

        return result;
    }
    
    public static int calcAmount(int number) {

        int calcAmount = 0;
        while(number > 0) {
            number = number / 10;
            calcAmount++;
        }
        
        return calcAmount;
    }
    
    public static String getFstString(int number) {
        String[] numbers_1_9     = {"Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять"};
        return numbers_1_9[number - 1];
    }
    
    public static String getScdString(int number) {
        String result;

        String[] numbers_11_19   = {"Одинадцать", "Двенадцать", "Тринадцать", "Четырнадцать", "Пятнадцать", "Шестнадцать", "Семнадцать", "Восемнадцать", "Девятнадцать"};
        String[] numbers_10_90   = {"Десять", "Двадцать", "Тридцать", "Сорок", "Пятьдесят", "Шестьдесят", "Семьдесят","Восемьдесят", "Девяносто"};


        int scdNumber =  number % 10;

        if(scdNumber == 0) {
            result = numbers_10_90[number / 10 - 1];
        }
        else {
            if (number < 10) {
                result = getFstString(number);
            }
            else if (number > 10 && number < 20) {
                result = numbers_11_19[number % 10 -1];
            }
            else {
                result = numbers_10_90[number / 10 - 1] + " " + getFstString(number % 10);
            }
        }

        return result;
    }

    public static String getThdString(int number) {
        String[] numbers_100_900 = {"Сто", "Двести", "Триста", "Четыреста", "Пятьсот", "Шестьсот", "Семьсот", "Восемьсот", "Девятьсот"};
        int fstNumber =  number / 100;
        String scdNumber = (number % 100) == 0 ? "" : getScdString(number % 100);
        return numbers_100_900[fstNumber - 1] + " " + scdNumber;
    }
}
