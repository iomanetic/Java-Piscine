package edu.school21.spring.renderer;

import edu.school21.spring.preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void displayMessage(String string) {
        System.out.println(preProcessor.preProcessor(string));
    }
}
