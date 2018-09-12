package com.example.wordcount;

import com.google.common.base.Splitter;
import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;

/**
 * created by ravibhushan.k on 31/08/18
 */
public class Tokenizer extends DoFn<String, String> {
    private static final Splitter SPLITTER = Splitter.onPattern("\\s+").omitEmptyStrings();

    @Override
    public void process(String line, Emitter<String> emitter) {
        for (String word : SPLITTER.split(line)) {
            emitter.emit(word);
        }
    }
}
