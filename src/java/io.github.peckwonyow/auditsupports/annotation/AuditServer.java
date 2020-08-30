package io.github.peckwonyow.auditsupports.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import io.github.peckwonyow.auditsupports.enums.AuditAction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
public @interface AuditServer {

    AuditAction value() default AuditAction.USER;
}
