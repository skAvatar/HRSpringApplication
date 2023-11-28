package com.hr.hrspring.finalStatic;

import lombok.Data;

// Final
// Classes -> can not be extended
@Data
public final class Final {

    public String name;

    // Field -> can not be reassigned
    // F -> primitives -> can not change
    public final long AGE = 20L; // Constant

    // F -> argument -> can not change inside the method
    public final Long argument(final int a, int b ){
        // a = 20;
        return (long) (a + b);
    }

    // Methods -> can not be Overridden
    public final Long methodFinal(int a, int b ){
        return (long) (a + b);
    }

}


/*class ExtendFinal extends Final{
    @Override
    public final Long methodFinal(int a, int b ){
        return (long) (a + b);
    }
}*/

/*
class ExtendFinal extends Final{

}*/
