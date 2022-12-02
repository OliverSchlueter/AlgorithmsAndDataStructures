package problems.leetcode;


public class NumberOfDaysBetweenTwoDates {

    /*
        https://leetcode.com/problems/number-of-days-between-two-dates/
     */

    public int daysBetweenDates(String date1, String date2)  {
        java.time.LocalDate d1 = java.time.LocalDate.parse(date1, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
        java.time.LocalDate d2 = java.time.LocalDate.parse(date2, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
        java.time.Duration diff = java.time.Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        return (int) Math.abs(diff.toDays());
    }
}
