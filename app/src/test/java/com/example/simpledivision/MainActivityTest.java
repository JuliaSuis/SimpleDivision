package com.example.simpledivision;

import android.text.Editable;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainActivityTest {

    private EditText mockedText;
    private Editable mockedEditable;

    @Before
    public void setUp() {
        mockedText = mock(EditText.class);
        mockedEditable = mock(Editable.class);

        when(mockedText.getText()).thenReturn(mockedEditable);
    }

    @Test
    public void parseIntFromEditText(){
        when(mockedEditable.toString()).thenReturn("123");

        assertEquals(123, MainActivity.parseEditText(mockedText));
    }


    @Test(expected = NumberFormatException.class)
    public void throwsExceptionWhenTextIsNotANumber() {
        when(mockedEditable.toString()).thenReturn("text");

        MainActivity.parseEditText(mockedText);
    }

}