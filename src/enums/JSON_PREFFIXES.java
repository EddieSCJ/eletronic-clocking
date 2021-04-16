package enums;

public enum JSON_PREFFIXES {
    STRING_PREFIX("\""),
    STRING_SUFFIX("\""),
    OBJECT_PREFIX("{"),
    OBJECT_SUFFIX("}"),
    LIST_PREFIX("["),
    LIST_SUFFIX("]"),
    SEPARATOR(",");

    private final String value;

    JSON_PREFFIXES(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    ;

}
