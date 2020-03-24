package logic;

public class Testtask {
    private final static String URL = "http://www.mocky.io/v2/5c51b9dd3400003252129fb5";
    private final static int MAX_THREADS_COUNT = 4;

    public static void main(String... args) {
        System.out.println(DataUtils.aggregateResults(URL, MAX_THREADS_COUNT));
    }

}
