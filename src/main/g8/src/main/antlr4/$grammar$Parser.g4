parser grammar $grammar$Parser;

options { tokenVocab=$grammar$Lexer; }

expr: NUMBER operation NUMBER;

operation: (ADD | SUB | MUL | DIV);
