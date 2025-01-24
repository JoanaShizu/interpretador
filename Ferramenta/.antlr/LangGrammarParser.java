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
		T__0=1, T__1=2, T__2=3, T__3=4, LIB=5, INCLUDE=6, DEFINE=7, RELOP=8, COMMENTLINE=9, 
		COMMENTBLOCK=10, INT=11, FLOAT=12, CHAR=13, DOUBLE=14, VOID=15, MAIN=16, 
		COMMA=17, PLUS=18, MINUS=19, MULT=20, DIV=21, MOD=22, AND=23, OR=24, NOT=25, 
		CD=26, CE=27, PD=28, PE=29, CO=30, CC=31, SOMA=32, SUB=33, ASSIGN=34, 
		DOT=35, RETURN=36, SCAN=37, PRINT=38, GETS=39, PUTS=40, STRUCT=41, UNION=42, 
		IF=43, ELSE=44, SWITCH=45, CASE=46, BREAK=47, DEFAULT=48, WHILE=49, FOR=50, 
		DO=51, TYPEOF=52, WS=53, VAR=54, NUM=55, CONSTANT=56, FORMAT=57, STR=58;
	public static final int
		RULE_programa = 0, RULE_cabecalho = 1, RULE_includeDecl = 2, RULE_defineDecl = 3, 
		RULE_corpo = 4, RULE_mainFunction = 5, RULE_bloco = 6, RULE_structDecl = 7, 
		RULE_structMember = 8, RULE_structAccess = 9, RULE_linhas = 10, RULE_comentario = 11, 
		RULE_atrib = 12, RULE_arrayDecl = 13, RULE_elementosArray = 14, RULE_arrayAccess = 15, 
		RULE_pointerDecl = 16, RULE_pointerAssign = 17, RULE_pointerDereference = 18, 
		RULE_input = 19, RULE_output = 20, RULE_getsStmt = 21, RULE_putsStmt = 22, 
		RULE_functionDecl = 23, RULE_functionCall = 24, RULE_blocoFunction = 25, 
		RULE_parametros = 26, RULE_tipo = 27, RULE_argumentos = 28, RULE_unionDecl = 29, 
		RULE_unionFields = 30, RULE_unionAccess = 31, RULE_decisionFunc = 32, 
		RULE_switchCase = 33, RULE_caseBlock = 34, RULE_defaultBlock = 35, RULE_loopFunc = 36, 
		RULE_whileLoop = 37, RULE_forLoop = 38, RULE_doWhileLoop = 39, RULE_expression = 40, 
		RULE_arrayUpdate = 41, RULE_terminais = 42, RULE_fator = 43, RULE_exprbloco = 44, 
		RULE_casting = 45, RULE_typeof = 46, RULE_ternary = 47, RULE_returnStmt = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "cabecalho", "includeDecl", "defineDecl", "corpo", "mainFunction", 
			"bloco", "structDecl", "structMember", "structAccess", "linhas", "comentario", 
			"atrib", "arrayDecl", "elementosArray", "arrayAccess", "pointerDecl", 
			"pointerAssign", "pointerDereference", "input", "output", "getsStmt", 
			"putsStmt", "functionDecl", "functionCall", "blocoFunction", "parametros", 
			"tipo", "argumentos", "unionDecl", "unionFields", "unionAccess", "decisionFunc", 
			"switchCase", "caseBlock", "defaultBlock", "loopFunc", "whileLoop", "forLoop", 
			"doWhileLoop", "expression", "arrayUpdate", "terminais", "fator", "exprbloco", 
			"casting", "typeof", "ternary", "returnStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'&'", "':'", "'?'", null, "'#include'", "'#define'", null, 
			null, null, "'int'", "'float'", "'char'", "'double'", "'void'", "'main'", 
			"','", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'{'", 
			"'}'", "'('", "')'", "'['", "']'", "'++'", "'--'", "'='", "'.'", "'return'", 
			"'scanf'", "'printf'", "'gets'", "'puts'", "'struct'", "'union'", "'if'", 
			"'else'", "'switch'", "'case'", "'break'", "'default'", "'while'", "'for'", 
			"'do'", "'typeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "LIB", "INCLUDE", "DEFINE", "RELOP", "COMMENTLINE", 
			"COMMENTBLOCK", "INT", "FLOAT", "CHAR", "DOUBLE", "VOID", "MAIN", "COMMA", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "AND", "OR", "NOT", "CD", "CE", 
			"PD", "PE", "CO", "CC", "SOMA", "SUB", "ASSIGN", "DOT", "RETURN", "SCAN", 
			"PRINT", "GETS", "PUTS", "STRUCT", "UNION", "IF", "ELSE", "SWITCH", "CASE", 
			"BREAK", "DEFAULT", "WHILE", "FOR", "DO", "TYPEOF", "WS", "VAR", "NUM", 
			"CONSTANT", "FORMAT", "STR"
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
			setState(98);
			cabecalho();
			setState(99);
			corpo();
			setState(100);
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
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(105);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INCLUDE:
						{
						setState(102);
						includeDecl();
						}
						break;
					case DEFINE:
						{
						setState(103);
						defineDecl();
						}
						break;
					case COMMENTLINE:
					case COMMENTBLOCK:
						{
						setState(104);
						comentario();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(109);
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
			setState(110);
			match(INCLUDE);
			setState(111);
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
			setState(113);
			match(DEFINE);
			setState(114);
			match(VAR);
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(115);
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
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18020995579313664L) != 0)) {
				{
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(118);
					structDecl();
					}
					break;
				case 2:
					{
					setState(119);
					mainFunction();
					}
					break;
				case 3:
					{
					setState(120);
					functionDecl();
					}
					break;
				case 4:
					{
					setState(121);
					unionDecl();
					}
					break;
				case 5:
					{
					setState(122);
					comentario();
					}
					break;
				}
				}
				setState(127);
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
			setState(128);
			match(INT);
			setState(129);
			match(MAIN);
			setState(130);
			match(PD);
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(131);
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
			setState(135);
			match(PE);
			setState(136);
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
			setState(138);
			match(CD);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 350766131076726272L) != 0)) {
				{
				{
				setState(139);
				linhas();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
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
			setState(147);
			match(STRUCT);
			setState(148);
			match(VAR);
			setState(149);
			match(CD);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18016597532801024L) != 0)) {
				{
				{
				setState(150);
				structMember();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(CE);
			setState(157);
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
	public static class StructMemberContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode CO() { return getToken(LangGrammarParser.CO, 0); }
		public TerminalNode CONSTANT() { return getToken(LangGrammarParser.CONSTANT, 0); }
		public TerminalNode CC() { return getToken(LangGrammarParser.CC, 0); }
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			tipo();
			setState(160);
			match(VAR);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CO) {
				{
				setState(161);
				match(CO);
				setState(162);
				match(CONSTANT);
				setState(163);
				match(CC);
				}
			}

			setState(166);
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
		enterRule(_localctx, 18, RULE_structAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(VAR);
			setState(169);
			match(DOT);
			setState(170);
			match(VAR);
			setState(171);
			match(ASSIGN);
			setState(172);
			expression();
			setState(173);
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
	public static class LinhasContext extends ParserRuleContext {
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
		public UnionAccessContext unionAccess() {
			return getRuleContext(UnionAccessContext.class,0);
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
		enterRule(_localctx, 20, RULE_linhas);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				structAccess();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				atrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				comentario();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				arrayDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
				pointerDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(181);
				pointerAssign();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(182);
				pointerDereference();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(183);
				unionAccess();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(184);
				input();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(185);
				output();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(186);
				getsStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(187);
				putsStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(188);
				decisionFunc();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(189);
				switchCase();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(190);
				loopFunc();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(191);
				doWhileLoop();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(192);
				casting();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(193);
				typeof();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(194);
				ternary();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(195);
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
		enterRule(_localctx, 22, RULE_comentario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
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
		enterRule(_localctx, 24, RULE_atrib);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				tipo();
				setState(201);
				match(VAR);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(202);
					match(ASSIGN);
					setState(203);
					expression();
					}
				}

				setState(206);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(VAR);
				setState(209);
				match(ASSIGN);
				setState(210);
				expression();
				setState(211);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
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
		public TerminalNode NUM() { return getToken(LangGrammarParser.NUM, 0); }
		public TerminalNode CC() { return getToken(LangGrammarParser.CC, 0); }
		public TerminalNode ASSIGN() { return getToken(LangGrammarParser.ASSIGN, 0); }
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
		enterRule(_localctx, 26, RULE_arrayDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			tipo();
			setState(217);
			match(VAR);
			setState(218);
			match(CO);
			setState(219);
			match(NUM);
			setState(220);
			match(CC);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(221);
				match(ASSIGN);
				setState(222);
				match(CD);
				setState(223);
				elementosArray();
				setState(224);
				match(CE);
				}
			}

			setState(228);
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
		public List<TerminalNode> DOT() { return getTokens(LangGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(LangGrammarParser.DOT, i);
		}
		public ElementosArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementosArray; }
	}

	public final ElementosArrayContext elementosArray() throws RecognitionException {
		ElementosArrayContext _localctx = new ElementosArrayContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elementosArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			expression();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(231);
				match(DOT);
				setState(232);
				expression();
				}
				}
				setState(237);
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
		enterRule(_localctx, 30, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(VAR);
			setState(239);
			match(CO);
			setState(240);
			expression();
			setState(241);
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
		enterRule(_localctx, 32, RULE_pointerDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(244);
			match(MULT);
			setState(245);
			match(VAR);
			setState(246);
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
		enterRule(_localctx, 34, RULE_pointerAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(VAR);
			setState(249);
			match(ASSIGN);
			setState(250);
			match(T__1);
			setState(251);
			match(VAR);
			setState(252);
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
		enterRule(_localctx, 36, RULE_pointerDereference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(MULT);
			setState(255);
			match(VAR);
			setState(256);
			match(ASSIGN);
			setState(257);
			expression();
			setState(258);
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
	public static class InputContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(LangGrammarParser.SCAN, 0); }
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode FORMAT() { return getToken(LangGrammarParser.FORMAT, 0); }
		public TerminalNode COMMA() { return getToken(LangGrammarParser.COMMA, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(SCAN);
			setState(261);
			match(PD);
			setState(262);
			match(FORMAT);
			setState(263);
			match(COMMA);
			setState(264);
			match(T__1);
			setState(265);
			match(VAR);
			setState(266);
			match(PE);
			setState(267);
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
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode STR() { return getToken(LangGrammarParser.STR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LangGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangGrammarParser.COMMA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExprblocoContext> exprbloco() {
			return getRuleContexts(ExprblocoContext.class);
		}
		public ExprblocoContext exprbloco(int i) {
			return getRuleContext(ExprblocoContext.class,i);
		}
		public List<ArrayAccessContext> arrayAccess() {
			return getRuleContexts(ArrayAccessContext.class);
		}
		public ArrayAccessContext arrayAccess(int i) {
			return getRuleContext(ArrayAccessContext.class,i);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_output);
		int _la;
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(PRINT);
				setState(270);
				match(PD);
				setState(271);
				match(STR);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(272);
					match(COMMA);
					setState(276);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(273);
						expression();
						}
						break;
					case 2:
						{
						setState(274);
						exprbloco(0);
						}
						break;
					case 3:
						{
						setState(275);
						arrayAccess();
						}
						break;
					}
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(283);
				match(PE);
				setState(284);
				match(T__0);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(STR);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					setState(290);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(286);
						match(COMMA);
						setState(287);
						expression();
						}
						break;
					case 2:
						{
						setState(288);
						match(COMMA);
						setState(289);
						arrayAccess();
						}
						break;
					}
					}
					setState(294);
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
		public GetsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getsStmt; }
	}

	public final GetsStmtContext getsStmt() throws RecognitionException {
		GetsStmtContext _localctx = new GetsStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_getsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(GETS);
			setState(298);
			match(PD);
			setState(299);
			match(VAR);
			setState(300);
			match(PE);
			setState(301);
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
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public PutsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_putsStmt; }
	}

	public final PutsStmtContext putsStmt() throws RecognitionException {
		PutsStmtContext _localctx = new PutsStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_putsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(PUTS);
			setState(304);
			match(PD);
			setState(305);
			match(VAR);
			setState(306);
			match(PE);
			setState(307);
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
		enterRule(_localctx, 46, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			tipo();
			setState(310);
			match(VAR);
			setState(311);
			match(PD);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18016597532801024L) != 0)) {
				{
				setState(312);
				parametros();
				}
			}

			setState(315);
			match(PE);
			setState(316);
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
		enterRule(_localctx, 48, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(VAR);
			setState(319);
			match(PD);
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 342273571982155776L) != 0)) {
				{
				setState(320);
				argumentos();
				}
			}

			setState(323);
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
		enterRule(_localctx, 50, RULE_blocoFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(CD);
			setState(327); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(326);
				linhas();
				}
				}
				setState(329); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 350766131076726272L) != 0) );
			setState(331);
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
		enterRule(_localctx, 52, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			tipo();
			setState(334);
			match(VAR);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(335);
				match(COMMA);
				setState(336);
				tipo();
				setState(337);
				match(VAR);
				}
				}
				setState(343);
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
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_tipo);
		try {
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				match(FLOAT);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(346);
				match(CHAR);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(347);
				match(DOUBLE);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 5);
				{
				setState(348);
				match(VOID);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 6);
				{
				setState(349);
				match(STRUCT);
				setState(350);
				match(VAR);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(351);
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
		enterRule(_localctx, 56, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			expression();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(355);
				match(COMMA);
				setState(356);
				expression();
				}
				}
				setState(361);
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
		public UnionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionDecl; }
	}

	public final UnionDeclContext unionDecl() throws RecognitionException {
		UnionDeclContext _localctx = new UnionDeclContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(UNION);
			setState(363);
			match(VAR);
			setState(364);
			match(CD);
			setState(365);
			unionFields();
			setState(366);
			match(CE);
			setState(367);
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
		enterRule(_localctx, 60, RULE_unionFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(369);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(370);
				match(VAR);
				setState(371);
				match(T__0);
				}
				}
				setState(374); 
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
		enterRule(_localctx, 62, RULE_unionAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(VAR);
			setState(377);
			match(DOT);
			setState(378);
			match(VAR);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(379);
				match(ASSIGN);
				setState(380);
				expression();
				}
			}

			setState(383);
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
		enterRule(_localctx, 64, RULE_decisionFunc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(IF);
			setState(386);
			match(PD);
			setState(387);
			exprbloco(0);
			setState(388);
			match(PE);
			setState(389);
			bloco();
			setState(399);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(390);
					match(ELSE);
					setState(391);
					match(IF);
					setState(392);
					match(PD);
					setState(393);
					exprbloco(0);
					setState(394);
					match(PE);
					setState(395);
					bloco();
					}
					} 
				}
				setState(401);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(402);
				match(ELSE);
				setState(403);
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
		enterRule(_localctx, 66, RULE_switchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(SWITCH);
			setState(407);
			match(PD);
			setState(408);
			match(VAR);
			setState(409);
			match(PE);
			setState(410);
			match(CD);
			setState(412); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(411);
				caseBlock();
				}
				}
				setState(414); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(416);
				defaultBlock();
				}
			}

			setState(419);
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
		enterRule(_localctx, 68, RULE_caseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(CASE);
			setState(422);
			match(NUM);
			setState(423);
			match(T__2);
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 350766131076726272L) != 0)) {
				{
				{
				setState(424);
				linhas();
				}
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(430);
			match(BREAK);
			setState(431);
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
		enterRule(_localctx, 70, RULE_defaultBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(DEFAULT);
			setState(434);
			match(T__2);
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 350766131076726272L) != 0)) {
				{
				{
				setState(435);
				linhas();
				}
				}
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(441);
			match(BREAK);
			setState(442);
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
		enterRule(_localctx, 72, RULE_loopFunc);
		try {
			setState(446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				whileLoop();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
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
		enterRule(_localctx, 74, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(WHILE);
			setState(449);
			match(PD);
			setState(450);
			exprbloco(0);
			setState(451);
			match(PE);
			setState(452);
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
		enterRule(_localctx, 76, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(FOR);
			setState(455);
			match(PD);
			setState(458);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case VOID:
			case STRUCT:
			case VAR:
				{
				setState(456);
				atrib();
				}
				break;
			case T__0:
				{
				setState(457);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 342273571982155776L) != 0)) {
				{
				setState(460);
				exprbloco(0);
				}
			}

			setState(463);
			match(T__0);
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(464);
				atrib();
				}
				break;
			case 2:
				{
				setState(465);
				expression();
				}
				break;
			}
			setState(468);
			match(PE);
			setState(469);
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
		public DoWhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoop; }
	}

	public final DoWhileLoopContext doWhileLoop() throws RecognitionException {
		DoWhileLoopContext _localctx = new DoWhileLoopContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_doWhileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(DO);
			setState(472);
			bloco();
			setState(473);
			match(WHILE);
			setState(474);
			match(PD);
			setState(475);
			exprbloco(0);
			setState(476);
			match(PE);
			setState(477);
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
		enterRule(_localctx, 80, RULE_expression);
		int _la;
		try {
			int _alt;
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				terminais();
				setState(484);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(480);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(481);
						terminais();
						}
						} 
					}
					setState(486);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
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
		enterRule(_localctx, 82, RULE_arrayUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(VAR);
			setState(491);
			match(CO);
			setState(492);
			expression();
			setState(493);
			match(CC);
			setState(494);
			match(ASSIGN);
			setState(495);
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
		enterRule(_localctx, 84, RULE_terminais);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			fator();
			setState(506);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(504);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MULT:
						{
						setState(498);
						match(MULT);
						setState(499);
						fator();
						}
						break;
					case DIV:
						{
						setState(500);
						match(DIV);
						setState(501);
						fator();
						}
						break;
					case MOD:
						{
						setState(502);
						match(MOD);
						setState(503);
						fator();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(508);
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
		enterRule(_localctx, 86, RULE_fator);
		try {
			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				match(NOT);
				setState(510);
				fator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				match(PD);
				setState(512);
				expression();
				setState(513);
				match(PE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(515);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(516);
				match(VAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(517);
				match(STR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(518);
				match(CHAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(519);
				match(VAR);
				setState(520);
				match(SOMA);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(521);
				match(VAR);
				setState(522);
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
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_exprbloco, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				_localctx = new ParentesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(526);
				match(PD);
				setState(527);
				exprbloco(0);
				setState(528);
				match(PE);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(530);
				match(NOT);
				setState(531);
				exprbloco(4);
				}
				break;
			case 3:
				{
				_localctx = new RelationalExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(532);
				expression();
				setState(535);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(533);
					match(RELOP);
					setState(534);
					expression();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(547);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(545);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new AndExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(539);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(540);
						match(AND);
						setState(541);
						exprbloco(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExpressionContext(new ExprblocoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprbloco);
						setState(542);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(543);
						match(OR);
						setState(544);
						exprbloco(3);
						}
						break;
					}
					} 
				}
				setState(549);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 90, RULE_casting);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(PD);
			setState(551);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(552);
			match(PE);
			setState(553);
			match(VAR);
			setState(554);
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
		public TerminalNode PD() { return getToken(LangGrammarParser.PD, 0); }
		public TerminalNode VAR() { return getToken(LangGrammarParser.VAR, 0); }
		public TerminalNode PE() { return getToken(LangGrammarParser.PE, 0); }
		public TypeofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeof; }
	}

	public final TypeofContext typeof() throws RecognitionException {
		TypeofContext _localctx = new TypeofContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_typeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(TYPEOF);
			setState(557);
			match(PD);
			setState(558);
			match(VAR);
			setState(559);
			match(PE);
			setState(560);
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
		enterRule(_localctx, 94, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			exprbloco(0);
			setState(563);
			match(T__3);
			setState(564);
			expression();
			setState(565);
			match(T__2);
			setState(566);
			expression();
			setState(567);
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
		enterRule(_localctx, 96, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			match(RETURN);
			setState(570);
			expression();
			setState(571);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 44:
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
		"\u0004\u0001:\u023e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"j\b\u0001\n\u0001\f\u0001m\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003u\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004|\b\u0004"+
		"\n\u0004\f\u0004\u007f\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u0086\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0005\u0006\u008d\b\u0006\n\u0006\f\u0006"+
		"\u0090\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u0098\b\u0007\n\u0007\f\u0007\u009b\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0003\b\u00a5\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c5\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00cd\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d7"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00e3\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00ea\b\u000e\n\u000e\f\u000e\u00ed\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u0115\b\u0014\u0005\u0014\u0117\b\u0014\n\u0014"+
		"\f\u0014\u011a\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0123\b\u0014\n\u0014"+
		"\f\u0014\u0126\t\u0014\u0003\u0014\u0128\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u013a\b\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0142\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0004\u0019\u0148\b\u0019"+
		"\u000b\u0019\f\u0019\u0149\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0154\b\u001a"+
		"\n\u001a\f\u001a\u0157\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0161"+
		"\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0166\b\u001c"+
		"\n\u001c\f\u001c\u0169\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0004\u001e\u0175\b\u001e\u000b\u001e\f\u001e\u0176\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u017e\b\u001f"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u018e\b \n \f \u0191\t \u0001"+
		" \u0001 \u0003 \u0195\b \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0004"+
		"!\u019d\b!\u000b!\f!\u019e\u0001!\u0003!\u01a2\b!\u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0005\"\u01aa\b\"\n\"\f\"\u01ad\t\"\u0001\""+
		"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0005#\u01b5\b#\n#\f#\u01b8\t#\u0001"+
		"#\u0001#\u0001#\u0001$\u0001$\u0003$\u01bf\b$\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0003&\u01cb\b&\u0001&\u0003"+
		"&\u01ce\b&\u0001&\u0001&\u0001&\u0003&\u01d3\b&\u0001&\u0001&\u0001&\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001"+
		"(\u0001(\u0005(\u01e3\b(\n(\f(\u01e6\t(\u0001(\u0003(\u01e9\b(\u0001)"+
		"\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0005*\u01f9\b*\n*\f*\u01fc\t*\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0003+\u020c\b+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0003,\u0218\b,\u0003,\u021a\b,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0005,\u0222\b,\n,\f,\u0225\t,\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u00010\u00010\u00010\u0001"+
		"0\u00010\u0000\u0001X1\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`\u0000\u0003\u0001\u0000\t\n\u0001\u0000\u000b\u000f\u0001\u0000\u0012"+
		"\u0013\u0260\u0000b\u0001\u0000\u0000\u0000\u0002k\u0001\u0000\u0000\u0000"+
		"\u0004n\u0001\u0000\u0000\u0000\u0006q\u0001\u0000\u0000\u0000\b}\u0001"+
		"\u0000\u0000\u0000\n\u0080\u0001\u0000\u0000\u0000\f\u008a\u0001\u0000"+
		"\u0000\u0000\u000e\u0093\u0001\u0000\u0000\u0000\u0010\u009f\u0001\u0000"+
		"\u0000\u0000\u0012\u00a8\u0001\u0000\u0000\u0000\u0014\u00c4\u0001\u0000"+
		"\u0000\u0000\u0016\u00c6\u0001\u0000\u0000\u0000\u0018\u00d6\u0001\u0000"+
		"\u0000\u0000\u001a\u00d8\u0001\u0000\u0000\u0000\u001c\u00e6\u0001\u0000"+
		"\u0000\u0000\u001e\u00ee\u0001\u0000\u0000\u0000 \u00f3\u0001\u0000\u0000"+
		"\u0000\"\u00f8\u0001\u0000\u0000\u0000$\u00fe\u0001\u0000\u0000\u0000"+
		"&\u0104\u0001\u0000\u0000\u0000(\u0127\u0001\u0000\u0000\u0000*\u0129"+
		"\u0001\u0000\u0000\u0000,\u012f\u0001\u0000\u0000\u0000.\u0135\u0001\u0000"+
		"\u0000\u00000\u013e\u0001\u0000\u0000\u00002\u0145\u0001\u0000\u0000\u0000"+
		"4\u014d\u0001\u0000\u0000\u00006\u0160\u0001\u0000\u0000\u00008\u0162"+
		"\u0001\u0000\u0000\u0000:\u016a\u0001\u0000\u0000\u0000<\u0174\u0001\u0000"+
		"\u0000\u0000>\u0178\u0001\u0000\u0000\u0000@\u0181\u0001\u0000\u0000\u0000"+
		"B\u0196\u0001\u0000\u0000\u0000D\u01a5\u0001\u0000\u0000\u0000F\u01b1"+
		"\u0001\u0000\u0000\u0000H\u01be\u0001\u0000\u0000\u0000J\u01c0\u0001\u0000"+
		"\u0000\u0000L\u01c6\u0001\u0000\u0000\u0000N\u01d7\u0001\u0000\u0000\u0000"+
		"P\u01e8\u0001\u0000\u0000\u0000R\u01ea\u0001\u0000\u0000\u0000T\u01f1"+
		"\u0001\u0000\u0000\u0000V\u020b\u0001\u0000\u0000\u0000X\u0219\u0001\u0000"+
		"\u0000\u0000Z\u0226\u0001\u0000\u0000\u0000\\\u022c\u0001\u0000\u0000"+
		"\u0000^\u0232\u0001\u0000\u0000\u0000`\u0239\u0001\u0000\u0000\u0000b"+
		"c\u0003\u0002\u0001\u0000cd\u0003\b\u0004\u0000de\u0005\u0000\u0000\u0001"+
		"e\u0001\u0001\u0000\u0000\u0000fj\u0003\u0004\u0002\u0000gj\u0003\u0006"+
		"\u0003\u0000hj\u0003\u0016\u000b\u0000if\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l\u0003\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005\u0006\u0000\u0000op\u0005"+
		"\u0005\u0000\u0000p\u0005\u0001\u0000\u0000\u0000qr\u0005\u0007\u0000"+
		"\u0000rt\u00056\u0000\u0000su\u0003P(\u0000ts\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u\u0007\u0001\u0000\u0000\u0000v|\u0003\u000e"+
		"\u0007\u0000w|\u0003\n\u0005\u0000x|\u0003.\u0017\u0000y|\u0003:\u001d"+
		"\u0000z|\u0003\u0016\u000b\u0000{v\u0001\u0000\u0000\u0000{w\u0001\u0000"+
		"\u0000\u0000{x\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0005\u000b\u0000\u0000\u0081\u0082\u0005"+
		"\u0010\u0000\u0000\u0082\u0085\u0005\u001c\u0000\u0000\u0083\u0086\u0005"+
		"\u000f\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005\u001d\u0000\u0000\u0088\u0089\u0003"+
		"\f\u0006\u0000\u0089\u000b\u0001\u0000\u0000\u0000\u008a\u008e\u0005\u001a"+
		"\u0000\u0000\u008b\u008d\u0003\u0014\n\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000"+
		"\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u001b\u0000"+
		"\u0000\u0092\r\u0001\u0000\u0000\u0000\u0093\u0094\u0005)\u0000\u0000"+
		"\u0094\u0095\u00056\u0000\u0000\u0095\u0099\u0005\u001a\u0000\u0000\u0096"+
		"\u0098\u0003\u0010\b\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u009b"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0099"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u001b\u0000\u0000\u009d\u009e"+
		"\u0005\u0001\u0000\u0000\u009e\u000f\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u00036\u001b\u0000\u00a0\u00a4\u00056\u0000\u0000\u00a1\u00a2\u0005\u001e"+
		"\u0000\u0000\u00a2\u00a3\u00058\u0000\u0000\u00a3\u00a5\u0005\u001f\u0000"+
		"\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0001\u0000"+
		"\u0000\u00a7\u0011\u0001\u0000\u0000\u0000\u00a8\u00a9\u00056\u0000\u0000"+
		"\u00a9\u00aa\u0005#\u0000\u0000\u00aa\u00ab\u00056\u0000\u0000\u00ab\u00ac"+
		"\u0005\"\u0000\u0000\u00ac\u00ad\u0003P(\u0000\u00ad\u00ae\u0005\u0001"+
		"\u0000\u0000\u00ae\u0013\u0001\u0000\u0000\u0000\u00af\u00c5\u0003\u0012"+
		"\t\u0000\u00b0\u00c5\u00030\u0018\u0000\u00b1\u00c5\u0003\u0018\f\u0000"+
		"\u00b2\u00c5\u0003\u0016\u000b\u0000\u00b3\u00c5\u0003\u001a\r\u0000\u00b4"+
		"\u00c5\u0003 \u0010\u0000\u00b5\u00c5\u0003\"\u0011\u0000\u00b6\u00c5"+
		"\u0003$\u0012\u0000\u00b7\u00c5\u0003>\u001f\u0000\u00b8\u00c5\u0003&"+
		"\u0013\u0000\u00b9\u00c5\u0003(\u0014\u0000\u00ba\u00c5\u0003*\u0015\u0000"+
		"\u00bb\u00c5\u0003,\u0016\u0000\u00bc\u00c5\u0003@ \u0000\u00bd\u00c5"+
		"\u0003B!\u0000\u00be\u00c5\u0003H$\u0000\u00bf\u00c5\u0003N\'\u0000\u00c0"+
		"\u00c5\u0003Z-\u0000\u00c1\u00c5\u0003\\.\u0000\u00c2\u00c5\u0003^/\u0000"+
		"\u00c3\u00c5\u0003`0\u0000\u00c4\u00af\u0001\u0000\u0000\u0000\u00c4\u00b0"+
		"\u0001\u0000\u0000\u0000\u00c4\u00b1\u0001\u0000\u0000\u0000\u00c4\u00b2"+
		"\u0001\u0000\u0000\u0000\u00c4\u00b3\u0001\u0000\u0000\u0000\u00c4\u00b4"+
		"\u0001\u0000\u0000\u0000\u00c4\u00b5\u0001\u0000\u0000\u0000\u00c4\u00b6"+
		"\u0001\u0000\u0000\u0000\u00c4\u00b7\u0001\u0000\u0000\u0000\u00c4\u00b8"+
		"\u0001\u0000\u0000\u0000\u00c4\u00b9\u0001\u0000\u0000\u0000\u00c4\u00ba"+
		"\u0001\u0000\u0000\u0000\u00c4\u00bb\u0001\u0000\u0000\u0000\u00c4\u00bc"+
		"\u0001\u0000\u0000\u0000\u00c4\u00bd\u0001\u0000\u0000\u0000\u00c4\u00be"+
		"\u0001\u0000\u0000\u0000\u00c4\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u0015"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0007\u0000\u0000\u0000\u00c7\u0017"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u00036\u001b\u0000\u00c9\u00cc\u0005"+
		"6\u0000\u0000\u00ca\u00cb\u0005\"\u0000\u0000\u00cb\u00cd\u0003P(\u0000"+
		"\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u0001\u0000\u0000"+
		"\u00cf\u00d7\u0001\u0000\u0000\u0000\u00d0\u00d1\u00056\u0000\u0000\u00d1"+
		"\u00d2\u0005\"\u0000\u0000\u00d2\u00d3\u0003P(\u0000\u00d3\u00d4\u0005"+
		"\u0001\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d7\u0003"+
		"\u0012\t\u0000\u00d6\u00c8\u0001\u0000\u0000\u0000\u00d6\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u0019\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u00036\u001b\u0000\u00d9\u00da\u00056\u0000\u0000"+
		"\u00da\u00db\u0005\u001e\u0000\u0000\u00db\u00dc\u00057\u0000\u0000\u00dc"+
		"\u00e2\u0005\u001f\u0000\u0000\u00dd\u00de\u0005\"\u0000\u0000\u00de\u00df"+
		"\u0005\u001a\u0000\u0000\u00df\u00e0\u0003\u001c\u000e\u0000\u00e0\u00e1"+
		"\u0005\u001b\u0000\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00dd"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u0001\u0000\u0000\u00e5\u001b"+
		"\u0001\u0000\u0000\u0000\u00e6\u00eb\u0003P(\u0000\u00e7\u00e8\u0005#"+
		"\u0000\u0000\u00e8\u00ea\u0003P(\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u001d\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef\u00056\u0000\u0000\u00ef"+
		"\u00f0\u0005\u001e\u0000\u0000\u00f0\u00f1\u0003P(\u0000\u00f1\u00f2\u0005"+
		"\u001f\u0000\u0000\u00f2\u001f\u0001\u0000\u0000\u0000\u00f3\u00f4\u0007"+
		"\u0001\u0000\u0000\u00f4\u00f5\u0005\u0014\u0000\u0000\u00f5\u00f6\u0005"+
		"6\u0000\u0000\u00f6\u00f7\u0005\u0001\u0000\u0000\u00f7!\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u00056\u0000\u0000\u00f9\u00fa\u0005\"\u0000\u0000"+
		"\u00fa\u00fb\u0005\u0002\u0000\u0000\u00fb\u00fc\u00056\u0000\u0000\u00fc"+
		"\u00fd\u0005\u0001\u0000\u0000\u00fd#\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0005\u0014\u0000\u0000\u00ff\u0100\u00056\u0000\u0000\u0100\u0101\u0005"+
		"\"\u0000\u0000\u0101\u0102\u0003P(\u0000\u0102\u0103\u0005\u0001\u0000"+
		"\u0000\u0103%\u0001\u0000\u0000\u0000\u0104\u0105\u0005%\u0000\u0000\u0105"+
		"\u0106\u0005\u001c\u0000\u0000\u0106\u0107\u00059\u0000\u0000\u0107\u0108"+
		"\u0005\u0011\u0000\u0000\u0108\u0109\u0005\u0002\u0000\u0000\u0109\u010a"+
		"\u00056\u0000\u0000\u010a\u010b\u0005\u001d\u0000\u0000\u010b\u010c\u0005"+
		"\u0001\u0000\u0000\u010c\'\u0001\u0000\u0000\u0000\u010d\u010e\u0005&"+
		"\u0000\u0000\u010e\u010f\u0005\u001c\u0000\u0000\u010f\u0118\u0005:\u0000"+
		"\u0000\u0110\u0114\u0005\u0011\u0000\u0000\u0111\u0115\u0003P(\u0000\u0112"+
		"\u0115\u0003X,\u0000\u0113\u0115\u0003\u001e\u000f\u0000\u0114\u0111\u0001"+
		"\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0113\u0001"+
		"\u0000\u0000\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0110\u0001"+
		"\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011b\u0001"+
		"\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011c\u0005"+
		"\u001d\u0000\u0000\u011c\u0128\u0005\u0001\u0000\u0000\u011d\u0124\u0005"+
		":\u0000\u0000\u011e\u011f\u0005\u0011\u0000\u0000\u011f\u0123\u0003P("+
		"\u0000\u0120\u0121\u0005\u0011\u0000\u0000\u0121\u0123\u0003\u001e\u000f"+
		"\u0000\u0122\u011e\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000"+
		"\u0000\u0123\u0126\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000"+
		"\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000"+
		"\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u010d\u0001\u0000\u0000"+
		"\u0000\u0127\u011d\u0001\u0000\u0000\u0000\u0128)\u0001\u0000\u0000\u0000"+
		"\u0129\u012a\u0005\'\u0000\u0000\u012a\u012b\u0005\u001c\u0000\u0000\u012b"+
		"\u012c\u00056\u0000\u0000\u012c\u012d\u0005\u001d\u0000\u0000\u012d\u012e"+
		"\u0005\u0001\u0000\u0000\u012e+\u0001\u0000\u0000\u0000\u012f\u0130\u0005"+
		"(\u0000\u0000\u0130\u0131\u0005\u001c\u0000\u0000\u0131\u0132\u00056\u0000"+
		"\u0000\u0132\u0133\u0005\u001d\u0000\u0000\u0133\u0134\u0005\u0001\u0000"+
		"\u0000\u0134-\u0001\u0000\u0000\u0000\u0135\u0136\u00036\u001b\u0000\u0136"+
		"\u0137\u00056\u0000\u0000\u0137\u0139\u0005\u001c\u0000\u0000\u0138\u013a"+
		"\u00034\u001a\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0005"+
		"\u001d\u0000\u0000\u013c\u013d\u00032\u0019\u0000\u013d/\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\u00056\u0000\u0000\u013f\u0141\u0005\u001c\u0000\u0000"+
		"\u0140\u0142\u00038\u001c\u0000\u0141\u0140\u0001\u0000\u0000\u0000\u0141"+
		"\u0142\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143"+
		"\u0144\u0005\u001d\u0000\u0000\u01441\u0001\u0000\u0000\u0000\u0145\u0147"+
		"\u0005\u001a\u0000\u0000\u0146\u0148\u0003\u0014\n\u0000\u0147\u0146\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u0147\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0005\u001b\u0000\u0000\u014c3\u0001\u0000"+
		"\u0000\u0000\u014d\u014e\u00036\u001b\u0000\u014e\u0155\u00056\u0000\u0000"+
		"\u014f\u0150\u0005\u0011\u0000\u0000\u0150\u0151\u00036\u001b\u0000\u0151"+
		"\u0152\u00056\u0000\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153\u014f"+
		"\u0001\u0000\u0000\u0000\u0154\u0157\u0001\u0000\u0000\u0000\u0155\u0153"+
		"\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u01565\u0001"+
		"\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0158\u0161\u0005"+
		"\u000b\u0000\u0000\u0159\u0161\u0005\f\u0000\u0000\u015a\u0161\u0005\r"+
		"\u0000\u0000\u015b\u0161\u0005\u000e\u0000\u0000\u015c\u0161\u0005\u000f"+
		"\u0000\u0000\u015d\u015e\u0005)\u0000\u0000\u015e\u0161\u00056\u0000\u0000"+
		"\u015f\u0161\u00056\u0000\u0000\u0160\u0158\u0001\u0000\u0000\u0000\u0160"+
		"\u0159\u0001\u0000\u0000\u0000\u0160\u015a\u0001\u0000\u0000\u0000\u0160"+
		"\u015b\u0001\u0000\u0000\u0000\u0160\u015c\u0001\u0000\u0000\u0000\u0160"+
		"\u015d\u0001\u0000\u0000\u0000\u0160\u015f\u0001\u0000\u0000\u0000\u0161"+
		"7\u0001\u0000\u0000\u0000\u0162\u0167\u0003P(\u0000\u0163\u0164\u0005"+
		"\u0011\u0000\u0000\u0164\u0166\u0003P(\u0000\u0165\u0163\u0001\u0000\u0000"+
		"\u0000\u0166\u0169\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000"+
		"\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u01689\u0001\u0000\u0000\u0000"+
		"\u0169\u0167\u0001\u0000\u0000\u0000\u016a\u016b\u0005*\u0000\u0000\u016b"+
		"\u016c\u00056\u0000\u0000\u016c\u016d\u0005\u001a\u0000\u0000\u016d\u016e"+
		"\u0003<\u001e\u0000\u016e\u016f\u0005\u001b\u0000\u0000\u016f\u0170\u0005"+
		"\u0001\u0000\u0000\u0170;\u0001\u0000\u0000\u0000\u0171\u0172\u0007\u0001"+
		"\u0000\u0000\u0172\u0173\u00056\u0000\u0000\u0173\u0175\u0005\u0001\u0000"+
		"\u0000\u0174\u0171\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000"+
		"\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000"+
		"\u0000\u0177=\u0001\u0000\u0000\u0000\u0178\u0179\u00056\u0000\u0000\u0179"+
		"\u017a\u0005#\u0000\u0000\u017a\u017d\u00056\u0000\u0000\u017b\u017c\u0005"+
		"\"\u0000\u0000\u017c\u017e\u0003P(\u0000\u017d\u017b\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000"+
		"\u0000\u017f\u0180\u0005\u0001\u0000\u0000\u0180?\u0001\u0000\u0000\u0000"+
		"\u0181\u0182\u0005+\u0000\u0000\u0182\u0183\u0005\u001c\u0000\u0000\u0183"+
		"\u0184\u0003X,\u0000\u0184\u0185\u0005\u001d\u0000\u0000\u0185\u018f\u0003"+
		"\f\u0006\u0000\u0186\u0187\u0005,\u0000\u0000\u0187\u0188\u0005+\u0000"+
		"\u0000\u0188\u0189\u0005\u001c\u0000\u0000\u0189\u018a\u0003X,\u0000\u018a"+
		"\u018b\u0005\u001d\u0000\u0000\u018b\u018c\u0003\f\u0006\u0000\u018c\u018e"+
		"\u0001\u0000\u0000\u0000\u018d\u0186\u0001\u0000\u0000\u0000\u018e\u0191"+
		"\u0001\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u0190"+
		"\u0001\u0000\u0000\u0000\u0190\u0194\u0001\u0000\u0000\u0000\u0191\u018f"+
		"\u0001\u0000\u0000\u0000\u0192\u0193\u0005,\u0000\u0000\u0193\u0195\u0003"+
		"\f\u0006\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000"+
		"\u0000\u0000\u0195A\u0001\u0000\u0000\u0000\u0196\u0197\u0005-\u0000\u0000"+
		"\u0197\u0198\u0005\u001c\u0000\u0000\u0198\u0199\u00056\u0000\u0000\u0199"+
		"\u019a\u0005\u001d\u0000\u0000\u019a\u019c\u0005\u001a\u0000\u0000\u019b"+
		"\u019d\u0003D\"\u0000\u019c\u019b\u0001\u0000\u0000\u0000\u019d\u019e"+
		"\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019f"+
		"\u0001\u0000\u0000\u0000\u019f\u01a1\u0001\u0000\u0000\u0000\u01a0\u01a2"+
		"\u0003F#\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005\u001b"+
		"\u0000\u0000\u01a4C\u0001\u0000\u0000\u0000\u01a5\u01a6\u0005.\u0000\u0000"+
		"\u01a6\u01a7\u00057\u0000\u0000\u01a7\u01ab\u0005\u0003\u0000\u0000\u01a8"+
		"\u01aa\u0003\u0014\n\u0000\u01a9\u01a8\u0001\u0000\u0000\u0000\u01aa\u01ad"+
		"\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ab\u01ac"+
		"\u0001\u0000\u0000\u0000\u01ac\u01ae\u0001\u0000\u0000\u0000\u01ad\u01ab"+
		"\u0001\u0000\u0000\u0000\u01ae\u01af\u0005/\u0000\u0000\u01af\u01b0\u0005"+
		"\u0001\u0000\u0000\u01b0E\u0001\u0000\u0000\u0000\u01b1\u01b2\u00050\u0000"+
		"\u0000\u01b2\u01b6\u0005\u0003\u0000\u0000\u01b3\u01b5\u0003\u0014\n\u0000"+
		"\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b8\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b9\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b9\u01ba\u0005/\u0000\u0000\u01ba\u01bb\u0005\u0001\u0000\u0000\u01bb"+
		"G\u0001\u0000\u0000\u0000\u01bc\u01bf\u0003J%\u0000\u01bd\u01bf\u0003"+
		"L&\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bfI\u0001\u0000\u0000\u0000\u01c0\u01c1\u00051\u0000\u0000\u01c1"+
		"\u01c2\u0005\u001c\u0000\u0000\u01c2\u01c3\u0003X,\u0000\u01c3\u01c4\u0005"+
		"\u001d\u0000\u0000\u01c4\u01c5\u0003\f\u0006\u0000\u01c5K\u0001\u0000"+
		"\u0000\u0000\u01c6\u01c7\u00052\u0000\u0000\u01c7\u01ca\u0005\u001c\u0000"+
		"\u0000\u01c8\u01cb\u0003\u0018\f\u0000\u01c9\u01cb\u0005\u0001\u0000\u0000"+
		"\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000"+
		"\u01cb\u01cd\u0001\u0000\u0000\u0000\u01cc\u01ce\u0003X,\u0000\u01cd\u01cc"+
		"\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01cf"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d2\u0005\u0001\u0000\u0000\u01d0\u01d3"+
		"\u0003\u0018\f\u0000\u01d1\u01d3\u0003P(\u0000\u01d2\u01d0\u0001\u0000"+
		"\u0000\u0000\u01d2\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d5\u0005\u001d\u0000\u0000\u01d5\u01d6\u0003\f\u0006"+
		"\u0000\u01d6M\u0001\u0000\u0000\u0000\u01d7\u01d8\u00053\u0000\u0000\u01d8"+
		"\u01d9\u0003\f\u0006\u0000\u01d9\u01da\u00051\u0000\u0000\u01da\u01db"+
		"\u0005\u001c\u0000\u0000\u01db\u01dc\u0003X,\u0000\u01dc\u01dd\u0005\u001d"+
		"\u0000\u0000\u01dd\u01de\u0005\u0001\u0000\u0000\u01deO\u0001\u0000\u0000"+
		"\u0000\u01df\u01e4\u0003T*\u0000\u01e0\u01e1\u0007\u0002\u0000\u0000\u01e1"+
		"\u01e3\u0003T*\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e6\u0001"+
		"\u0000\u0000\u0000\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e5\u01e9\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001"+
		"\u0000\u0000\u0000\u01e7\u01e9\u0003\u001e\u000f\u0000\u01e8\u01df\u0001"+
		"\u0000\u0000\u0000\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e9Q\u0001\u0000"+
		"\u0000\u0000\u01ea\u01eb\u00056\u0000\u0000\u01eb\u01ec\u0005\u001e\u0000"+
		"\u0000\u01ec\u01ed\u0003P(\u0000\u01ed\u01ee\u0005\u001f\u0000\u0000\u01ee"+
		"\u01ef\u0005\"\u0000\u0000\u01ef\u01f0\u0003P(\u0000\u01f0S\u0001\u0000"+
		"\u0000\u0000\u01f1\u01fa\u0003V+\u0000\u01f2\u01f3\u0005\u0014\u0000\u0000"+
		"\u01f3\u01f9\u0003V+\u0000\u01f4\u01f5\u0005\u0015\u0000\u0000\u01f5\u01f9"+
		"\u0003V+\u0000\u01f6\u01f7\u0005\u0016\u0000\u0000\u01f7\u01f9\u0003V"+
		"+\u0000\u01f8\u01f2\u0001\u0000\u0000\u0000\u01f8\u01f4\u0001\u0000\u0000"+
		"\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f9\u01fc\u0001\u0000\u0000"+
		"\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000"+
		"\u0000\u01fbU\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000"+
		"\u01fd\u01fe\u0005\u0019\u0000\u0000\u01fe\u020c\u0003V+\u0000\u01ff\u0200"+
		"\u0005\u001c\u0000\u0000\u0200\u0201\u0003P(\u0000\u0201\u0202\u0005\u001d"+
		"\u0000\u0000\u0202\u020c\u0001\u0000\u0000\u0000\u0203\u020c\u00057\u0000"+
		"\u0000\u0204\u020c\u00056\u0000\u0000\u0205\u020c\u0005:\u0000\u0000\u0206"+
		"\u020c\u0005\r\u0000\u0000\u0207\u0208\u00056\u0000\u0000\u0208\u020c"+
		"\u0005 \u0000\u0000\u0209\u020a\u00056\u0000\u0000\u020a\u020c\u0005!"+
		"\u0000\u0000\u020b\u01fd\u0001\u0000\u0000\u0000\u020b\u01ff\u0001\u0000"+
		"\u0000\u0000\u020b\u0203\u0001\u0000\u0000\u0000\u020b\u0204\u0001\u0000"+
		"\u0000\u0000\u020b\u0205\u0001\u0000\u0000\u0000\u020b\u0206\u0001\u0000"+
		"\u0000\u0000\u020b\u0207\u0001\u0000\u0000\u0000\u020b\u0209\u0001\u0000"+
		"\u0000\u0000\u020cW\u0001\u0000\u0000\u0000\u020d\u020e\u0006,\uffff\uffff"+
		"\u0000\u020e\u020f\u0005\u001c\u0000\u0000\u020f\u0210\u0003X,\u0000\u0210"+
		"\u0211\u0005\u001d\u0000\u0000\u0211\u021a\u0001\u0000\u0000\u0000\u0212"+
		"\u0213\u0005\u0019\u0000\u0000\u0213\u021a\u0003X,\u0004\u0214\u0217\u0003"+
		"P(\u0000\u0215\u0216\u0005\b\u0000\u0000\u0216\u0218\u0003P(\u0000\u0217"+
		"\u0215\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218"+
		"\u021a\u0001\u0000\u0000\u0000\u0219\u020d\u0001\u0000\u0000\u0000\u0219"+
		"\u0212\u0001\u0000\u0000\u0000\u0219\u0214\u0001\u0000\u0000\u0000\u021a"+
		"\u0223\u0001\u0000\u0000\u0000\u021b\u021c\n\u0003\u0000\u0000\u021c\u021d"+
		"\u0005\u0017\u0000\u0000\u021d\u0222\u0003X,\u0004\u021e\u021f\n\u0002"+
		"\u0000\u0000\u021f\u0220\u0005\u0018\u0000\u0000\u0220\u0222\u0003X,\u0003"+
		"\u0221\u021b\u0001\u0000\u0000\u0000\u0221\u021e\u0001\u0000\u0000\u0000"+
		"\u0222\u0225\u0001\u0000\u0000\u0000\u0223\u0221\u0001\u0000\u0000\u0000"+
		"\u0223\u0224\u0001\u0000\u0000\u0000\u0224Y\u0001\u0000\u0000\u0000\u0225"+
		"\u0223\u0001\u0000\u0000\u0000\u0226\u0227\u0005\u001c\u0000\u0000\u0227"+
		"\u0228\u0007\u0001\u0000\u0000\u0228\u0229\u0005\u001d\u0000\u0000\u0229"+
		"\u022a\u00056\u0000\u0000\u022a\u022b\u0005\u0001\u0000\u0000\u022b[\u0001"+
		"\u0000\u0000\u0000\u022c\u022d\u00054\u0000\u0000\u022d\u022e\u0005\u001c"+
		"\u0000\u0000\u022e\u022f\u00056\u0000\u0000\u022f\u0230\u0005\u001d\u0000"+
		"\u0000\u0230\u0231\u0005\u0001\u0000\u0000\u0231]\u0001\u0000\u0000\u0000"+
		"\u0232\u0233\u0003X,\u0000\u0233\u0234\u0005\u0004\u0000\u0000\u0234\u0235"+
		"\u0003P(\u0000\u0235\u0236\u0005\u0003\u0000\u0000\u0236\u0237\u0003P"+
		"(\u0000\u0237\u0238\u0005\u0001\u0000\u0000\u0238_\u0001\u0000\u0000\u0000"+
		"\u0239\u023a\u0005$\u0000\u0000\u023a\u023b\u0003P(\u0000\u023b\u023c"+
		"\u0005\u0001\u0000\u0000\u023ca\u0001\u0000\u0000\u0000.ikt{}\u0085\u008e"+
		"\u0099\u00a4\u00c4\u00cc\u00d6\u00e2\u00eb\u0114\u0118\u0122\u0124\u0127"+
		"\u0139\u0141\u0149\u0155\u0160\u0167\u0176\u017d\u018f\u0194\u019e\u01a1"+
		"\u01ab\u01b6\u01be\u01ca\u01cd\u01d2\u01e4\u01e8\u01f8\u01fa\u020b\u0217"+
		"\u0219\u0221\u0223";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}