package io.github.peckwonyow.websupports.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author peckwon
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InvalidIdException extends Exception {

    private String randomString;

    public InvalidIdException(String randomString) {
        super("Invalid ID");
        this.randomString = randomString;
    }
}
