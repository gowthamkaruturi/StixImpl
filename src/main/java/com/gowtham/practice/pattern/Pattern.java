package com.gowtham.practice.pattern;

import com.gowtham.practice.STIXPatternLexer;
import com.gowtham.practice.STIXPatternParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.Tree;

public class Pattern {


    public static void doParse(String pattern) {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(pattern);
        Lexer lexer = new STIXPatternLexer(antlrInputStream);
        TokenStream commonTokenStream = new CommonTokenStream(lexer);
        Parser parser = new STIXPatternParser(commonTokenStream);
        Tree tree  = ((STIXPatternParser) parser).pattern();
        System.out.println(tree.toStringTree());

    }

    public static void main(String[] args)
    {
        String pattern = "[file-object:hashes.md5 = '79054025255fb1a26e4bc422aef54eb4']\n" +  "PASS: [file-object:hashes.md5 = '79054025255fb1a26e4bc422aef54eb4']";
        doParse(pattern);
        String p = "[url:value= 'http://x4z9arb.cn/4712/']";
        doParse(p);
    }

}
