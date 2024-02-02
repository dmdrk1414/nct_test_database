package org.example.myutill;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLocalDate {
    /**
     * "yyyy-MM-dd"을 보장 한다.
     * 생년월일의 문자열을 LocalDate으로 변환 한다.
     *
     * @param dateString "yyyy-MM-dd"의 문자열
     * @return
     */
    public static LocalDate parse2BirthDateFromString(String dateString) {
        // "yyyy-MM-dd" 형식으로 파싱하기 위한 DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 문자열을 LocalDate로 파싱
        return LocalDate.parse(dateString, formatter);
    }
}
