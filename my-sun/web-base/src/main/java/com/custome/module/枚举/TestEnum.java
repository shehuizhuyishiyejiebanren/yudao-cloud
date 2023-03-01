package com.custome.module.枚举;



public enum TestEnum implements BaseEnum<String, String>{


    A("a","1")
    ;

    private final String key;
    private final String value;

    TestEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        TestEnum a = BaseEnumHandler.getEnumByKey(TestEnum.class, "a");
        System.out.println(a.getValue());
    }
}
