package io.github.peckwonyow.websupports.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * @author peckwon
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InvalidValueException extends Exception {

    private HashMap<String, String> map;
    private String randomString;

    public InvalidValueException(String randomString) {
        super("Invalid Value");
        this.randomString = randomString;
    }
}
