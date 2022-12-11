package acyclicvisitor;

interface Modem {

  void accept(final ModemVisitor visitor);
}
