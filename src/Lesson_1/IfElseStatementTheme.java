package Lesson_1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        translatePseudocodeToJava();
        System.out.println();
        searchMaxStepCount();
        guestCountCheck();
        System.out.println();
        resolveFirstNicknameSymbol();
        System.out.println();
        inventory();
        System.out.println();
        calculateCashOfBank();
        System.out.println();
        resolveDisciplineBall();
        System.out.println();
        calculateYearProfit();
        System.out.println();
    }

    private static void translatePseudocodeToJava() {
        System.out.println("ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean isMailGender = true;
        if (!isMailGender) {
            System.out.println("Пол женский");
        } else {
            System.out.println("Пол мужской");
        }

        int age = 19;
        if (age > 18) {
            System.out.println("Возраст больше 18");
        } else {
            System.out.println("Возраст меньше или равен 18");
        }

        double growth = 1.75;
        if (growth > 1.8) {
            System.out.println("Рост больше 1 метра 80 сантиметров");
        } else {
            System.out.println("Гном");
        }
    }

    private static void searchMaxStepCount() {
        System.out.println("ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");
        int mondaySteps = 13689;
        int tuesdaySteps = 15687;

        System.out.println("mondaySteps = " + mondaySteps);
        System.out.println("tuesdaySteps = " + tuesdaySteps);

        if (mondaySteps > tuesdaySteps) {
            System.out.println("В понедельник шагов больше");
        } else if (mondaySteps < tuesdaySteps) {
            System.out.println("Во вторник шагов больше");
        } else {
            System.out.println("Шаги во вторник и понедельник равны");
        }

        int avgSteps = (mondaySteps + tuesdaySteps) / 2;
        System.out.println("среднее кол-во шагов = " + avgSteps);
    }

    private static void guestCountCheck() {
        System.out.println("ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestCount = 13;
        System.out.println("Количество гостей = " + guestCount);
        if (guestCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestCount % 2 == 0) {
            System.out.printf("Записалось %d гостей. Можно формировать пары для конкурсов\n", guestCount);
        } else if (guestCount % 2 > 0) {
            System.out.printf("Записалось %d гостей. Нужны индивидуальные задания.\n", guestCount);
        } else if (guestCount < 0) {
            System.out.println("Количество гостей меньше нуля. Ошибка");
        }
    }

    private static void resolveFirstNicknameSymbol() {
        System.out.println("ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String nickname = "DevastratorDesintegrator";
        System.out.println("nickname = " + nickname);
        char firstSymbol = nickname.charAt(0);
        if (Character.isUpperCase(firstSymbol)) {
            System.out.printf("Имя %s начинается с большой буквы '%c'\n", nickname, firstSymbol);
        }  else if (Character.isLowerCase(firstSymbol)) {
            System.out.printf("Имя %s начинается с маленькой  буквы '%c'\n", nickname, firstSymbol);
        } else if (Character.isDigit(firstSymbol)) {
            System.out.printf("Имя %s начинается с цифры '%c'\n", nickname, firstSymbol);
        } else {
            System.out.printf("Имя %s начинается с символа '%c'\n", nickname, firstSymbol);
        }
    }

    private static void inventory() {
        System.out.println("ИНВЕНТАРИЗАЦИЯ");
        int dbSerialNumber = 321;
        int pcNumber = 341;
        if (dbSerialNumber == pcNumber) {
            System.out.printf("[№%d]: компьютер на 3-м этаже в кабинете 2\n", dbSerialNumber);
        } if (dbSerialNumber != pcNumber) {
            System.out.printf("[№%d]: оборудование не идентифицировано\n", dbSerialNumber);
        }

        String strDbSerialNumber = String.valueOf(dbSerialNumber);
        String strPcNumber = String.valueOf(pcNumber);
        StringBuilder eqResult = new StringBuilder();
        for (int i = 0; i < strDbSerialNumber.length(); i++) {
            if (strDbSerialNumber.charAt(i) == strPcNumber.charAt(i)) {
                eqResult.append(strDbSerialNumber.charAt(i));
            } else {
                eqResult.append('_');
            }
        }
        if (!eqResult.equals("___")) {
            System.out.printf("""
                    Нет полного совпадения:
                    База данных: [№%s]
                    Фактический: [№%s]
                    """, strDbSerialNumber, eqResult.toString());
        }
    }

    private static void calculateCashOfBank() {
        float cash = 321123.79f;
        float percent;
        if (cash < 100_000) {
            percent = 0.05f;
        } else if (cash > 100_000 && cash < 300_000) {
            percent = 0.07f;
        } else {
            percent = 0.1f;
        }
        System.out.println("Сумма вклада = " + cash);
        float profit = cash * percent;
        System.out.println("Сумма начисленнго = " + profit);
        System.out.println("Итоговая сумма = " + (cash + profit));

        System.out.println();

        BigDecimal bgCash = new BigDecimal("321123.79");
        BigDecimal bgPercent;
        if (cash < 100_000) {
            bgPercent = new BigDecimal("0.05");
        } else if (cash > 100_000 && cash < 300_000) {
            bgPercent = new BigDecimal("0.07");
        } else {
            bgPercent = new BigDecimal("0.1");
        }
        System.out.println("Сумма вклада = " + bgCash);
        BigDecimal bgProfit = bgCash.multiply(bgPercent).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Сумма начисленнго = " + bgProfit);
        System.out.println("Итоговая сумма = " + bgCash.add(bgProfit).setScale(2, RoundingMode.HALF_UP));
    }


    private static void resolveDisciplineBall() {
        float historyScore = 59;
        float developmentScore = 92;
        int historyBall = resolveBall(historyScore);
        int developmentBall = resolveBall(developmentScore);
        System.out.println("История: " + historyBall);
        System.out.println("Програмирование: " + developmentBall);
        float avgScore = (historyScore + developmentScore) / 2;
        float avgBall = (float) (historyBall + developmentBall) / 2;
        System.out.printf("Средний процент по предметам = %S\n", avgScore);
        System.out.printf("Средний балл по предметам = %S\n",  avgBall);
    }

    private static int resolveBall(float score) {
        int ball = 2;
        if (score < 60) {
            return 2;
        }
        if (score > 60) {
            ball++;
        }
        if (score > 73) {
            ball++;
        }
        if (score > 91) {
            ball++;
        }
        return ball;
    }

    private static void calculateYearProfit() {
        BigDecimal bgYearProfit = new BigDecimal("14124.743");
        BigDecimal arend = new BigDecimal("5123.018");
        BigDecimal selfCost = new BigDecimal("9001.729");
        StringBuilder stringBuilder =  new StringBuilder("Прибыль за год: ");
        BigDecimal credit = arend.add(selfCost);
        BigDecimal resultProfit = bgYearProfit.subtract(credit).setScale(2, RoundingMode.HALF_UP);
        if (resultProfit.compareTo(BigDecimal.valueOf(0)) > 0) {
            stringBuilder.append("+");
        }

        stringBuilder.append(resultProfit);
        stringBuilder.append(" руб.");
        System.out.println(stringBuilder);
    }
}
