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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, RELOP=7, COMMENTLINE=8, 
		COMMENTBLOCK=9, BIB=10, INT=11, FLOAT=12, CHAR=13, DOUBLE=14, VOID=15, 
		MAIN=16, COMMA=17, PV=18, PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, 
		AND=24, OR=25, NOT=26, CD=27, CE=28, PD=29, PE=30, CO=31, CC=32, SOMA=33, 
		SUB=34, ASSIGN=35, DOT=36, RETURN=37, SCAN=38, PRINT=39, GETS=40, PUTS=41, 
		STRUCT=42, UNION=43, IF=44, ELSE=45, SWITCH=46, CASE=47, BREAK=48, DEFAULT=49, 
		WHILE=50, FOR=51, DO=52, TYPEOF=53, WS=54, VAR=55, NUM=56, CONSTANT=57, 
		CHARLIT=58, FORMAT=59, STR=60;
	public static final int
		RULE_programa = 0, RULE_cabecalho = 1, RULE_includeDecl = 2, RULE_defineDecl = 3, 
		RULE_corpo = 4, RULE_mainFunction = 5, RULE_functionDecl = 6, RULE_functionblock = 7, 
		RULE_bloco = 8, RULE_structDecl = 9, RULE_structInstDecl = 10, RULE_structMember = 11, 
		RULE_structAccess = 12, RULE_structFieldAccess = 13, RULE_linhas = 14, 
		RULE_comentario = 15, RULE_atrib = 16, RULE_callFunction = 17, RULE_arrayDecl = 18, 
		RULE_size = 19, RULE_elementosArray = 20, RULE_arrayAccess = 21, RULE_pointerDecl = 22, 
		RULE_pointerAssign = 23, RULE_pointerDereference = 24, RULE_input = 25, 
		RULE_output = 26, RULE_getsStmt = 27, RULE_putsStmt = 28, RULE_structLiteral = 29, 
		RULE_parametros = 30, RULE_tipo = 31, RULE_argumentos = 32, RULE_unionDecl = 33, 
		RULE_unionFields = 34, RULE_unionAccess = 35, RULE_decisionFunc = 36, 
		RULE_switchCase = 37, RULE_caseBlock = 38, RULE_defaultBlock = 39, RULE_loopFunc = 40, 
		RULE_whileLoop = 41, RULE_forLoop = 42, RULE_doWhileLoop = 43, RULE_expression = 44, 
		RULE_arrayUpdate = 45, RULE_terminais = 46, RULE_fator = 47, RULE_argument = 48, 
		RULE_exprbloco = 49, RULE_casting = 50, RULE_typeof = 51, RULE_ternary = 52, 
		RULE_returnStmt = 53;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "cabecalho", "includeDecl", "defineDecl", "corpo", "mainFunction", 
			"functionDecl", "functionblock", "bloco", "structDecl", "structInstDecl", 
			"structMember", "structAccess", "structFieldAccess", "linhas", "comentario", 
			"atrib", "callFunction", "arrayDecl", "size", "elementosArray", "arrayAccess", 
			"pointerDecl", "pointerAssign", "pointerDereference", "input", "output", 
			"getsStmt", "putsStmt", "structLiteral", "parametros", "tipo", "argumentos", 
			"unionDecl", "unionFields", "unionAccess", "decisionFunc", "switchCase", 
			"caseBlock", "defaultBlock", "loopFunc", "whileLoop", "forLoop", "doWhileLoop", 
			"expression", "arrayUpdate", "terminais", "fator", "argument", "exprbloco", 
			"casting", "typeof", "ternary", "returnStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#'", "'include'", "'define'", "'&'", "':'", "'?'", null, null, 
			null, null, "'int'", "'float'", "'char'", "'double'", "'void'", "'main'", 
			"','", "';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", 
			"'{'", "'}'", "'('", "')'", "'['", "']'", "'++'", "'--'", "'='", "'.'", 
			"'return'", "'scanf'", "'printf'", "'gets'", "'puts'", "'struct'", "'union'", 
			"'if'", "'else'", "'switch'", "'case'", "'break'", "'default'", "'while'", 
			"'for'", "'do'", "'typeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "RELOP", "COMMENTLINE", "COMMENTBLOCK", 
			"BIB", "INT", "FLOAT", "CHAR", "DOUBLE", "VOID", "MAIN", "COMMA", "PV", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "AND", "OR", "NOT", "CD", "CE", 
			"PD", "PE", "CO", "CC", "SOMA", "SUB", "ASSIGN", "DOT", "RETURN", "SCAN", 
			"PRINT", "GETS", "PUTS", "STRUCT", "UNION", "IF", "ELSE", "SWITCH", "CASE", 
			"BREAK", "DEFAULT", "WHILE", "FOR", "DO", "TYPEOF", "WS", "VAR", "NUM", 
			"CONSTANT", "CHARLIT", "FORMAT", "STR"
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
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(112);
					includeDecl();
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(120);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
						{
						setState(118);
						defineDecl();
						}
						break;
					case COMMENTLINE:
					case COMMENTBLOCK:
						{
						setState(119);
						comentario();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		public TerminalNode BIB() { return getToken(LangGrammarParser.BIB, 0); }
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
			setState(125);
			match(T__0);
			setState(126);
			match(T__1);
			setState(127);
			match(BIB);
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode CONSTANT() { return getToken(LangGrammarParser.CONSTANT, 0); }
		public TerminalNode CHARLIT() { return getToken(LangGrammarParser.CHARLIT, 0); }
		public DefineDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineDecl; }
	}

	public final DefineDeclContext defineDecl() throws RecognitionException {
		DefineDeclContext _localctx = new DefineDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defineDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__0);
			setState(130);
			match(T__2);
			setState(131);
			match(VAR);
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 504403158265495552L) != 0)) ) {
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
	public static class CorpoContext extends ParserRuleContext {
		public List<StructDeclContext> structDecl() {
			return getRuleContexts(StructDeclContext.class);
		}
		public StructDeclContext structDecl(int i) {
			return getRuleContext(StructDeclContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<MainFunctionContext> mainFunction() {
			return getRuleContexts(MainFunctionContext.class);
		}
		public MainFunctionContext mainFunction(int i) {
			return getRuleContext(MainFunctionContext.class,i);
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
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36041991158561536L) != 0)) {
				{
				setState(139);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(134);
					structDecl();
					}
					break;
				case 2:
					{
					setState(135);
					functionDecl();
					}
					break;
				case 3:
					{
					setState(136);
					mainFunction();
					}
					break;
				case 4:
					{
					setState(137);
					unionDecl();
					}
					break;
				case 5:
					{
					setState(138);
					comentario();
					}
					break;
				}
				}
				setState(143);
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
			setState(144);
			match(INT);
			setState(145);
			match(MAIN);
			setState(146);
			match(PD);
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(147);
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
			setState(151);
			match(PE);
			setState(152);
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
	public static class FunctionDeclContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public FunctionblockContext functionblock() {
			return getRuleContext(FunctionblockContext.class,0);
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
		enterRule(_localctx, 12, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			tipo();
			setState(155);
			match(VAR);
			setState(156);
			match(PD);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36041991158560768L) != 0)) {
				{
				setState(157);
				parametros();
				}
			}

			setState(160);
			match(PE);
			setState(161);
			functionblock();
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
	public static class FunctionblockContext extends ParserRuleContext {
		public TerminalNode CD() { return getToken(LangGrammarParser.CD, 0); }
		public TerminalNode CE() { return getToken(LangGrammarParser.CE, 0); }
		public List<LinhasContext> linhas() {
			return getRuleContexts(LinhasContext.class);
		}
		public LinhasContext linhas(int i) {
			return getRuleContext(LinhasContext.class,i);
		}
		public FunctionblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionblock; }
	}

	public final FunctionblockContext functionblock() throws RecognitionException {
		FunctionblockContext _localctx = new FunctionblockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(CD);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1710347374911617792L) != 0)) {
				{
				{
				setState(164);
				linhas();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
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
		enterRule(_localctx, 16, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(CD);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1710347374911617792L) != 0)) {
				{
				{
				setState(173);
				linhas();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
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
		enterRule(_localctx, 18, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(STRUCT);
			setState(182);
			match(VAR);
			setState(183);
			match(CD);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36041991158560768L) != 0)) {
				{
				{
				setState(184);
				structMember();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			match(CE);
			setState(191);
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
		enterRule(_localctx, 20, RULE_structInstDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(STRUCT);
			setState(194);
			match(VAR);
			setState(195);
			match(VAR);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(196);
				match(ASSIGN);
				setState(197);
				structLiteral();
				}
			}

			setState(200);
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
		enterRule(_localctx, 22, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			tipo();
			setState(203);
			match(VAR);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CO) {
				{
				setState(204);
				match(CO);
				setState(205);
				_la = _input.LA(1);
				if ( !(_la==NUM || _la==CONSTANT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(206);
				match(CC);
				}
			}

			setState(209);
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
		enterRule(_localctx, 24, RULE_structAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(VAR);
			setState(212);
			match(DOT);
			setState(213);
			match(VAR);
			setState(214);
			match(ASSIGN);
			setState(215);
			expression();
			setState(216);
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
		enterRule(_localctx, 26, RULE_structFieldAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(VAR);
			setState(219);
			match(DOT);
			setState(220);
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
		public CallFunctionContext callFunction() {
			return getRuleContext(CallFunctionContext.class,0);
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
		enterRule(_localctx, 28, RULE_linhas);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				unionAccess();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				structAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				callFunction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				atrib();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				comentario();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				arrayDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(228);
				pointerDecl();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(229);
				pointerAssign();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(230);
				pointerDereference();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(231);
				input();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(232);
				output();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(233);
				getsStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(234);
				putsStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(235);
				decisionFunc();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(236);
				switchCase();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(237);
				loopFunc();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(238);
				doWhileLoop();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(239);
				casting();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(240);
				typeof();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(241);
				ternary();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(242);
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
		enterRule(_localctx, 30, RULE_comentario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
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
		enterRule(_localctx, 32, RULE_atrib);
		int _la;
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				tipo();
				setState(248);
				match(VAR);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(249);
					match(ASSIGN);
					setState(250);
					expression();
					}
				}

				setState(253);
				match(PV);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(VAR);
				setState(256);
				match(ASSIGN);
				setState(257);
				expression();
				setState(258);
				match(PV);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
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
	public static class CallFunctionContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
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
		public CallFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callFunction; }
	}

	public final CallFunctionContext callFunction() throws RecognitionException {
		CallFunctionContext _localctx = new CallFunctionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_callFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(VAR);
			setState(264);
			match(PD);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1693353460629504000L) != 0)) {
				{
				setState(265);
				expression();
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(266);
					match(COMMA);
					setState(267);
					expression();
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(275);
			match(PE);
			setState(276);
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
		enterRule(_localctx, 36, RULE_arrayDecl);
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				tipo();
				setState(279);
				match(VAR);
				setState(280);
				match(CO);
				setState(281);
				size();
				setState(282);
				match(CC);
				setState(283);
				match(ASSIGN);
				setState(284);
				match(STR);
				setState(285);
				match(PV);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				tipo();
				setState(288);
				match(VAR);
				setState(289);
				match(CO);
				setState(290);
				size();
				setState(291);
				match(CC);
				setState(292);
				match(ASSIGN);
				setState(293);
				match(CD);
				setState(294);
				elementosArray();
				setState(295);
				match(CE);
				setState(296);
				match(PV);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				tipo();
				setState(299);
				match(VAR);
				setState(300);
				match(CO);
				setState(301);
				size();
				setState(302);
				match(CC);
				setState(303);
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
		enterRule(_localctx, 38, RULE_size);
		try {
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
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
		enterRule(_localctx, 40, RULE_elementosArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			expression();
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(312);
				match(COMMA);
				setState(313);
				expression();
				}
				}
				setState(318);
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
		enterRule(_localctx, 42, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(VAR);
			setState(320);
			match(CO);
			setState(321);
			expression();
			setState(322);
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
		enterRule(_localctx, 44, RULE_pointerDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(325);
			match(MULT);
			setState(326);
			match(VAR);
			setState(327);
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
		enterRule(_localctx, 46, RULE_pointerAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(VAR);
			setState(330);
			match(ASSIGN);
			setState(331);
			match(T__3);
			setState(332);
			match(VAR);
			setState(333);
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
		enterRule(_localctx, 48, RULE_pointerDereference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(MULT);
			setState(336);
			match(VAR);
			setState(337);
			match(ASSIGN);
			setState(338);
			expression();
			setState(339);
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
		enterRule(_localctx, 50, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(SCAN);
			setState(342);
			match(PD);
			setState(343);
			match(FORMAT);
			setState(344);
			match(COMMA);
			setState(345);
			match(T__3);
			setState(346);
			match(VAR);
			setState(347);
			match(PE);
			setState(348);
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
		enterRule(_localctx, 52, RULE_output);
		int _la;
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				match(PRINT);
				setState(351);
				match(PD);
				setState(352);
				match(STR);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(353);
					match(COMMA);
					setState(354);
					((OutputContext)_localctx).argument = argument();
					((OutputContext)_localctx).arg.add(((OutputContext)_localctx).argument);
					}
					}
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(360);
				match(PE);
				setState(361);
				match(PV);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(STR);
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(363);
					match(COMMA);
					setState(364);
					((OutputContext)_localctx).argument = argument();
					((OutputContext)_localctx).arg.add(((OutputContext)_localctx).argument);
					}
					}
					setState(369);
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
		enterRule(_localctx, 54, RULE_getsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(GETS);
			setState(373);
			match(PD);
			setState(374);
			match(VAR);
			setState(375);
			match(PE);
			setState(376);
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
		enterRule(_localctx, 56, RULE_putsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(PUTS);
			setState(379);
			match(PD);
			setState(380);
			match(VAR);
			setState(381);
			match(PE);
			setState(382);
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
		enterRule(_localctx, 58, RULE_structLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(CD);
			setState(385);
			expression();
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(386);
				match(COMMA);
				setState(387);
				expression();
				}
				}
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(393);
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
			setState(395);
			tipo();
			setState(396);
			match(VAR);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(397);
				match(COMMA);
				setState(398);
				tipo();
				setState(399);
				match(VAR);
				}
				}
				setState(405);
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
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(406);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				match(FLOAT);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(408);
				match(CHAR);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(409);
				match(DOUBLE);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 5);
				{
				setState(410);
				match(VOID);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 6);
				{
				setState(411);
				match(STRUCT);
				setState(412);
				match(VAR);
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 7);
				{
				setState(413);
				match(UNION);
				setState(414);
				match(VAR);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(415);
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
			setState(418);
			expression();
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(419);
				match(COMMA);
				setState(420);
				expression();
				}
				}
				setState(425);
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
			setState(426);
			match(UNION);
			setState(427);
			match(VAR);
			setState(428);
			match(CD);
			setState(429);
			unionFields();
			setState(430);
			match(CE);
			setState(431);
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
			setState(436); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(433);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(434);
				match(VAR);
				setState(435);
				match(PV);
				}
				}
				setState(438); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0) );
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
			setState(440);
			match(VAR);
			setState(441);
			match(DOT);
			setState(442);
			match(VAR);
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(443);
				match(ASSIGN);
				setState(444);
				expression();
				}
			}

			setState(447);
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
			setState(449);
			match(IF);
			setState(450);
			match(PD);
			setState(451);
			exprbloco(0);
			setState(452);
			match(PE);
			setState(453);
			bloco();
			setState(463);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(454);
					match(ELSE);
					setState(455);
					match(IF);
					setState(456);
					match(PD);
					setState(457);
					exprbloco(0);
					setState(458);
					match(PE);
					setState(459);
					bloco();
					}
					} 
				}
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(466);
				match(ELSE);
				setState(467);
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
			setState(470);
			match(SWITCH);
			setState(471);
			match(PD);
			setState(472);
			match(VAR);
			setState(473);
			match(PE);
			setState(474);
			match(CD);
			setState(476); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(475);
				caseBlock();
				}
				}
				setState(478); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(480);
				defaultBlock();
				}
			}

			setState(483);
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
			setState(485);
			match(CASE);
			setState(486);
			match(NUM);
			setState(487);
			match(T__4);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1710347374911617792L) != 0)) {
				{
				{
				setState(488);
				linhas();
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(494);
			match(BREAK);
			setState(495);
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
			setState(497);
			match(DEFAULT);
			setState(498);
			match(T__4);
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1710347374911617792L) != 0)) {
				{
				{
				setState(499);
				linhas();
				}
				}
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(505);
			match(BREAK);
			setState(506);
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
			setState(510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				whileLoop();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
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
			setState(512);
			match(WHILE);
			setState(513);
			match(PD);
			setState(514);
			exprbloco(0);
			setState(515);
			match(PE);
			setState(516);
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
			setState(518);
			match(FOR);
			setState(519);
			match(PD);
			setState(522);
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
				setState(520);
				atrib();
				}
				break;
			case PV:
				{
				setState(521);
				match(PV);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1693353460629504000L) != 0)) {
				{
				setState(524);
				exprbloco(0);
				}
			}

			setState(527);
			match(PV);
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(528);
				atrib();
				}
				break;
			case 2:
				{
				setState(529);
				expression();
				}
				break;
			}
			setState(532);
			match(PE);
			setState(533);
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
			setState(535);
			match(DO);
			setState(536);
			bloco();
			setState(537);
			match(WHILE);
			setState(538);
			match(PD);
			setState(539);
			exprbloco(0);
			setState(540);
			match(PE);
			setState(541);
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
		public CallFunctionContext callFunction() {
			return getRuleContext(CallFunctionContext.class,0);
		}
		public StructFieldAccessContext structFieldAccess() {
			return getRuleContext(StructFieldAccessContext.class,0);
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
			setState(555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(543);
				structLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
				terminais();
				setState(549);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(545);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(546);
						terminais();
						}
						} 
					}
					setState(551);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(552);
				arrayAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(553);
				callFunction();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(554);
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
			setState(557);
			match(VAR);
			setState(558);
			match(CO);
			setState(559);
			expression();
			setState(560);
			match(CC);
			setState(561);
			match(ASSIGN);
			setState(562);
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
			setState(564);
			fator();
			setState(569);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(565);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(566);
					fator();
					}
					} 
				}
				setState(571);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
			setState(590);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(572);
				match(NOT);
				setState(573);
				fator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(574);
				match(PD);
				setState(575);
				expression();
				setState(576);
				match(PE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(578);
				arrayAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(579);
				structFieldAccess();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(580);
				structAccess();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(581);
				match(NUM);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(582);
				match(CONSTANT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(583);
				match(VAR);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(584);
				match(STR);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(585);
				match(CHARLIT);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(586);
				match(VAR);
				setState(587);
				match(SOMA);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(588);
				match(VAR);
				setState(589);
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
			setState(596);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				exprbloco(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(594);
				arrayAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(595);
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
			setState(610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				_localctx = new ParentesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(599);
				match(PD);
				setState(600);
				exprbloco(0);
				setState(601);
				match(PE);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(603);
				match(NOT);
				setState(604);
				exprbloco(4);
				}
				break;
			case 3:
				{
				_localctx = new RelationalExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(605);
				expression();
				setState(608);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(606);
					match(RELOP);
					setState(607);
					expression();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(620);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(618);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						_localctx = new AndExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(612);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(613);
						match(AND);
						setState(614);
						exprbloco(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(615);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(616);
						match(OR);
						setState(617);
						exprbloco(3);
						}
						break;
					}
					} 
				}
				setState(622);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
			setState(623);
			match(PD);
			setState(624);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(625);
			match(PE);
			setState(626);
			match(VAR);
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
			setState(629);
			match(TYPEOF);
			setState(630);
			match(PD);
			setState(631);
			match(VAR);
			setState(632);
			match(PE);
			setState(633);
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
			setState(635);
			exprbloco(0);
			setState(636);
			match(T__5);
			setState(637);
			expression();
			setState(638);
			match(T__4);
			setState(639);
			expression();
			setState(640);
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
		public TerminalNode PV() { return getToken(LangGrammarParser.PV, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			match(RETURN);
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1693353460629504000L) != 0)) {
				{
				setState(643);
				expression();
				}
			}

			setState(646);
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
		"\u0004\u0001<\u0289\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001r\b\u0001\n\u0001\f\u0001"+
		"u\t\u0001\u0001\u0001\u0001\u0001\u0005\u0001y\b\u0001\n\u0001\f\u0001"+
		"|\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u008c\b\u0004\n\u0004"+
		"\f\u0004\u008f\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0096\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009f\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u00a6\b\u0007\n\u0007\f\u0007\u00a9\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0005\b\u00af\b\b\n\b\f\b\u00b2\t\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u00ba\b\t\n\t\f\t\u00bd\t\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c7\b\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00d0\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00f4\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00fc"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0106\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u010d\b\u0011\n"+
		"\u0011\f\u0011\u0110\t\u0011\u0003\u0011\u0112\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0132"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u0136\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u013b\b\u0014\n\u0014\f\u0014\u013e"+
		"\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u0164\b\u001a\n\u001a\f\u001a\u0167\t\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u016e\b\u001a"+
		"\n\u001a\f\u001a\u0171\t\u001a\u0003\u001a\u0173\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0185\b\u001d\n\u001d\f\u001d"+
		"\u0188\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0192\b\u001e\n\u001e"+
		"\f\u001e\u0195\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u01a1\b\u001f\u0001 \u0001 \u0001 \u0005 \u01a6\b \n \f "+
		"\u01a9\t \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0004\"\u01b5\b\"\u000b\"\f\"\u01b6\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0003#\u01be\b#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0005$\u01ce\b$\n$"+
		"\f$\u01d1\t$\u0001$\u0001$\u0003$\u01d5\b$\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0004%\u01dd\b%\u000b%\f%\u01de\u0001%\u0003%\u01e2\b"+
		"%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0005&\u01ea\b&\n&\f&\u01ed"+
		"\t&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0005\'\u01f5\b\'\n\'"+
		"\f\'\u01f8\t\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0003(\u01ff\b(\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u020b\b*\u0001*\u0003*\u020e\b*\u0001*\u0001*\u0001*\u0003*\u0213\b"+
		"*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001,\u0001,\u0001,\u0001,\u0005,\u0224\b,\n,\f,\u0227\t,\u0001"+
		",\u0001,\u0001,\u0003,\u022c\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001.\u0001.\u0001.\u0005.\u0238\b.\n.\f.\u023b\t.\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003/\u024f\b/\u00010\u0001"+
		"0\u00010\u00010\u00030\u0255\b0\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00031\u0261\b1\u00031\u0263\b1\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00051\u026b\b1\n1\f1\u026e\t1\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u00013\u0001"+
		"3\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00015\u00015\u0003"+
		"5\u0285\b5\u00015\u00015\u00015\u0000\u0001b6\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPRTVXZ\\^`bdfhj\u0000\u0006\u0001\u00008:\u0001\u0000"+
		"89\u0001\u0000\b\t\u0001\u0000\u000b\u000f\u0001\u0000\u0013\u0014\u0001"+
		"\u0000\u0015\u0017\u02b1\u0000l\u0001\u0000\u0000\u0000\u0002s\u0001\u0000"+
		"\u0000\u0000\u0004}\u0001\u0000\u0000\u0000\u0006\u0081\u0001\u0000\u0000"+
		"\u0000\b\u008d\u0001\u0000\u0000\u0000\n\u0090\u0001\u0000\u0000\u0000"+
		"\f\u009a\u0001\u0000\u0000\u0000\u000e\u00a3\u0001\u0000\u0000\u0000\u0010"+
		"\u00ac\u0001\u0000\u0000\u0000\u0012\u00b5\u0001\u0000\u0000\u0000\u0014"+
		"\u00c1\u0001\u0000\u0000\u0000\u0016\u00ca\u0001\u0000\u0000\u0000\u0018"+
		"\u00d3\u0001\u0000\u0000\u0000\u001a\u00da\u0001\u0000\u0000\u0000\u001c"+
		"\u00f3\u0001\u0000\u0000\u0000\u001e\u00f5\u0001\u0000\u0000\u0000 \u0105"+
		"\u0001\u0000\u0000\u0000\"\u0107\u0001\u0000\u0000\u0000$\u0131\u0001"+
		"\u0000\u0000\u0000&\u0135\u0001\u0000\u0000\u0000(\u0137\u0001\u0000\u0000"+
		"\u0000*\u013f\u0001\u0000\u0000\u0000,\u0144\u0001\u0000\u0000\u0000."+
		"\u0149\u0001\u0000\u0000\u00000\u014f\u0001\u0000\u0000\u00002\u0155\u0001"+
		"\u0000\u0000\u00004\u0172\u0001\u0000\u0000\u00006\u0174\u0001\u0000\u0000"+
		"\u00008\u017a\u0001\u0000\u0000\u0000:\u0180\u0001\u0000\u0000\u0000<"+
		"\u018b\u0001\u0000\u0000\u0000>\u01a0\u0001\u0000\u0000\u0000@\u01a2\u0001"+
		"\u0000\u0000\u0000B\u01aa\u0001\u0000\u0000\u0000D\u01b4\u0001\u0000\u0000"+
		"\u0000F\u01b8\u0001\u0000\u0000\u0000H\u01c1\u0001\u0000\u0000\u0000J"+
		"\u01d6\u0001\u0000\u0000\u0000L\u01e5\u0001\u0000\u0000\u0000N\u01f1\u0001"+
		"\u0000\u0000\u0000P\u01fe\u0001\u0000\u0000\u0000R\u0200\u0001\u0000\u0000"+
		"\u0000T\u0206\u0001\u0000\u0000\u0000V\u0217\u0001\u0000\u0000\u0000X"+
		"\u022b\u0001\u0000\u0000\u0000Z\u022d\u0001\u0000\u0000\u0000\\\u0234"+
		"\u0001\u0000\u0000\u0000^\u024e\u0001\u0000\u0000\u0000`\u0254\u0001\u0000"+
		"\u0000\u0000b\u0262\u0001\u0000\u0000\u0000d\u026f\u0001\u0000\u0000\u0000"+
		"f\u0275\u0001\u0000\u0000\u0000h\u027b\u0001\u0000\u0000\u0000j\u0282"+
		"\u0001\u0000\u0000\u0000lm\u0003\u0002\u0001\u0000mn\u0003\b\u0004\u0000"+
		"no\u0005\u0000\u0000\u0001o\u0001\u0001\u0000\u0000\u0000pr\u0003\u0004"+
		"\u0002\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tz\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vy\u0003\u0006\u0003\u0000wy\u0003\u001e\u000f"+
		"\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0003"+
		"\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005\u0001\u0000"+
		"\u0000~\u007f\u0005\u0002\u0000\u0000\u007f\u0080\u0005\n\u0000\u0000"+
		"\u0080\u0005\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0001\u0000\u0000"+
		"\u0082\u0083\u0005\u0003\u0000\u0000\u0083\u0084\u00057\u0000\u0000\u0084"+
		"\u0085\u0007\u0000\u0000\u0000\u0085\u0007\u0001\u0000\u0000\u0000\u0086"+
		"\u008c\u0003\u0012\t\u0000\u0087\u008c\u0003\f\u0006\u0000\u0088\u008c"+
		"\u0003\n\u0005\u0000\u0089\u008c\u0003B!\u0000\u008a\u008c\u0003\u001e"+
		"\u000f\u0000\u008b\u0086\u0001\u0000\u0000\u0000\u008b\u0087\u0001\u0000"+
		"\u0000\u0000\u008b\u0088\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\t\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005\u000b\u0000\u0000\u0091\u0092\u0005\u0010\u0000"+
		"\u0000\u0092\u0095\u0005\u001d\u0000\u0000\u0093\u0096\u0005\u000f\u0000"+
		"\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005\u001e\u0000\u0000\u0098\u0099\u0003\u0010\b\u0000"+
		"\u0099\u000b\u0001\u0000\u0000\u0000\u009a\u009b\u0003>\u001f\u0000\u009b"+
		"\u009c\u00057\u0000\u0000\u009c\u009e\u0005\u001d\u0000\u0000\u009d\u009f"+
		"\u0003<\u001e\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"\u001e\u0000\u0000\u00a1\u00a2\u0003\u000e\u0007\u0000\u00a2\r\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a7\u0005\u001b\u0000\u0000\u00a4\u00a6\u0003\u001c"+
		"\u000e\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005\u001c\u0000\u0000\u00ab\u000f\u0001\u0000"+
		"\u0000\u0000\u00ac\u00b0\u0005\u001b\u0000\u0000\u00ad\u00af\u0003\u001c"+
		"\u000e\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0005\u001c\u0000\u0000\u00b4\u0011\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0005*\u0000\u0000\u00b6\u00b7\u00057\u0000\u0000"+
		"\u00b7\u00bb\u0005\u001b\u0000\u0000\u00b8\u00ba\u0003\u0016\u000b\u0000"+
		"\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0005\u001c\u0000\u0000\u00bf\u00c0\u0005\u0012\u0000\u0000"+
		"\u00c0\u0013\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005*\u0000\u0000\u00c2"+
		"\u00c3\u00057\u0000\u0000\u00c3\u00c6\u00057\u0000\u0000\u00c4\u00c5\u0005"+
		"#\u0000\u0000\u00c5\u00c7\u0003:\u001d\u0000\u00c6\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0005\u0012\u0000\u0000\u00c9\u0015\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0003>\u001f\u0000\u00cb\u00cf\u00057\u0000\u0000\u00cc"+
		"\u00cd\u0005\u001f\u0000\u0000\u00cd\u00ce\u0007\u0001\u0000\u0000\u00ce"+
		"\u00d0\u0005 \u0000\u0000\u00cf\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0005\u0012\u0000\u0000\u00d2\u0017\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u00057\u0000\u0000\u00d4\u00d5\u0005$\u0000\u0000\u00d5\u00d6\u00057"+
		"\u0000\u0000\u00d6\u00d7\u0005#\u0000\u0000\u00d7\u00d8\u0003X,\u0000"+
		"\u00d8\u00d9\u0005\u0012\u0000\u0000\u00d9\u0019\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u00057\u0000\u0000\u00db\u00dc\u0005$\u0000\u0000\u00dc\u00dd"+
		"\u00057\u0000\u0000\u00dd\u001b\u0001\u0000\u0000\u0000\u00de\u00f4\u0003"+
		"F#\u0000\u00df\u00f4\u0003\u0018\f\u0000\u00e0\u00f4\u0003\"\u0011\u0000"+
		"\u00e1\u00f4\u0003 \u0010\u0000\u00e2\u00f4\u0003\u001e\u000f\u0000\u00e3"+
		"\u00f4\u0003$\u0012\u0000\u00e4\u00f4\u0003,\u0016\u0000\u00e5\u00f4\u0003"+
		".\u0017\u0000\u00e6\u00f4\u00030\u0018\u0000\u00e7\u00f4\u00032\u0019"+
		"\u0000\u00e8\u00f4\u00034\u001a\u0000\u00e9\u00f4\u00036\u001b\u0000\u00ea"+
		"\u00f4\u00038\u001c\u0000\u00eb\u00f4\u0003H$\u0000\u00ec\u00f4\u0003"+
		"J%\u0000\u00ed\u00f4\u0003P(\u0000\u00ee\u00f4\u0003V+\u0000\u00ef\u00f4"+
		"\u0003d2\u0000\u00f0\u00f4\u0003f3\u0000\u00f1\u00f4\u0003h4\u0000\u00f2"+
		"\u00f4\u0003j5\u0000\u00f3\u00de\u0001\u0000\u0000\u0000\u00f3\u00df\u0001"+
		"\u0000\u0000\u0000\u00f3\u00e0\u0001\u0000\u0000\u0000\u00f3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00f3\u00e2\u0001\u0000\u0000\u0000\u00f3\u00e3\u0001"+
		"\u0000\u0000\u0000\u00f3\u00e4\u0001\u0000\u0000\u0000\u00f3\u00e5\u0001"+
		"\u0000\u0000\u0000\u00f3\u00e6\u0001\u0000\u0000\u0000\u00f3\u00e7\u0001"+
		"\u0000\u0000\u0000\u00f3\u00e8\u0001\u0000\u0000\u0000\u00f3\u00e9\u0001"+
		"\u0000\u0000\u0000\u00f3\u00ea\u0001\u0000\u0000\u0000\u00f3\u00eb\u0001"+
		"\u0000\u0000\u0000\u00f3\u00ec\u0001\u0000\u0000\u0000\u00f3\u00ed\u0001"+
		"\u0000\u0000\u0000\u00f3\u00ee\u0001\u0000\u0000\u0000\u00f3\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u001d\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0007\u0002\u0000\u0000\u00f6\u001f\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0003>\u001f\u0000\u00f8\u00fb\u00057\u0000"+
		"\u0000\u00f9\u00fa\u0005#\u0000\u0000\u00fa\u00fc\u0003X,\u0000\u00fb"+
		"\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005\u0012\u0000\u0000\u00fe"+
		"\u0106\u0001\u0000\u0000\u0000\u00ff\u0100\u00057\u0000\u0000\u0100\u0101"+
		"\u0005#\u0000\u0000\u0101\u0102\u0003X,\u0000\u0102\u0103\u0005\u0012"+
		"\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0106\u0003\u0018"+
		"\f\u0000\u0105\u00f7\u0001\u0000\u0000\u0000\u0105\u00ff\u0001\u0000\u0000"+
		"\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106!\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u00057\u0000\u0000\u0108\u0111\u0005\u001d\u0000\u0000\u0109"+
		"\u010e\u0003X,\u0000\u010a\u010b\u0005\u0011\u0000\u0000\u010b\u010d\u0003"+
		"X,\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000"+
		"\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000"+
		"\u0000\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000"+
		"\u0000\u0111\u0109\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000"+
		"\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u001e\u0000"+
		"\u0000\u0114\u0115\u0005\u0012\u0000\u0000\u0115#\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\u0003>\u001f\u0000\u0117\u0118\u00057\u0000\u0000\u0118\u0119"+
		"\u0005\u001f\u0000\u0000\u0119\u011a\u0003&\u0013\u0000\u011a\u011b\u0005"+
		" \u0000\u0000\u011b\u011c\u0005#\u0000\u0000\u011c\u011d\u0005<\u0000"+
		"\u0000\u011d\u011e\u0005\u0012\u0000\u0000\u011e\u0132\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0003>\u001f\u0000\u0120\u0121\u00057\u0000\u0000\u0121"+
		"\u0122\u0005\u001f\u0000\u0000\u0122\u0123\u0003&\u0013\u0000\u0123\u0124"+
		"\u0005 \u0000\u0000\u0124\u0125\u0005#\u0000\u0000\u0125\u0126\u0005\u001b"+
		"\u0000\u0000\u0126\u0127\u0003(\u0014\u0000\u0127\u0128\u0005\u001c\u0000"+
		"\u0000\u0128\u0129\u0005\u0012\u0000\u0000\u0129\u0132\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0003>\u001f\u0000\u012b\u012c\u00057\u0000\u0000\u012c"+
		"\u012d\u0005\u001f\u0000\u0000\u012d\u012e\u0003&\u0013\u0000\u012e\u012f"+
		"\u0005 \u0000\u0000\u012f\u0130\u0005\u0012\u0000\u0000\u0130\u0132\u0001"+
		"\u0000\u0000\u0000\u0131\u0116\u0001\u0000\u0000\u0000\u0131\u011f\u0001"+
		"\u0000\u0000\u0000\u0131\u012a\u0001\u0000\u0000\u0000\u0132%\u0001\u0000"+
		"\u0000\u0000\u0133\u0136\u00058\u0000\u0000\u0134\u0136\u0001\u0000\u0000"+
		"\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135\u0134\u0001\u0000\u0000"+
		"\u0000\u0136\'\u0001\u0000\u0000\u0000\u0137\u013c\u0003X,\u0000\u0138"+
		"\u0139\u0005\u0011\u0000\u0000\u0139\u013b\u0003X,\u0000\u013a\u0138\u0001"+
		"\u0000\u0000\u0000\u013b\u013e\u0001\u0000\u0000\u0000\u013c\u013a\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d)\u0001\u0000"+
		"\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0140\u00057\u0000"+
		"\u0000\u0140\u0141\u0005\u001f\u0000\u0000\u0141\u0142\u0003X,\u0000\u0142"+
		"\u0143\u0005 \u0000\u0000\u0143+\u0001\u0000\u0000\u0000\u0144\u0145\u0007"+
		"\u0003\u0000\u0000\u0145\u0146\u0005\u0015\u0000\u0000\u0146\u0147\u0005"+
		"7\u0000\u0000\u0147\u0148\u0005\u0012\u0000\u0000\u0148-\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u00057\u0000\u0000\u014a\u014b\u0005#\u0000\u0000\u014b"+
		"\u014c\u0005\u0004\u0000\u0000\u014c\u014d\u00057\u0000\u0000\u014d\u014e"+
		"\u0005\u0012\u0000\u0000\u014e/\u0001\u0000\u0000\u0000\u014f\u0150\u0005"+
		"\u0015\u0000\u0000\u0150\u0151\u00057\u0000\u0000\u0151\u0152\u0005#\u0000"+
		"\u0000\u0152\u0153\u0003X,\u0000\u0153\u0154\u0005\u0012\u0000\u0000\u0154"+
		"1\u0001\u0000\u0000\u0000\u0155\u0156\u0005&\u0000\u0000\u0156\u0157\u0005"+
		"\u001d\u0000\u0000\u0157\u0158\u0005;\u0000\u0000\u0158\u0159\u0005\u0011"+
		"\u0000\u0000\u0159\u015a\u0005\u0004\u0000\u0000\u015a\u015b\u00057\u0000"+
		"\u0000\u015b\u015c\u0005\u001e\u0000\u0000\u015c\u015d\u0005\u0012\u0000"+
		"\u0000\u015d3\u0001\u0000\u0000\u0000\u015e\u015f\u0005\'\u0000\u0000"+
		"\u015f\u0160\u0005\u001d\u0000\u0000\u0160\u0165\u0005<\u0000\u0000\u0161"+
		"\u0162\u0005\u0011\u0000\u0000\u0162\u0164\u0003`0\u0000\u0163\u0161\u0001"+
		"\u0000\u0000\u0000\u0164\u0167\u0001\u0000\u0000\u0000\u0165\u0163\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0168\u0001"+
		"\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0168\u0169\u0005"+
		"\u001e\u0000\u0000\u0169\u0173\u0005\u0012\u0000\u0000\u016a\u016f\u0005"+
		"<\u0000\u0000\u016b\u016c\u0005\u0011\u0000\u0000\u016c\u016e\u0003`0"+
		"\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016e\u0171\u0001\u0000\u0000"+
		"\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000"+
		"\u0000\u0170\u0173\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000\u0000"+
		"\u0000\u0172\u015e\u0001\u0000\u0000\u0000\u0172\u016a\u0001\u0000\u0000"+
		"\u0000\u01735\u0001\u0000\u0000\u0000\u0174\u0175\u0005(\u0000\u0000\u0175"+
		"\u0176\u0005\u001d\u0000\u0000\u0176\u0177\u00057\u0000\u0000\u0177\u0178"+
		"\u0005\u001e\u0000\u0000\u0178\u0179\u0005\u0012\u0000\u0000\u01797\u0001"+
		"\u0000\u0000\u0000\u017a\u017b\u0005)\u0000\u0000\u017b\u017c\u0005\u001d"+
		"\u0000\u0000\u017c\u017d\u00057\u0000\u0000\u017d\u017e\u0005\u001e\u0000"+
		"\u0000\u017e\u017f\u0005\u0012\u0000\u0000\u017f9\u0001\u0000\u0000\u0000"+
		"\u0180\u0181\u0005\u001b\u0000\u0000\u0181\u0186\u0003X,\u0000\u0182\u0183"+
		"\u0005\u0011\u0000\u0000\u0183\u0185\u0003X,\u0000\u0184\u0182\u0001\u0000"+
		"\u0000\u0000\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000"+
		"\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0189\u0001\u0000"+
		"\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0189\u018a\u0005\u001c"+
		"\u0000\u0000\u018a;\u0001\u0000\u0000\u0000\u018b\u018c\u0003>\u001f\u0000"+
		"\u018c\u0193\u00057\u0000\u0000\u018d\u018e\u0005\u0011\u0000\u0000\u018e"+
		"\u018f\u0003>\u001f\u0000\u018f\u0190\u00057\u0000\u0000\u0190\u0192\u0001"+
		"\u0000\u0000\u0000\u0191\u018d\u0001\u0000\u0000\u0000\u0192\u0195\u0001"+
		"\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0193\u0194\u0001"+
		"\u0000\u0000\u0000\u0194=\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000"+
		"\u0000\u0000\u0196\u01a1\u0005\u000b\u0000\u0000\u0197\u01a1\u0005\f\u0000"+
		"\u0000\u0198\u01a1\u0005\r\u0000\u0000\u0199\u01a1\u0005\u000e\u0000\u0000"+
		"\u019a\u01a1\u0005\u000f\u0000\u0000\u019b\u019c\u0005*\u0000\u0000\u019c"+
		"\u01a1\u00057\u0000\u0000\u019d\u019e\u0005+\u0000\u0000\u019e\u01a1\u0005"+
		"7\u0000\u0000\u019f\u01a1\u00057\u0000\u0000\u01a0\u0196\u0001\u0000\u0000"+
		"\u0000\u01a0\u0197\u0001\u0000\u0000\u0000\u01a0\u0198\u0001\u0000\u0000"+
		"\u0000\u01a0\u0199\u0001\u0000\u0000\u0000\u01a0\u019a\u0001\u0000\u0000"+
		"\u0000\u01a0\u019b\u0001\u0000\u0000\u0000\u01a0\u019d\u0001\u0000\u0000"+
		"\u0000\u01a0\u019f\u0001\u0000\u0000\u0000\u01a1?\u0001\u0000\u0000\u0000"+
		"\u01a2\u01a7\u0003X,\u0000\u01a3\u01a4\u0005\u0011\u0000\u0000\u01a4\u01a6"+
		"\u0003X,\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a9\u0001\u0000"+
		"\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000"+
		"\u0000\u0000\u01a8A\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000"+
		"\u0000\u01aa\u01ab\u0005+\u0000\u0000\u01ab\u01ac\u00057\u0000\u0000\u01ac"+
		"\u01ad\u0005\u001b\u0000\u0000\u01ad\u01ae\u0003D\"\u0000\u01ae\u01af"+
		"\u0005\u001c\u0000\u0000\u01af\u01b0\u0005\u0012\u0000\u0000\u01b0C\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0007\u0003\u0000\u0000\u01b2\u01b3\u0005"+
		"7\u0000\u0000\u01b3\u01b5\u0005\u0012\u0000\u0000\u01b4\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000"+
		"\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7E\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b9\u00057\u0000\u0000\u01b9\u01ba\u0005$\u0000\u0000\u01ba"+
		"\u01bd\u00057\u0000\u0000\u01bb\u01bc\u0005#\u0000\u0000\u01bc\u01be\u0003"+
		"X,\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000"+
		"\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005\u0012\u0000"+
		"\u0000\u01c0G\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005,\u0000\u0000\u01c2"+
		"\u01c3\u0005\u001d\u0000\u0000\u01c3\u01c4\u0003b1\u0000\u01c4\u01c5\u0005"+
		"\u001e\u0000\u0000\u01c5\u01cf\u0003\u0010\b\u0000\u01c6\u01c7\u0005-"+
		"\u0000\u0000\u01c7\u01c8\u0005,\u0000\u0000\u01c8\u01c9\u0005\u001d\u0000"+
		"\u0000\u01c9\u01ca\u0003b1\u0000\u01ca\u01cb\u0005\u001e\u0000\u0000\u01cb"+
		"\u01cc\u0003\u0010\b\u0000\u01cc\u01ce\u0001\u0000\u0000\u0000\u01cd\u01c6"+
		"\u0001\u0000\u0000\u0000\u01ce\u01d1\u0001\u0000\u0000\u0000\u01cf\u01cd"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d4"+
		"\u0001\u0000\u0000\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d2\u01d3"+
		"\u0005-\u0000\u0000\u01d3\u01d5\u0003\u0010\b\u0000\u01d4\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5I\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d7\u0005.\u0000\u0000\u01d7\u01d8\u0005\u001d\u0000"+
		"\u0000\u01d8\u01d9\u00057\u0000\u0000\u01d9\u01da\u0005\u001e\u0000\u0000"+
		"\u01da\u01dc\u0005\u001b\u0000\u0000\u01db\u01dd\u0003L&\u0000\u01dc\u01db"+
		"\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01dc"+
		"\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df\u01e1"+
		"\u0001\u0000\u0000\u0000\u01e0\u01e2\u0003N\'\u0000\u01e1\u01e0\u0001"+
		"\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001"+
		"\u0000\u0000\u0000\u01e3\u01e4\u0005\u001c\u0000\u0000\u01e4K\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e6\u0005/\u0000\u0000\u01e6\u01e7\u00058\u0000\u0000"+
		"\u01e7\u01eb\u0005\u0005\u0000\u0000\u01e8\u01ea\u0003\u001c\u000e\u0000"+
		"\u01e9\u01e8\u0001\u0000\u0000\u0000\u01ea\u01ed\u0001\u0000\u0000\u0000"+
		"\u01eb\u01e9\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ee\u0001\u0000\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000"+
		"\u01ee\u01ef\u00050\u0000\u0000\u01ef\u01f0\u0005\u0012\u0000\u0000\u01f0"+
		"M\u0001\u0000\u0000\u0000\u01f1\u01f2\u00051\u0000\u0000\u01f2\u01f6\u0005"+
		"\u0005\u0000\u0000\u01f3\u01f5\u0003\u001c\u000e\u0000\u01f4\u01f3\u0001"+
		"\u0000\u0000\u0000\u01f5\u01f8\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7\u01f9\u0001"+
		"\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f9\u01fa\u0005"+
		"0\u0000\u0000\u01fa\u01fb\u0005\u0012\u0000\u0000\u01fbO\u0001\u0000\u0000"+
		"\u0000\u01fc\u01ff\u0003R)\u0000\u01fd\u01ff\u0003T*\u0000\u01fe\u01fc"+
		"\u0001\u0000\u0000\u0000\u01fe\u01fd\u0001\u0000\u0000\u0000\u01ffQ\u0001"+
		"\u0000\u0000\u0000\u0200\u0201\u00052\u0000\u0000\u0201\u0202\u0005\u001d"+
		"\u0000\u0000\u0202\u0203\u0003b1\u0000\u0203\u0204\u0005\u001e\u0000\u0000"+
		"\u0204\u0205\u0003\u0010\b\u0000\u0205S\u0001\u0000\u0000\u0000\u0206"+
		"\u0207\u00053\u0000\u0000\u0207\u020a\u0005\u001d\u0000\u0000\u0208\u020b"+
		"\u0003 \u0010\u0000\u0209\u020b\u0005\u0012\u0000\u0000\u020a\u0208\u0001"+
		"\u0000\u0000\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020b\u020d\u0001"+
		"\u0000\u0000\u0000\u020c\u020e\u0003b1\u0000\u020d\u020c\u0001\u0000\u0000"+
		"\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000\u0000"+
		"\u0000\u020f\u0212\u0005\u0012\u0000\u0000\u0210\u0213\u0003 \u0010\u0000"+
		"\u0211\u0213\u0003X,\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212\u0211"+
		"\u0001\u0000\u0000\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214\u0215"+
		"\u0005\u001e\u0000\u0000\u0215\u0216\u0003\u0010\b\u0000\u0216U\u0001"+
		"\u0000\u0000\u0000\u0217\u0218\u00054\u0000\u0000\u0218\u0219\u0003\u0010"+
		"\b\u0000\u0219\u021a\u00052\u0000\u0000\u021a\u021b\u0005\u001d\u0000"+
		"\u0000\u021b\u021c\u0003b1\u0000\u021c\u021d\u0005\u001e\u0000\u0000\u021d"+
		"\u021e\u0005\u0012\u0000\u0000\u021eW\u0001\u0000\u0000\u0000\u021f\u022c"+
		"\u0003:\u001d\u0000\u0220\u0225\u0003\\.\u0000\u0221\u0222\u0007\u0004"+
		"\u0000\u0000\u0222\u0224\u0003\\.\u0000\u0223\u0221\u0001\u0000\u0000"+
		"\u0000\u0224\u0227\u0001\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000"+
		"\u0000\u0225\u0226\u0001\u0000\u0000\u0000\u0226\u022c\u0001\u0000\u0000"+
		"\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0228\u022c\u0003*\u0015\u0000"+
		"\u0229\u022c\u0003\"\u0011\u0000\u022a\u022c\u0003\u001a\r\u0000\u022b"+
		"\u021f\u0001\u0000\u0000\u0000\u022b\u0220\u0001\u0000\u0000\u0000\u022b"+
		"\u0228\u0001\u0000\u0000\u0000\u022b\u0229\u0001\u0000\u0000\u0000\u022b"+
		"\u022a\u0001\u0000\u0000\u0000\u022cY\u0001\u0000\u0000\u0000\u022d\u022e"+
		"\u00057\u0000\u0000\u022e\u022f\u0005\u001f\u0000\u0000\u022f\u0230\u0003"+
		"X,\u0000\u0230\u0231\u0005 \u0000\u0000\u0231\u0232\u0005#\u0000\u0000"+
		"\u0232\u0233\u0003X,\u0000\u0233[\u0001\u0000\u0000\u0000\u0234\u0239"+
		"\u0003^/\u0000\u0235\u0236\u0007\u0005\u0000\u0000\u0236\u0238\u0003^"+
		"/\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0238\u023b\u0001\u0000\u0000"+
		"\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000"+
		"\u0000\u023a]\u0001\u0000\u0000\u0000\u023b\u0239\u0001\u0000\u0000\u0000"+
		"\u023c\u023d\u0005\u001a\u0000\u0000\u023d\u024f\u0003^/\u0000\u023e\u023f"+
		"\u0005\u001d\u0000\u0000\u023f\u0240\u0003X,\u0000\u0240\u0241\u0005\u001e"+
		"\u0000\u0000\u0241\u024f\u0001\u0000\u0000\u0000\u0242\u024f\u0003*\u0015"+
		"\u0000\u0243\u024f\u0003\u001a\r\u0000\u0244\u024f\u0003\u0018\f\u0000"+
		"\u0245\u024f\u00058\u0000\u0000\u0246\u024f\u00059\u0000\u0000\u0247\u024f"+
		"\u00057\u0000\u0000\u0248\u024f\u0005<\u0000\u0000\u0249\u024f\u0005:"+
		"\u0000\u0000\u024a\u024b\u00057\u0000\u0000\u024b\u024f\u0005!\u0000\u0000"+
		"\u024c\u024d\u00057\u0000\u0000\u024d\u024f\u0005\"\u0000\u0000\u024e"+
		"\u023c\u0001\u0000\u0000\u0000\u024e\u023e\u0001\u0000\u0000\u0000\u024e"+
		"\u0242\u0001\u0000\u0000\u0000\u024e\u0243\u0001\u0000\u0000\u0000\u024e"+
		"\u0244\u0001\u0000\u0000\u0000\u024e\u0245\u0001\u0000\u0000\u0000\u024e"+
		"\u0246\u0001\u0000\u0000\u0000\u024e\u0247\u0001\u0000\u0000\u0000\u024e"+
		"\u0248\u0001\u0000\u0000\u0000\u024e\u0249\u0001\u0000\u0000\u0000\u024e"+
		"\u024a\u0001\u0000\u0000\u0000\u024e\u024c\u0001\u0000\u0000\u0000\u024f"+
		"_\u0001\u0000\u0000\u0000\u0250\u0255\u0003X,\u0000\u0251\u0255\u0003"+
		"b1\u0000\u0252\u0255\u0003*\u0015\u0000\u0253\u0255\u0003\u001a\r\u0000"+
		"\u0254\u0250\u0001\u0000\u0000\u0000\u0254\u0251\u0001\u0000\u0000\u0000"+
		"\u0254\u0252\u0001\u0000\u0000\u0000\u0254\u0253\u0001\u0000\u0000\u0000"+
		"\u0255a\u0001\u0000\u0000\u0000\u0256\u0257\u00061\uffff\uffff\u0000\u0257"+
		"\u0258\u0005\u001d\u0000\u0000\u0258\u0259\u0003b1\u0000\u0259\u025a\u0005"+
		"\u001e\u0000\u0000\u025a\u0263\u0001\u0000\u0000\u0000\u025b\u025c\u0005"+
		"\u001a\u0000\u0000\u025c\u0263\u0003b1\u0004\u025d\u0260\u0003X,\u0000"+
		"\u025e\u025f\u0005\u0007\u0000\u0000\u025f\u0261\u0003X,\u0000\u0260\u025e"+
		"\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u0263"+
		"\u0001\u0000\u0000\u0000\u0262\u0256\u0001\u0000\u0000\u0000\u0262\u025b"+
		"\u0001\u0000\u0000\u0000\u0262\u025d\u0001\u0000\u0000\u0000\u0263\u026c"+
		"\u0001\u0000\u0000\u0000\u0264\u0265\n\u0003\u0000\u0000\u0265\u0266\u0005"+
		"\u0018\u0000\u0000\u0266\u026b\u0003b1\u0004\u0267\u0268\n\u0002\u0000"+
		"\u0000\u0268\u0269\u0005\u0019\u0000\u0000\u0269\u026b\u0003b1\u0003\u026a"+
		"\u0264\u0001\u0000\u0000\u0000\u026a\u0267\u0001\u0000\u0000\u0000\u026b"+
		"\u026e\u0001\u0000\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026c"+
		"\u026d\u0001\u0000\u0000\u0000\u026dc\u0001\u0000\u0000\u0000\u026e\u026c"+
		"\u0001\u0000\u0000\u0000\u026f\u0270\u0005\u001d\u0000\u0000\u0270\u0271"+
		"\u0007\u0003\u0000\u0000\u0271\u0272\u0005\u001e\u0000\u0000\u0272\u0273"+
		"\u00057\u0000\u0000\u0273\u0274\u0005\u0012\u0000\u0000\u0274e\u0001\u0000"+
		"\u0000\u0000\u0275\u0276\u00055\u0000\u0000\u0276\u0277\u0005\u001d\u0000"+
		"\u0000\u0277\u0278\u00057\u0000\u0000\u0278\u0279\u0005\u001e\u0000\u0000"+
		"\u0279\u027a\u0005\u0012\u0000\u0000\u027ag\u0001\u0000\u0000\u0000\u027b"+
		"\u027c\u0003b1\u0000\u027c\u027d\u0005\u0006\u0000\u0000\u027d\u027e\u0003"+
		"X,\u0000\u027e\u027f\u0005\u0005\u0000\u0000\u027f\u0280\u0003X,\u0000"+
		"\u0280\u0281\u0005\u0012\u0000\u0000\u0281i\u0001\u0000\u0000\u0000\u0282"+
		"\u0284\u0005%\u0000\u0000\u0283\u0285\u0003X,\u0000\u0284\u0283\u0001"+
		"\u0000\u0000\u0000\u0284\u0285\u0001\u0000\u0000\u0000\u0285\u0286\u0001"+
		"\u0000\u0000\u0000\u0286\u0287\u0005\u0012\u0000\u0000\u0287k\u0001\u0000"+
		"\u0000\u00001sxz\u008b\u008d\u0095\u009e\u00a7\u00b0\u00bb\u00c6\u00cf"+
		"\u00f3\u00fb\u0105\u010e\u0111\u0131\u0135\u013c\u0165\u016f\u0172\u0186"+
		"\u0193\u01a0\u01a7\u01b6\u01bd\u01cf\u01d4\u01de\u01e1\u01eb\u01f6\u01fe"+
		"\u020a\u020d\u0212\u0225\u022b\u0239\u024e\u0254\u0260\u0262\u026a\u026c"+
		"\u0284";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}