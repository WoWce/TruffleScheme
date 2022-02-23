package com.ihorak.truffle.node.exprs.builtin.arithmetic;

import com.ihorak.truffle.node.exprs.builtin.BinaryOperationNode;
import com.oracle.truffle.api.dsl.Specialization;

public abstract class DivideExprNode extends BinaryOperationNode {

    @Specialization
    public double doDouble(double left, double right) {
        return left / right;
    }


    @Override
    public String toString() {
        return "/";
    }
}
