package pro.sky;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Exception.NotFoundElemException;
import pro.sky.Exception.NullStringException;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Value.*;

class StringListImpTest {
    private StringListImp listImp;

    @BeforeEach
    void init() {
        listImp = new StringListImp(5);
    }

    @AfterEach
    void post() {
        LIST = new StringListImp(5);
        LIST.add(CAT);
        LIST.add(DOG);
    }

    @Test
    void addTestOne() {
        assertAll(() -> assertEquals("Murka", listImp.add(CAT)),
                () -> assertNotEquals(DOG, listImp.add(MOUSE)),
                () -> assertThrows(NullStringException.class, () -> listImp.add(null)));
    }

    @Test
    void addTestTwo() {
        assertAll(() -> assertEquals("Murka", listImp.add(0, CAT)),
                () -> assertEquals(CAT, listImp.getArrayList()[0]),
                () -> assertThrows(NullStringException.class,
                        () -> listImp.add(1, null)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> listImp.add(10, CAT)));
    }

    @Test
    void setTest() {
        assertAll(() -> assertEquals(MOUSE, LIST.set(0, MOUSE)),
                () -> assertNotEquals(CAT, LIST.set(0, MOUSE)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> listImp.set(10, CAT)),
                () -> assertThrows(NullStringException.class,
                        () -> listImp.set(0, null)));
    }

    @Test
    void removeOne() {
        assertAll(() -> assertEquals(CAT, LIST.remove("Murka")),
                () -> assertEquals(DOG, LIST.getArrayList()[0]),
                () -> assertThrows(NotFoundElemException.class,
                        () -> listImp.remove(MOUSE)));
    }

    @Test
    void removeTwo() {
        assertAll(() -> assertEquals(CAT, LIST.remove(0)),
                () -> assertEquals(DOG, LIST.getArrayList()[0]),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> listImp.remove(10)));
    }

    @Test
    void contains() {
        assertAll(() -> assertTrue(LIST.contains(CAT)),
                () -> assertFalse(LIST.contains(MOUSE))
        );
    }

    @Test
    void indexOfTest() {
        assertAll(() -> assertEquals(ONE, LIST.indexOf(DOG)),
                () -> assertEquals(MINUS_ONE, LIST.indexOf(MOUSE))
        );
    }
    @Test
    void lastIndexOfTest() {
        LIST.add(CAT);
        assertAll(() -> assertEquals(TWO, LIST.lastIndexOf(CAT)),
                () -> assertEquals(MINUS_ONE, LIST.lastIndexOf(MOUSE)));
    }
    @Test
    void getTest() {
        assertAll(() ->assertEquals(CAT, LIST.get(ZERO)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class,
                        () -> LIST.get(SIX)));
    }

    @Test
    void equalsTest() {
        StringListImp listNew = new StringListImp(5);
        listNew.add(CAT);
        listNew.add(DOG);
        assertAll(() -> assertThrows(NullStringException.class,
                () -> listImp.equals(null)),
                () -> assertTrue(listImp.equals(listNew)));
    }
    @Test
    void sizeTest() {
        assertAll(() -> assertEquals(TWO, LIST.size()),
                () -> assertNotEquals(ZERO, LIST.size()));
    }

    @Test
    void isEmptyTest() {
        assertAll(() -> assertTrue(listImp.isEmpty()),
                () -> assertFalse(LIST.isEmpty()));
    }

    @Test
    void clearTest() {
        LIST.clear();
        assertTrue(LIST.isEmpty());
    }

    @Test
    void toArrayTest() {
        assertThat(array).contains(LIST.toArray());
    }
}