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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, LIBRARY_NAME=30, PRINT_FUNCTION=31, 
		STRING=32, INT_LITERAL=33, FLOAT_LITERAL=34, CHAR_LITERAL=35, ID=36, WS=37;
	public static final int
		RULE_program = 0, RULE_include = 1, RULE_mainFunction = 2, RULE_block = 3, 
		RULE_statement = 4, RULE_expression = 5, RULE_declaration = 6, RULE_type = 7, 
		RULE_returnStatement = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "include", "mainFunction", "block", "statement", "expression", 
			"declaration", "type", "returnStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#include'", "'<'", "'>'", "'int'", "'main'", "'('", "')'", "'void'", 
			"'{'", "'}'", "';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", 
			"'>='", "'<='", "'&&'", "'||'", "'!'", "'='", "'['", "']'", "'float'", 
			"'char'", "'return'", null, "'printf'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "LIBRARY_NAME", "PRINT_FUNCTION", 
			"STRING", "INT_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", "ID", "WS"
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
	public static class ProgramContext extends ParserRuleContext {
		public MainFunctionContext mainFunction() {
			return getRuleContext(MainFunctionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LangGrammarParser.EOF, 0); }
		public List<IncludeContext> include() {
			return getRuleContexts(IncludeContext.class);
		}
		public IncludeContext include(int i) {
			return getRuleContext(IncludeContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(18);
				include();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			mainFunction();
			setState(25);
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
	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode LIBRARY_NAME() { return getToken(LangGrammarParser.LIBRARY_NAME, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__0);
			setState(28);
			match(T__1);
			setState(29);
			match(LIBRARY_NAME);
			setState(30);
			match(T__2);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__3);
			setState(33);
			match(T__4);
			setState(34);
			match(T__5);
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(36);
			match(T__6);
			setState(37);
			block();
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
	public static class BlockContext extends ParserRuleContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__8);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 131399155728L) != 0)) {
				{
				setState(42);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PRINT_FUNCTION:
				case INT_LITERAL:
				case FLOAT_LITERAL:
				case CHAR_LITERAL:
				case ID:
					{
					setState(40);
					statement();
					}
					break;
				case T__3:
				case T__26:
				case T__27:
					{
					setState(41);
					declaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			returnStatement();
			setState(48);
			match(T__9);
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
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode PRINT_FUNCTION() { return getToken(LangGrammarParser.PRINT_FUNCTION, 0); }
		public TerminalNode STRING() { return getToken(LangGrammarParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT_FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(PRINT_FUNCTION);
				setState(51);
				match(T__5);
				setState(52);
				match(STRING);
				setState(53);
				match(T__6);
				setState(54);
				match(T__10);
				}
				break;
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case CHAR_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				expression(0);
				setState(56);
				match(T__10);
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
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangGrammarParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode INT_LITERAL() { return getToken(LangGrammarParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(LangGrammarParser.FLOAT_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(LangGrammarParser.CHAR_LITERAL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(61);
				match(ID);
				setState(62);
				match(T__23);
				setState(63);
				expression(5);
				}
				break;
			case 2:
				{
				setState(64);
				match(INT_LITERAL);
				}
				break;
			case 3:
				{
				setState(65);
				match(FLOAT_LITERAL);
				}
				break;
			case 4:
				{
				setState(66);
				match(CHAR_LITERAL);
				}
				break;
			case 5:
				{
				setState(67);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(70);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(71);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16773132L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(72);
					expression(7);
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LangGrammarParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(LangGrammarParser.INT_LITERAL, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			type();
			setState(79);
			match(ID);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(80);
				match(T__23);
				setState(81);
				expression(0);
				}
			}

			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(84);
				match(T__24);
				setState(85);
				match(INT_LITERAL);
				setState(86);
				match(T__25);
				}
			}

			setState(89);
			match(T__10);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 402653200L) != 0)) ) {
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__28);
			setState(94);
			expression(0);
			setState(95);
			match(T__10);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003+\b\u0003\n\u0003\f\u0003.\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004;\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005E\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005J\b\u0005\n\u0005\f\u0005M\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006S\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006X\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0000\u0001\n\t\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0003\u0001\u0000\u0007\b\u0002"+
		"\u0000\u0002\u0003\f\u0017\u0002\u0000\u0004\u0004\u001b\u001cc\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0004"+
		" \u0001\u0000\u0000\u0000\u0006\'\u0001\u0000\u0000\u0000\b:\u0001\u0000"+
		"\u0000\u0000\nD\u0001\u0000\u0000\u0000\fN\u0001\u0000\u0000\u0000\u000e"+
		"[\u0001\u0000\u0000\u0000\u0010]\u0001\u0000\u0000\u0000\u0012\u0014\u0003"+
		"\u0002\u0001\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014\u0017\u0001"+
		"\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001"+
		"\u0000\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000\u0017\u0015\u0001"+
		"\u0000\u0000\u0000\u0018\u0019\u0003\u0004\u0002\u0000\u0019\u001a\u0005"+
		"\u0000\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"\u0001\u0000\u0000\u001c\u001d\u0005\u0002\u0000\u0000\u001d\u001e\u0005"+
		"\u001e\u0000\u0000\u001e\u001f\u0005\u0003\u0000\u0000\u001f\u0003\u0001"+
		"\u0000\u0000\u0000 !\u0005\u0004\u0000\u0000!\"\u0005\u0005\u0000\u0000"+
		"\"#\u0005\u0006\u0000\u0000#$\u0007\u0000\u0000\u0000$%\u0005\u0007\u0000"+
		"\u0000%&\u0003\u0006\u0003\u0000&\u0005\u0001\u0000\u0000\u0000\',\u0005"+
		"\t\u0000\u0000(+\u0003\b\u0004\u0000)+\u0003\f\u0006\u0000*(\u0001\u0000"+
		"\u0000\u0000*)\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-/\u0001\u0000\u0000\u0000"+
		".,\u0001\u0000\u0000\u0000/0\u0003\u0010\b\u000001\u0005\n\u0000\u0000"+
		"1\u0007\u0001\u0000\u0000\u000023\u0005\u001f\u0000\u000034\u0005\u0006"+
		"\u0000\u000045\u0005 \u0000\u000056\u0005\u0007\u0000\u00006;\u0005\u000b"+
		"\u0000\u000078\u0003\n\u0005\u000089\u0005\u000b\u0000\u00009;\u0001\u0000"+
		"\u0000\u0000:2\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000;\t\u0001"+
		"\u0000\u0000\u0000<=\u0006\u0005\uffff\uffff\u0000=>\u0005$\u0000\u0000"+
		">?\u0005\u0018\u0000\u0000?E\u0003\n\u0005\u0005@E\u0005!\u0000\u0000"+
		"AE\u0005\"\u0000\u0000BE\u0005#\u0000\u0000CE\u0005$\u0000\u0000D<\u0001"+
		"\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DA\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000EK\u0001\u0000\u0000"+
		"\u0000FG\n\u0006\u0000\u0000GH\u0007\u0001\u0000\u0000HJ\u0003\n\u0005"+
		"\u0007IF\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000L\u000b\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000NO\u0003\u000e\u0007\u0000OR\u0005$\u0000\u0000"+
		"PQ\u0005\u0018\u0000\u0000QS\u0003\n\u0005\u0000RP\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000SW\u0001\u0000\u0000\u0000TU\u0005\u0019\u0000"+
		"\u0000UV\u0005!\u0000\u0000VX\u0005\u001a\u0000\u0000WT\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0005\u000b"+
		"\u0000\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0007\u0002\u0000\u0000\\\u000f"+
		"\u0001\u0000\u0000\u0000]^\u0005\u001d\u0000\u0000^_\u0003\n\u0005\u0000"+
		"_`\u0005\u000b\u0000\u0000`\u0011\u0001\u0000\u0000\u0000\b\u0015*,:D"+
		"KRW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}