//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.13.2
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from LangGrammar.g4 by ANTLR 4.13.2

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

using System;
using System.IO;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.2")]
[System.CLSCompliant(false)]
public partial class LangGrammarLexer : Lexer {
	protected static DFA[] decisionToDFA;
	protected static PredictionContextCache sharedContextCache = new PredictionContextCache();
	public const int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, LIBRARY_NAME=30, PRINT_FUNCTION=31, 
		STRING=32, INT_LITERAL=33, FLOAT_LITERAL=34, CHAR_LITERAL=35, ID=36, WS=37;
	public static string[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static string[] modeNames = {
		"DEFAULT_MODE"
	};

	public static readonly string[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "LIBRARY_NAME", "PRINT_FUNCTION", 
		"STRING", "INT_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", "ID", "WS"
	};


	public LangGrammarLexer(ICharStream input)
	: this(input, Console.Out, Console.Error) { }

	public LangGrammarLexer(ICharStream input, TextWriter output, TextWriter errorOutput)
	: base(input, output, errorOutput)
	{
		Interpreter = new LexerATNSimulator(this, _ATN, decisionToDFA, sharedContextCache);
	}

	private static readonly string[] _LiteralNames = {
		null, "'#include'", "'<'", "'>'", "'int'", "'main'", "'('", "')'", "'void'", 
		"'{'", "'}'", "';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", 
		"'>='", "'<='", "'&&'", "'||'", "'!'", "'='", "'['", "']'", "'float'", 
		"'char'", "'return'", null, "'printf'"
	};
	private static readonly string[] _SymbolicNames = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "LIBRARY_NAME", "PRINT_FUNCTION", 
		"STRING", "INT_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", "ID", "WS"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "LangGrammar.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override string[] ChannelNames { get { return channelNames; } }

	public override string[] ModeNames { get { return modeNames; } }

	public override int[] SerializedAtn { get { return _serializedATN; } }

	static LangGrammarLexer() {
		decisionToDFA = new DFA[_ATN.NumberOfDecisions];
		for (int i = 0; i < _ATN.NumberOfDecisions; i++) {
			decisionToDFA[i] = new DFA(_ATN.GetDecisionState(i), i);
		}
	}
	private static int[] _serializedATN = {
		4,0,37,247,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,
		6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,
		7,14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,
		7,21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,26,2,27,7,27,2,28,
		7,28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,7,32,2,33,7,33,2,34,7,34,2,35,
		7,35,2,36,7,36,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,2,1,2,1,3,
		1,3,1,3,1,3,1,4,1,4,1,4,1,4,1,4,1,5,1,5,1,6,1,6,1,7,1,7,1,7,1,7,1,7,1,
		8,1,8,1,9,1,9,1,10,1,10,1,11,1,11,1,12,1,12,1,13,1,13,1,14,1,14,1,15,1,
		15,1,16,1,16,1,16,1,17,1,17,1,17,1,18,1,18,1,18,1,19,1,19,1,19,1,20,1,
		20,1,20,1,21,1,21,1,21,1,22,1,22,1,23,1,23,1,24,1,24,1,25,1,25,1,26,1,
		26,1,26,1,26,1,26,1,26,1,27,1,27,1,27,1,27,1,27,1,28,1,28,1,28,1,28,1,
		28,1,28,1,28,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,
		29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,
		29,1,29,1,29,1,29,3,29,196,8,29,1,30,1,30,1,30,1,30,1,30,1,30,1,30,1,31,
		1,31,5,31,207,8,31,10,31,12,31,210,9,31,1,31,1,31,1,32,4,32,215,8,32,11,
		32,12,32,216,1,33,4,33,220,8,33,11,33,12,33,221,1,33,1,33,4,33,226,8,33,
		11,33,12,33,227,1,34,1,34,1,34,1,34,1,35,1,35,5,35,236,8,35,10,35,12,35,
		239,9,35,1,36,4,36,242,8,36,11,36,12,36,243,1,36,1,36,1,208,0,37,1,1,3,
		2,5,3,7,4,9,5,11,6,13,7,15,8,17,9,19,10,21,11,23,12,25,13,27,14,29,15,
		31,16,33,17,35,18,37,19,39,20,41,21,43,22,45,23,47,24,49,25,51,26,53,27,
		55,28,57,29,59,30,61,31,63,32,65,33,67,34,69,35,71,36,73,37,1,0,5,1,0,
		48,57,2,0,65,90,97,122,3,0,65,90,95,95,97,122,4,0,48,57,65,90,95,95,97,
		122,3,0,9,10,13,13,32,32,255,0,1,1,0,0,0,0,3,1,0,0,0,0,5,1,0,0,0,0,7,1,
		0,0,0,0,9,1,0,0,0,0,11,1,0,0,0,0,13,1,0,0,0,0,15,1,0,0,0,0,17,1,0,0,0,
		0,19,1,0,0,0,0,21,1,0,0,0,0,23,1,0,0,0,0,25,1,0,0,0,0,27,1,0,0,0,0,29,
		1,0,0,0,0,31,1,0,0,0,0,33,1,0,0,0,0,35,1,0,0,0,0,37,1,0,0,0,0,39,1,0,0,
		0,0,41,1,0,0,0,0,43,1,0,0,0,0,45,1,0,0,0,0,47,1,0,0,0,0,49,1,0,0,0,0,51,
		1,0,0,0,0,53,1,0,0,0,0,55,1,0,0,0,0,57,1,0,0,0,0,59,1,0,0,0,0,61,1,0,0,
		0,0,63,1,0,0,0,0,65,1,0,0,0,0,67,1,0,0,0,0,69,1,0,0,0,0,71,1,0,0,0,0,73,
		1,0,0,0,1,75,1,0,0,0,3,84,1,0,0,0,5,86,1,0,0,0,7,88,1,0,0,0,9,92,1,0,0,
		0,11,97,1,0,0,0,13,99,1,0,0,0,15,101,1,0,0,0,17,106,1,0,0,0,19,108,1,0,
		0,0,21,110,1,0,0,0,23,112,1,0,0,0,25,114,1,0,0,0,27,116,1,0,0,0,29,118,
		1,0,0,0,31,120,1,0,0,0,33,122,1,0,0,0,35,125,1,0,0,0,37,128,1,0,0,0,39,
		131,1,0,0,0,41,134,1,0,0,0,43,137,1,0,0,0,45,140,1,0,0,0,47,142,1,0,0,
		0,49,144,1,0,0,0,51,146,1,0,0,0,53,148,1,0,0,0,55,154,1,0,0,0,57,159,1,
		0,0,0,59,195,1,0,0,0,61,197,1,0,0,0,63,204,1,0,0,0,65,214,1,0,0,0,67,219,
		1,0,0,0,69,229,1,0,0,0,71,233,1,0,0,0,73,241,1,0,0,0,75,76,5,35,0,0,76,
		77,5,105,0,0,77,78,5,110,0,0,78,79,5,99,0,0,79,80,5,108,0,0,80,81,5,117,
		0,0,81,82,5,100,0,0,82,83,5,101,0,0,83,2,1,0,0,0,84,85,5,60,0,0,85,4,1,
		0,0,0,86,87,5,62,0,0,87,6,1,0,0,0,88,89,5,105,0,0,89,90,5,110,0,0,90,91,
		5,116,0,0,91,8,1,0,0,0,92,93,5,109,0,0,93,94,5,97,0,0,94,95,5,105,0,0,
		95,96,5,110,0,0,96,10,1,0,0,0,97,98,5,40,0,0,98,12,1,0,0,0,99,100,5,41,
		0,0,100,14,1,0,0,0,101,102,5,118,0,0,102,103,5,111,0,0,103,104,5,105,0,
		0,104,105,5,100,0,0,105,16,1,0,0,0,106,107,5,123,0,0,107,18,1,0,0,0,108,
		109,5,125,0,0,109,20,1,0,0,0,110,111,5,59,0,0,111,22,1,0,0,0,112,113,5,
		43,0,0,113,24,1,0,0,0,114,115,5,45,0,0,115,26,1,0,0,0,116,117,5,42,0,0,
		117,28,1,0,0,0,118,119,5,47,0,0,119,30,1,0,0,0,120,121,5,37,0,0,121,32,
		1,0,0,0,122,123,5,61,0,0,123,124,5,61,0,0,124,34,1,0,0,0,125,126,5,33,
		0,0,126,127,5,61,0,0,127,36,1,0,0,0,128,129,5,62,0,0,129,130,5,61,0,0,
		130,38,1,0,0,0,131,132,5,60,0,0,132,133,5,61,0,0,133,40,1,0,0,0,134,135,
		5,38,0,0,135,136,5,38,0,0,136,42,1,0,0,0,137,138,5,124,0,0,138,139,5,124,
		0,0,139,44,1,0,0,0,140,141,5,33,0,0,141,46,1,0,0,0,142,143,5,61,0,0,143,
		48,1,0,0,0,144,145,5,91,0,0,145,50,1,0,0,0,146,147,5,93,0,0,147,52,1,0,
		0,0,148,149,5,102,0,0,149,150,5,108,0,0,150,151,5,111,0,0,151,152,5,97,
		0,0,152,153,5,116,0,0,153,54,1,0,0,0,154,155,5,99,0,0,155,156,5,104,0,
		0,156,157,5,97,0,0,157,158,5,114,0,0,158,56,1,0,0,0,159,160,5,114,0,0,
		160,161,5,101,0,0,161,162,5,116,0,0,162,163,5,117,0,0,163,164,5,114,0,
		0,164,165,5,110,0,0,165,58,1,0,0,0,166,167,5,115,0,0,167,168,5,116,0,0,
		168,169,5,100,0,0,169,170,5,105,0,0,170,171,5,111,0,0,171,172,5,46,0,0,
		172,196,5,104,0,0,173,174,5,109,0,0,174,175,5,97,0,0,175,176,5,116,0,0,
		176,177,5,104,0,0,177,178,5,46,0,0,178,196,5,104,0,0,179,180,5,115,0,0,
		180,181,5,116,0,0,181,182,5,100,0,0,182,183,5,108,0,0,183,184,5,105,0,
		0,184,185,5,98,0,0,185,186,5,46,0,0,186,196,5,104,0,0,187,188,5,115,0,
		0,188,189,5,116,0,0,189,190,5,114,0,0,190,191,5,105,0,0,191,192,5,110,
		0,0,192,193,5,103,0,0,193,194,5,46,0,0,194,196,5,104,0,0,195,166,1,0,0,
		0,195,173,1,0,0,0,195,179,1,0,0,0,195,187,1,0,0,0,196,60,1,0,0,0,197,198,
		5,112,0,0,198,199,5,114,0,0,199,200,5,105,0,0,200,201,5,110,0,0,201,202,
		5,116,0,0,202,203,5,102,0,0,203,62,1,0,0,0,204,208,5,34,0,0,205,207,9,
		0,0,0,206,205,1,0,0,0,207,210,1,0,0,0,208,209,1,0,0,0,208,206,1,0,0,0,
		209,211,1,0,0,0,210,208,1,0,0,0,211,212,5,34,0,0,212,64,1,0,0,0,213,215,
		7,0,0,0,214,213,1,0,0,0,215,216,1,0,0,0,216,214,1,0,0,0,216,217,1,0,0,
		0,217,66,1,0,0,0,218,220,7,0,0,0,219,218,1,0,0,0,220,221,1,0,0,0,221,219,
		1,0,0,0,221,222,1,0,0,0,222,223,1,0,0,0,223,225,5,46,0,0,224,226,7,0,0,
		0,225,224,1,0,0,0,226,227,1,0,0,0,227,225,1,0,0,0,227,228,1,0,0,0,228,
		68,1,0,0,0,229,230,5,39,0,0,230,231,7,1,0,0,231,232,5,39,0,0,232,70,1,
		0,0,0,233,237,7,2,0,0,234,236,7,3,0,0,235,234,1,0,0,0,236,239,1,0,0,0,
		237,235,1,0,0,0,237,238,1,0,0,0,238,72,1,0,0,0,239,237,1,0,0,0,240,242,
		7,4,0,0,241,240,1,0,0,0,242,243,1,0,0,0,243,241,1,0,0,0,243,244,1,0,0,
		0,244,245,1,0,0,0,245,246,6,36,0,0,246,74,1,0,0,0,8,0,195,208,216,221,
		227,237,243,1,6,0,0
	};

	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN);


}
