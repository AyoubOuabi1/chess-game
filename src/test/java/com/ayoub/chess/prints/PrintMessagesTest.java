package com.ayoub.chess.prints;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintMessagesTest {

    @Test
    void getInput() {
        int[] input = {7,8,0,5};
        assertEquals(false, PrintMessages.checkInput(input));
    }
}