import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void isWeekDay() throws Exception{
        assertEquals(false, DateUtil.isWeekDay("2023/05/14"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/15"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/16"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/17"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/18"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/19"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/20"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/21"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/22"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/23"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/27"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/28"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("2023-03-01"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("アイウエオ"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("2023-03-1"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("2023-3-01"));
    }

    @Test
    void isSaturdayOrSunday() throws Exception{
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/14"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/15"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/16"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/17"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/18"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/19"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/20"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/21"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/22"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/23"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/27"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/28"));
    }

    @Test
    void getNationalHoliday() throws Exception {
        String[] expected = {
                "2023/01/01",
                "2023/01/02",
                "2023/01/09",
                "2023/02/11",
                "2023/02/23",
                "2023/03/21",
                "2023/04/29",
                "2023/05/03",
                "2023/05/04",
                "2023/05/05",
                "2023/07/17",
                "2023/08/11",
                "2023/09/18",
                "2023/09/23",
                "2023/10/09",
                "2023/11/03",
                "2023/11/23"
        };
        System.out.println("actual");
        String[] actual = DateUtil.getNationalHoliday(2023);
        System.out.println(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void isNationalHoliday() throws Exception {
        assertEquals(true, DateUtil.isNationalHoliday("2023/01/01"));
        assertEquals(true, DateUtil.isNationalHoliday("2023/01/02"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/03"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/04"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/05"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/06"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/07"));
    }

    @Test
    void isHoliday() throws Exception {
        assertEquals(true, DateUtil.isHoliday("2023/01/01"));
        assertEquals(true, DateUtil.isHoliday("2023/01/02"));
        assertEquals(false, DateUtil.isHoliday("2023/01/03"));
        assertEquals(false, DateUtil.isHoliday("2023/01/04"));
        assertEquals(false, DateUtil.isHoliday("2023/01/05"));
        assertEquals(false, DateUtil.isHoliday("2023/01/06"));
        assertEquals(true, DateUtil.isHoliday("2023/01/07"));
        assertEquals(true, DateUtil.isHoliday("2023/01/08"));
        assertEquals(true, DateUtil.isHoliday("2023/01/09"));
        assertEquals(true, DateUtil.isHoliday("2022/01/08"));
        assertEquals(true, DateUtil.isHoliday("2022/01/09"));
        assertEquals(true, DateUtil.isHoliday("2022/01/10"));
        assertEquals(false, DateUtil.isHoliday("2022/01/11"));
    }

    @Test
    void validateAndParseDate() throws ParseException {
        String inputDate = "2023-05-07";
        assertThrows(ParseException.class, () -> DateUtil.validateAndParseDate(inputDate));
        String inputDate2 = "2023/05/07";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 5 - 1, 7, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), DateUtil.validateAndParseDate(inputDate2));
    }

}