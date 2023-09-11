import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static boolean isPalindrome(String input){
        String date = input.replaceAll("[-.,/]", "");
        return date.equals(new StringBuilder(date).reverse().toString());
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear > toYear) {
            System.out.println("Start date bigger than end date");
            return;
        }

        LocalDate currentDate = LocalDate.parse(LocalDate.of(fromYear, 1, 1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LocalDate endDate = LocalDate.of(toYear, 12, 31);

        while (!currentDate.isAfter(endDate)) {
            if (isPalindrome(currentDate.toString())) {
                System.out.println(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2010,2015);
    }
}