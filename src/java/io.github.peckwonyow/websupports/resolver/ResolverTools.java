package io.github.peckwonyow.websupports.resolver;

import io.github.peckwonyow.websupports.annotation.JsonToUpperCase;
import io.github.peckwonyow.websupports.util.CommUtils;

import java.lang.reflect.Field;

/**
 * @author peckwon
 */
public class ResolverTools {

    public static void setToUpperCase(Field f, Object o) throws Exception {

        JsonToUpperCase jsonToUpperCase = f.getAnnotation(JsonToUpperCase.class);

        if (jsonToUpperCase != null) {

            f.setAccessible(true);
            Object value = f.get(o);

            if (CommUtils.parseString(value) != null) {

                if (f.getType().isAssignableFrom(String.class)) {
                    f.set(o, CommUtils.parseString(value).trim().toUpperCase());

                }
            }
        }
    }
}
