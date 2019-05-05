package programs.problems;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class DateConversionUtil {

    public static void main(String[] args) {

        System.out.println(ConvertDate("2016-08-17 07:10:32.000000"));
        System.out.println(ConvertDate("2016/08/17 07:10:32"));
        System.out.println(ConvertDate("20160817"));
        System.out.println(ConvertDate("17.08.2016 07:10"));
    }

    public static String ConvertDate(String inputDate) {

        DateTimeParser customParser = new DateTimeFormatterBuilder()
                .appendYear(4, 4)        //4 digit year (YYYY)
                .appendLiteral("-")
                .appendMonthOfYear(2)    //2 digit month (MM)
                .appendLiteral("-")
                .appendDayOfMonth(2)    //2 digit day (DD)
                .appendLiteral(" ")
                .appendHourOfDay(2)        //2 digit hour (hh)
                .appendLiteral(":")
                .appendMinuteOfHour(2)    //2 digit minute (mm)
                .appendLiteral(":")
                .appendSecondOfMinute(2)//2 digit second (ss)
                //optional 9 digit nanosecs
                .appendOptional(new DateTimeFormatterBuilder()
                        .appendLiteral(".")
                        .appendPattern("SSSSSSSSS")
                        .toParser())
                .toParser();

        // creating an array of all possible parsers we want to support in our date conversion util
        DateTimeParser[] parsers = {
                DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss").getParser(),
                DateTimeFormat.forPattern("yyyyMMdd").getParser(),
                DateTimeFormat.forPattern("dd.MM.yyyy HH:mm").getParser(),
                customParser
        };

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(null, parsers).toFormatter();


        DateTime date1 = formatter.parseDateTime(inputDate);

        return date1.toLocalDateTime().toString();

    }
}
