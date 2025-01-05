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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, INCLUDE=12, DEFINE=13, LIB=14, COMMENTLINE=15, COMMENTBLOCK=16, 
		INT=17, FLOAT=18, CHAR=19, DOUBLE=20, VOID=21, MAIN=22, PLUS=23, MINUS=24, 
		MULT=25, DIV=26, MOD=27, AND=28, OR=29, NOT=30, RELOP=31, SOMA=32, SUB=33, 
		ASSIGN=34, DOT=35, RETURN=36, SCAN=37, PRINT=38, GETS=39, PUTS=40, STRUCT=41, 
		UNION=42, IF=43, ELSE=44, SWITCH=45, CASE=46, BREAK=47, DEFAULT=48, WHILE=49, 
		FOR=50, DO=51, TYPEOF=52, WS=53, VAR=54, NUM=55, STR=56, FORMAT=57;
	public static final int
		RULE_programa = 0, RULE_cabecalho = 1, RULE_includeDecl = 2, RULE_defineDecl = 3, 
		RULE_corpo = 4, RULE_mainFunction = 5, RULE_bloco = 6, RULE_linhas = 7, 
		RULE_comentario = 8, RULE_atrib = 9, RULE_arrayDecl = 10, RULE_elementosArray = 11, 
		RULE_pointerDecl = 12, RULE_pointerAssign = 13, RULE_pointerDereference = 14, 
		RULE_in = 15, RULE_output = 16, RULE_getsStmt = 17, RULE_putsStmt = 18, 
		RULE_functionDecl = 19, RULE_functionCall = 20, RULE_parametros = 21, 
		RULE_argumentos = 22, RULE_structDecl = 23, RULE_structFields = 24, RULE_unionDecl = 25, 
		RULE_unionFields = 26, RULE_structAccess = 27, RULE_unionAccess = 28, 
		RULE_decisionFunc = 29, RULE_switchCase = 30, RULE_caseBlock = 31, RULE_defaultBlock = 32, 
		RULE_loopFunc = 33, RULE_whileLoop = 34, RULE_forLoop = 35, RULE_doWhileLoop = 36, 
		RULE_expression = 37, RULE_terminais = 38, RULE_fator = 39, RULE_exprbloco = 40, 
		RULE_casting = 41, RULE_typeof = 42, RULE_ternary = 43, RULE_returnStmt = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "cabecalho", "includeDecl", "defineDecl", "corpo", "mainFunction", 
			"bloco", "linhas", "comentario", "atrib", "arrayDecl", "elementosArray", 
			"pointerDecl", "pointerAssign", "pointerDereference", "in", "output", 
			"getsStmt", "putsStmt", "functionDecl", "functionCall", "parametros", 
			"argumentos", "structDecl", "structFields", "unionDecl", "unionFields", 
			"structAccess", "unionAccess", "decisionFunc", "switchCase", "caseBlock", 
			"defaultBlock", "loopFunc", "whileLoop", "forLoop", "doWhileLoop", "expression", 
			"terminais", "fator", "exprbloco", "casting", "typeof", "ternary", "returnStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'&'", 
			"':'", "'?'", "'#include'", "'#define'", null, null, null, "'int'", "'float'", 
			"'char'", "'double'", "'void'", "'main'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'&&'", "'||'", "'!'", null, "'++'", "'--'", "'='", "'.'", "'return'", 
			"'scanf'", "'printf'", "'gets'", "'puts'", "'struct'", "'union'", "'if'", 
			"'else'", "'switch'", "'case'", "'break'", "'default'", "'while'", "'for'", 
			"'do'", "'typeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"INCLUDE", "DEFINE", "LIB", "COMMENTLINE", "COMMENTBLOCK", "INT", "FLOAT", 
			"CHAR", "DOUBLE", "VOID", "MAIN", "PLUS", "MINUS", "MULT", "DIV", "MOD", 
			"AND", "OR", "NOT", "RELOP", "SOMA", "SUB", "ASSIGN", "DOT", "RETURN", 
			"SCAN", "PRINT", "GETS", "PUTS", "STRUCT", "UNION", "IF", "ELSE", "SWITCH", 
			"CASE", "BREAK", "DEFAULT", "WHILE", "FOR", "DO", "TYPEOF", "WS", "VAR", 
			"NUM", "STR", "FORMAT"
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
			setState(90);
			cabecalho();
			setState(91);
			corpo();
			setState(92);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 110592L) != 0)) {
				{
				setState(97);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INCLUDE:
					{
					setState(94);
					includeDecl();
					}
					break;
				case DEFINE:
					{
					setState(95);
					defineDecl();
					}
					break;
				case COMMENTLINE:
				case COMMENTBLOCK:
					{
					setState(96);
					comentario();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(101);
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
			setState(102);
			match(INCLUDE);
			setState(103);
			match(LIB);
			setState(104);
			match(T__0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(DEFINE);
			setState(107);
			match(VAR);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100790640640004L) != 0)) {
				{
				setState(108);
				expression();
				}
			}

			setState(111);
			match(T__0);
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
			setState(113);
			mainFunction();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597073928192L) != 0)) {
				{
				setState(118);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case FLOAT:
				case CHAR:
				case DOUBLE:
				case VOID:
					{
					setState(114);
					functionDecl();
					}
					break;
				case STRUCT:
					{
					setState(115);
					structDecl();
					}
					break;
				case UNION:
					{
					setState(116);
					unionDecl();
					}
					break;
				case COMMENTLINE:
				case COMMENTBLOCK:
					{
					setState(117);
					comentario();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(122);
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
			setState(123);
			match(INT);
			setState(124);
			match(MAIN);
			setState(125);
			match(T__1);
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(126);
				match(VOID);
				}
				break;
			case T__2:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(130);
			match(T__2);
			setState(131);
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
			setState(133);
			match(T__3);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134591150748041220L) != 0)) {
				{
				{
				setState(134);
				linhas();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(T__4);
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
		enterRule(_localctx, 14, RULE_linhas);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				comentario();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				atrib();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				arrayDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				pointerDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				pointerAssign();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				pointerDereference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(148);
				functionCall();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(149);
				structAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(150);
				unionAccess();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(151);
				in();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(152);
				output();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(153);
				getsStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(154);
				putsStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(155);
				decisionFunc();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(156);
				switchCase();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(157);
				loopFunc();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(158);
				doWhileLoop();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(159);
				casting();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(160);
				typeof();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(161);
				ternary();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(162);
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
		enterRule(_localctx, 16, RULE_comentario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
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
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(168);
				match(VAR);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(169);
					match(ASSIGN);
					setState(170);
					expression();
					}
				}

				setState(175);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(173);
					match(T__0);
					}
					break;
				case 2:
					{
					}
					break;
				}
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(VAR);
				setState(178);
				match(ASSIGN);
				setState(179);
				expression();
				setState(182);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(180);
					match(T__0);
					}
					break;
				case 2:
					{
					}
					break;
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
	public static class ArrayDeclContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode INT() { return getToken(LangGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangGrammarParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangGrammarParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangGrammarParser.VOID, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
		public ElementosArrayContext elementosArray() {
			return getRuleContext(ElementosArrayContext.class,0);
		}
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
			setState(186);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(187);
			match(VAR);
			setState(188);
			match(T__5);
			setState(189);
			match(NUM);
			setState(190);
			match(T__6);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(191);
				match(ASSIGN);
				setState(192);
				match(T__3);
				setState(193);
				elementosArray();
				setState(194);
				match(T__4);
				}
			}

			setState(198);
			match(T__0);
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
			setState(200);
			expression();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(201);
				match(T__7);
				setState(202);
				expression();
				}
				}
				setState(207);
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
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(209);
			match(MULT);
			setState(210);
			match(VAR);
			setState(211);
			match(T__0);
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
			setState(213);
			match(VAR);
			setState(214);
			match(ASSIGN);
			setState(215);
			match(T__8);
			setState(216);
			match(VAR);
			setState(217);
			match(T__0);
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
			setState(219);
			match(MULT);
			setState(220);
			match(VAR);
			setState(221);
			match(ASSIGN);
			setState(222);
			expression();
			setState(223);
			match(T__0);
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
		public TerminalNode FORMAT() { return getToken(LangGrammarParser.FORMAT, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
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
			setState(225);
			match(SCAN);
			setState(226);
			match(T__1);
			setState(227);
			match(FORMAT);
			setState(228);
			match(T__7);
			setState(229);
			match(T__8);
			setState(230);
			match(VAR);
			setState(231);
			match(T__2);
			setState(232);
			match(T__0);
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
		public TerminalNode PRINT() { return getToken(LangGrammarParser.PRINT, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_output);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(PRINT);
			setState(235);
			match(T__1);
			setState(236);
			match(STR);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(237);
				match(T__7);
				setState(238);
				expression();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			match(T__2);
			setState(245);
			match(T__0);
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
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
			setState(247);
			match(GETS);
			setState(248);
			match(T__1);
			setState(249);
			match(VAR);
			setState(250);
			match(T__2);
			setState(251);
			match(T__0);
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
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
			setState(253);
			match(PUTS);
			setState(254);
			match(T__1);
			setState(255);
			match(VAR);
			setState(256);
			match(T__2);
			setState(257);
			match(T__0);
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
			setState(259);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(260);
			match(VAR);
			setState(261);
			match(T__1);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) {
				{
				setState(262);
				parametros();
				}
			}

			setState(265);
			match(T__2);
			setState(266);
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
			setState(268);
			match(VAR);
			setState(269);
			match(T__1);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100790640640004L) != 0)) {
				{
				setState(270);
				argumentos();
				}
			}

			setState(273);
			match(T__2);
			setState(274);
			match(T__0);
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
			setState(276);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(277);
			match(VAR);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(278);
				match(T__7);
				setState(279);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(280);
				match(VAR);
				}
				}
				setState(285);
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
			setState(286);
			expression();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(287);
				match(T__7);
				setState(288);
				expression();
				}
				}
				setState(293);
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
		public StructFieldsContext structFields() {
			return getRuleContext(StructFieldsContext.class,0);
		}
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
			setState(294);
			match(STRUCT);
			setState(295);
			match(VAR);
			setState(296);
			match(T__3);
			setState(297);
			structFields();
			setState(298);
			match(T__4);
			setState(299);
			match(T__0);
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
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(301);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(302);
				match(VAR);
				setState(303);
				match(T__0);
				}
				}
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0) );
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
		public UnionFieldsContext unionFields() {
			return getRuleContext(UnionFieldsContext.class,0);
		}
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
			setState(308);
			match(UNION);
			setState(309);
			match(VAR);
			setState(310);
			match(T__3);
			setState(311);
			unionFields();
			setState(312);
			match(T__4);
			setState(313);
			match(T__0);
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
			setState(318); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(315);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(316);
				match(VAR);
				setState(317);
				match(T__0);
				}
				}
				setState(320); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0) );
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(VAR);
			setState(323);
			match(DOT);
			setState(324);
			match(VAR);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(325);
				match(ASSIGN);
				setState(326);
				expression();
				}
			}

			setState(329);
			match(T__0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(VAR);
			setState(332);
			match(DOT);
			setState(333);
			match(VAR);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(334);
				match(ASSIGN);
				setState(335);
				expression();
				}
			}

			setState(338);
			match(T__0);
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
		public List<ExprblocoContext> exprbloco() {
			return getRuleContexts(ExprblocoContext.class);
		}
		public ExprblocoContext exprbloco(int i) {
			return getRuleContext(ExprblocoContext.class,i);
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
		enterRule(_localctx, 58, RULE_decisionFunc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(IF);
			setState(341);
			match(T__1);
			setState(342);
			exprbloco(0);
			setState(343);
			match(T__2);
			setState(344);
			bloco();
			setState(354);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(345);
					match(ELSE);
					setState(346);
					match(IF);
					setState(347);
					match(T__1);
					setState(348);
					exprbloco(0);
					setState(349);
					match(T__2);
					setState(350);
					bloco();
					}
					} 
				}
				setState(356);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(357);
				match(ELSE);
				setState(358);
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
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
			setState(361);
			match(SWITCH);
			setState(362);
			match(T__1);
			setState(363);
			match(VAR);
			setState(364);
			match(T__2);
			setState(365);
			match(T__3);
			setState(367); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(366);
				caseBlock();
				}
				}
				setState(369); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(371);
				defaultBlock();
				}
			}

			setState(374);
			match(T__4);
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
			setState(376);
			match(CASE);
			setState(377);
			match(NUM);
			setState(378);
			match(T__9);
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134591150748041220L) != 0)) {
				{
				{
				setState(379);
				linhas();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(385);
			match(BREAK);
			setState(386);
			match(T__0);
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
			setState(388);
			match(DEFAULT);
			setState(389);
			match(T__9);
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134591150748041220L) != 0)) {
				{
				{
				setState(390);
				linhas();
				}
				}
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(396);
			match(BREAK);
			setState(397);
			match(T__0);
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
		enterRule(_localctx, 66, RULE_loopFunc);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				whileLoop();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
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
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
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
		enterRule(_localctx, 68, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(WHILE);
			setState(404);
			match(T__1);
			setState(405);
			exprbloco(0);
			setState(406);
			match(T__2);
			setState(407);
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
		enterRule(_localctx, 70, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(FOR);
			setState(410);
			match(T__1);
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case VOID:
			case VAR:
				{
				setState(411);
				atrib();
				}
				break;
			case T__0:
				{
				setState(412);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100790640640004L) != 0)) {
				{
				setState(415);
				exprbloco(0);
				}
			}

			setState(418);
			match(T__0);
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(419);
				atrib();
				}
				break;
			case 2:
				{
				setState(420);
				expression();
				}
				break;
			}
			setState(423);
			match(T__2);
			setState(424);
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
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
		public DoWhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoop; }
	}

	public final DoWhileLoopContext doWhileLoop() throws RecognitionException {
		DoWhileLoopContext _localctx = new DoWhileLoopContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_doWhileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(DO);
			setState(427);
			bloco();
			setState(428);
			match(WHILE);
			setState(429);
			match(T__1);
			setState(430);
			exprbloco(0);
			setState(431);
			match(T__2);
			setState(432);
			match(T__0);
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
		enterRule(_localctx, 74, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			terminais();
			setState(441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(439);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PLUS:
						{
						setState(435);
						match(PLUS);
						setState(436);
						terminais();
						}
						break;
					case MINUS:
						{
						setState(437);
						match(MINUS);
						setState(438);
						terminais();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 76, RULE_terminais);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			fator();
			setState(453);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(451);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MULT:
						{
						setState(445);
						match(MULT);
						setState(446);
						fator();
						}
						break;
					case DIV:
						{
						setState(447);
						match(DIV);
						setState(448);
						fator();
						}
						break;
					case MOD:
						{
						setState(449);
						match(MOD);
						setState(450);
						fator();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(455);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public TerminalNode CHAR() { return getToken(LangGrammarParser.CHAR, 0); }
		public TerminalNode SOMA() { return getToken(LangGrammarParser.SOMA, 0); }
		public TerminalNode SUB() { return getToken(LangGrammarParser.SUB, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_fator);
		try {
			setState(470);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				match(NOT);
				setState(457);
				fator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				match(T__1);
				setState(459);
				expression();
				setState(460);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(462);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(463);
				match(VAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(464);
				match(STR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(465);
				match(CHAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(466);
				match(VAR);
				setState(467);
				match(SOMA);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(468);
				match(VAR);
				setState(469);
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
		public ExprblocoContext exprbloco() {
			return getRuleContext(ExprblocoContext.class,0);
		}
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
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_exprbloco, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				_localctx = new ParentesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(473);
				match(T__1);
				setState(474);
				exprbloco(0);
				setState(475);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(477);
				match(NOT);
				setState(478);
				exprbloco(4);
				}
				break;
			case 3:
				{
				_localctx = new RelationalExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(479);
				expression();
				setState(482);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(480);
					match(RELOP);
					setState(481);
					expression();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(494);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(492);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new AndExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(486);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(487);
						match(AND);
						setState(488);
						exprbloco(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(489);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(490);
						match(OR);
						setState(491);
						exprbloco(3);
						}
						break;
					}
					} 
				}
				setState(496);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastingContext extends ParserRuleContext {
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
		enterRule(_localctx, 82, RULE_casting);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(T__1);
			setState(498);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(499);
			match(T__2);
			setState(500);
			match(VAR);
			setState(501);
			match(T__0);
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
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TypeofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeof; }
	}

	public final TypeofContext typeof() throws RecognitionException {
		TypeofContext _localctx = new TypeofContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_typeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(TYPEOF);
			setState(504);
			match(T__1);
			setState(505);
			match(VAR);
			setState(506);
			match(T__2);
			setState(507);
			match(T__0);
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
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			exprbloco(0);
			setState(510);
			match(T__10);
			setState(511);
			expression();
			setState(512);
			match(T__9);
			setState(513);
			expression();
			setState(514);
			match(T__0);
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
		enterRule(_localctx, 88, RULE_returnStmt);
		try {
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				match(RETURN);
				setState(517);
				expression();
				setState(518);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(520);
				match(RETURN);
				setState(521);
				match(T__0);
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
		case 40:
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
		"\u0004\u00019\u020d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001b\b\u0001\n\u0001\f\u0001e\t\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003n\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004w\b\u0004\n\u0004\f\u0004z\t"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u0081\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u0088\b\u0006\n\u0006\f\u0006\u008b\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a4\b\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00ac\b\t\u0001"+
		"\t\u0001\t\u0003\t\u00b0\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00b7\b\t\u0003\t\u00b9\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c5\b\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00cc\b\u000b\n\u000b"+
		"\f\u000b\u00cf\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u00f0\b\u0010\n\u0010\f\u0010\u00f3\t\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u0108\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u0110\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u011a\b\u0015\n\u0015\f\u0015\u011d\t\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u0122\b\u0016\n\u0016\f\u0016\u0125\t\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0004\u0018\u0131\b\u0018\u000b\u0018"+
		"\f\u0018\u0132\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0004\u001a"+
		"\u013f\b\u001a\u000b\u001a\f\u001a\u0140\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0148\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u0151\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0161\b\u001d\n"+
		"\u001d\f\u001d\u0164\t\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0168"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0004\u001e\u0170\b\u001e\u000b\u001e\f\u001e\u0171\u0001\u001e"+
		"\u0003\u001e\u0175\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0005\u001f\u017d\b\u001f\n\u001f\f\u001f\u0180"+
		"\t\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0005"+
		" \u0188\b \n \f \u018b\t \u0001 \u0001 \u0001 \u0001!\u0001!\u0003!\u0192"+
		"\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0003#\u019e\b#\u0001#\u0003#\u01a1\b#\u0001#\u0001#\u0001#\u0003"+
		"#\u01a6\b#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0005%\u01b8\b%\n%"+
		"\f%\u01bb\t%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u01c4"+
		"\b&\n&\f&\u01c7\t&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u01d7"+
		"\b\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0003(\u01e3\b(\u0003(\u01e5\b(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0005(\u01ed\b(\n(\f(\u01f0\t(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0003"+
		",\u020b\b,\u0001,\u0000\u0001P-\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVX\u0000\u0002\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0015\u0228"+
		"\u0000Z\u0001\u0000\u0000\u0000\u0002c\u0001\u0000\u0000\u0000\u0004f"+
		"\u0001\u0000\u0000\u0000\u0006j\u0001\u0000\u0000\u0000\bq\u0001\u0000"+
		"\u0000\u0000\n{\u0001\u0000\u0000\u0000\f\u0085\u0001\u0000\u0000\u0000"+
		"\u000e\u00a3\u0001\u0000\u0000\u0000\u0010\u00a5\u0001\u0000\u0000\u0000"+
		"\u0012\u00b8\u0001\u0000\u0000\u0000\u0014\u00ba\u0001\u0000\u0000\u0000"+
		"\u0016\u00c8\u0001\u0000\u0000\u0000\u0018\u00d0\u0001\u0000\u0000\u0000"+
		"\u001a\u00d5\u0001\u0000\u0000\u0000\u001c\u00db\u0001\u0000\u0000\u0000"+
		"\u001e\u00e1\u0001\u0000\u0000\u0000 \u00ea\u0001\u0000\u0000\u0000\""+
		"\u00f7\u0001\u0000\u0000\u0000$\u00fd\u0001\u0000\u0000\u0000&\u0103\u0001"+
		"\u0000\u0000\u0000(\u010c\u0001\u0000\u0000\u0000*\u0114\u0001\u0000\u0000"+
		"\u0000,\u011e\u0001\u0000\u0000\u0000.\u0126\u0001\u0000\u0000\u00000"+
		"\u0130\u0001\u0000\u0000\u00002\u0134\u0001\u0000\u0000\u00004\u013e\u0001"+
		"\u0000\u0000\u00006\u0142\u0001\u0000\u0000\u00008\u014b\u0001\u0000\u0000"+
		"\u0000:\u0154\u0001\u0000\u0000\u0000<\u0169\u0001\u0000\u0000\u0000>"+
		"\u0178\u0001\u0000\u0000\u0000@\u0184\u0001\u0000\u0000\u0000B\u0191\u0001"+
		"\u0000\u0000\u0000D\u0193\u0001\u0000\u0000\u0000F\u0199\u0001\u0000\u0000"+
		"\u0000H\u01aa\u0001\u0000\u0000\u0000J\u01b2\u0001\u0000\u0000\u0000L"+
		"\u01bc\u0001\u0000\u0000\u0000N\u01d6\u0001\u0000\u0000\u0000P\u01e4\u0001"+
		"\u0000\u0000\u0000R\u01f1\u0001\u0000\u0000\u0000T\u01f7\u0001\u0000\u0000"+
		"\u0000V\u01fd\u0001\u0000\u0000\u0000X\u020a\u0001\u0000\u0000\u0000Z"+
		"[\u0003\u0002\u0001\u0000[\\\u0003\b\u0004\u0000\\]\u0005\u0000\u0000"+
		"\u0001]\u0001\u0001\u0000\u0000\u0000^b\u0003\u0004\u0002\u0000_b\u0003"+
		"\u0006\u0003\u0000`b\u0003\u0010\b\u0000a^\u0001\u0000\u0000\u0000a_\u0001"+
		"\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0003\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\f\u0000\u0000gh\u0005\u000e"+
		"\u0000\u0000hi\u0005\u0001\u0000\u0000i\u0005\u0001\u0000\u0000\u0000"+
		"jk\u0005\r\u0000\u0000km\u00056\u0000\u0000ln\u0003J%\u0000ml\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0005"+
		"\u0001\u0000\u0000p\u0007\u0001\u0000\u0000\u0000qx\u0003\n\u0005\u0000"+
		"rw\u0003&\u0013\u0000sw\u0003.\u0017\u0000tw\u00032\u0019\u0000uw\u0003"+
		"\u0010\b\u0000vr\u0001\u0000\u0000\u0000vs\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\t\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000{|\u0005\u0011\u0000\u0000|}\u0005\u0016"+
		"\u0000\u0000}\u0080\u0005\u0002\u0000\u0000~\u0081\u0005\u0015\u0000\u0000"+
		"\u007f\u0081\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080"+
		"\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u0003\u0000\u0000\u0083\u0084\u0003\f\u0006\u0000\u0084\u000b"+
		"\u0001\u0000\u0000\u0000\u0085\u0089\u0005\u0004\u0000\u0000\u0086\u0088"+
		"\u0003\u000e\u0007\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u008b"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0005\u0000\u0000\u008d\r\u0001"+
		"\u0000\u0000\u0000\u008e\u00a4\u0003\u0010\b\u0000\u008f\u00a4\u0003\u0012"+
		"\t\u0000\u0090\u00a4\u0003\u0014\n\u0000\u0091\u00a4\u0003\u0018\f\u0000"+
		"\u0092\u00a4\u0003\u001a\r\u0000\u0093\u00a4\u0003\u001c\u000e\u0000\u0094"+
		"\u00a4\u0003(\u0014\u0000\u0095\u00a4\u00036\u001b\u0000\u0096\u00a4\u0003"+
		"8\u001c\u0000\u0097\u00a4\u0003\u001e\u000f\u0000\u0098\u00a4\u0003 \u0010"+
		"\u0000\u0099\u00a4\u0003\"\u0011\u0000\u009a\u00a4\u0003$\u0012\u0000"+
		"\u009b\u00a4\u0003:\u001d\u0000\u009c\u00a4\u0003<\u001e\u0000\u009d\u00a4"+
		"\u0003B!\u0000\u009e\u00a4\u0003H$\u0000\u009f\u00a4\u0003R)\u0000\u00a0"+
		"\u00a4\u0003T*\u0000\u00a1\u00a4\u0003V+\u0000\u00a2\u00a4\u0003X,\u0000"+
		"\u00a3\u008e\u0001\u0000\u0000\u0000\u00a3\u008f\u0001\u0000\u0000\u0000"+
		"\u00a3\u0090\u0001\u0000\u0000\u0000\u00a3\u0091\u0001\u0000\u0000\u0000"+
		"\u00a3\u0092\u0001\u0000\u0000\u0000\u00a3\u0093\u0001\u0000\u0000\u0000"+
		"\u00a3\u0094\u0001\u0000\u0000\u0000\u00a3\u0095\u0001\u0000\u0000\u0000"+
		"\u00a3\u0096\u0001\u0000\u0000\u0000\u00a3\u0097\u0001\u0000\u0000\u0000"+
		"\u00a3\u0098\u0001\u0000\u0000\u0000\u00a3\u0099\u0001\u0000\u0000\u0000"+
		"\u00a3\u009a\u0001\u0000\u0000\u0000\u00a3\u009b\u0001\u0000\u0000\u0000"+
		"\u00a3\u009c\u0001\u0000\u0000\u0000\u00a3\u009d\u0001\u0000\u0000\u0000"+
		"\u00a3\u009e\u0001\u0000\u0000\u0000\u00a3\u009f\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u000f\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0007\u0000\u0000\u0000\u00a6\u0011\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0007\u0001\u0000\u0000\u00a8\u00ab\u00056\u0000\u0000\u00a9"+
		"\u00aa\u0005\"\u0000\u0000\u00aa\u00ac\u0003J%\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00af\u0001"+
		"\u0000\u0000\u0000\u00ad\u00b0\u0005\u0001\u0000\u0000\u00ae\u00b0\u0001"+
		"\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b9\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		"6\u0000\u0000\u00b2\u00b3\u0005\"\u0000\u0000\u00b3\u00b6\u0003J%\u0000"+
		"\u00b4\u00b7\u0005\u0001\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00a7\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b1\u0001\u0000\u0000\u0000\u00b9\u0013\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0007\u0001\u0000\u0000\u00bb\u00bc\u00056\u0000\u0000\u00bc"+
		"\u00bd\u0005\u0006\u0000\u0000\u00bd\u00be\u00057\u0000\u0000\u00be\u00c4"+
		"\u0005\u0007\u0000\u0000\u00bf\u00c0\u0005\"\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0004\u0000\u0000\u00c1\u00c2\u0003\u0016\u000b\u0000\u00c2\u00c3\u0005"+
		"\u0005\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0005\u0001\u0000\u0000\u00c7\u0015\u0001"+
		"\u0000\u0000\u0000\u00c8\u00cd\u0003J%\u0000\u00c9\u00ca\u0005\b\u0000"+
		"\u0000\u00ca\u00cc\u0003J%\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0001\u0000\u0000\u0000\u00ce\u0017\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d1\u0007\u0001\u0000\u0000\u00d1"+
		"\u00d2\u0005\u0019\u0000\u0000\u00d2\u00d3\u00056\u0000\u0000\u00d3\u00d4"+
		"\u0005\u0001\u0000\u0000\u00d4\u0019\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u00056\u0000\u0000\u00d6\u00d7\u0005\"\u0000\u0000\u00d7\u00d8\u0005"+
		"\t\u0000\u0000\u00d8\u00d9\u00056\u0000\u0000\u00d9\u00da\u0005\u0001"+
		"\u0000\u0000\u00da\u001b\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0019"+
		"\u0000\u0000\u00dc\u00dd\u00056\u0000\u0000\u00dd\u00de\u0005\"\u0000"+
		"\u0000\u00de\u00df\u0003J%\u0000\u00df\u00e0\u0005\u0001\u0000\u0000\u00e0"+
		"\u001d\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005%\u0000\u0000\u00e2\u00e3"+
		"\u0005\u0002\u0000\u0000\u00e3\u00e4\u00059\u0000\u0000\u00e4\u00e5\u0005"+
		"\b\u0000\u0000\u00e5\u00e6\u0005\t\u0000\u0000\u00e6\u00e7\u00056\u0000"+
		"\u0000\u00e7\u00e8\u0005\u0003\u0000\u0000\u00e8\u00e9\u0005\u0001\u0000"+
		"\u0000\u00e9\u001f\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005&\u0000\u0000"+
		"\u00eb\u00ec\u0005\u0002\u0000\u0000\u00ec\u00f1\u00058\u0000\u0000\u00ed"+
		"\u00ee\u0005\b\u0000\u0000\u00ee\u00f0\u0003J%\u0000\u00ef\u00ed\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005"+
		"\u0003\u0000\u0000\u00f5\u00f6\u0005\u0001\u0000\u0000\u00f6!\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0005\'\u0000\u0000\u00f8\u00f9\u0005\u0002\u0000"+
		"\u0000\u00f9\u00fa\u00056\u0000\u0000\u00fa\u00fb\u0005\u0003\u0000\u0000"+
		"\u00fb\u00fc\u0005\u0001\u0000\u0000\u00fc#\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0005(\u0000\u0000\u00fe\u00ff\u0005\u0002\u0000\u0000\u00ff\u0100"+
		"\u00056\u0000\u0000\u0100\u0101\u0005\u0003\u0000\u0000\u0101\u0102\u0005"+
		"\u0001\u0000\u0000\u0102%\u0001\u0000\u0000\u0000\u0103\u0104\u0007\u0001"+
		"\u0000\u0000\u0104\u0105\u00056\u0000\u0000\u0105\u0107\u0005\u0002\u0000"+
		"\u0000\u0106\u0108\u0003*\u0015\u0000\u0107\u0106\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u0005\u0003\u0000\u0000\u010a\u010b\u0003\f\u0006\u0000\u010b"+
		"\'\u0001\u0000\u0000\u0000\u010c\u010d\u00056\u0000\u0000\u010d\u010f"+
		"\u0005\u0002\u0000\u0000\u010e\u0110\u0003,\u0016\u0000\u010f\u010e\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0001"+
		"\u0000\u0000\u0000\u0111\u0112\u0005\u0003\u0000\u0000\u0112\u0113\u0005"+
		"\u0001\u0000\u0000\u0113)\u0001\u0000\u0000\u0000\u0114\u0115\u0007\u0001"+
		"\u0000\u0000\u0115\u011b\u00056\u0000\u0000\u0116\u0117\u0005\b\u0000"+
		"\u0000\u0117\u0118\u0007\u0001\u0000\u0000\u0118\u011a\u00056\u0000\u0000"+
		"\u0119\u0116\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000"+
		"\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000"+
		"\u011c+\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011e"+
		"\u0123\u0003J%\u0000\u011f\u0120\u0005\b\u0000\u0000\u0120\u0122\u0003"+
		"J%\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0122\u0125\u0001\u0000\u0000"+
		"\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000"+
		"\u0000\u0124-\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000"+
		"\u0126\u0127\u0005)\u0000\u0000\u0127\u0128\u00056\u0000\u0000\u0128\u0129"+
		"\u0005\u0004\u0000\u0000\u0129\u012a\u00030\u0018\u0000\u012a\u012b\u0005"+
		"\u0005\u0000\u0000\u012b\u012c\u0005\u0001\u0000\u0000\u012c/\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0007\u0001\u0000\u0000\u012e\u012f\u00056\u0000"+
		"\u0000\u012f\u0131\u0005\u0001\u0000\u0000\u0130\u012d\u0001\u0000\u0000"+
		"\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u01331\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0005*\u0000\u0000\u0135\u0136\u00056\u0000\u0000\u0136\u0137"+
		"\u0005\u0004\u0000\u0000\u0137\u0138\u00034\u001a\u0000\u0138\u0139\u0005"+
		"\u0005\u0000\u0000\u0139\u013a\u0005\u0001\u0000\u0000\u013a3\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0007\u0001\u0000\u0000\u013c\u013d\u00056\u0000"+
		"\u0000\u013d\u013f\u0005\u0001\u0000\u0000\u013e\u013b\u0001\u0000\u0000"+
		"\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u01415\u0001\u0000\u0000\u0000"+
		"\u0142\u0143\u00056\u0000\u0000\u0143\u0144\u0005#\u0000\u0000\u0144\u0147"+
		"\u00056\u0000\u0000\u0145\u0146\u0005\"\u0000\u0000\u0146\u0148\u0003"+
		"J%\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0005\u0001\u0000"+
		"\u0000\u014a7\u0001\u0000\u0000\u0000\u014b\u014c\u00056\u0000\u0000\u014c"+
		"\u014d\u0005#\u0000\u0000\u014d\u0150\u00056\u0000\u0000\u014e\u014f\u0005"+
		"\"\u0000\u0000\u014f\u0151\u0003J%\u0000\u0150\u014e\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000"+
		"\u0000\u0152\u0153\u0005\u0001\u0000\u0000\u01539\u0001\u0000\u0000\u0000"+
		"\u0154\u0155\u0005+\u0000\u0000\u0155\u0156\u0005\u0002\u0000\u0000\u0156"+
		"\u0157\u0003P(\u0000\u0157\u0158\u0005\u0003\u0000\u0000\u0158\u0162\u0003"+
		"\f\u0006\u0000\u0159\u015a\u0005,\u0000\u0000\u015a\u015b\u0005+\u0000"+
		"\u0000\u015b\u015c\u0005\u0002\u0000\u0000\u015c\u015d\u0003P(\u0000\u015d"+
		"\u015e\u0005\u0003\u0000\u0000\u015e\u015f\u0003\f\u0006\u0000\u015f\u0161"+
		"\u0001\u0000\u0000\u0000\u0160\u0159\u0001\u0000\u0000\u0000\u0161\u0164"+
		"\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0001\u0000\u0000\u0000\u0163\u0167\u0001\u0000\u0000\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0165\u0166\u0005,\u0000\u0000\u0166\u0168\u0003"+
		"\f\u0006\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000"+
		"\u0000\u0000\u0168;\u0001\u0000\u0000\u0000\u0169\u016a\u0005-\u0000\u0000"+
		"\u016a\u016b\u0005\u0002\u0000\u0000\u016b\u016c\u00056\u0000\u0000\u016c"+
		"\u016d\u0005\u0003\u0000\u0000\u016d\u016f\u0005\u0004\u0000\u0000\u016e"+
		"\u0170\u0003>\u001f\u0000\u016f\u016e\u0001\u0000\u0000\u0000\u0170\u0171"+
		"\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0171\u0172"+
		"\u0001\u0000\u0000\u0000\u0172\u0174\u0001\u0000\u0000\u0000\u0173\u0175"+
		"\u0003@ \u0000\u0174\u0173\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000"+
		"\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0177\u0005\u0005"+
		"\u0000\u0000\u0177=\u0001\u0000\u0000\u0000\u0178\u0179\u0005.\u0000\u0000"+
		"\u0179\u017a\u00057\u0000\u0000\u017a\u017e\u0005\n\u0000\u0000\u017b"+
		"\u017d\u0003\u000e\u0007\u0000\u017c\u017b\u0001\u0000\u0000\u0000\u017d"+
		"\u0180\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e"+
		"\u017f\u0001\u0000\u0000\u0000\u017f\u0181\u0001\u0000\u0000\u0000\u0180"+
		"\u017e\u0001\u0000\u0000\u0000\u0181\u0182\u0005/\u0000\u0000\u0182\u0183"+
		"\u0005\u0001\u0000\u0000\u0183?\u0001\u0000\u0000\u0000\u0184\u0185\u0005"+
		"0\u0000\u0000\u0185\u0189\u0005\n\u0000\u0000\u0186\u0188\u0003\u000e"+
		"\u0007\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u018b\u0001\u0000"+
		"\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000"+
		"\u0000\u0000\u018a\u018c\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000"+
		"\u0000\u0000\u018c\u018d\u0005/\u0000\u0000\u018d\u018e\u0005\u0001\u0000"+
		"\u0000\u018eA\u0001\u0000\u0000\u0000\u018f\u0192\u0003D\"\u0000\u0190"+
		"\u0192\u0003F#\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0191\u0190\u0001"+
		"\u0000\u0000\u0000\u0192C\u0001\u0000\u0000\u0000\u0193\u0194\u00051\u0000"+
		"\u0000\u0194\u0195\u0005\u0002\u0000\u0000\u0195\u0196\u0003P(\u0000\u0196"+
		"\u0197\u0005\u0003\u0000\u0000\u0197\u0198\u0003\f\u0006\u0000\u0198E"+
		"\u0001\u0000\u0000\u0000\u0199\u019a\u00052\u0000\u0000\u019a\u019d\u0005"+
		"\u0002\u0000\u0000\u019b\u019e\u0003\u0012\t\u0000\u019c\u019e\u0005\u0001"+
		"\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019d\u019c\u0001\u0000"+
		"\u0000\u0000\u019e\u01a0\u0001\u0000\u0000\u0000\u019f\u01a1\u0003P(\u0000"+
		"\u01a0\u019f\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01a5\u0005\u0001\u0000\u0000"+
		"\u01a3\u01a6\u0003\u0012\t\u0000\u01a4\u01a6\u0003J%\u0000\u01a5\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005\u0003\u0000\u0000\u01a8\u01a9"+
		"\u0003\f\u0006\u0000\u01a9G\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005"+
		"3\u0000\u0000\u01ab\u01ac\u0003\f\u0006\u0000\u01ac\u01ad\u00051\u0000"+
		"\u0000\u01ad\u01ae\u0005\u0002\u0000\u0000\u01ae\u01af\u0003P(\u0000\u01af"+
		"\u01b0\u0005\u0003\u0000\u0000\u01b0\u01b1\u0005\u0001\u0000\u0000\u01b1"+
		"I\u0001\u0000\u0000\u0000\u01b2\u01b9\u0003L&\u0000\u01b3\u01b4\u0005"+
		"\u0017\u0000\u0000\u01b4\u01b8\u0003L&\u0000\u01b5\u01b6\u0005\u0018\u0000"+
		"\u0000\u01b6\u01b8\u0003L&\u0000\u01b7\u01b3\u0001\u0000\u0000\u0000\u01b7"+
		"\u01b5\u0001\u0000\u0000\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000\u01b9"+
		"\u01b7\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba"+
		"K\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bc\u01c5"+
		"\u0003N\'\u0000\u01bd\u01be\u0005\u0019\u0000\u0000\u01be\u01c4\u0003"+
		"N\'\u0000\u01bf\u01c0\u0005\u001a\u0000\u0000\u01c0\u01c4\u0003N\'\u0000"+
		"\u01c1\u01c2\u0005\u001b\u0000\u0000\u01c2\u01c4\u0003N\'\u0000\u01c3"+
		"\u01bd\u0001\u0000\u0000\u0000\u01c3\u01bf\u0001\u0000\u0000\u0000\u01c3"+
		"\u01c1\u0001\u0000\u0000\u0000\u01c4\u01c7\u0001\u0000\u0000\u0000\u01c5"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6"+
		"M\u0001\u0000\u0000\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01c9"+
		"\u0005\u001e\u0000\u0000\u01c9\u01d7\u0003N\'\u0000\u01ca\u01cb\u0005"+
		"\u0002\u0000\u0000\u01cb\u01cc\u0003J%\u0000\u01cc\u01cd\u0005\u0003\u0000"+
		"\u0000\u01cd\u01d7\u0001\u0000\u0000\u0000\u01ce\u01d7\u00057\u0000\u0000"+
		"\u01cf\u01d7\u00056\u0000\u0000\u01d0\u01d7\u00058\u0000\u0000\u01d1\u01d7"+
		"\u0005\u0013\u0000\u0000\u01d2\u01d3\u00056\u0000\u0000\u01d3\u01d7\u0005"+
		" \u0000\u0000\u01d4\u01d5\u00056\u0000\u0000\u01d5\u01d7\u0005!\u0000"+
		"\u0000\u01d6\u01c8\u0001\u0000\u0000\u0000\u01d6\u01ca\u0001\u0000\u0000"+
		"\u0000\u01d6\u01ce\u0001\u0000\u0000\u0000\u01d6\u01cf\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d0\u0001\u0000\u0000\u0000\u01d6\u01d1\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d2\u0001\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000"+
		"\u0000\u01d7O\u0001\u0000\u0000\u0000\u01d8\u01d9\u0006(\uffff\uffff\u0000"+
		"\u01d9\u01da\u0005\u0002\u0000\u0000\u01da\u01db\u0003P(\u0000\u01db\u01dc"+
		"\u0005\u0003\u0000\u0000\u01dc\u01e5\u0001\u0000\u0000\u0000\u01dd\u01de"+
		"\u0005\u001e\u0000\u0000\u01de\u01e5\u0003P(\u0004\u01df\u01e2\u0003J"+
		"%\u0000\u01e0\u01e1\u0005\u001f\u0000\u0000\u01e1\u01e3\u0003J%\u0000"+
		"\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000\u0000\u0000"+
		"\u01e3\u01e5\u0001\u0000\u0000\u0000\u01e4\u01d8\u0001\u0000\u0000\u0000"+
		"\u01e4\u01dd\u0001\u0000\u0000\u0000\u01e4\u01df\u0001\u0000\u0000\u0000"+
		"\u01e5\u01ee\u0001\u0000\u0000\u0000\u01e6\u01e7\n\u0003\u0000\u0000\u01e7"+
		"\u01e8\u0005\u001c\u0000\u0000\u01e8\u01ed\u0003P(\u0004\u01e9\u01ea\n"+
		"\u0002\u0000\u0000\u01ea\u01eb\u0005\u001d\u0000\u0000\u01eb\u01ed\u0003"+
		"P(\u0003\u01ec\u01e6\u0001\u0000\u0000\u0000\u01ec\u01e9\u0001\u0000\u0000"+
		"\u0000\u01ed\u01f0\u0001\u0000\u0000\u0000\u01ee\u01ec\u0001\u0000\u0000"+
		"\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000\u01efQ\u0001\u0000\u0000\u0000"+
		"\u01f0\u01ee\u0001\u0000\u0000\u0000\u01f1\u01f2\u0005\u0002\u0000\u0000"+
		"\u01f2\u01f3\u0007\u0001\u0000\u0000\u01f3\u01f4\u0005\u0003\u0000\u0000"+
		"\u01f4\u01f5\u00056\u0000\u0000\u01f5\u01f6\u0005\u0001\u0000\u0000\u01f6"+
		"S\u0001\u0000\u0000\u0000\u01f7\u01f8\u00054\u0000\u0000\u01f8\u01f9\u0005"+
		"\u0002\u0000\u0000\u01f9\u01fa\u00056\u0000\u0000\u01fa\u01fb\u0005\u0003"+
		"\u0000\u0000\u01fb\u01fc\u0005\u0001\u0000\u0000\u01fcU\u0001\u0000\u0000"+
		"\u0000\u01fd\u01fe\u0003P(\u0000\u01fe\u01ff\u0005\u000b\u0000\u0000\u01ff"+
		"\u0200\u0003J%\u0000\u0200\u0201\u0005\n\u0000\u0000\u0201\u0202\u0003"+
		"J%\u0000\u0202\u0203\u0005\u0001\u0000\u0000\u0203W\u0001\u0000\u0000"+
		"\u0000\u0204\u0205\u0005$\u0000\u0000\u0205\u0206\u0003J%\u0000\u0206"+
		"\u0207\u0005\u0001\u0000\u0000\u0207\u020b\u0001\u0000\u0000\u0000\u0208"+
		"\u0209\u0005$\u0000\u0000\u0209\u020b\u0005\u0001\u0000\u0000\u020a\u0204"+
		"\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000\u0000\u0000\u020bY\u0001"+
		"\u0000\u0000\u0000+acmvx\u0080\u0089\u00a3\u00ab\u00af\u00b6\u00b8\u00c4"+
		"\u00cd\u00f1\u0107\u010f\u011b\u0123\u0132\u0140\u0147\u0150\u0162\u0167"+
		"\u0171\u0174\u017e\u0189\u0191\u019d\u01a0\u01a5\u01b7\u01b9\u01c3\u01c5"+
		"\u01d6\u01e2\u01e4\u01ec\u01ee\u020a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}