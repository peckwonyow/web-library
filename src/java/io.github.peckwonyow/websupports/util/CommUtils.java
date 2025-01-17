package io.github.peckwonyow.websupports.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author peckwon
 */
public class CommUtils {
    private static Logger logger = LoggerFactory.getLogger(CommUtils.class);

    public static Date parseDate(String format, String sDate) {
        try {
            return new SimpleDateFormat(format).parse(sDate);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Integer parseInt(Object o) {
        try {
            return Integer.parseInt(o.toString());
        } catch (Exception ex) {
            return 0;
        }
    }

    public static Long parseLong(Object o) {
        try {
            return Long.parseLong(o.toString());
        } catch (Exception ex) {
            return 0L;
        }
    }

    public static String parseString(Object o) {
        return o instanceof String ? o.toString() : null;
    }

    public static BigDecimal parseBigDecimal(Object o) {
        return new BigDecimal(CommUtils.parseInt(o));
    }

    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException ex) {
            logger.error(ex.toString(), ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    logger.error(ex.toString(), ex);
                }
            }
        }

        return sb.toString();

    }

    public static String randomAlphanumeric() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    public static String formatDate(String pattern, Date date) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
