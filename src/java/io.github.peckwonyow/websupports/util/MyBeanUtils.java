package io.github.peckwonyow.websupports.util;


import io.github.peckwonyow.auditsupports.annotation.CreatedDate;
import io.github.peckwonyow.auditsupports.annotation.LastModifiedDate;
import io.github.peckwonyow.auditsupports.tools.AuditUtils;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;
import javax.persistence.Version;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author peckwon
 */
public class MyBeanUtils extends BeanUtils {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    private static String[] getNullPropertyNames(Object source) {

        Set<String> emptyNames = new HashSet<>();

        for (Field f : AuditUtils.getSuperClass(source)) {

            LastModifiedDate lastModifiedDate = f.getAnnotation(LastModifiedDate.class);
            CreatedDate createdDate = f.getAnnotation(CreatedDate.class);
            Version version = f.getAnnotation(Version.class);
            Id id = f.getAnnotation(Id.class);

            String fieldName = f.getName();

            if (lastModifiedDate != null || createdDate != null || version != null || id != null) {
                emptyNames.add(fieldName);
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
