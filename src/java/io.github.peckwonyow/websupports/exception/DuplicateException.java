package io.github.peckwonyow.websupports.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * @author peckwon
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DuplicateException extends Exception {

    private HashMap<String, String> map;
    private String randomString;

    public DuplicateException(String randomString, HashMap<String, String> map) {
        super("Duplicate");
        this.randomString = randomString;
        this.map = map;
    }
}
