package com.ihorak.truffle.node.exprs.shared;

import com.ihorak.truffle.node.exprs.ArbitraryBuiltin;
import com.ihorak.truffle.type.SchemeCell;
import com.oracle.truffle.api.dsl.Specialization;


import static com.ihorak.truffle.type.SchemeCell.EMPTY_LIST;

public abstract class ListExprNode extends ArbitraryBuiltin {

    @Specialization
    protected SchemeCell createList(Object[] arguments) {
        SchemeCell list = EMPTY_LIST;
        for (int i = arguments.length; i-- > 0; ) {
            list = new SchemeCell(arguments[i], list);
        }

        return list;
    }

//    @Children private final SchemeExpression[] arguments;
//
//    public ListExprNode(List<SchemeExpression> arguments) {
//        this.arguments = arguments.toArray(SchemeExpression[]::new);
//    }
//
//    public ListExprNode() {
//        this.arguments = new SchemeExpression[0];
//    }
//
//    @Override
//    public SchemeCell executeList(VirtualFrame virtualFrame) {
//        return createList(virtualFrame);
//    }
//
//    @Override
//    public Object executeGeneric(VirtualFrame virtualFrame) {
//        return createList(virtualFrame);
//    }
//
//    private SchemeCell createList(VirtualFrame virtualFrame) {
//        if (arguments.length == 0) {
//            return EMPTY_LIST;
//        }
//
//        SchemeCell list = EMPTY_LIST;
//        for (int i = arguments.length; i-- > 0; ) {
//            list = new SchemeCell(arguments[i].executeGeneric(virtualFrame), list);
//        }
//
//        return list;
//    }
}
