// Generated from c:/Users/Joana/Downloads/interpretador/Ferramenta/LangGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LangGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LIB=4, INCLUDE=5, DEFINE=6, RELOP=7, COMMENTLINE=8, 
		COMMENTBLOCK=9, INT=10, FLOAT=11, CHAR=12, DOUBLE=13, VOID=14, MAIN=15, 
		COMMA=16, PV=17, PLUS=18, MINUS=19, MULT=20, DIV=21, MOD=22, AND=23, OR=24, 
		NOT=25, CD=26, CE=27, PD=28, PE=29, CO=30, CC=31, SOMA=32, SUB=33, ASSIGN=34, 
		DOT=35, RETURN=36, SCAN=37, PRINT=38, GETS=39, PUTS=40, STRUCT=41, UNION=42, 
		IF=43, ELSE=44, SWITCH=45, CASE=46, BREAK=47, DEFAULT=48, WHILE=49, FOR=50, 
		DO=51, TYPEOF=52, WS=53, VAR=54, NUM=55, CONSTANT=56, CHARLIT=57, FORMAT=58, 
		STR=59;
	public static final int
		RULE_programa = 0, RULE_cabecalho = 1, RULE_includeDecl = 2, RULE_defineDecl = 3, 
		RULE_corpo = 4, RULE_mainFunction = 5, RULE_bloco = 6, RULE_structDecl = 7, 
		RULE_structInstDecl = 8, RULE_structMember = 9, RULE_structAccess = 10, 
		RULE_structFieldAccess = 11, RULE_linhas = 12, RULE_comentario = 13, RULE_atrib = 14, 
		RULE_arrayDecl = 15, RULE_size = 16, RULE_elementosArray = 17, RULE_arrayAccess = 18, 
		RULE_pointerDecl = 19, RULE_pointerAssign = 20, RULE_pointerDereference = 21, 
		RULE_input = 22, RULE_output = 23, RULE_getsStmt = 24, RULE_putsStmt = 25, 
		RULE_structLiteral = 26, RULE_functionDecl = 27, RULE_functionCall = 28, 
		RULE_blocoFunction = 29, RULE_parametros = 30, RULE_tipo = 31, RULE_argumentos = 32, 
		RULE_unionDecl = 33, RULE_unionFields = 34, RULE_unionAccess = 35, RULE_decisionFunc = 36, 
		RULE_switchCase = 37, RULE_caseBlock = 38, RULE_defaultBlock = 39, RULE_loopFunc = 40, 
		RULE_whileLoop = 41, RULE_forLoop = 42, RULE_doWhileLoop = 43, RULE_expression = 44, 
		RULE_arrayUpdate = 45, RULE_terminais = 46, RULE_fator = 47, RULE_argument = 48, 
		RULE_exprbloco = 49, RULE_casting = 50, RULE_typeof = 51, RULE_ternary = 52, 
		RULE_returnStmt = 53;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "cabecalho", "includeDecl", "defineDecl", "corpo", "mainFunction", 
			"bloco", "structDecl", "structInstDecl", "structMember", "structAccess", 
			"structFieldAccess", "linhas", "comentario", "atrib", "arrayDecl", "size", 
			"elementosArray", "arrayAccess", "pointerDecl", "pointerAssign", "pointerDereference", 
			"input", "output", "getsStmt", "putsStmt", "structLiteral", "functionDecl", 
			"functionCall", "blocoFunction", "parametros", "tipo", "argumentos", 
			"unionDecl", "unionFields", "unionAccess", "decisionFunc", "switchCase", 
			"caseBlock", "defaultBlock", "loopFunc", "whileLoop", "forLoop", "doWhileLoop", 
			"expression", "arrayUpdate", "terminais", "fator", "argument", "exprbloco", 
			"casting", "typeof", "ternary", "returnStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&'", "':'", "'?'", null, "'#include'", "'#define'", null, null, 
			null, "'int'", "'float'", "'char'", "'double'", "'void'", "'main'", "','", 
			"';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'{'", 
			"'}'", "'('", "')'", "'['", "']'", "'++'", "'--'", "'='", "'.'", "'return'", 
			"'scanf'", "'printf'", "'gets'", "'puts'", "'struct'", "'union'", "'if'", 
			"'else'", "'switch'", "'case'", "'break'", "'default'", "'while'", "'for'", 
			"'do'", "'typeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LIB", "INCLUDE", "DEFINE", "RELOP", "COMMENTLINE", 
			"COMMENTBLOCK", "INT", "FLOAT", "CHAR", "DOUBLE", "VOID", "MAIN", "COMMA", 
			"PV", "PLUS", "MINUS", "MULT", "DIV", "MOD", "AND", "OR", "NOT", "CD", 
			"CE", "PD", "PE", "CO", "CC", "SOMA", "SUB", "ASSIGN", "DOT", "RETURN", 
			"SCAN", "PRINT", "GETS", "PUTS", "STRUCT", "UNION", "IF", "ELSE", "SWITCH", 
			"CASE", "BREAK", "DEFAULT", "WHILE", "FOR", "DO", "TYPEOF", "WS", "VAR", 
			"NUM", "CONSTANT", "CHARLIT", "FORMAT", "STR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LangGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public CabecalhoContext cabecalho() {
			return getRuleContext(CabecalhoContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LangGrammarParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			cabecalho();
			setState(109);
			corpo();
			setState(110);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CabecalhoContext extends ParserRuleContext {
		public List<IncludeDeclContext> includeDecl() {
			return getRuleContexts(IncludeDeclContext.class);
		}
		public IncludeDeclContext includeDecl(int i) {
			return getRuleContext(IncludeDeclContext.class,i);
		}
		public List<DefineDeclContext> defineDecl() {
			return getRuleContexts(DefineDeclContext.class);
		}
		public DefineDeclContext defineDecl(int i) {
			return getRuleContext(DefineDeclContext.class,i);
		}
		public List<ComentarioContext> comentario() {
			return getRuleContexts(ComentarioContext.class);
		}
		public ComentarioContext comentario(int i) {
			return getRuleContext(ComentarioContext.class,i);
		}
		public CabecalhoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cabecalho; }
	}

	public final CabecalhoContext cabecalho() throws RecognitionException {
		CabecalhoContext _localctx = new CabecalhoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cabecalho);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(115);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INCLUDE:
						{
						setState(112);
						includeDecl();
						}
						break;
					case DEFINE:
						{
						setState(113);
						defineDecl();
						}
						break;
					case COMMENTLINE:
					case COMMENTBLOCK:
						{
						setState(114);
						comentario();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncludeDeclContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(LangGrammarParser.INCLUDE, 0); }
		public TerminalNode LIB() { return getToken(LangGrammarParser.LIB, 0); }
		public IncludeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeDecl; }
	}

	public final IncludeDeclContext includeDecl() throws RecognitionException {
		IncludeDeclContext _localctx = new IncludeDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_includeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(INCLUDE);
			setState(121);
			match(LIB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefineDeclContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(LangGrammarParser.DEFINE, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefineDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineDecl; }
	}

	public final DefineDeclContext defineDecl() throws RecognitionException {
		DefineDeclContext _localctx = new DefineDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defineDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(DEFINE);
			setState(124);
			match(VAR);
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(125);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CorpoContext extends ParserRuleContext {
		public List<StructDeclContext> structDecl() {
			return getRuleContexts(StructDeclContext.class);
		}
		public StructDeclContext structDecl(int i) {
			return getRuleContext(StructDeclContext.class,i);
		}
		public List<MainFunctionContext> mainFunction() {
			return getRuleContexts(MainFunctionContext.class);
		}
		public MainFunctionContext mainFunction(int i) {
			return getRuleContext(MainFunctionContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<UnionDeclContext> unionDecl() {
			return getRuleContexts(UnionDeclContext.class);
		}
		public UnionDeclContext unionDecl(int i) {
			return getRuleContext(UnionDeclContext.class,i);
		}
		public List<ComentarioContext> comentario() {
			return getRuleContexts(ComentarioContext.class);
		}
		public ComentarioContext comentario(int i) {
			return getRuleContext(ComentarioContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18020995579281152L) != 0)) {
				{
				setState(133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(128);
					structDecl();
					}
					break;
				case 2:
					{
					setState(129);
					mainFunction();
					}
					break;
				case 3:
					{
					setState(130);
					functionDecl();
					}
					break;
				case 4:
					{
					setState(131);
					unionDecl();
					}
					break;
				case 5:
					{
					setState(132);
					comentario();
					}
					break;
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainFunctionContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode MAIN() { return getToken(LangGrammarParser.MAIN, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mainFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(INT);
			setState(139);
			match(MAIN);
			setState(140);
			match(PD);
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(141);
				match(VOID);
				}
				break;
			case PE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(145);
			match(PE);
			setState(146);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public List<LinhasContext> linhas() {
			return getRuleContexts(LinhasContext.class);
		}
		public LinhasContext linhas(int i) {
			return getRuleContext(LinhasContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(CD);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 855173687455809280L) != 0)) {
				{
				{
				setState(149);
				linhas();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(CE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(LangGrammarParser.STRUCT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(STRUCT);
			setState(158);
			match(VAR);
			setState(159);
			match(CD);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18020995579280384L) != 0)) {
				{
				{
				setState(160);
				structMember();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
			match(CE);
			setState(167);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructInstDeclContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(LangGrammarParser.STRUCT, 0); }
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public StructLiteralContext structLiteral() {
			return getRuleContext(StructLiteralContext.class,0);
		}
		public StructInstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInstDecl; }
	}

	public final StructInstDeclContext structInstDecl() throws RecognitionException {
		StructInstDeclContext _localctx = new StructInstDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structInstDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(STRUCT);
			setState(170);
			match(VAR);
			setState(171);
			match(VAR);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(172);
				match(ASSIGN);
				setState(173);
				structLiteral();
				}
			}

			setState(176);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructMemberContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TerminalNode CO() { return getToken(LangGrammarParser.CO, 0); }
		public TerminalNode CC() { return getToken(LangGrammarParser.CC, 0); }
		public TerminalNode CONSTANT() { return getToken(LangGrammarParser.CONSTANT, 0); }
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			tipo();
			setState(179);
			match(VAR);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CO) {
				{
				setState(180);
				match(CO);
				setState(181);
				_la = _input.LA(1);
				if ( !(_la==NUM || _la==CONSTANT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(182);
				match(CC);
				}
			}

			setState(185);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructAccessContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public TerminalNode DOT() { return getToken(LangGrammarParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public StructAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structAccess; }
	}

	public final StructAccessContext structAccess() throws RecognitionException {
		StructAccessContext _localctx = new StructAccessContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_structAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(VAR);
			setState(188);
			match(DOT);
			setState(189);
			match(VAR);
			setState(190);
			match(ASSIGN);
			setState(191);
			expression();
			setState(192);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructFieldAccessContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public TerminalNode DOT() { return getToken(LangGrammarParser.DOT, 0); }
		public StructFieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structFieldAccess; }
	}

	public final StructFieldAccessContext structFieldAccess() throws RecognitionException {
		StructFieldAccessContext _localctx = new StructFieldAccessContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_structFieldAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(VAR);
			setState(195);
			match(DOT);
			setState(196);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinhasContext extends ParserRuleContext {
		public UnionAccessContext unionAccess() {
			return getRuleContext(UnionAccessContext.class,0);
		}
		public StructAccessContext structAccess() {
			return getRuleContext(StructAccessContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public AtribContext atrib() {
			return getRuleContext(AtribContext.class,0);
		}
		public ComentarioContext comentario() {
			return getRuleContext(ComentarioContext.class,0);
		}
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
		public PointerDeclContext pointerDecl() {
			return getRuleContext(PointerDeclContext.class,0);
		}
		public PointerAssignContext pointerAssign() {
			return getRuleContext(PointerAssignContext.class,0);
		}
		public PointerDereferenceContext pointerDereference() {
			return getRuleContext(PointerDereferenceContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public GetsStmtContext getsStmt() {
			return getRuleContext(GetsStmtContext.class,0);
		}
		public PutsStmtContext putsStmt() {
			return getRuleContext(PutsStmtContext.class,0);
		}
		public DecisionFuncContext decisionFunc() {
			return getRuleContext(DecisionFuncContext.class,0);
		}
		public SwitchCaseContext switchCase() {
			return getRuleContext(SwitchCaseContext.class,0);
		}
		public LoopFuncContext loopFunc() {
			return getRuleContext(LoopFuncContext.class,0);
		}
		public DoWhileLoopContext doWhileLoop() {
			return getRuleContext(DoWhileLoopContext.class,0);
		}
		public CastingContext casting() {
			return getRuleContext(CastingContext.class,0);
		}
		public TypeofContext typeof() {
			return getRuleContext(TypeofContext.class,0);
		}
		public TernaryContext ternary() {
			return getRuleContext(TernaryContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public LinhasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linhas; }
	}

	public final LinhasContext linhas() throws RecognitionException {
		LinhasContext _localctx = new LinhasContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_linhas);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				unionAccess();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				structAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				atrib();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				comentario();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(203);
				arrayDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(204);
				pointerDecl();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(205);
				pointerAssign();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(206);
				pointerDereference();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(207);
				input();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(208);
				output();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(209);
				getsStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(210);
				putsStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(211);
				decisionFunc();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(212);
				switchCase();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(213);
				loopFunc();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(214);
				doWhileLoop();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(215);
				casting();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(216);
				typeof();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(217);
				ternary();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(218);
				returnStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComentarioContext extends ParserRuleContext {
		public TerminalNode COMMENTLINE() { return getToken(LangGrammarParser.COMMENTLINE, 0); }
		public TerminalNode COMMENTBLOCK() { return getToken(LangGrammarParser.COMMENTBLOCK, 0); }
		public ComentarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comentario; }
	}

	public final ComentarioContext comentario() throws RecognitionException {
		ComentarioContext _localctx = new ComentarioContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comentario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_la = _input.LA(1);
			if ( !(_la==COMMENTLINE || _la==COMMENTBLOCK) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtribContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StructAccessContext structAccess() {
			return getRuleContext(StructAccessContext.class,0);
		}
		public AtribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atrib; }
	}

	public final AtribContext atrib() throws RecognitionException {
		AtribContext _localctx = new AtribContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atrib);
		int _la;
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				tipo();
				setState(224);
				match(VAR);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(225);
					match(ASSIGN);
					setState(226);
					expression();
					}
				}

				setState(229);
				match(PV);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(VAR);
				setState(232);
				match(ASSIGN);
				setState(233);
				expression();
				setState(234);
				match(PV);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				structAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDeclContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CO() { return getToken(LangGrammarParser.CO, 0); }
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public TerminalNode CC() { return getToken(LangGrammarParser.CC, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public ElementosArrayContext elementosArray() {
			return getRuleContext(ElementosArrayContext.class,0);
		}
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayDecl);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				tipo();
				setState(240);
				match(VAR);
				setState(241);
				match(CO);
				setState(242);
				size();
				setState(243);
				match(CC);
				setState(244);
				match(ASSIGN);
				setState(245);
				match(STR);
				setState(246);
				match(PV);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				tipo();
				setState(249);
				match(VAR);
				setState(250);
				match(CO);
				setState(251);
				size();
				setState(252);
				match(CC);
				setState(253);
				match(ASSIGN);
				setState(254);
				match(CD);
				setState(255);
				elementosArray();
				setState(256);
				match(CE);
				setState(257);
				match(PV);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				tipo();
				setState(260);
				match(VAR);
				setState(261);
				match(CO);
				setState(262);
				size();
				setState(263);
				match(CC);
				setState(264);
				match(PV);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SizeContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_size);
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(NUM);
				}
				break;
			case CC:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementosArrayContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangGrammarParser.COMMA, i);
		}
		public ElementosArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementosArray; }
	}

	public final ElementosArrayContext elementosArray() throws RecognitionException {
		ElementosArrayContext _localctx = new ElementosArrayContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elementosArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			expression();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(273);
				match(COMMA);
				setState(274);
				expression();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CO() { return getToken(LangGrammarParser.CO, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CC() { return getToken(LangGrammarParser.CC, 0); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(VAR);
			setState(281);
			match(CO);
			setState(282);
			expression();
			setState(283);
			match(CC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerDeclContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(LangGrammarParser.MULT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public PointerDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerDecl; }
	}

	public final PointerDeclContext pointerDecl() throws RecognitionException {
		PointerDeclContext _localctx = new PointerDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pointerDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(286);
			match(MULT);
			setState(287);
			match(VAR);
			setState(288);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerAssignContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public PointerAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerAssign; }
	}

	public final PointerAssignContext pointerAssign() throws RecognitionException {
		PointerAssignContext _localctx = new PointerAssignContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pointerAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(VAR);
			setState(291);
			match(ASSIGN);
			setState(292);
			match(T__0);
			setState(293);
			match(VAR);
			setState(294);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerDereferenceContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(LangGrammarParser.MULT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public PointerDereferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerDereference; }
	}

	public final PointerDereferenceContext pointerDereference() throws RecognitionException {
		PointerDereferenceContext _localctx = new PointerDereferenceContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_pointerDereference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(MULT);
			setState(297);
			match(VAR);
			setState(298);
			match(ASSIGN);
			setState(299);
			expression();
			setState(300);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(LangGrammarParser.SCAN, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode FORMAT() { return getToken(LangGrammarParser.FORMAT, 0); }
		public TerminalNode COMMA() { return getToken(LangGrammarParser.COMMA, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(SCAN);
			setState(303);
			match(PD);
			setState(304);
			match(FORMAT);
			setState(305);
			match(COMMA);
			setState(306);
			match(T__0);
			setState(307);
			match(VAR);
			setState(308);
			match(PE);
			setState(309);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OutputContext extends ParserRuleContext {
		public ArgumentContext argument;
		public List<ArgumentContext> arg = new ArrayList<ArgumentContext>();
		public TerminalNode PRINT() { return getToken(LangGrammarParser.PRINT, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LangGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangGrammarParser.COMMA, i);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_output);
		int _la;
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				match(PRINT);
				setState(312);
				match(PD);
				setState(313);
				match(STR);
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(314);
					match(COMMA);
					setState(315);
					((OutputContext)_localctx).argument = argument();
					((OutputContext)_localctx).arg.add(((OutputContext)_localctx).argument);
					}
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(321);
				match(PE);
				setState(322);
				match(PV);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				match(STR);
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(324);
					match(COMMA);
					setState(325);
					((OutputContext)_localctx).argument = argument();
					((OutputContext)_localctx).arg.add(((OutputContext)_localctx).argument);
					}
					}
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GetsStmtContext extends ParserRuleContext {
		public TerminalNode GETS() { return getToken(LangGrammarParser.GETS, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public GetsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getsStmt; }
	}

	public final GetsStmtContext getsStmt() throws RecognitionException {
		GetsStmtContext _localctx = new GetsStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_getsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(GETS);
			setState(334);
			match(PD);
			setState(335);
			match(VAR);
			setState(336);
			match(PE);
			setState(337);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PutsStmtContext extends ParserRuleContext {
		public TerminalNode PUTS() { return getToken(LangGrammarParser.PUTS, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public PutsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_putsStmt; }
	}

	public final PutsStmtContext putsStmt() throws RecognitionException {
		PutsStmtContext _localctx = new PutsStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_putsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(PUTS);
			setState(340);
			match(PD);
			setState(341);
			match(VAR);
			setState(342);
			match(PE);
			setState(343);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructLiteralContext extends ParserRuleContext {
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LangGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangGrammarParser.COMMA, i);
		}
		public StructLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structLiteral; }
	}

	public final StructLiteralContext structLiteral() throws RecognitionException {
		StructLiteralContext _localctx = new StructLiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_structLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(CD);
			setState(346);
			expression();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(347);
				match(COMMA);
				setState(348);
				expression();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354);
			match(CE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public BlocoFunctionContext blocoFunction() {
			return getRuleContext(BlocoFunctionContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			tipo();
			setState(357);
			match(VAR);
			setState(358);
			match(PD);
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18020995579280384L) != 0)) {
				{
				setState(359);
				parametros();
				}
			}

			setState(362);
			match(PE);
			setState(363);
			blocoFunction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(VAR);
			setState(366);
			match(PD);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 846676730314752000L) != 0)) {
				{
				setState(367);
				argumentos();
				}
			}

			setState(370);
			match(PE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoFunctionContext extends ParserRuleContext {
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public List<LinhasContext> linhas() {
			return getRuleContexts(LinhasContext.class);
		}
		public LinhasContext linhas(int i) {
			return getRuleContext(LinhasContext.class,i);
		}
		public BlocoFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoFunction; }
	}

	public final BlocoFunctionContext blocoFunction() throws RecognitionException {
		BlocoFunctionContext _localctx = new BlocoFunctionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_blocoFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(CD);
			setState(374); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(373);
				linhas();
				}
				}
				setState(376); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 855173687455809280L) != 0) );
			setState(378);
			match(CE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangGrammarParser.COMMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			tipo();
			setState(381);
			match(VAR);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(382);
				match(COMMA);
				setState(383);
				tipo();
				setState(384);
				match(VAR);
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public TerminalNode STRUCT() { return getToken(LangGrammarParser.STRUCT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode UNION() { return getToken(LangGrammarParser.UNION, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tipo);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(392);
				match(FLOAT);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				match(CHAR);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(394);
				match(DOUBLE);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 5);
				{
				setState(395);
				match(VOID);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 6);
				{
				setState(396);
				match(STRUCT);
				setState(397);
				match(VAR);
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 7);
				{
				setState(398);
				match(UNION);
				setState(399);
				match(VAR);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(400);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangGrammarParser.COMMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			expression();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(404);
				match(COMMA);
				setState(405);
				expression();
				}
				}
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnionDeclContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(LangGrammarParser.UNION, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public UnionFieldsContext unionFields() {
			return getRuleContext(UnionFieldsContext.class,0);
		}
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public UnionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionDecl; }
	}

	public final UnionDeclContext unionDecl() throws RecognitionException {
		UnionDeclContext _localctx = new UnionDeclContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_unionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(UNION);
			setState(412);
			match(VAR);
			setState(413);
			match(CD);
			setState(414);
			unionFields();
			setState(415);
			match(CE);
			setState(416);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnionFieldsContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public List<TerminalNode> PV() { return getTokens(LangGrammarParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(LangGrammarParser.PV, i);
		}
		public List<TerminalNode> INT() { return getTokens(LangGrammarParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(LangGrammarParser.INT, i);
		}
		public List<TerminalNode> FLOAT() { return getTokens(LangGrammarParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(LangGrammarParser.FLOAT, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(LangGrammarParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(LangGrammarParser.CHAR, i);
		}
		public List<TerminalNode> DOUBLE() { return getTokens(LangGrammarParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(LangGrammarParser.DOUBLE, i);
		}
		public List<TerminalNode> VOID() { return getTokens(LangGrammarParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(LangGrammarParser.VOID, i);
		}
		public UnionFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionFields; }
	}

	public final UnionFieldsContext unionFields() throws RecognitionException {
		UnionFieldsContext _localctx = new UnionFieldsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_unionFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(418);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(419);
				match(VAR);
				setState(420);
				match(PV);
				}
				}
				setState(423); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnionAccessContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public TerminalNode DOT() { return getToken(LangGrammarParser.DOT, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnionAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionAccess; }
	}

	public final UnionAccessContext unionAccess() throws RecognitionException {
		UnionAccessContext _localctx = new UnionAccessContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_unionAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(VAR);
			setState(426);
			match(DOT);
			setState(427);
			match(VAR);
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(428);
				match(ASSIGN);
				setState(429);
				expression();
				}
			}

			setState(432);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecisionFuncContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(LangGrammarParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(LangGrammarParser.IF, i);
		}
		public List<TerminalNode> PD() { return getTokens(LangGrammarParser.PD); }
		public TerminalNode PD(int i) {
			return getToken(LangGrammarParser.PD, i);
		}
		public List<ExprblocoContext> exprbloco() {
			return getRuleContexts(ExprblocoContext.class);
		}
		public ExprblocoContext exprbloco(int i) {
			return getRuleContext(ExprblocoContext.class,i);
		}
		public List<TerminalNode> PE() { return getTokens(LangGrammarParser.PE); }
		public TerminalNode PE(int i) {
			return getToken(LangGrammarParser.PE, i);
		}
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(LangGrammarParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(LangGrammarParser.ELSE, i);
		}
		public DecisionFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionFunc; }
	}

	public final DecisionFuncContext decisionFunc() throws RecognitionException {
		DecisionFuncContext _localctx = new DecisionFuncContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_decisionFunc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(IF);
			setState(435);
			match(PD);
			setState(436);
			exprbloco(0);
			setState(437);
			match(PE);
			setState(438);
			bloco();
			setState(448);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(439);
					match(ELSE);
					setState(440);
					match(IF);
					setState(441);
					match(PD);
					setState(442);
					exprbloco(0);
					setState(443);
					match(PE);
					setState(444);
					bloco();
					}
					} 
				}
				setState(450);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(451);
				match(ELSE);
				setState(452);
				bloco();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchCaseContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(LangGrammarParser.SWITCH, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public DefaultBlockContext defaultBlock() {
			return getRuleContext(DefaultBlockContext.class,0);
		}
		public SwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchCase; }
	}

	public final SwitchCaseContext switchCase() throws RecognitionException {
		SwitchCaseContext _localctx = new SwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_switchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(SWITCH);
			setState(456);
			match(PD);
			setState(457);
			match(VAR);
			setState(458);
			match(PE);
			setState(459);
			match(CD);
			setState(461); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(460);
				caseBlock();
				}
				}
				setState(463); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(465);
				defaultBlock();
				}
			}

			setState(468);
			match(CE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseBlockContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(LangGrammarParser.CASE, 0); }
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode BREAK() { return getToken(LangGrammarParser.BREAK, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public List<LinhasContext> linhas() {
			return getRuleContexts(LinhasContext.class);
		}
		public LinhasContext linhas(int i) {
			return getRuleContext(LinhasContext.class,i);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_caseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			match(CASE);
			setState(471);
			match(NUM);
			setState(472);
			match(T__1);
			setState(476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 855173687455809280L) != 0)) {
				{
				{
				setState(473);
				linhas();
				}
				}
				setState(478);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(479);
			match(BREAK);
			setState(480);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultBlockContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(LangGrammarParser.DEFAULT, 0); }
		public TerminalNode BREAK() { return getToken(LangGrammarParser.BREAK, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public List<LinhasContext> linhas() {
			return getRuleContexts(LinhasContext.class);
		}
		public LinhasContext linhas(int i) {
			return getRuleContext(LinhasContext.class,i);
		}
		public DefaultBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBlock; }
	}

	public final DefaultBlockContext defaultBlock() throws RecognitionException {
		DefaultBlockContext _localctx = new DefaultBlockContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_defaultBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(DEFAULT);
			setState(483);
			match(T__1);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 855173687455809280L) != 0)) {
				{
				{
				setState(484);
				linhas();
				}
				}
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(490);
			match(BREAK);
			setState(491);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopFuncContext extends ParserRuleContext {
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public LoopFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopFunc; }
	}

	public final LoopFuncContext loopFunc() throws RecognitionException {
		LoopFuncContext _localctx = new LoopFuncContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_loopFunc);
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				whileLoop();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				forLoop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LangGrammarParser.WHILE, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(WHILE);
			setState(498);
			match(PD);
			setState(499);
			exprbloco(0);
			setState(500);
			match(PE);
			setState(501);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LangGrammarParser.FOR, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public List<TerminalNode> PV() { return getTokens(LangGrammarParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(LangGrammarParser.PV, i);
		}
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public List<AtribContext> atrib() {
			return getRuleContexts(AtribContext.class);
		}
		public AtribContext atrib(int i) {
			return getRuleContext(AtribContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(FOR);
			setState(504);
			match(PD);
			setState(507);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case VOID:
			case STRUCT:
			case UNION:
			case VAR:
				{
				setState(505);
				atrib();
				}
				break;
			case PV:
				{
				setState(506);
				match(PV);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 846676730314752000L) != 0)) {
				{
				setState(509);
				exprbloco(0);
				}
			}

			setState(512);
			match(PV);
			setState(515);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(513);
				atrib();
				}
				break;
			case 2:
				{
				setState(514);
				expression();
				}
				break;
			}
			setState(517);
			match(PE);
			setState(518);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileLoopContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(LangGrammarParser.DO, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(LangGrammarParser.WHILE, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public DoWhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoop; }
	}

	public final DoWhileLoopContext doWhileLoop() throws RecognitionException {
		DoWhileLoopContext _localctx = new DoWhileLoopContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_doWhileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(DO);
			setState(521);
			bloco();
			setState(522);
			match(WHILE);
			setState(523);
			match(PD);
			setState(524);
			exprbloco(0);
			setState(525);
			match(PE);
			setState(526);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public StructLiteralContext structLiteral() {
			return getRuleContext(StructLiteralContext.class,0);
		}
		public List<TerminaisContext> terminais() {
			return getRuleContexts(TerminaisContext.class);
		}
		public TerminaisContext terminais(int i) {
			return getRuleContext(TerminaisContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LangGrammarParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LangGrammarParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LangGrammarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LangGrammarParser.MINUS, i);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_expression);
		int _la;
		try {
			int _alt;
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				structLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(529);
				terminais();
				setState(534);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(530);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(531);
						terminais();
						}
						} 
					}
					setState(536);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(537);
				arrayAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayUpdateContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CO() { return getToken(LangGrammarParser.CO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CC() { return getToken(LangGrammarParser.CC, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ArrayUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayUpdate; }
	}

	public final ArrayUpdateContext arrayUpdate() throws RecognitionException {
		ArrayUpdateContext _localctx = new ArrayUpdateContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_arrayUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(VAR);
			setState(541);
			match(CO);
			setState(542);
			expression();
			setState(543);
			match(CC);
			setState(544);
			match(ASSIGN);
			setState(545);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TerminaisContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(LangGrammarParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LangGrammarParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LangGrammarParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LangGrammarParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(LangGrammarParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(LangGrammarParser.MOD, i);
		}
		public TerminaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminais; }
	}

	public final TerminaisContext terminais() throws RecognitionException {
		TerminaisContext _localctx = new TerminaisContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_terminais);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			fator();
			setState(552);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(548);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(549);
					fator();
					}
					} 
				}
				setState(554);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(LangGrammarParser.NOT, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public StructFieldAccessContext structFieldAccess() {
			return getRuleContext(StructFieldAccessContext.class,0);
		}
		public StructAccessContext structAccess() {
			return getRuleContext(StructAccessContext.class,0);
		}
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode CONSTANT() { return getToken(LangGrammarParser.CONSTANT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public TerminalNode CHARLIT() { return getToken(LangGrammarParser.CHARLIT, 0); }
		public TerminalNode SOMA() { return getToken(LangGrammarParser.SOMA, 0); }
		public TerminalNode SUB() { return getToken(LangGrammarParser.SUB, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_fator);
		try {
			setState(573);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(555);
				match(NOT);
				setState(556);
				fator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				match(PD);
				setState(558);
				expression();
				setState(559);
				match(PE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(561);
				arrayAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(562);
				structFieldAccess();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(563);
				structAccess();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(564);
				match(NUM);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(565);
				match(CONSTANT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(566);
				match(VAR);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(567);
				match(STR);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(568);
				match(CHARLIT);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(569);
				match(VAR);
				setState(570);
				match(SOMA);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(571);
				match(VAR);
				setState(572);
				match(SUB);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public StructFieldAccessContext structFieldAccess() {
			return getRuleContext(StructFieldAccessContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_argument);
		try {
			setState(579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(576);
				exprbloco(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(577);
				arrayAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(578);
				structFieldAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprblocoContext extends ParserRuleContext {
		public ExprblocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprbloco; }
	 
		public ExprblocoContext() { }
		public void copyFrom(ExprblocoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExpressionContext extends ExprblocoContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(LangGrammarParser.RELOP, 0); }
		public RelationalExpressionContext(ExprblocoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentesisExpressionContext extends ExprblocoContext {
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public ParentesisExpressionContext(ExprblocoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ExprblocoContext {
		public List<ExprblocoContext> exprbloco() {
			return getRuleContexts(ExprblocoContext.class);
		}
		public ExprblocoContext exprbloco(int i) {
			return getRuleContext(ExprblocoContext.class,i);
		}
		public TerminalNode AND() { return getToken(LangGrammarParser.AND, 0); }
		public AndExpressionContext(ExprblocoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExprblocoContext {
		public TerminalNode NOT() { return getToken(LangGrammarParser.NOT, 0); }
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public NotExpressionContext(ExprblocoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ExprblocoContext {
		public List<ExprblocoContext> exprbloco() {
			return getRuleContexts(ExprblocoContext.class);
		}
		public ExprblocoContext exprbloco(int i) {
			return getRuleContext(ExprblocoContext.class,i);
		}
		public TerminalNode OR() { return getToken(LangGrammarParser.OR, 0); }
		public OrExpressionContext(ExprblocoContext ctx) { copyFrom(ctx); }
	}

	public final ExprblocoContext exprbloco() throws RecognitionException {
		return exprbloco(0);
	}

	private ExprblocoContext exprbloco(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprblocoContext _localctx = new ExprblocoContext(_ctx, _parentState);
		ExprblocoContext _prevctx = _localctx;
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_exprbloco, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				_localctx = new ParentesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(582);
				match(PD);
				setState(583);
				exprbloco(0);
				setState(584);
				match(PE);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(586);
				match(NOT);
				setState(587);
				exprbloco(4);
				}
				break;
			case 3:
				{
				_localctx = new RelationalExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(588);
				expression();
				setState(591);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(589);
					match(RELOP);
					setState(590);
					expression();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(603);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(601);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new AndExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(595);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(596);
						match(AND);
						setState(597);
						exprbloco(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(598);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(599);
						match(OR);
						setState(600);
						exprbloco(3);
						}
						break;
					}
					} 
				}
				setState(605);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastingContext extends ParserRuleContext {
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public CastingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casting; }
	}

	public final CastingContext casting() throws RecognitionException {
		CastingContext _localctx = new CastingContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_casting);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			match(PD);
			setState(607);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(608);
			match(PE);
			setState(609);
			match(VAR);
			setState(610);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeofContext extends ParserRuleContext {
		public TerminalNode TYPEOF() { return getToken(LangGrammarParser.TYPEOF, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TypeofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeof; }
	}

	public final TypeofContext typeof() throws RecognitionException {
		TypeofContext _localctx = new TypeofContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_typeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			match(TYPEOF);
			setState(613);
			match(PD);
			setState(614);
			match(VAR);
			setState(615);
			match(PE);
			setState(616);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TernaryContext extends ParserRuleContext {
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			exprbloco(0);
			setState(619);
			match(T__2);
			setState(620);
			expression();
			setState(621);
			match(T__1);
			setState(622);
			expression();
			setState(623);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(LangGrammarParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(RETURN);
			setState(626);
			expression();
			setState(627);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 49:
			return exprbloco_sempred((ExprblocoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprbloco_sempred(ExprblocoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001;\u0276\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"t\b\u0001\n\u0001\f\u0001w\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u007f\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0086\b\u0004"+
		"\n\u0004\f\u0004\u0089\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u0090\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0005\u0006\u0097\b\u0006\n\u0006\f\u0006"+
		"\u009a\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u00a2\b\u0007\n\u0007\f\u0007\u00a5\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0003\b\u00af\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00b8\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00dc\b\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00e4\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00ee\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u010b\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u010f\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0114\b\u0011\n\u0011"+
		"\f\u0011\u0117\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u013d\b\u0017\n\u0017\f\u0017\u0140"+
		"\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u0147\b\u0017\n\u0017\f\u0017\u014a\t\u0017\u0003\u0017\u014c\b"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u015e"+
		"\b\u001a\n\u001a\f\u001a\u0161\t\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0169\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u0171\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0004\u001d"+
		"\u0177\b\u001d\u000b\u001d\f\u001d\u0178\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005"+
		"\u001e\u0183\b\u001e\n\u001e\f\u001e\u0186\t\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u0192\b\u001f\u0001 \u0001 \u0001"+
		" \u0005 \u0197\b \n \f \u019a\t \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001\"\u0001\"\u0001\"\u0004\"\u01a6\b\"\u000b\"\f\"\u01a7\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0003#\u01af\b#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0005$\u01bf\b$\n$\f$\u01c2\t$\u0001$\u0001$\u0003$\u01c6\b$\u0001%"+
		"\u0001%\u0001%\u0001%\u0001%\u0001%\u0004%\u01ce\b%\u000b%\f%\u01cf\u0001"+
		"%\u0003%\u01d3\b%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0005&\u01db"+
		"\b&\n&\f&\u01de\t&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0005"+
		"\'\u01e6\b\'\n\'\f\'\u01e9\t\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0003"+
		"(\u01f0\b(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0003*\u01fc\b*\u0001*\u0003*\u01ff\b*\u0001*\u0001*\u0001*\u0003"+
		"*\u0204\b*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0005,\u0215\b,\n,\f,\u0218"+
		"\t,\u0001,\u0003,\u021b\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001.\u0001.\u0001.\u0005.\u0227\b.\n.\f.\u022a\t.\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003/\u023e\b/\u00010\u00010\u0001"+
		"0\u00010\u00030\u0244\b0\u00011\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00031\u0250\b1\u00031\u0252\b1\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00051\u025a\b1\n1\f1\u025d\t1\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u00013\u00013\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00014\u00015\u00015\u00015\u0001"+
		"5\u00015\u0000\u0001b6\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhj\u0000\u0005\u0001\u000078\u0001\u0000\b\t\u0001\u0000\n\u000e"+
		"\u0001\u0000\u0012\u0013\u0001\u0000\u0014\u0016\u029b\u0000l\u0001\u0000"+
		"\u0000\u0000\u0002u\u0001\u0000\u0000\u0000\u0004x\u0001\u0000\u0000\u0000"+
		"\u0006{\u0001\u0000\u0000\u0000\b\u0087\u0001\u0000\u0000\u0000\n\u008a"+
		"\u0001\u0000\u0000\u0000\f\u0094\u0001\u0000\u0000\u0000\u000e\u009d\u0001"+
		"\u0000\u0000\u0000\u0010\u00a9\u0001\u0000\u0000\u0000\u0012\u00b2\u0001"+
		"\u0000\u0000\u0000\u0014\u00bb\u0001\u0000\u0000\u0000\u0016\u00c2\u0001"+
		"\u0000\u0000\u0000\u0018\u00db\u0001\u0000\u0000\u0000\u001a\u00dd\u0001"+
		"\u0000\u0000\u0000\u001c\u00ed\u0001\u0000\u0000\u0000\u001e\u010a\u0001"+
		"\u0000\u0000\u0000 \u010e\u0001\u0000\u0000\u0000\"\u0110\u0001\u0000"+
		"\u0000\u0000$\u0118\u0001\u0000\u0000\u0000&\u011d\u0001\u0000\u0000\u0000"+
		"(\u0122\u0001\u0000\u0000\u0000*\u0128\u0001\u0000\u0000\u0000,\u012e"+
		"\u0001\u0000\u0000\u0000.\u014b\u0001\u0000\u0000\u00000\u014d\u0001\u0000"+
		"\u0000\u00002\u0153\u0001\u0000\u0000\u00004\u0159\u0001\u0000\u0000\u0000"+
		"6\u0164\u0001\u0000\u0000\u00008\u016d\u0001\u0000\u0000\u0000:\u0174"+
		"\u0001\u0000\u0000\u0000<\u017c\u0001\u0000\u0000\u0000>\u0191\u0001\u0000"+
		"\u0000\u0000@\u0193\u0001\u0000\u0000\u0000B\u019b\u0001\u0000\u0000\u0000"+
		"D\u01a5\u0001\u0000\u0000\u0000F\u01a9\u0001\u0000\u0000\u0000H\u01b2"+
		"\u0001\u0000\u0000\u0000J\u01c7\u0001\u0000\u0000\u0000L\u01d6\u0001\u0000"+
		"\u0000\u0000N\u01e2\u0001\u0000\u0000\u0000P\u01ef\u0001\u0000\u0000\u0000"+
		"R\u01f1\u0001\u0000\u0000\u0000T\u01f7\u0001\u0000\u0000\u0000V\u0208"+
		"\u0001\u0000\u0000\u0000X\u021a\u0001\u0000\u0000\u0000Z\u021c\u0001\u0000"+
		"\u0000\u0000\\\u0223\u0001\u0000\u0000\u0000^\u023d\u0001\u0000\u0000"+
		"\u0000`\u0243\u0001\u0000\u0000\u0000b\u0251\u0001\u0000\u0000\u0000d"+
		"\u025e\u0001\u0000\u0000\u0000f\u0264\u0001\u0000\u0000\u0000h\u026a\u0001"+
		"\u0000\u0000\u0000j\u0271\u0001\u0000\u0000\u0000lm\u0003\u0002\u0001"+
		"\u0000mn\u0003\b\u0004\u0000no\u0005\u0000\u0000\u0001o\u0001\u0001\u0000"+
		"\u0000\u0000pt\u0003\u0004\u0002\u0000qt\u0003\u0006\u0003\u0000rt\u0003"+
		"\u001a\r\u0000sp\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000sr\u0001"+
		"\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000v\u0003\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000xy\u0005\u0005\u0000\u0000yz\u0005\u0004\u0000\u0000z\u0005"+
		"\u0001\u0000\u0000\u0000{|\u0005\u0006\u0000\u0000|~\u00056\u0000\u0000"+
		"}\u007f\u0003X,\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0007\u0001\u0000\u0000\u0000\u0080\u0086\u0003\u000e\u0007"+
		"\u0000\u0081\u0086\u0003\n\u0005\u0000\u0082\u0086\u00036\u001b\u0000"+
		"\u0083\u0086\u0003B!\u0000\u0084\u0086\u0003\u001a\r\u0000\u0085\u0080"+
		"\u0001\u0000\u0000\u0000\u0085\u0081\u0001\u0000\u0000\u0000\u0085\u0082"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\t\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\n\u0000\u0000\u008b\u008c\u0005\u000f\u0000\u0000\u008c\u008f\u0005\u001c"+
		"\u0000\u0000\u008d\u0090\u0005\u000e\u0000\u0000\u008e\u0090\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u001d"+
		"\u0000\u0000\u0092\u0093\u0003\f\u0006\u0000\u0093\u000b\u0001\u0000\u0000"+
		"\u0000\u0094\u0098\u0005\u001a\u0000\u0000\u0095\u0097\u0003\u0018\f\u0000"+
		"\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0005\u001b\u0000\u0000\u009c\r\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0005)\u0000\u0000\u009e\u009f\u00056\u0000\u0000\u009f\u00a3\u0005"+
		"\u001a\u0000\u0000\u00a0\u00a2\u0003\u0012\t\u0000\u00a1\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u001b"+
		"\u0000\u0000\u00a7\u00a8\u0005\u0011\u0000\u0000\u00a8\u000f\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0005)\u0000\u0000\u00aa\u00ab\u00056\u0000\u0000"+
		"\u00ab\u00ae\u00056\u0000\u0000\u00ac\u00ad\u0005\"\u0000\u0000\u00ad"+
		"\u00af\u00034\u001a\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005\u0011\u0000\u0000\u00b1\u0011\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0003>\u001f\u0000\u00b3\u00b7\u00056\u0000\u0000\u00b4\u00b5\u0005\u001e"+
		"\u0000\u0000\u00b5\u00b6\u0007\u0000\u0000\u0000\u00b6\u00b8\u0005\u001f"+
		"\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u0011"+
		"\u0000\u0000\u00ba\u0013\u0001\u0000\u0000\u0000\u00bb\u00bc\u00056\u0000"+
		"\u0000\u00bc\u00bd\u0005#\u0000\u0000\u00bd\u00be\u00056\u0000\u0000\u00be"+
		"\u00bf\u0005\"\u0000\u0000\u00bf\u00c0\u0003X,\u0000\u00c0\u00c1\u0005"+
		"\u0011\u0000\u0000\u00c1\u0015\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"6\u0000\u0000\u00c3\u00c4\u0005#\u0000\u0000\u00c4\u00c5\u00056\u0000"+
		"\u0000\u00c5\u0017\u0001\u0000\u0000\u0000\u00c6\u00dc\u0003F#\u0000\u00c7"+
		"\u00dc\u0003\u0014\n\u0000\u00c8\u00dc\u00038\u001c\u0000\u00c9\u00dc"+
		"\u0003\u001c\u000e\u0000\u00ca\u00dc\u0003\u001a\r\u0000\u00cb\u00dc\u0003"+
		"\u001e\u000f\u0000\u00cc\u00dc\u0003&\u0013\u0000\u00cd\u00dc\u0003(\u0014"+
		"\u0000\u00ce\u00dc\u0003*\u0015\u0000\u00cf\u00dc\u0003,\u0016\u0000\u00d0"+
		"\u00dc\u0003.\u0017\u0000\u00d1\u00dc\u00030\u0018\u0000\u00d2\u00dc\u0003"+
		"2\u0019\u0000\u00d3\u00dc\u0003H$\u0000\u00d4\u00dc\u0003J%\u0000\u00d5"+
		"\u00dc\u0003P(\u0000\u00d6\u00dc\u0003V+\u0000\u00d7\u00dc\u0003d2\u0000"+
		"\u00d8\u00dc\u0003f3\u0000\u00d9\u00dc\u0003h4\u0000\u00da\u00dc\u0003"+
		"j5\u0000\u00db\u00c6\u0001\u0000\u0000\u0000\u00db\u00c7\u0001\u0000\u0000"+
		"\u0000\u00db\u00c8\u0001\u0000\u0000\u0000\u00db\u00c9\u0001\u0000\u0000"+
		"\u0000\u00db\u00ca\u0001\u0000\u0000\u0000\u00db\u00cb\u0001\u0000\u0000"+
		"\u0000\u00db\u00cc\u0001\u0000\u0000\u0000\u00db\u00cd\u0001\u0000\u0000"+
		"\u0000\u00db\u00ce\u0001\u0000\u0000\u0000\u00db\u00cf\u0001\u0000\u0000"+
		"\u0000\u00db\u00d0\u0001\u0000\u0000\u0000\u00db\u00d1\u0001\u0000\u0000"+
		"\u0000\u00db\u00d2\u0001\u0000\u0000\u0000\u00db\u00d3\u0001\u0000\u0000"+
		"\u0000\u00db\u00d4\u0001\u0000\u0000\u0000\u00db\u00d5\u0001\u0000\u0000"+
		"\u0000\u00db\u00d6\u0001\u0000\u0000\u0000\u00db\u00d7\u0001\u0000\u0000"+
		"\u0000\u00db\u00d8\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000"+
		"\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u0019\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0007\u0001\u0000\u0000\u00de\u001b\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0003>\u001f\u0000\u00e0\u00e3\u00056\u0000\u0000\u00e1"+
		"\u00e2\u0005\"\u0000\u0000\u00e2\u00e4\u0003X,\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0005\u0011\u0000\u0000\u00e6\u00ee\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u00056\u0000\u0000\u00e8\u00e9\u0005\""+
		"\u0000\u0000\u00e9\u00ea\u0003X,\u0000\u00ea\u00eb\u0005\u0011\u0000\u0000"+
		"\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ee\u0003\u0014\n\u0000\u00ed"+
		"\u00df\u0001\u0000\u0000\u0000\u00ed\u00e7\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ee\u001d\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0003>\u001f\u0000\u00f0\u00f1\u00056\u0000\u0000\u00f1\u00f2\u0005"+
		"\u001e\u0000\u0000\u00f2\u00f3\u0003 \u0010\u0000\u00f3\u00f4\u0005\u001f"+
		"\u0000\u0000\u00f4\u00f5\u0005\"\u0000\u0000\u00f5\u00f6\u0005;\u0000"+
		"\u0000\u00f6\u00f7\u0005\u0011\u0000\u0000\u00f7\u010b\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0003>\u001f\u0000\u00f9\u00fa\u00056\u0000\u0000\u00fa"+
		"\u00fb\u0005\u001e\u0000\u0000\u00fb\u00fc\u0003 \u0010\u0000\u00fc\u00fd"+
		"\u0005\u001f\u0000\u0000\u00fd\u00fe\u0005\"\u0000\u0000\u00fe\u00ff\u0005"+
		"\u001a\u0000\u0000\u00ff\u0100\u0003\"\u0011\u0000\u0100\u0101\u0005\u001b"+
		"\u0000\u0000\u0101\u0102\u0005\u0011\u0000\u0000\u0102\u010b\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0003>\u001f\u0000\u0104\u0105\u00056\u0000\u0000"+
		"\u0105\u0106\u0005\u001e\u0000\u0000\u0106\u0107\u0003 \u0010\u0000\u0107"+
		"\u0108\u0005\u001f\u0000\u0000\u0108\u0109\u0005\u0011\u0000\u0000\u0109"+
		"\u010b\u0001\u0000\u0000\u0000\u010a\u00ef\u0001\u0000\u0000\u0000\u010a"+
		"\u00f8\u0001\u0000\u0000\u0000\u010a\u0103\u0001\u0000\u0000\u0000\u010b"+
		"\u001f\u0001\u0000\u0000\u0000\u010c\u010f\u00057\u0000\u0000\u010d\u010f"+
		"\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010d"+
		"\u0001\u0000\u0000\u0000\u010f!\u0001\u0000\u0000\u0000\u0110\u0115\u0003"+
		"X,\u0000\u0111\u0112\u0005\u0010\u0000\u0000\u0112\u0114\u0003X,\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000"+
		"\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000"+
		"\u0116#\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u00056\u0000\u0000\u0119\u011a\u0005\u001e\u0000\u0000\u011a\u011b"+
		"\u0003X,\u0000\u011b\u011c\u0005\u001f\u0000\u0000\u011c%\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0007\u0002\u0000\u0000\u011e\u011f\u0005\u0014"+
		"\u0000\u0000\u011f\u0120\u00056\u0000\u0000\u0120\u0121\u0005\u0011\u0000"+
		"\u0000\u0121\'\u0001\u0000\u0000\u0000\u0122\u0123\u00056\u0000\u0000"+
		"\u0123\u0124\u0005\"\u0000\u0000\u0124\u0125\u0005\u0001\u0000\u0000\u0125"+
		"\u0126\u00056\u0000\u0000\u0126\u0127\u0005\u0011\u0000\u0000\u0127)\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0005\u0014\u0000\u0000\u0129\u012a\u0005"+
		"6\u0000\u0000\u012a\u012b\u0005\"\u0000\u0000\u012b\u012c\u0003X,\u0000"+
		"\u012c\u012d\u0005\u0011\u0000\u0000\u012d+\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0005%\u0000\u0000\u012f\u0130\u0005\u001c\u0000\u0000\u0130\u0131"+
		"\u0005:\u0000\u0000\u0131\u0132\u0005\u0010\u0000\u0000\u0132\u0133\u0005"+
		"\u0001\u0000\u0000\u0133\u0134\u00056\u0000\u0000\u0134\u0135\u0005\u001d"+
		"\u0000\u0000\u0135\u0136\u0005\u0011\u0000\u0000\u0136-\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0005&\u0000\u0000\u0138\u0139\u0005\u001c\u0000\u0000"+
		"\u0139\u013e\u0005;\u0000\u0000\u013a\u013b\u0005\u0010\u0000\u0000\u013b"+
		"\u013d\u0003`0\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u0140\u0001"+
		"\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001"+
		"\u0000\u0000\u0000\u013f\u0141\u0001\u0000\u0000\u0000\u0140\u013e\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0005\u001d\u0000\u0000\u0142\u014c\u0005"+
		"\u0011\u0000\u0000\u0143\u0148\u0005;\u0000\u0000\u0144\u0145\u0005\u0010"+
		"\u0000\u0000\u0145\u0147\u0003`0\u0000\u0146\u0144\u0001\u0000\u0000\u0000"+
		"\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014c\u0001\u0000\u0000\u0000"+
		"\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u0137\u0001\u0000\u0000\u0000"+
		"\u014b\u0143\u0001\u0000\u0000\u0000\u014c/\u0001\u0000\u0000\u0000\u014d"+
		"\u014e\u0005\'\u0000\u0000\u014e\u014f\u0005\u001c\u0000\u0000\u014f\u0150"+
		"\u00056\u0000\u0000\u0150\u0151\u0005\u001d\u0000\u0000\u0151\u0152\u0005"+
		"\u0011\u0000\u0000\u01521\u0001\u0000\u0000\u0000\u0153\u0154\u0005(\u0000"+
		"\u0000\u0154\u0155\u0005\u001c\u0000\u0000\u0155\u0156\u00056\u0000\u0000"+
		"\u0156\u0157\u0005\u001d\u0000\u0000\u0157\u0158\u0005\u0011\u0000\u0000"+
		"\u01583\u0001\u0000\u0000\u0000\u0159\u015a\u0005\u001a\u0000\u0000\u015a"+
		"\u015f\u0003X,\u0000\u015b\u015c\u0005\u0010\u0000\u0000\u015c\u015e\u0003"+
		"X,\u0000\u015d\u015b\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000"+
		"\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000"+
		"\u0000\u0160\u0162\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000"+
		"\u0000\u0162\u0163\u0005\u001b\u0000\u0000\u01635\u0001\u0000\u0000\u0000"+
		"\u0164\u0165\u0003>\u001f\u0000\u0165\u0166\u00056\u0000\u0000\u0166\u0168"+
		"\u0005\u001c\u0000\u0000\u0167\u0169\u0003<\u001e\u0000\u0168\u0167\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u016a\u0001"+
		"\u0000\u0000\u0000\u016a\u016b\u0005\u001d\u0000\u0000\u016b\u016c\u0003"+
		":\u001d\u0000\u016c7\u0001\u0000\u0000\u0000\u016d\u016e\u00056\u0000"+
		"\u0000\u016e\u0170\u0005\u001c\u0000\u0000\u016f\u0171\u0003@ \u0000\u0170"+
		"\u016f\u0001\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171"+
		"\u0172\u0001\u0000\u0000\u0000\u0172\u0173\u0005\u001d\u0000\u0000\u0173"+
		"9\u0001\u0000\u0000\u0000\u0174\u0176\u0005\u001a\u0000\u0000\u0175\u0177"+
		"\u0003\u0018\f\u0000\u0176\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001"+
		"\u0000\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001"+
		"\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017b\u0005"+
		"\u001b\u0000\u0000\u017b;\u0001\u0000\u0000\u0000\u017c\u017d\u0003>\u001f"+
		"\u0000\u017d\u0184\u00056\u0000\u0000\u017e\u017f\u0005\u0010\u0000\u0000"+
		"\u017f\u0180\u0003>\u001f\u0000\u0180\u0181\u00056\u0000\u0000\u0181\u0183"+
		"\u0001\u0000\u0000\u0000\u0182\u017e\u0001\u0000\u0000\u0000\u0183\u0186"+
		"\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184\u0185"+
		"\u0001\u0000\u0000\u0000\u0185=\u0001\u0000\u0000\u0000\u0186\u0184\u0001"+
		"\u0000\u0000\u0000\u0187\u0192\u0005\n\u0000\u0000\u0188\u0192\u0005\u000b"+
		"\u0000\u0000\u0189\u0192\u0005\f\u0000\u0000\u018a\u0192\u0005\r\u0000"+
		"\u0000\u018b\u0192\u0005\u000e\u0000\u0000\u018c\u018d\u0005)\u0000\u0000"+
		"\u018d\u0192\u00056\u0000\u0000\u018e\u018f\u0005*\u0000\u0000\u018f\u0192"+
		"\u00056\u0000\u0000\u0190\u0192\u00056\u0000\u0000\u0191\u0187\u0001\u0000"+
		"\u0000\u0000\u0191\u0188\u0001\u0000\u0000\u0000\u0191\u0189\u0001\u0000"+
		"\u0000\u0000\u0191\u018a\u0001\u0000\u0000\u0000\u0191\u018b\u0001\u0000"+
		"\u0000\u0000\u0191\u018c\u0001\u0000\u0000\u0000\u0191\u018e\u0001\u0000"+
		"\u0000\u0000\u0191\u0190\u0001\u0000\u0000\u0000\u0192?\u0001\u0000\u0000"+
		"\u0000\u0193\u0198\u0003X,\u0000\u0194\u0195\u0005\u0010\u0000\u0000\u0195"+
		"\u0197\u0003X,\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0197\u019a\u0001"+
		"\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001"+
		"\u0000\u0000\u0000\u0199A\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000"+
		"\u0000\u0000\u019b\u019c\u0005*\u0000\u0000\u019c\u019d\u00056\u0000\u0000"+
		"\u019d\u019e\u0005\u001a\u0000\u0000\u019e\u019f\u0003D\"\u0000\u019f"+
		"\u01a0\u0005\u001b\u0000\u0000\u01a0\u01a1\u0005\u0011\u0000\u0000\u01a1"+
		"C\u0001\u0000\u0000\u0000\u01a2\u01a3\u0007\u0002\u0000\u0000\u01a3\u01a4"+
		"\u00056\u0000\u0000\u01a4\u01a6\u0005\u0011\u0000\u0000\u01a5\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001"+
		"\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8E\u0001\u0000"+
		"\u0000\u0000\u01a9\u01aa\u00056\u0000\u0000\u01aa\u01ab\u0005#\u0000\u0000"+
		"\u01ab\u01ae\u00056\u0000\u0000\u01ac\u01ad\u0005\"\u0000\u0000\u01ad"+
		"\u01af\u0003X,\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae\u01af\u0001"+
		"\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b1\u0005"+
		"\u0011\u0000\u0000\u01b1G\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005+\u0000"+
		"\u0000\u01b3\u01b4\u0005\u001c\u0000\u0000\u01b4\u01b5\u0003b1\u0000\u01b5"+
		"\u01b6\u0005\u001d\u0000\u0000\u01b6\u01c0\u0003\f\u0006\u0000\u01b7\u01b8"+
		"\u0005,\u0000\u0000\u01b8\u01b9\u0005+\u0000\u0000\u01b9\u01ba\u0005\u001c"+
		"\u0000\u0000\u01ba\u01bb\u0003b1\u0000\u01bb\u01bc\u0005\u001d\u0000\u0000"+
		"\u01bc\u01bd\u0003\f\u0006\u0000\u01bd\u01bf\u0001\u0000\u0000\u0000\u01be"+
		"\u01b7\u0001\u0000\u0000\u0000\u01bf\u01c2\u0001\u0000\u0000\u0000\u01c0"+
		"\u01be\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c5\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c3"+
		"\u01c4\u0005,\u0000\u0000\u01c4\u01c6\u0003\f\u0006\u0000\u01c5\u01c3"+
		"\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6I\u0001"+
		"\u0000\u0000\u0000\u01c7\u01c8\u0005-\u0000\u0000\u01c8\u01c9\u0005\u001c"+
		"\u0000\u0000\u01c9\u01ca\u00056\u0000\u0000\u01ca\u01cb\u0005\u001d\u0000"+
		"\u0000\u01cb\u01cd\u0005\u001a\u0000\u0000\u01cc\u01ce\u0003L&\u0000\u01cd"+
		"\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf"+
		"\u01cd\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0"+
		"\u01d2\u0001\u0000\u0000\u0000\u01d1\u01d3\u0003N\'\u0000\u01d2\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4"+
		"\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005\u001b\u0000\u0000\u01d5K\u0001"+
		"\u0000\u0000\u0000\u01d6\u01d7\u0005.\u0000\u0000\u01d7\u01d8\u00057\u0000"+
		"\u0000\u01d8\u01dc\u0005\u0002\u0000\u0000\u01d9\u01db\u0003\u0018\f\u0000"+
		"\u01da\u01d9\u0001\u0000\u0000\u0000\u01db\u01de\u0001\u0000\u0000\u0000"+
		"\u01dc\u01da\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000\u0000"+
		"\u01dd\u01df\u0001\u0000\u0000\u0000\u01de\u01dc\u0001\u0000\u0000\u0000"+
		"\u01df\u01e0\u0005/\u0000\u0000\u01e0\u01e1\u0005\u0011\u0000\u0000\u01e1"+
		"M\u0001\u0000\u0000\u0000\u01e2\u01e3\u00050\u0000\u0000\u01e3\u01e7\u0005"+
		"\u0002\u0000\u0000\u01e4\u01e6\u0003\u0018\f\u0000\u01e5\u01e4\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e9\u0001\u0000\u0000\u0000\u01e7\u01e5\u0001\u0000"+
		"\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01ea\u0001\u0000"+
		"\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000\u01ea\u01eb\u0005/\u0000"+
		"\u0000\u01eb\u01ec\u0005\u0011\u0000\u0000\u01ecO\u0001\u0000\u0000\u0000"+
		"\u01ed\u01f0\u0003R)\u0000\u01ee\u01f0\u0003T*\u0000\u01ef\u01ed\u0001"+
		"\u0000\u0000\u0000\u01ef\u01ee\u0001\u0000\u0000\u0000\u01f0Q\u0001\u0000"+
		"\u0000\u0000\u01f1\u01f2\u00051\u0000\u0000\u01f2\u01f3\u0005\u001c\u0000"+
		"\u0000\u01f3\u01f4\u0003b1\u0000\u01f4\u01f5\u0005\u001d\u0000\u0000\u01f5"+
		"\u01f6\u0003\f\u0006\u0000\u01f6S\u0001\u0000\u0000\u0000\u01f7\u01f8"+
		"\u00052\u0000\u0000\u01f8\u01fb\u0005\u001c\u0000\u0000\u01f9\u01fc\u0003"+
		"\u001c\u000e\u0000\u01fa\u01fc\u0005\u0011\u0000\u0000\u01fb\u01f9\u0001"+
		"\u0000\u0000\u0000\u01fb\u01fa\u0001\u0000\u0000\u0000\u01fc\u01fe\u0001"+
		"\u0000\u0000\u0000\u01fd\u01ff\u0003b1\u0000\u01fe\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000"+
		"\u0000\u0200\u0203\u0005\u0011\u0000\u0000\u0201\u0204\u0003\u001c\u000e"+
		"\u0000\u0202\u0204\u0003X,\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0203"+
		"\u0202\u0001\u0000\u0000\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205"+
		"\u0206\u0005\u001d\u0000\u0000\u0206\u0207\u0003\f\u0006\u0000\u0207U"+
		"\u0001\u0000\u0000\u0000\u0208\u0209\u00053\u0000\u0000\u0209\u020a\u0003"+
		"\f\u0006\u0000\u020a\u020b\u00051\u0000\u0000\u020b\u020c\u0005\u001c"+
		"\u0000\u0000\u020c\u020d\u0003b1\u0000\u020d\u020e\u0005\u001d\u0000\u0000"+
		"\u020e\u020f\u0005\u0011\u0000\u0000\u020fW\u0001\u0000\u0000\u0000\u0210"+
		"\u021b\u00034\u001a\u0000\u0211\u0216\u0003\\.\u0000\u0212\u0213\u0007"+
		"\u0003\u0000\u0000\u0213\u0215\u0003\\.\u0000\u0214\u0212\u0001\u0000"+
		"\u0000\u0000\u0215\u0218\u0001\u0000\u0000\u0000\u0216\u0214\u0001\u0000"+
		"\u0000\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217\u021b\u0001\u0000"+
		"\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000\u0219\u021b\u0003$\u0012"+
		"\u0000\u021a\u0210\u0001\u0000\u0000\u0000\u021a\u0211\u0001\u0000\u0000"+
		"\u0000\u021a\u0219\u0001\u0000\u0000\u0000\u021bY\u0001\u0000\u0000\u0000"+
		"\u021c\u021d\u00056\u0000\u0000\u021d\u021e\u0005\u001e\u0000\u0000\u021e"+
		"\u021f\u0003X,\u0000\u021f\u0220\u0005\u001f\u0000\u0000\u0220\u0221\u0005"+
		"\"\u0000\u0000\u0221\u0222\u0003X,\u0000\u0222[\u0001\u0000\u0000\u0000"+
		"\u0223\u0228\u0003^/\u0000\u0224\u0225\u0007\u0004\u0000\u0000\u0225\u0227"+
		"\u0003^/\u0000\u0226\u0224\u0001\u0000\u0000\u0000\u0227\u022a\u0001\u0000"+
		"\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000\u0228\u0229\u0001\u0000"+
		"\u0000\u0000\u0229]\u0001\u0000\u0000\u0000\u022a\u0228\u0001\u0000\u0000"+
		"\u0000\u022b\u022c\u0005\u0019\u0000\u0000\u022c\u023e\u0003^/\u0000\u022d"+
		"\u022e\u0005\u001c\u0000\u0000\u022e\u022f\u0003X,\u0000\u022f\u0230\u0005"+
		"\u001d\u0000\u0000\u0230\u023e\u0001\u0000\u0000\u0000\u0231\u023e\u0003"+
		"$\u0012\u0000\u0232\u023e\u0003\u0016\u000b\u0000\u0233\u023e\u0003\u0014"+
		"\n\u0000\u0234\u023e\u00057\u0000\u0000\u0235\u023e\u00058\u0000\u0000"+
		"\u0236\u023e\u00056\u0000\u0000\u0237\u023e\u0005;\u0000\u0000\u0238\u023e"+
		"\u00059\u0000\u0000\u0239\u023a\u00056\u0000\u0000\u023a\u023e\u0005 "+
		"\u0000\u0000\u023b\u023c\u00056\u0000\u0000\u023c\u023e\u0005!\u0000\u0000"+
		"\u023d\u022b\u0001\u0000\u0000\u0000\u023d\u022d\u0001\u0000\u0000\u0000"+
		"\u023d\u0231\u0001\u0000\u0000\u0000\u023d\u0232\u0001\u0000\u0000\u0000"+
		"\u023d\u0233\u0001\u0000\u0000\u0000\u023d\u0234\u0001\u0000\u0000\u0000"+
		"\u023d\u0235\u0001\u0000\u0000\u0000\u023d\u0236\u0001\u0000\u0000\u0000"+
		"\u023d\u0237\u0001\u0000\u0000\u0000\u023d\u0238\u0001\u0000\u0000\u0000"+
		"\u023d\u0239\u0001\u0000\u0000\u0000\u023d\u023b\u0001\u0000\u0000\u0000"+
		"\u023e_\u0001\u0000\u0000\u0000\u023f\u0244\u0003X,\u0000\u0240\u0244"+
		"\u0003b1\u0000\u0241\u0244\u0003$\u0012\u0000\u0242\u0244\u0003\u0016"+
		"\u000b\u0000\u0243\u023f\u0001\u0000\u0000\u0000\u0243\u0240\u0001\u0000"+
		"\u0000\u0000\u0243\u0241\u0001\u0000\u0000\u0000\u0243\u0242\u0001\u0000"+
		"\u0000\u0000\u0244a\u0001\u0000\u0000\u0000\u0245\u0246\u00061\uffff\uffff"+
		"\u0000\u0246\u0247\u0005\u001c\u0000\u0000\u0247\u0248\u0003b1\u0000\u0248"+
		"\u0249\u0005\u001d\u0000\u0000\u0249\u0252\u0001\u0000\u0000\u0000\u024a"+
		"\u024b\u0005\u0019\u0000\u0000\u024b\u0252\u0003b1\u0004\u024c\u024f\u0003"+
		"X,\u0000\u024d\u024e\u0005\u0007\u0000\u0000\u024e\u0250\u0003X,\u0000"+
		"\u024f\u024d\u0001\u0000\u0000\u0000\u024f\u0250\u0001\u0000\u0000\u0000"+
		"\u0250\u0252\u0001\u0000\u0000\u0000\u0251\u0245\u0001\u0000\u0000\u0000"+
		"\u0251\u024a\u0001\u0000\u0000\u0000\u0251\u024c\u0001\u0000\u0000\u0000"+
		"\u0252\u025b\u0001\u0000\u0000\u0000\u0253\u0254\n\u0003\u0000\u0000\u0254"+
		"\u0255\u0005\u0017\u0000\u0000\u0255\u025a\u0003b1\u0004\u0256\u0257\n"+
		"\u0002\u0000\u0000\u0257\u0258\u0005\u0018\u0000\u0000\u0258\u025a\u0003"+
		"b1\u0003\u0259\u0253\u0001\u0000\u0000\u0000\u0259\u0256\u0001\u0000\u0000"+
		"\u0000\u025a\u025d\u0001\u0000\u0000\u0000\u025b\u0259\u0001\u0000\u0000"+
		"\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025cc\u0001\u0000\u0000\u0000"+
		"\u025d\u025b\u0001\u0000\u0000\u0000\u025e\u025f\u0005\u001c\u0000\u0000"+
		"\u025f\u0260\u0007\u0002\u0000\u0000\u0260\u0261\u0005\u001d\u0000\u0000"+
		"\u0261\u0262\u00056\u0000\u0000\u0262\u0263\u0005\u0011\u0000\u0000\u0263"+
		"e\u0001\u0000\u0000\u0000\u0264\u0265\u00054\u0000\u0000\u0265\u0266\u0005"+
		"\u001c\u0000\u0000\u0266\u0267\u00056\u0000\u0000\u0267\u0268\u0005\u001d"+
		"\u0000\u0000\u0268\u0269\u0005\u0011\u0000\u0000\u0269g\u0001\u0000\u0000"+
		"\u0000\u026a\u026b\u0003b1\u0000\u026b\u026c\u0005\u0003\u0000\u0000\u026c"+
		"\u026d\u0003X,\u0000\u026d\u026e\u0005\u0002\u0000\u0000\u026e\u026f\u0003"+
		"X,\u0000\u026f\u0270\u0005\u0011\u0000\u0000\u0270i\u0001\u0000\u0000"+
		"\u0000\u0271\u0272\u0005$\u0000\u0000\u0272\u0273\u0003X,\u0000\u0273"+
		"\u0274\u0005\u0011\u0000\u0000\u0274k\u0001\u0000\u0000\u0000/su~\u0085"+
		"\u0087\u008f\u0098\u00a3\u00ae\u00b7\u00db\u00e3\u00ed\u010a\u010e\u0115"+
		"\u013e\u0148\u014b\u015f\u0168\u0170\u0178\u0184\u0191\u0198\u01a7\u01ae"+
		"\u01c0\u01c5\u01cf\u01d2\u01dc\u01e7\u01ef\u01fb\u01fe\u0203\u0216\u021a"+
		"\u0228\u023d\u0243\u024f\u0251\u0259\u025b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}