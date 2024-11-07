package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class encryptTest {

    @Test
    void encryptAlpabet() {
        String exp = "nopqrstuvwxyzabcdefghijklm";

        String test1 = "4k2n";
        String test2 = "4k.2n";
        String test3 = "4K-2n";
        String test4 = "4k 2n";

        String res1 = encrypt.encryptAlpabet(test1);
        String res2 = encrypt.encryptAlpabet(test2);
        String res3 = encrypt.encryptAlpabet(test3);
        String res4 = encrypt.encryptAlpabet(test4);

        assertAll(
                () -> assertEquals(exp, res1),
                () -> assertEquals(exp, res2),
                () -> assertEquals(exp, res3),
                () -> assertEquals(exp, res4)
        );
    }

    @ParameterizedTest
    @CsvSource({
      "hi,5n,uv",
      "test,l2j,cnbc"
    })
    void encryptString(String test, String key, String exp) {
        String res = encrypt.encryptString(test, key);

        assertEquals(exp, res);
    }

    @ParameterizedTest
    @CsvSource({
            "uv,5n,hi",
            "cnbc,l2j,test"
    })
    void decryptString(String test, String key, String exp) {
        String res = encrypt.decryptString(test, key);

        assertEquals(exp, res);
    }
}