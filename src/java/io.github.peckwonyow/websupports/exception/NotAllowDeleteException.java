package io.github.peckwonyow.websupports.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author peckwon
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NotAllowDeleteException extends Exception {

    private String randomString;

    public NotAllowDeleteException(String randomString) {
        super("Unable to delete this record.");
        this.randomString = randomString;
    }
}
