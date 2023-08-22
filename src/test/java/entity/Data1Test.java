package entity;

import org.example.entity.Data1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Data1Test {

    Data1 dta = new Data1("Ignat", 75.6, true);
    @Test
    void print() {
        assertEquals("{\"name\":\"Ignat\",\"weight\":" + 75.6  + ",\"tattoo\":true}", dta.print());
    }
}