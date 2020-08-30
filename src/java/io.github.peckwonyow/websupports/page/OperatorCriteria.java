package io.github.peckwonyow.websupports.page;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author peckwon
 */
@Data
@AllArgsConstructor
public class OperatorCriteria {

    public String operator;
    public Object value;
}
