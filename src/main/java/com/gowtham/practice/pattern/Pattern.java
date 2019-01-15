package com.gowtham.practice.pattern;

import com.gowtham.practice.STIXPatternLexer;
import com.gowtham.practice.STIXPatternParser;
import com.gowtham.stiximpl.obj.ExpressionObject;

import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.CharStream;

public class Pattern {
	
	public static void createMap(Tree tree) {
		int count = tree.getChildCount();
		while (count > 0) {
			Tree temp = tree.getChild(count);

		}

	}

	public static void printNode(Tree tree) {

		if (tree.getChildCount() > 0) {

			for (int x = 0; x < tree.getChildCount(); x++) {

				printNode(tree.getChild(x));

			}

		} else {

			if (tree.getClass() == TerminalNodeImpl.class) {

				TerminalNodeImpl impl = (TerminalNodeImpl) tree;
					System.out.println(impl.getSymbol().getText());
					
				switch (impl.getSymbol().getType()) {

				case 29:
					
					System.out.println("Found a field type! : " + impl.getText());

					break;
				case 28:
					
					System.out.println("Found a field subtype! : " + impl.getText());

					break;

				case 7:
					
					System.out.println("Found a field VALUE! : " + impl.getText());

					break;
				case 10:
				
					System.out.println("Found a field VALUE    : " + impl.getText());
					break;

				}

			} else {

				System.out.println("WHAT IS THIS?? : " + tree.toString());

			}

		}

	}

	public static void doParse(String pattern) {
		CharStream charStream = CharStreams.fromString(pattern);

		Lexer lexer = new STIXPatternLexer(charStream);
		TokenStream commonTokenStream = new CommonTokenStream(lexer);
		Parser parser = new STIXPatternParser(commonTokenStream);
		Tree tree = ((STIXPatternParser) parser).pattern();
		printNode(tree);

	}

	public static void main(String[] args) {
		// String pattern = "[file-object:hashes.md5 =
		// '79054025255fb1a26e4bc422aef54eb4']\n";
		// String pattern="[test='gowtham']";
		// doParse(pattern);
		// String p = "[url:value= 'http://x4z9arb.cn/4712/']";
		// doParse(p);

		// System.out.println("new pattern");

		//String p2 = "[ network-traffic:dst_ref.type = 'ipv4-addr' AND network-traffic:dst_ref.value = '203.0.113.33' ]";
		// String p3 = "[ network-traffic:dst_ref.type = 'ipv6-addr' AND
		// network-traffic:dst_ref.value = 'abcd::23' ]";
		//doParse(p2);
		//key = ipv4-addr value = 203.0.113.33
		
		//String p3 ="[ url:value = 'http://www.harddomainname.biz/wordpress/wp-admin/css/colors/blue/panel/gate.php' ]";
				
				String p3 ="[(\n" + 
						"                            file:size = '262144' AND\n" + 
						"                                (\n" + 
						"                                    file:hashes.'MD5' = 'a95296c8c88f581e6aa88bc0747b3256' OR\n" + 
						"                                    file:hashes.'SHA-1' = 'cf04120f5c5813ef4e42907b378eecfa625d0249' OR\n" + 
						"                                    file:hashes.'SHA-256' = 'b6024be8783d9870761d4a422e8bebd72361e24f3e65331d546eae7e8a775e89'\n" + 
						"                                )\n" + 
						"                        )]";
		
		//key ="url" value = "http://www.harddomainname.biz/wordpress/wp-admin/css/colors/blue/panel/gate.php"
		doParse(p3);
		
	//	file:hashes.'SHA-256' = 'aec070645fe53ee3b3763059376134f058cc337247c978add178b6ccdfb0019f'
		
		
		
	}

}
/*
 * you want to build the key value pair of the whole pattern and then try to
 * build an expression t
 * 
 * 
 */
