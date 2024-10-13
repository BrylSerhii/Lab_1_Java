package com.appliances;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FridgeTest {

    private Fridge fridge;

    @Before
    public void setUp() {
        fridge = new Fridge("LG", 200);
    }

    @Test
    public void testGetDescription() {
        assertEquals("Fridge: LG, Power: 200W", fridge.getDescription());
    }

    @Test
    public void testPlugIn() {
        fridge.plugIn();
        assertTrue(fridge.isPluggedIn());
    }

    @Test
    public void testUnplug() {
        fridge.unplug();
        assertFalse(fridge.isPluggedIn());
    }
}
