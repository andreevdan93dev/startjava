package lesson_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.FileSystems;
import java.time.LocalTime;


public class VariablesTheme {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        LocalTime startClock = LocalTime.now();
        printAsciiGraphic();
        System.out.println();
        calculateProductCost();
        System.out.println();
        swapExelCellValue();
        System.out.println();
        decodeMessage();
        System.out.println();
        analyzeProductCode();
        System.out.println();
        testingSensorsBeforeRocketLaunch();
        System.out.println();
        printJvmAndOsProperties();
        System.out.println();
        calculateCodeWorkingTime(startTime, startClock);
    }

    private static void printAsciiGraphic() {
        System.out.println("ВЫВОД ASCII-ГРАФИКИ");
        String janaConcatenation = "                     /\\\n" +
                "   J    a  v     v  /  \\\n" +
                "   J   a a  v   v  /_( )\\\n" +
                "J  J  aaaaa  V V  /      \\\n" +
                " JJ  a     a  V  /___/\\___\\";
        System.out.println(janaConcatenation);
        System.out.println();
        String javaTextBlock = """
                         /\\           \s
                   J    /  \\  v     v  a
                   J   /_( )\\  v   v  a a
                J  J  /      \\  V V  aaaaa
                 JJ  /___/\\___\\  V  a     a
                
                """;
        System.out.println(javaTextBlock);
        System.out.println();
    }

    private static void calculateProductCost() {
        System.out.println("РАСЧЕТ СТОИМОСТИ ТОВАРА");
        float penCost = 105.5F;
        float bookCost = 235.23F;
        int salePercent = 11;
        float totalCostWithoutSale = bookCost + penCost;
        System.out.println("стоимость товаров без скидки = " + totalCostWithoutSale);
        float saleSum = (salePercent * totalCostWithoutSale) / 100;
        System.out.println("сумма скидки = " + saleSum);
        float totalCostWithSale = totalCostWithoutSale - saleSum;
        System.out.println("стоимость товаров со скидкой = " + totalCostWithSale);
        System.out.println();

        BigDecimal bdPenCost = new BigDecimal("105.5");
        BigDecimal bdBookCost = new BigDecimal("235.23");
        BigDecimal bdSalePercent = new BigDecimal("0.11");
        BigDecimal bdTotalCostWithoutSale = bdPenCost.add(bdBookCost).setScale(2, RoundingMode.HALF_UP);
        System.out.println("стоимость товаров без скидки = " + bdTotalCostWithoutSale);
        BigDecimal bdSaleSum = bdTotalCostWithoutSale.multiply(bdSalePercent).setScale(2, RoundingMode.HALF_UP);
        System.out.println("сумма скидки = " + bdSaleSum);
        BigDecimal bdTotalCostWithSale = bdTotalCostWithoutSale.subtract(bdSaleSum).setScale(2, RoundingMode.HALF_UP);
        System.out.println(bdTotalCostWithSale);
    }

    private static void swapExelCellValue() {
        System.out.println("ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int A1 = 2;
        int B1 = 5;
        System.out.println("A1: " + A1);
        System.out.println("B1: " + B1);
        System.out.println("Метод: третьей переменной");
        int thirdValue = A1;
        A1 = B1;
        B1 = thirdValue;
        System.out.println("Результат: A1 = " + A1 + ", B1 = " + B1);
        System.out.println("Метод: арифметических операций");
        int substruct = A1 - B1;
        A1 -= substruct;
        B1 += substruct;
        System.out.println("Результат: A1 = " + A1 + ", B1 = " + B1);
        System.out.println("Метод:побитовой операции");
        int product = A1 ^ B1;
        A1 ^= product;
        B1 ^= product;
        System.out.println("Результат: A1 = " + A1 + ", B1 = " + B1);
    }

    private static void decodeMessage() {
        int asciiCode1 = 1055;
        int asciiCode2 = 1088;
        int asciiCode3 = 1080;
        int asciiCode4 = 1074;
        int asciiCode5 = 1077;
        int asciiCode6 = 1090;
        final int delimiter = 6;

        System.out.printf("%" + delimiter + "d%" + delimiter + "d%" + delimiter +
                        "d%" + delimiter + "d%" + delimiter + "d%" + delimiter + "d%n",
                asciiCode1, asciiCode2, asciiCode3, asciiCode4, asciiCode5, asciiCode6);
        System.out.printf("%" + delimiter + "c%" + delimiter + "c%" + delimiter +
                        "c%" + delimiter + "c%" + delimiter + "c%" + delimiter + "c%n",
                (char) asciiCode1, (char) asciiCode2, (char) asciiCode3,
                (char) asciiCode4, (char) asciiCode5, (char) asciiCode6);
    }

    private static void analyzeProductCode() {
        int productCode = 123;
        int productCategory = 123 / 100 % 10;
        int productSubCategory = 123 / 10 % 10;
        int packageType = 123 % 10;
        int controlSum = productCategory + productSubCategory + packageType;
        int verificationCode = productCategory * productSubCategory * packageType;
        System.out.printf("""
                        Код товара: %d
                          категория товара - %d
                          подкатегория - %d
                          тип упаковки - %d
                        Контрольная сумма = %d
                        Проверочный код = %d
                        """, productCode,
                productCategory,
                productSubCategory,
                packageType,
                controlSum,
                verificationCode);
    }

    private static void testingSensorsBeforeRocketLaunch() {
        byte temperature = Byte.MAX_VALUE;
        System.out.printf("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, temperature, ++temperature, --temperature);
        short pressure = Short.MAX_VALUE;
        System.out.printf("""
                [Давление, Па]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, pressure, ++pressure, --pressure);
        char systemStatusCode = Character.MAX_VALUE;
        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, (int) systemStatusCode, (int) ++systemStatusCode, (int) --systemStatusCode);
        int distanceTraveled = Integer.MAX_VALUE;
        System.out.printf("""
                [Пройденное расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, distanceTraveled, ++distanceTraveled, --distanceTraveled);
        long sinceLaunchTime = Long.MAX_VALUE;
        System.out.printf("""
                [Время с момента старта, мс]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, sinceLaunchTime, ++sinceLaunchTime, --sinceLaunchTime);
    }

    private static void printJvmAndOsProperties() {
        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();
        int availableProcessors = runtime.availableProcessors();

        double totalMemoryMB = totalMemory / 1024.0 / 1024.0;
        double freeMemoryMB = freeMemory / 1024.0 / 1024.0;
        double usedMemoryMB = usedMemory / 1024.0 / 1024.0;
        double maxMemoryMB = maxMemory / 1024.0 / 1024.0;

        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String fileSeparator = FileSystems.getDefault().getSeparator();
        String userDir = System.getProperty("user.dir");
        String systemDrive = userDir.substring(0, 2);

        System.out.printf("""
                        Информация о JVM
                        Доступное число ядер: %d
                        Выделенная память (МБ): %.1f
                        Свободная память (МБ): %.1f
                        Используемая память (МБ): %.1f
                        Максимально доступная память (МБ): %.1f
                        """,
                availableProcessors,
                totalMemoryMB,
                freeMemoryMB,
                usedMemoryMB,
                maxMemoryMB
        );

        System.out.printf("""
                Системная информация
                Системный диск: %s
                Версия ОС: %s %s
                Версия Java: %s
                Символ разделения пути: '%s'
                """.formatted(
                systemDrive,
                osName, osVersion,
                javaVersion,
                fileSeparator
        ));
    }

    private static void calculateCodeWorkingTime(long startTime, LocalTime startClock) {
        long endTime = System.nanoTime();
        LocalTime endClock = LocalTime.now();
        double elapsedTimeSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("""
                Старт проверки: %s
                Финиш проверки: %s
                Время работы:   %s
                """,
                startClock.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss.SSS")),
                endClock.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss.SSS")),
                elapsedTimeSeconds
        );
    }

}
