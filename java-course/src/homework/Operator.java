package homework;

public enum Operator {

   PLUS("+",
           (
                   (a, b) -> a + b)
           ),
    MINUS("-",
            (
                    (a, b) -> a - b)
    ),
    MULTIP("*",
            (
                    (a, b) -> a*b
            )
    ),
    DIVISION("/",
            (
                    (a, b) -> (b == 0) ? null : (a / b)
            )
    ),
    ;

   final String name;
   final  CalculateFunction function;

    Operator(String name, CalculateFunction function) {
        this.name = name;
        this.function = function;
    }

    public static Operator findSymbol(String symbol) {
        Operator[] operators = Operator.values();
        for (Operator o : operators) {
            if (o.name.equals(symbol)) {
                return o;
            }
        }

        return null;
    }
}
