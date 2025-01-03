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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INCLUDE=6, DEFINE=7, EOL=8, LIB=9, 
		COMMENTLINE=10, COMMENTBLOCK=11, INT=12, FLOAT=13, CHAR=14, DOUBLE=15, 
		VOID=16, MAIN=17, VAR=18, NUM=19, STR=20, FORMAT=21, PLUS=22, MINUS=23, 
		MULT=24, DIV=25, MOD=26, AND=27, OR=28, NOT=29, RELOP=30, SOMA=31, SUB=32, 
		ASSIGN=33, DOT=34, OPEN_PAREN=35, CLOSE_PAREN=36, OPEN_BRACE=37, CLOSE_BRACE=38, 
		VIR=39, RETURN=40, SCAN=41, PRINT=42, GETS=43, PUTS=44, STRUCT=45, UNION=46, 
		IF=47, ELSE=48, SWITCH=49, CASE=50, BREAK=51, DEFAULT=52, WHILE=53, FOR=54, 
		DO=55, TYPEOF=56, WS=57;
	public static final int
		RULE_programa = 0, RULE_cabecalho = 1, RULE_includeDecl = 2, RULE_defineDecl = 3, 
		RULE_corpo = 4, RULE_mainFunction = 5, RULE_bloco = 6, RULE_linhas = 7, 
		RULE_comentario = 8, RULE_atrib = 9, RULE_arrayDecl = 10, RULE_elementosArray = 11, 
		RULE_pointerDecl = 12, RULE_pointerAssign = 13, RULE_pointerDereference = 14, 
		RULE_in = 15, RULE_out = 16, RULE_getsStmt = 17, RULE_putsStmt = 18, RULE_functionDecl = 19, 
		RULE_functionCall = 20, RULE_parametros = 21, RULE_argumentos = 22, RULE_structDecl = 23, 
		RULE_structFields = 24, RULE_unionDecl = 25, RULE_unionFields = 26, RULE_structAccess = 27, 
		RULE_unionAccess = 28, RULE_decisionFunc = 29, RULE_switchCase = 30, RULE_caseBlock = 31, 
		RULE_defaultBlock = 32, RULE_loopFunc = 33, RULE_doWhileLoop = 34, RULE_expression = 35, 
		RULE_terminais = 36, RULE_fator = 37, RULE_exprbloco = 38, RULE_casting = 39, 
		RULE_typeof = 40, RULE_ternary = 41, RULE_returnStmt = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "cabecalho", "includeDecl", "defineDecl", "corpo", "mainFunction", 
			"bloco", "linhas", "comentario", "atrib", "arrayDecl", "elementosArray", 
			"pointerDecl", "pointerAssign", "pointerDereference", "in", "out", "getsStmt", 
			"putsStmt", "functionDecl", "functionCall", "parametros", "argumentos", 
			"structDecl", "structFields", "unionDecl", "unionFields", "structAccess", 
			"unionAccess", "decisionFunc", "switchCase", "caseBlock", "defaultBlock", 
			"loopFunc", "doWhileLoop", "expression", "terminais", "fator", "exprbloco", 
			"casting", "typeof", "ternary", "returnStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'&'", "':'", "'?'", "'#include'", "'#define'", "';'", 
			null, null, null, "'int'", "'float'", "'char'", "'double'", "'void'", 
			"'main'", null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'&&'", "'||'", "'!'", null, "'++'", "'--'", "'='", "'.'", "'('", "')'", 
			"'{'", "'}'", "','", "'return'", "'scanf'", "'printf'", "'gets'", "'puts'", 
			"'struct'", "'union'", "'if'", "'else'", "'switch'", "'case'", "'break'", 
			"'default'", "'while'", "'for'", "'do'", "'typeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "INCLUDE", "DEFINE", "EOL", "LIB", 
			"COMMENTLINE", "COMMENTBLOCK", "INT", "FLOAT", "CHAR", "DOUBLE", "VOID", 
			"MAIN", "VAR", "NUM", "STR", "FORMAT", "PLUS", "MINUS", "MULT", "DIV", 
			"MOD", "AND", "OR", "NOT", "RELOP", "SOMA", "SUB", "ASSIGN", "DOT", "OPEN_PAREN", 
			"CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "VIR", "RETURN", "SCAN", 
			"PRINT", "GETS", "PUTS", "STRUCT", "UNION", "IF", "ELSE", "SWITCH", "CASE", 
			"BREAK", "DEFAULT", "WHILE", "FOR", "DO", "TYPEOF", "WS"
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
			setState(86);
			cabecalho();
			setState(87);
			corpo();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3264L) != 0)) {
				{
				setState(92);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INCLUDE:
					{
					setState(89);
					includeDecl();
					}
					break;
				case DEFINE:
					{
					setState(90);
					defineDecl();
					}
					break;
				case COMMENTLINE:
				case COMMENTBLOCK:
					{
					setState(91);
					comentario();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(96);
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
	public static class IncludeDeclContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(LangGrammarParser.INCLUDE, 0); }
		public TerminalNode LIB() { return getToken(LangGrammarParser.LIB, 0); }
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
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
			setState(97);
			match(INCLUDE);
			setState(98);
			match(LIB);
			setState(99);
			match(EOL);
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
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(DEFINE);
			setState(102);
			match(VAR);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34361589760L) != 0)) {
				{
				setState(103);
				expression();
				}
			}

			setState(106);
			match(EOL);
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
		public MainFunctionContext mainFunction() {
			return getRuleContext(MainFunctionContext.class,0);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<StructDeclContext> structDecl() {
			return getRuleContexts(StructDeclContext.class);
		}
		public StructDeclContext structDecl(int i) {
			return getRuleContext(StructDeclContext.class,i);
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
			setState(108);
			mainFunction();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 105553116396544L) != 0)) {
				{
				setState(113);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case FLOAT:
				case CHAR:
				case DOUBLE:
				case VOID:
					{
					setState(109);
					functionDecl();
					}
					break;
				case STRUCT:
					{
					setState(110);
					structDecl();
					}
					break;
				case UNION:
					{
					setState(111);
					unionDecl();
					}
					break;
				case COMMENTLINE:
				case COMMENTBLOCK:
					{
					setState(112);
					comentario();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(117);
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
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
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
			setState(118);
			match(INT);
			setState(119);
			match(MAIN);
			setState(120);
			match(OPEN_PAREN);
			setState(121);
			match(VOID);
			setState(122);
			match(CLOSE_PAREN);
			setState(123);
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
		public TerminalNode OPEN_BRACE() { return getToken(LangGrammarParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(LangGrammarParser.CLOSE_BRACE, 0); }
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
			setState(125);
			match(OPEN_BRACE);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135845796038704128L) != 0)) {
				{
				{
				setState(126);
				linhas();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(CLOSE_BRACE);
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
		public ComentarioContext comentario() {
			return getRuleContext(ComentarioContext.class,0);
		}
		public AtribContext atrib() {
			return getRuleContext(AtribContext.class,0);
		}
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
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
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public StructAccessContext structAccess() {
			return getRuleContext(StructAccessContext.class,0);
		}
		public UnionAccessContext unionAccess() {
			return getRuleContext(UnionAccessContext.class,0);
		}
		public InContext in() {
			return getRuleContext(InContext.class,0);
		}
		public OutContext out() {
			return getRuleContext(OutContext.class,0);
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
		enterRule(_localctx, 14, RULE_linhas);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				comentario();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				atrib();
				setState(136);
				match(EOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				arrayDecl();
				setState(139);
				match(EOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				pointerDecl();
				setState(142);
				match(EOL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				pointerAssign();
				setState(145);
				match(EOL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				pointerDereference();
				setState(148);
				match(EOL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(150);
				functionCall();
				setState(151);
				match(EOL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(153);
				structAccess();
				setState(154);
				match(EOL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(156);
				unionAccess();
				setState(157);
				match(EOL);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(159);
				in();
				setState(160);
				match(EOL);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(162);
				out();
				setState(163);
				match(EOL);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(165);
				getsStmt();
				setState(166);
				match(EOL);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(168);
				putsStmt();
				setState(169);
				match(EOL);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(171);
				decisionFunc();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(172);
				switchCase();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(173);
				loopFunc();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(174);
				doWhileLoop();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(175);
				casting();
				setState(176);
				match(EOL);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(178);
				typeof();
				setState(179);
				match(EOL);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(181);
				ternary();
				setState(182);
				match(EOL);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(184);
				returnStmt();
				setState(185);
				match(EOL);
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
		enterRule(_localctx, 16, RULE_comentario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public AtribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atrib; }
	}

	public final AtribContext atrib() throws RecognitionException {
		AtribContext _localctx = new AtribContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atrib);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(192);
				match(VAR);
				setState(193);
				match(ASSIGN);
				setState(194);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(196);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				match(VAR);
				setState(198);
				match(ASSIGN);
				setState(199);
				expression();
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(LangGrammarParser.OPEN_BRACE, 0); }
		public ElementosArrayContext elementosArray() {
			return getRuleContext(ElementosArrayContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(LangGrammarParser.CLOSE_BRACE, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(203);
			match(VAR);
			setState(204);
			match(T__0);
			setState(205);
			match(NUM);
			setState(206);
			match(T__1);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(207);
				match(ASSIGN);
				setState(208);
				match(OPEN_BRACE);
				setState(209);
				elementosArray();
				setState(210);
				match(CLOSE_BRACE);
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
	public static class ElementosArrayContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(LangGrammarParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(LangGrammarParser.VIR, i);
		}
		public ElementosArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementosArray; }
	}

	public final ElementosArrayContext elementosArray() throws RecognitionException {
		ElementosArrayContext _localctx = new ElementosArrayContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elementosArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			expression();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(215);
				match(VIR);
				setState(216);
				expression();
				}
				}
				setState(221);
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
	public static class PointerDeclContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(LangGrammarParser.MULT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
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
		enterRule(_localctx, 24, RULE_pointerDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(223);
			match(MULT);
			setState(224);
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
	public static class PointerAssignContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public PointerAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerAssign; }
	}

	public final PointerAssignContext pointerAssign() throws RecognitionException {
		PointerAssignContext _localctx = new PointerAssignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pointerAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(VAR);
			setState(227);
			match(ASSIGN);
			setState(228);
			match(T__2);
			setState(229);
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
	public static class PointerDereferenceContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(LangGrammarParser.MULT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PointerDereferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerDereference; }
	}

	public final PointerDereferenceContext pointerDereference() throws RecognitionException {
		PointerDereferenceContext _localctx = new PointerDereferenceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pointerDereference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(MULT);
			setState(232);
			match(VAR);
			setState(233);
			match(ASSIGN);
			setState(234);
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
	public static class InContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(LangGrammarParser.SCAN, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode FORMAT() { return getToken(LangGrammarParser.FORMAT, 0); }
		public TerminalNode VIR() { return getToken(LangGrammarParser.VIR, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public InContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in; }
	}

	public final InContext in() throws RecognitionException {
		InContext _localctx = new InContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(SCAN);
			setState(237);
			match(OPEN_PAREN);
			setState(238);
			match(FORMAT);
			setState(239);
			match(VIR);
			setState(240);
			match(T__2);
			setState(241);
			match(VAR);
			setState(242);
			match(CLOSE_PAREN);
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
	public static class OutContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(LangGrammarParser.PRINT, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public List<TerminalNode> VIR() { return getTokens(LangGrammarParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(LangGrammarParser.VIR, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_out; }
	}

	public final OutContext out() throws RecognitionException {
		OutContext _localctx = new OutContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_out);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(PRINT);
			setState(245);
			match(OPEN_PAREN);
			setState(246);
			match(STR);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(247);
				match(VIR);
				setState(248);
				expression();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
			match(CLOSE_PAREN);
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
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public GetsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getsStmt; }
	}

	public final GetsStmtContext getsStmt() throws RecognitionException {
		GetsStmtContext _localctx = new GetsStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_getsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(GETS);
			setState(257);
			match(OPEN_PAREN);
			setState(258);
			match(VAR);
			setState(259);
			match(CLOSE_PAREN);
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
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public PutsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_putsStmt; }
	}

	public final PutsStmtContext putsStmt() throws RecognitionException {
		PutsStmtContext _localctx = new PutsStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_putsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(PUTS);
			setState(262);
			match(OPEN_PAREN);
			setState(263);
			match(VAR);
			setState(264);
			match(CLOSE_PAREN);
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
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
		enterRule(_localctx, 38, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(267);
			match(VAR);
			setState(268);
			match(OPEN_PAREN);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) {
				{
				setState(269);
				parametros();
				}
			}

			setState(272);
			match(CLOSE_PAREN);
			setState(273);
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
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
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
		enterRule(_localctx, 40, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(VAR);
			setState(276);
			match(OPEN_PAREN);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34361589760L) != 0)) {
				{
				setState(277);
				argumentos();
				}
			}

			setState(280);
			match(CLOSE_PAREN);
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
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
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
		public List<TerminalNode> VIR() { return getTokens(LangGrammarParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(LangGrammarParser.VIR, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(283);
			match(VAR);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(284);
				match(VIR);
				setState(285);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(286);
				match(VAR);
				}
				}
				setState(291);
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
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(LangGrammarParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(LangGrammarParser.VIR, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			expression();
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(293);
				match(VIR);
				setState(294);
				expression();
				}
				}
				setState(299);
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
	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(LangGrammarParser.STRUCT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(LangGrammarParser.OPEN_BRACE, 0); }
		public StructFieldsContext structFields() {
			return getRuleContext(StructFieldsContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(LangGrammarParser.CLOSE_BRACE, 0); }
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_structDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(STRUCT);
			setState(301);
			match(VAR);
			setState(302);
			match(OPEN_BRACE);
			setState(303);
			structFields();
			setState(304);
			match(CLOSE_BRACE);
			setState(305);
			match(EOL);
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
	public static class StructFieldsContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public List<TerminalNode> EOL() { return getTokens(LangGrammarParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(LangGrammarParser.EOL, i);
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
		public StructFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structFields; }
	}

	public final StructFieldsContext structFields() throws RecognitionException {
		StructFieldsContext _localctx = new StructFieldsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_structFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(307);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(308);
				match(VAR);
				setState(309);
				match(EOL);
				}
				}
				setState(312); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0) );
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
		public TerminalNode OPEN_BRACE() { return getToken(LangGrammarParser.OPEN_BRACE, 0); }
		public UnionFieldsContext unionFields() {
			return getRuleContext(UnionFieldsContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(LangGrammarParser.CLOSE_BRACE, 0); }
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
		public UnionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionDecl; }
	}

	public final UnionDeclContext unionDecl() throws RecognitionException {
		UnionDeclContext _localctx = new UnionDeclContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(UNION);
			setState(315);
			match(VAR);
			setState(316);
			match(OPEN_BRACE);
			setState(317);
			unionFields();
			setState(318);
			match(CLOSE_BRACE);
			setState(319);
			match(EOL);
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
		public List<TerminalNode> EOL() { return getTokens(LangGrammarParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(LangGrammarParser.EOL, i);
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
		enterRule(_localctx, 52, RULE_unionFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(321);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(322);
				match(VAR);
				setState(323);
				match(EOL);
				}
				}
				setState(326); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0) );
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
		public StructAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structAccess; }
	}

	public final StructAccessContext structAccess() throws RecognitionException {
		StructAccessContext _localctx = new StructAccessContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_structAccess);
		try {
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				match(VAR);
				setState(329);
				match(DOT);
				setState(330);
				match(VAR);
				setState(331);
				match(ASSIGN);
				setState(332);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(VAR);
				setState(334);
				match(DOT);
				setState(335);
				match(VAR);
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
	public static class UnionAccessContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangGrammarParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangGrammarParser.VAR, i);
		}
		public TerminalNode DOT() { return getToken(LangGrammarParser.DOT, 0); }
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
		enterRule(_localctx, 56, RULE_unionAccess);
		try {
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				match(VAR);
				setState(339);
				match(DOT);
				setState(340);
				match(VAR);
				setState(341);
				match(ASSIGN);
				setState(342);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				match(VAR);
				setState(344);
				match(DOT);
				setState(345);
				match(VAR);
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
	public static class DecisionFuncContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LangGrammarParser.IF, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LangGrammarParser.ELSE, 0); }
		public DecisionFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionFunc; }
	}

	public final DecisionFuncContext decisionFunc() throws RecognitionException {
		DecisionFuncContext _localctx = new DecisionFuncContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_decisionFunc);
		try {
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(IF);
				setState(349);
				match(OPEN_PAREN);
				setState(350);
				exprbloco(0);
				setState(351);
				match(CLOSE_PAREN);
				setState(352);
				bloco();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				match(IF);
				setState(355);
				match(OPEN_PAREN);
				setState(356);
				exprbloco(0);
				setState(357);
				match(CLOSE_PAREN);
				setState(358);
				bloco();
				setState(359);
				match(ELSE);
				setState(360);
				bloco();
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
	public static class SwitchCaseContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(LangGrammarParser.SWITCH, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(LangGrammarParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(LangGrammarParser.CLOSE_BRACE, 0); }
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
		enterRule(_localctx, 60, RULE_switchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(SWITCH);
			setState(365);
			match(OPEN_PAREN);
			setState(366);
			match(VAR);
			setState(367);
			match(CLOSE_PAREN);
			setState(368);
			match(OPEN_BRACE);
			setState(370); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(369);
				caseBlock();
				}
				}
				setState(372); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(374);
				defaultBlock();
				}
			}

			setState(377);
			match(CLOSE_BRACE);
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
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
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
		enterRule(_localctx, 62, RULE_caseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(CASE);
			setState(380);
			match(NUM);
			setState(381);
			match(T__3);
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135845796038704128L) != 0)) {
				{
				{
				setState(382);
				linhas();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
			match(BREAK);
			setState(389);
			match(EOL);
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
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
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
		enterRule(_localctx, 64, RULE_defaultBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(DEFAULT);
			setState(392);
			match(T__3);
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135845796038704128L) != 0)) {
				{
				{
				setState(393);
				linhas();
				}
				}
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(399);
			match(BREAK);
			setState(400);
			match(EOL);
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
		public TerminalNode WHILE() { return getToken(LangGrammarParser.WHILE, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode FOR() { return getToken(LangGrammarParser.FOR, 0); }
		public List<AtribContext> atrib() {
			return getRuleContexts(AtribContext.class);
		}
		public AtribContext atrib(int i) {
			return getRuleContext(AtribContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(LangGrammarParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(LangGrammarParser.EOL, i);
		}
		public LoopFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopFunc; }
	}

	public final LoopFuncContext loopFunc() throws RecognitionException {
		LoopFuncContext _localctx = new LoopFuncContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_loopFunc);
		try {
			setState(418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				match(WHILE);
				setState(403);
				match(OPEN_PAREN);
				setState(404);
				exprbloco(0);
				setState(405);
				match(CLOSE_PAREN);
				setState(406);
				bloco();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				match(FOR);
				setState(409);
				match(OPEN_PAREN);
				setState(410);
				atrib();
				setState(411);
				match(EOL);
				setState(412);
				exprbloco(0);
				setState(413);
				match(EOL);
				setState(414);
				atrib();
				setState(415);
				match(CLOSE_PAREN);
				setState(416);
				bloco();
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
	public static class DoWhileLoopContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(LangGrammarParser.DO, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(LangGrammarParser.WHILE, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public TerminalNode EOL() { return getToken(LangGrammarParser.EOL, 0); }
		public DoWhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoop; }
	}

	public final DoWhileLoopContext doWhileLoop() throws RecognitionException {
		DoWhileLoopContext _localctx = new DoWhileLoopContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_doWhileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			match(DO);
			setState(421);
			bloco();
			setState(422);
			match(WHILE);
			setState(423);
			match(OPEN_PAREN);
			setState(424);
			exprbloco(0);
			setState(425);
			match(CLOSE_PAREN);
			setState(426);
			match(EOL);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			terminais();
			setState(435);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(433);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PLUS:
						{
						setState(429);
						match(PLUS);
						setState(430);
						terminais();
						}
						break;
					case MINUS:
						{
						setState(431);
						match(MINUS);
						setState(432);
						terminais();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(437);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		enterRule(_localctx, 72, RULE_terminais);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			fator();
			setState(447);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(445);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MULT:
						{
						setState(439);
						match(MULT);
						setState(440);
						fator();
						}
						break;
					case DIV:
						{
						setState(441);
						match(DIV);
						setState(442);
						fator();
						}
						break;
					case MOD:
						{
						setState(443);
						match(MOD);
						setState(444);
						fator();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public List<TerminalNode> SOMA() { return getTokens(LangGrammarParser.SOMA); }
		public TerminalNode SOMA(int i) {
			return getToken(LangGrammarParser.SOMA, i);
		}
		public List<TerminalNode> SUB() { return getTokens(LangGrammarParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(LangGrammarParser.SUB, i);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_fator);
		try {
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(450);
				match(OPEN_PAREN);
				setState(451);
				expression();
				setState(452);
				match(CLOSE_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				match(NUM);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(455);
				match(VAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(456);
				match(STR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(457);
				match(CHAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(458);
				match(VAR);
				setState(459);
				match(SOMA);
				setState(460);
				match(SOMA);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(461);
				match(VAR);
				setState(462);
				match(SUB);
				setState(463);
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
	public static class ExprblocoContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(LangGrammarParser.RELOP, 0); }
		public TerminalNode NOT() { return getToken(LangGrammarParser.NOT, 0); }
		public List<ExprblocoContext> exprbloco() {
			return getRuleContexts(ExprblocoContext.class);
		}
		public ExprblocoContext exprbloco(int i) {
			return getRuleContext(ExprblocoContext.class,i);
		}
		public TerminalNode AND() { return getToken(LangGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(LangGrammarParser.OR, 0); }
		public ExprblocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprbloco; }
	}

	public final ExprblocoContext exprbloco() throws RecognitionException {
		return exprbloco(0);
	}

	private ExprblocoContext exprbloco(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprblocoContext _localctx = new ExprblocoContext(_ctx, _parentState);
		ExprblocoContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_exprbloco, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR:
			case VAR:
			case NUM:
			case STR:
			case OPEN_PAREN:
				{
				setState(467);
				expression();
				setState(470);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(468);
					match(RELOP);
					setState(469);
					expression();
					}
					break;
				}
				}
				break;
			case NOT:
				{
				setState(472);
				match(NOT);
				setState(473);
				exprbloco(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(484);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(482);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new ExprblocoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(476);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(477);
						match(AND);
						setState(478);
						exprbloco(4);
						}
						break;
					case 2:
						{
						_localctx = new ExprblocoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(479);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(480);
						match(OR);
						setState(481);
						exprbloco(3);
						}
						break;
					}
					} 
				}
				setState(486);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
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
		enterRule(_localctx, 78, RULE_casting);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(OPEN_PAREN);
			setState(488);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(489);
			match(CLOSE_PAREN);
			setState(490);
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
	public static class TypeofContext extends ParserRuleContext {
		public TerminalNode TYPEOF() { return getToken(LangGrammarParser.TYPEOF, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(LangGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(LangGrammarParser.CLOSE_PAREN, 0); }
		public TypeofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeof; }
	}

	public final TypeofContext typeof() throws RecognitionException {
		TypeofContext _localctx = new TypeofContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_typeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			match(TYPEOF);
			setState(493);
			match(OPEN_PAREN);
			setState(494);
			match(VAR);
			setState(495);
			match(CLOSE_PAREN);
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
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			exprbloco(0);
			setState(498);
			match(T__4);
			setState(499);
			bloco();
			setState(500);
			match(T__3);
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
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(LangGrammarParser.RETURN, 0); }
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
		enterRule(_localctx, 84, RULE_returnStmt);
		try {
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(503);
				match(RETURN);
				setState(504);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(505);
				match(RETURN);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 38:
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
		"\u0004\u00019\u01fd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001]\b\u0001\n\u0001\f\u0001"+
		"`\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003i\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"r\b\u0004\n\u0004\f\u0004u\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u0080\b\u0006\n\u0006\f\u0006\u0083\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00bc\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00c9\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00d5"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00da\b\u000b\n\u000b"+
		"\f\u000b\u00dd\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00fa\b\u0010\n\u0010\f\u0010\u00fd"+
		"\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u010f"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u0117\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0120\b\u0015\n"+
		"\u0015\f\u0015\u0123\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0128\b\u0016\n\u0016\f\u0016\u012b\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0004\u0018\u0137\b\u0018\u000b\u0018\f\u0018"+
		"\u0138\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0004\u001a\u0145"+
		"\b\u001a\u000b\u001a\f\u001a\u0146\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u0151\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u015b\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u016b\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0004\u001e\u0173\b\u001e\u000b\u001e"+
		"\f\u001e\u0174\u0001\u001e\u0003\u001e\u0178\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0180"+
		"\b\u001f\n\u001f\f\u001f\u0183\t\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001 \u0005 \u018b\b \n \f \u018e\t \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u01a3\b!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0005#\u01b2\b#\n#\f#\u01b5\t#\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0005$\u01be\b$\n$\f$\u01c1\t$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0003%\u01d1\b%\u0001&\u0001&\u0001&\u0001&\u0003&\u01d7\b&\u0001"+
		"&\u0001&\u0003&\u01db\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005"+
		"&\u01e3\b&\n&\f&\u01e6\t&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001*\u0001*\u0001*\u0003*\u01fb\b*\u0001*\u0000\u0001L+\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRT\u0000\u0002\u0001\u0000\n\u000b\u0001\u0000"+
		"\f\u0010\u0211\u0000V\u0001\u0000\u0000\u0000\u0002^\u0001\u0000\u0000"+
		"\u0000\u0004a\u0001\u0000\u0000\u0000\u0006e\u0001\u0000\u0000\u0000\b"+
		"l\u0001\u0000\u0000\u0000\nv\u0001\u0000\u0000\u0000\f}\u0001\u0000\u0000"+
		"\u0000\u000e\u00bb\u0001\u0000\u0000\u0000\u0010\u00bd\u0001\u0000\u0000"+
		"\u0000\u0012\u00c8\u0001\u0000\u0000\u0000\u0014\u00ca\u0001\u0000\u0000"+
		"\u0000\u0016\u00d6\u0001\u0000\u0000\u0000\u0018\u00de\u0001\u0000\u0000"+
		"\u0000\u001a\u00e2\u0001\u0000\u0000\u0000\u001c\u00e7\u0001\u0000\u0000"+
		"\u0000\u001e\u00ec\u0001\u0000\u0000\u0000 \u00f4\u0001\u0000\u0000\u0000"+
		"\"\u0100\u0001\u0000\u0000\u0000$\u0105\u0001\u0000\u0000\u0000&\u010a"+
		"\u0001\u0000\u0000\u0000(\u0113\u0001\u0000\u0000\u0000*\u011a\u0001\u0000"+
		"\u0000\u0000,\u0124\u0001\u0000\u0000\u0000.\u012c\u0001\u0000\u0000\u0000"+
		"0\u0136\u0001\u0000\u0000\u00002\u013a\u0001\u0000\u0000\u00004\u0144"+
		"\u0001\u0000\u0000\u00006\u0150\u0001\u0000\u0000\u00008\u015a\u0001\u0000"+
		"\u0000\u0000:\u016a\u0001\u0000\u0000\u0000<\u016c\u0001\u0000\u0000\u0000"+
		">\u017b\u0001\u0000\u0000\u0000@\u0187\u0001\u0000\u0000\u0000B\u01a2"+
		"\u0001\u0000\u0000\u0000D\u01a4\u0001\u0000\u0000\u0000F\u01ac\u0001\u0000"+
		"\u0000\u0000H\u01b6\u0001\u0000\u0000\u0000J\u01d0\u0001\u0000\u0000\u0000"+
		"L\u01da\u0001\u0000\u0000\u0000N\u01e7\u0001\u0000\u0000\u0000P\u01ec"+
		"\u0001\u0000\u0000\u0000R\u01f1\u0001\u0000\u0000\u0000T\u01fa\u0001\u0000"+
		"\u0000\u0000VW\u0003\u0002\u0001\u0000WX\u0003\b\u0004\u0000X\u0001\u0001"+
		"\u0000\u0000\u0000Y]\u0003\u0004\u0002\u0000Z]\u0003\u0006\u0003\u0000"+
		"[]\u0003\u0010\b\u0000\\Y\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0003\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000ab\u0005\u0006\u0000\u0000bc\u0005\t\u0000\u0000"+
		"cd\u0005\b\u0000\u0000d\u0005\u0001\u0000\u0000\u0000ef\u0005\u0007\u0000"+
		"\u0000fh\u0005\u0012\u0000\u0000gi\u0003F#\u0000hg\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0005\b\u0000\u0000"+
		"k\u0007\u0001\u0000\u0000\u0000ls\u0003\n\u0005\u0000mr\u0003&\u0013\u0000"+
		"nr\u0003.\u0017\u0000or\u00032\u0019\u0000pr\u0003\u0010\b\u0000qm\u0001"+
		"\u0000\u0000\u0000qn\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000t\t\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000vw\u0005\f\u0000\u0000wx\u0005\u0011\u0000\u0000xy\u0005#"+
		"\u0000\u0000yz\u0005\u0010\u0000\u0000z{\u0005$\u0000\u0000{|\u0003\f"+
		"\u0006\u0000|\u000b\u0001\u0000\u0000\u0000}\u0081\u0005%\u0000\u0000"+
		"~\u0080\u0003\u000e\u0007\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005&\u0000\u0000\u0085\r\u0001"+
		"\u0000\u0000\u0000\u0086\u00bc\u0003\u0010\b\u0000\u0087\u0088\u0003\u0012"+
		"\t\u0000\u0088\u0089\u0005\b\u0000\u0000\u0089\u00bc\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0003\u0014\n\u0000\u008b\u008c\u0005\b\u0000\u0000"+
		"\u008c\u00bc\u0001\u0000\u0000\u0000\u008d\u008e\u0003\u0018\f\u0000\u008e"+
		"\u008f\u0005\b\u0000\u0000\u008f\u00bc\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0003\u001a\r\u0000\u0091\u0092\u0005\b\u0000\u0000\u0092\u00bc\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0003\u001c\u000e\u0000\u0094\u0095\u0005"+
		"\b\u0000\u0000\u0095\u00bc\u0001\u0000\u0000\u0000\u0096\u0097\u0003("+
		"\u0014\u0000\u0097\u0098\u0005\b\u0000\u0000\u0098\u00bc\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u00036\u001b\u0000\u009a\u009b\u0005\b\u0000\u0000"+
		"\u009b\u00bc\u0001\u0000\u0000\u0000\u009c\u009d\u00038\u001c\u0000\u009d"+
		"\u009e\u0005\b\u0000\u0000\u009e\u00bc\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0003\u001e\u000f\u0000\u00a0\u00a1\u0005\b\u0000\u0000\u00a1\u00bc\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0003 \u0010\u0000\u00a3\u00a4\u0005\b"+
		"\u0000\u0000\u00a4\u00bc\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003\"\u0011"+
		"\u0000\u00a6\u00a7\u0005\b\u0000\u0000\u00a7\u00bc\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0003$\u0012\u0000\u00a9\u00aa\u0005\b\u0000\u0000\u00aa"+
		"\u00bc\u0001\u0000\u0000\u0000\u00ab\u00bc\u0003:\u001d\u0000\u00ac\u00bc"+
		"\u0003<\u001e\u0000\u00ad\u00bc\u0003B!\u0000\u00ae\u00bc\u0003D\"\u0000"+
		"\u00af\u00b0\u0003N\'\u0000\u00b0\u00b1\u0005\b\u0000\u0000\u00b1\u00bc"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003P(\u0000\u00b3\u00b4\u0005\b"+
		"\u0000\u0000\u00b4\u00bc\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003R)\u0000"+
		"\u00b6\u00b7\u0005\b\u0000\u0000\u00b7\u00bc\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0003T*\u0000\u00b9\u00ba\u0005\b\u0000\u0000\u00ba\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bb\u0086\u0001\u0000\u0000\u0000\u00bb\u0087\u0001"+
		"\u0000\u0000\u0000\u00bb\u008a\u0001\u0000\u0000\u0000\u00bb\u008d\u0001"+
		"\u0000\u0000\u0000\u00bb\u0090\u0001\u0000\u0000\u0000\u00bb\u0093\u0001"+
		"\u0000\u0000\u0000\u00bb\u0096\u0001\u0000\u0000\u0000\u00bb\u0099\u0001"+
		"\u0000\u0000\u0000\u00bb\u009c\u0001\u0000\u0000\u0000\u00bb\u009f\u0001"+
		"\u0000\u0000\u0000\u00bb\u00a2\u0001\u0000\u0000\u0000\u00bb\u00a5\u0001"+
		"\u0000\u0000\u0000\u00bb\u00a8\u0001\u0000\u0000\u0000\u00bb\u00ab\u0001"+
		"\u0000\u0000\u0000\u00bb\u00ac\u0001\u0000\u0000\u0000\u00bb\u00ad\u0001"+
		"\u0000\u0000\u0000\u00bb\u00ae\u0001\u0000\u0000\u0000\u00bb\u00af\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b2\u0001\u0000\u0000\u0000\u00bb\u00b5\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b8\u0001\u0000\u0000\u0000\u00bc\u000f\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0007\u0000\u0000\u0000\u00be\u0011\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c0\u0007\u0001\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0012\u0000\u0000\u00c1\u00c2\u0005!\u0000\u0000\u00c2\u00c9\u0003F#"+
		"\u0000\u00c3\u00c4\u0007\u0001\u0000\u0000\u00c4\u00c9\u0005\u0012\u0000"+
		"\u0000\u00c5\u00c6\u0005\u0012\u0000\u0000\u00c6\u00c7\u0005!\u0000\u0000"+
		"\u00c7\u00c9\u0003F#\u0000\u00c8\u00bf\u0001\u0000\u0000\u0000\u00c8\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c5\u0001\u0000\u0000\u0000\u00c9\u0013"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0007\u0001\u0000\u0000\u00cb\u00cc"+
		"\u0005\u0012\u0000\u0000\u00cc\u00cd\u0005\u0001\u0000\u0000\u00cd\u00ce"+
		"\u0005\u0013\u0000\u0000\u00ce\u00d4\u0005\u0002\u0000\u0000\u00cf\u00d0"+
		"\u0005!\u0000\u0000\u00d0\u00d1\u0005%\u0000\u0000\u00d1\u00d2\u0003\u0016"+
		"\u000b\u0000\u00d2\u00d3\u0005&\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d4\u00cf\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d5\u0015\u0001\u0000\u0000\u0000\u00d6\u00db\u0003F#\u0000\u00d7"+
		"\u00d8\u0005\'\u0000\u0000\u00d8\u00da\u0003F#\u0000\u00d9\u00d7\u0001"+
		"\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9\u0001"+
		"\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u0017\u0001"+
		"\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00df\u0007"+
		"\u0001\u0000\u0000\u00df\u00e0\u0005\u0018\u0000\u0000\u00e0\u00e1\u0005"+
		"\u0012\u0000\u0000\u00e1\u0019\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005"+
		"\u0012\u0000\u0000\u00e3\u00e4\u0005!\u0000\u0000\u00e4\u00e5\u0005\u0003"+
		"\u0000\u0000\u00e5\u00e6\u0005\u0012\u0000\u0000\u00e6\u001b\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0005\u0018\u0000\u0000\u00e8\u00e9\u0005\u0012"+
		"\u0000\u0000\u00e9\u00ea\u0005!\u0000\u0000\u00ea\u00eb\u0003F#\u0000"+
		"\u00eb\u001d\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005)\u0000\u0000\u00ed"+
		"\u00ee\u0005#\u0000\u0000\u00ee\u00ef\u0005\u0015\u0000\u0000\u00ef\u00f0"+
		"\u0005\'\u0000\u0000\u00f0\u00f1\u0005\u0003\u0000\u0000\u00f1\u00f2\u0005"+
		"\u0012\u0000\u0000\u00f2\u00f3\u0005$\u0000\u0000\u00f3\u001f\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0005*\u0000\u0000\u00f5\u00f6\u0005#\u0000\u0000"+
		"\u00f6\u00fb\u0005\u0014\u0000\u0000\u00f7\u00f8\u0005\'\u0000\u0000\u00f8"+
		"\u00fa\u0003F#\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0005$\u0000\u0000\u00ff!\u0001\u0000\u0000"+
		"\u0000\u0100\u0101\u0005+\u0000\u0000\u0101\u0102\u0005#\u0000\u0000\u0102"+
		"\u0103\u0005\u0012\u0000\u0000\u0103\u0104\u0005$\u0000\u0000\u0104#\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0005,\u0000\u0000\u0106\u0107\u0005#\u0000"+
		"\u0000\u0107\u0108\u0005\u0012\u0000\u0000\u0108\u0109\u0005$\u0000\u0000"+
		"\u0109%\u0001\u0000\u0000\u0000\u010a\u010b\u0007\u0001\u0000\u0000\u010b"+
		"\u010c\u0005\u0012\u0000\u0000\u010c\u010e\u0005#\u0000\u0000\u010d\u010f"+
		"\u0003*\u0015\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0005"+
		"$\u0000\u0000\u0111\u0112\u0003\f\u0006\u0000\u0112\'\u0001\u0000\u0000"+
		"\u0000\u0113\u0114\u0005\u0012\u0000\u0000\u0114\u0116\u0005#\u0000\u0000"+
		"\u0115\u0117\u0003,\u0016\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u0005$\u0000\u0000\u0119)\u0001\u0000\u0000\u0000\u011a\u011b\u0007"+
		"\u0001\u0000\u0000\u011b\u0121\u0005\u0012\u0000\u0000\u011c\u011d\u0005"+
		"\'\u0000\u0000\u011d\u011e\u0007\u0001\u0000\u0000\u011e\u0120\u0005\u0012"+
		"\u0000\u0000\u011f\u011c\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000"+
		"\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000"+
		"\u0000\u0000\u0122+\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000"+
		"\u0000\u0124\u0129\u0003F#\u0000\u0125\u0126\u0005\'\u0000\u0000\u0126"+
		"\u0128\u0003F#\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u012b\u0001"+
		"\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001"+
		"\u0000\u0000\u0000\u012a-\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0005-\u0000\u0000\u012d\u012e\u0005\u0012\u0000"+
		"\u0000\u012e\u012f\u0005%\u0000\u0000\u012f\u0130\u00030\u0018\u0000\u0130"+
		"\u0131\u0005&\u0000\u0000\u0131\u0132\u0005\b\u0000\u0000\u0132/\u0001"+
		"\u0000\u0000\u0000\u0133\u0134\u0007\u0001\u0000\u0000\u0134\u0135\u0005"+
		"\u0012\u0000\u0000\u0135\u0137\u0005\b\u0000\u0000\u0136\u0133\u0001\u0000"+
		"\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u01391\u0001\u0000\u0000"+
		"\u0000\u013a\u013b\u0005.\u0000\u0000\u013b\u013c\u0005\u0012\u0000\u0000"+
		"\u013c\u013d\u0005%\u0000\u0000\u013d\u013e\u00034\u001a\u0000\u013e\u013f"+
		"\u0005&\u0000\u0000\u013f\u0140\u0005\b\u0000\u0000\u01403\u0001\u0000"+
		"\u0000\u0000\u0141\u0142\u0007\u0001\u0000\u0000\u0142\u0143\u0005\u0012"+
		"\u0000\u0000\u0143\u0145\u0005\b\u0000\u0000\u0144\u0141\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u01475\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0005\u0012\u0000\u0000\u0149\u014a\u0005\"\u0000\u0000\u014a"+
		"\u014b\u0005\u0012\u0000\u0000\u014b\u014c\u0005!\u0000\u0000\u014c\u0151"+
		"\u0003F#\u0000\u014d\u014e\u0005\u0012\u0000\u0000\u014e\u014f\u0005\""+
		"\u0000\u0000\u014f\u0151\u0005\u0012\u0000\u0000\u0150\u0148\u0001\u0000"+
		"\u0000\u0000\u0150\u014d\u0001\u0000\u0000\u0000\u01517\u0001\u0000\u0000"+
		"\u0000\u0152\u0153\u0005\u0012\u0000\u0000\u0153\u0154\u0005\"\u0000\u0000"+
		"\u0154\u0155\u0005\u0012\u0000\u0000\u0155\u0156\u0005!\u0000\u0000\u0156"+
		"\u015b\u0003F#\u0000\u0157\u0158\u0005\u0012\u0000\u0000\u0158\u0159\u0005"+
		"\"\u0000\u0000\u0159\u015b\u0005\u0012\u0000\u0000\u015a\u0152\u0001\u0000"+
		"\u0000\u0000\u015a\u0157\u0001\u0000\u0000\u0000\u015b9\u0001\u0000\u0000"+
		"\u0000\u015c\u015d\u0005/\u0000\u0000\u015d\u015e\u0005#\u0000\u0000\u015e"+
		"\u015f\u0003L&\u0000\u015f\u0160\u0005$\u0000\u0000\u0160\u0161\u0003"+
		"\f\u0006\u0000\u0161\u016b\u0001\u0000\u0000\u0000\u0162\u0163\u0005/"+
		"\u0000\u0000\u0163\u0164\u0005#\u0000\u0000\u0164\u0165\u0003L&\u0000"+
		"\u0165\u0166\u0005$\u0000\u0000\u0166\u0167\u0003\f\u0006\u0000\u0167"+
		"\u0168\u00050\u0000\u0000\u0168\u0169\u0003\f\u0006\u0000\u0169\u016b"+
		"\u0001\u0000\u0000\u0000\u016a\u015c\u0001\u0000\u0000\u0000\u016a\u0162"+
		"\u0001\u0000\u0000\u0000\u016b;\u0001\u0000\u0000\u0000\u016c\u016d\u0005"+
		"1\u0000\u0000\u016d\u016e\u0005#\u0000\u0000\u016e\u016f\u0005\u0012\u0000"+
		"\u0000\u016f\u0170\u0005$\u0000\u0000\u0170\u0172\u0005%\u0000\u0000\u0171"+
		"\u0173\u0003>\u001f\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0173\u0174"+
		"\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0174\u0175"+
		"\u0001\u0000\u0000\u0000\u0175\u0177\u0001\u0000\u0000\u0000\u0176\u0178"+
		"\u0003@ \u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000"+
		"\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017a\u0005&\u0000"+
		"\u0000\u017a=\u0001\u0000\u0000\u0000\u017b\u017c\u00052\u0000\u0000\u017c"+
		"\u017d\u0005\u0013\u0000\u0000\u017d\u0181\u0005\u0004\u0000\u0000\u017e"+
		"\u0180\u0003\u000e\u0007\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u0180"+
		"\u0183\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181"+
		"\u0182\u0001\u0000\u0000\u0000\u0182\u0184\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0184\u0185\u00053\u0000\u0000\u0185\u0186"+
		"\u0005\b\u0000\u0000\u0186?\u0001\u0000\u0000\u0000\u0187\u0188\u0005"+
		"4\u0000\u0000\u0188\u018c\u0005\u0004\u0000\u0000\u0189\u018b\u0003\u000e"+
		"\u0007\u0000\u018a\u0189\u0001\u0000\u0000\u0000\u018b\u018e\u0001\u0000"+
		"\u0000\u0000\u018c\u018a\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000"+
		"\u0000\u0000\u018d\u018f\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000"+
		"\u0000\u0000\u018f\u0190\u00053\u0000\u0000\u0190\u0191\u0005\b\u0000"+
		"\u0000\u0191A\u0001\u0000\u0000\u0000\u0192\u0193\u00055\u0000\u0000\u0193"+
		"\u0194\u0005#\u0000\u0000\u0194\u0195\u0003L&\u0000\u0195\u0196\u0005"+
		"$\u0000\u0000\u0196\u0197\u0003\f\u0006\u0000\u0197\u01a3\u0001\u0000"+
		"\u0000\u0000\u0198\u0199\u00056\u0000\u0000\u0199\u019a\u0005#\u0000\u0000"+
		"\u019a\u019b\u0003\u0012\t\u0000\u019b\u019c\u0005\b\u0000\u0000\u019c"+
		"\u019d\u0003L&\u0000\u019d\u019e\u0005\b\u0000\u0000\u019e\u019f\u0003"+
		"\u0012\t\u0000\u019f\u01a0\u0005$\u0000\u0000\u01a0\u01a1\u0003\f\u0006"+
		"\u0000\u01a1\u01a3\u0001\u0000\u0000\u0000\u01a2\u0192\u0001\u0000\u0000"+
		"\u0000\u01a2\u0198\u0001\u0000\u0000\u0000\u01a3C\u0001\u0000\u0000\u0000"+
		"\u01a4\u01a5\u00057\u0000\u0000\u01a5\u01a6\u0003\f\u0006\u0000\u01a6"+
		"\u01a7\u00055\u0000\u0000\u01a7\u01a8\u0005#\u0000\u0000\u01a8\u01a9\u0003"+
		"L&\u0000\u01a9\u01aa\u0005$\u0000\u0000\u01aa\u01ab\u0005\b\u0000\u0000"+
		"\u01abE\u0001\u0000\u0000\u0000\u01ac\u01b3\u0003H$\u0000\u01ad\u01ae"+
		"\u0005\u0016\u0000\u0000\u01ae\u01b2\u0003H$\u0000\u01af\u01b0\u0005\u0017"+
		"\u0000\u0000\u01b0\u01b2\u0003H$\u0000\u01b1\u01ad\u0001\u0000\u0000\u0000"+
		"\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000"+
		"\u01b4G\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b6"+
		"\u01bf\u0003J%\u0000\u01b7\u01b8\u0005\u0018\u0000\u0000\u01b8\u01be\u0003"+
		"J%\u0000\u01b9\u01ba\u0005\u0019\u0000\u0000\u01ba\u01be\u0003J%\u0000"+
		"\u01bb\u01bc\u0005\u001a\u0000\u0000\u01bc\u01be\u0003J%\u0000\u01bd\u01b7"+
		"\u0001\u0000\u0000\u0000\u01bd\u01b9\u0001\u0000\u0000\u0000\u01bd\u01bb"+
		"\u0001\u0000\u0000\u0000\u01be\u01c1\u0001\u0000\u0000\u0000\u01bf\u01bd"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0I\u0001"+
		"\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c2\u01c3\u0005"+
		"#\u0000\u0000\u01c3\u01c4\u0003F#\u0000\u01c4\u01c5\u0005$\u0000\u0000"+
		"\u01c5\u01d1\u0001\u0000\u0000\u0000\u01c6\u01d1\u0005\u0013\u0000\u0000"+
		"\u01c7\u01d1\u0005\u0012\u0000\u0000\u01c8\u01d1\u0005\u0014\u0000\u0000"+
		"\u01c9\u01d1\u0005\u000e\u0000\u0000\u01ca\u01cb\u0005\u0012\u0000\u0000"+
		"\u01cb\u01cc\u0005\u001f\u0000\u0000\u01cc\u01d1\u0005\u001f\u0000\u0000"+
		"\u01cd\u01ce\u0005\u0012\u0000\u0000\u01ce\u01cf\u0005 \u0000\u0000\u01cf"+
		"\u01d1\u0005 \u0000\u0000\u01d0\u01c2\u0001\u0000\u0000\u0000\u01d0\u01c6"+
		"\u0001\u0000\u0000\u0000\u01d0\u01c7\u0001\u0000\u0000\u0000\u01d0\u01c8"+
		"\u0001\u0000\u0000\u0000\u01d0\u01c9\u0001\u0000\u0000\u0000\u01d0\u01ca"+
		"\u0001\u0000\u0000\u0000\u01d0\u01cd\u0001\u0000\u0000\u0000\u01d1K\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d3\u0006&\uffff\uffff\u0000\u01d3\u01d6\u0003"+
		"F#\u0000\u01d4\u01d5\u0005\u001e\u0000\u0000\u01d5\u01d7\u0003F#\u0000"+
		"\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d7\u01db\u0001\u0000\u0000\u0000\u01d8\u01d9\u0005\u001d\u0000\u0000"+
		"\u01d9\u01db\u0003L&\u0001\u01da\u01d2\u0001\u0000\u0000\u0000\u01da\u01d8"+
		"\u0001\u0000\u0000\u0000\u01db\u01e4\u0001\u0000\u0000\u0000\u01dc\u01dd"+
		"\n\u0003\u0000\u0000\u01dd\u01de\u0005\u001b\u0000\u0000\u01de\u01e3\u0003"+
		"L&\u0004\u01df\u01e0\n\u0002\u0000\u0000\u01e0\u01e1\u0005\u001c\u0000"+
		"\u0000\u01e1\u01e3\u0003L&\u0003\u01e2\u01dc\u0001\u0000\u0000\u0000\u01e2"+
		"\u01df\u0001\u0000\u0000\u0000\u01e3\u01e6\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5"+
		"M\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e7\u01e8"+
		"\u0005#\u0000\u0000\u01e8\u01e9\u0007\u0001\u0000\u0000\u01e9\u01ea\u0005"+
		"$\u0000\u0000\u01ea\u01eb\u0005\u0012\u0000\u0000\u01ebO\u0001\u0000\u0000"+
		"\u0000\u01ec\u01ed\u00058\u0000\u0000\u01ed\u01ee\u0005#\u0000\u0000\u01ee"+
		"\u01ef\u0005\u0012\u0000\u0000\u01ef\u01f0\u0005$\u0000\u0000\u01f0Q\u0001"+
		"\u0000\u0000\u0000\u01f1\u01f2\u0003L&\u0000\u01f2\u01f3\u0005\u0005\u0000"+
		"\u0000\u01f3\u01f4\u0003\f\u0006\u0000\u01f4\u01f5\u0005\u0004\u0000\u0000"+
		"\u01f5\u01f6\u0003\f\u0006\u0000\u01f6S\u0001\u0000\u0000\u0000\u01f7"+
		"\u01f8\u0005(\u0000\u0000\u01f8\u01fb\u0003F#\u0000\u01f9\u01fb\u0005"+
		"(\u0000\u0000\u01fa\u01f7\u0001\u0000\u0000\u0000\u01fa\u01f9\u0001\u0000"+
		"\u0000\u0000\u01fbU\u0001\u0000\u0000\u0000#\\^hqs\u0081\u00bb\u00c8\u00d4"+
		"\u00db\u00fb\u010e\u0116\u0121\u0129\u0138\u0146\u0150\u015a\u016a\u0174"+
		"\u0177\u0181\u018c\u01a2\u01b1\u01b3\u01bd\u01bf\u01d0\u01d6\u01da\u01e2"+
		"\u01e4\u01fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}