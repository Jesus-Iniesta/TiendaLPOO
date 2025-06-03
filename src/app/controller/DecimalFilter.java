
package app.controller;

/**
 *
 * @author Alfonso
 */
import javax.swing.text.*;

public class DecimalFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        if (isValidInput(fb.getDocument().getText(0, fb.getDocument().getLength()) + string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        String newText = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()))
                .replace(offset, offset + length, text)
                .toString();

        if (isValidInput(newText)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isValidInput(String text) {
        return text.matches("^\\d*(\\.\\d{0,2})?$"); // acepta números como 123, 123.4, 123.45
    }
}

