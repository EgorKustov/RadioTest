public class Radio {
    private int currentStation;
    private int volumeLevel;

    public Radio() {
        this.currentStation = 0;
        this.volumeLevel = 0;
    }

    public void nextStation() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation--;
        }
    }

    public void setStation(int station) {
        if (station >= 0 && station <= 9) {
            currentStation = station;
        } else {
            throw new IllegalArgumentException("Invalid station number");
        }
    }

    public void increaseVolume() {
        if (volumeLevel < 100) {
            volumeLevel++;
        }
    }

    public void decreaseVolume() {
        if (volumeLevel > 0) {
            volumeLevel--;
        }
    }

    // Getters for testing purposes
    public int getCurrentStation() {
        return currentStation;
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }
}
    And here's the corresponding test class:

        java
        Копировать
        import org.junit.Test;
        import static org.junit.Assert.*;

public class RadioTest {
    @Test
    public void testNextStation() {
        Radio radio = new Radio();

        assertEquals(0, radio.getCurrentStation());

        radio.nextStation();
        assertEquals(1, radio.getCurrentStation());

        // ... repeat for all stations (2 to 9)
        // ...

        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio();

        assertEquals(0, radio.getCurrentStation());

        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());

        // ... repeat for all stations (8 to 1)
        // ...

        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetStation() {
        Radio radio = new Radio();

        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());

        radio.setStation(9);
        assertEquals(9, radio.getCurrentStation());

        try {
            radio.setStation(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            radio.setStation(10);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();

        assertEquals(0, radio.getVolumeLevel());

        radio.increaseVolume();
        assertEquals(1, radio.getVolumeLevel());

        // ... repeat for all volume levels (2 to 100)
        // ...

        radio.increaseVolume();
        assertEquals(100, radio.getVolumeLevel());

        // Further increase should not lead to anything
        radio.increaseVolume();
        assertEquals(100, radio.getVolumeLevel());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();

        assertEquals(0, radio.getVolumeLevel());

        radio.decreaseVolume();
        assertEquals(0, radio.getVolumeLevel());

        radio.increaseVolume();
        assertEquals(1, radio.getVolumeLevel());

        // ... repeat for all volume levels (100 to 2)
        // ...

        radio.decreaseVolume();
        assertEquals(1, radio.getVolumeLevel());

        // Further decrease should not lead to anything
        radio.decreaseVolume();
        assertEquals(1, radio.getVolumeLevel());
    }
}{
}
        To set up the project for code coverage reporting using JaCoCo, you can use a build tool like Maven or Gradle and add the JaCoCo plugin. After running the tests, JaCoCo will generate a coverage report that you can view to check the code coverage.