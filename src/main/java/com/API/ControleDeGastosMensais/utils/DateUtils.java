package com.API.ControleDeGastosMensais.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String formatDate(String dataMoviment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dataMoviment,formatter);
        return localDateTime.format(formatter);
    }
}
