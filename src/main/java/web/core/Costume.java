package web.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Costume {

    private int id;
    private String condition;
    private Date inventoryDate;
}
