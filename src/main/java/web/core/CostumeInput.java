package web.core;

import lombok.Getter;

import java.util.Calendar;
import java.util.Date;

@Getter
public class CostumeInput {

    private int id;
    private String condition;

    public Costume toCostume() {
        return new Costume(id, condition, Calendar.getInstance().getTime());
    }
}
