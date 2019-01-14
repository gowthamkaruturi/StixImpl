package com.gowtham.practice.error;
import  org.antlr.v4.runtime.BaseErrorListener;
public class ParseErrorListener {

    BaseErrorListener baseErrorListener;

            public ParseErrorListener(BaseErrorListener baseErrorListener)
            {
                this.baseErrorListener = baseErrorListener;
            }

}
