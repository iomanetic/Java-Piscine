package edu.school21.spring.preprocessor;

public class PreProcessorToLower implements PreProcessor {

    @Override
    public String preProcessor(String string) {
        return (string.toLowerCase());
    }
}
