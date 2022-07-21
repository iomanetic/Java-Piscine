package edu.school21.spring.printer;

import edu.school21.spring.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String string) {
        renderer.displayMessage(prefix + ' ' + string);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
