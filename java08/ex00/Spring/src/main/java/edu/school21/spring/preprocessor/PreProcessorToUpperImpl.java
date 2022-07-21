package edu.school21.spring.preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {

    @Override
    public String preProcessor(String string) {
        return (string.toUpperCase());
    }
}
