package org.codehaus.jparsec;

/**
 * Converts the current return value as a {@link org.codehaus.jparsec.WithSource}
 * with string that matches it.
 *
 * @author Stepan Koltsov
 *
 * @see org.codehaus.jparsec.ReturnSourceParser
 * @see org.codehaus.jparsec.ToTokenParser
 */
final class WithSourceParser<T> extends Parser<WithSource<T>> {
  private final Parser<?> parser;

  WithSourceParser(Parser<?> parser) {
    this.parser = parser;
  }

  @Override boolean apply(ParseContext ctxt) {
    int begin = ctxt.getIndex();
    if (!parser.apply(ctxt)) {
      return false;
    }
    String source = ctxt.source.subSequence(begin, ctxt.getIndex()).toString();
    @SuppressWarnings("unchecked")
    WithSource<T> withSource = new WithSource<T>((T) ctxt.result, source);
    ctxt.result = withSource;
    return true;
  }
  
  @Override public String toString() {
    return parser.toString();
  }
}
