package com.ihorak.truffle.node.exprs.builtin.arithmetic;

import com.ihorak.truffle.node.SchemeExpression;
import com.ihorak.truffle.node.exprs.core.BinaryOperationNode;
import com.ihorak.truffle.node.exprs.core.arithmetic.MinusBinaryNodeGen;
import com.oracle.truffle.api.frame.VirtualFrame;



public class MinusExprNode extends SchemeExpression {

    @Child private SchemeExpression left;
    @Child private SchemeExpression right;
    @Child private BinaryOperationNode subtractOperation = MinusBinaryNodeGen.create();

    public MinusExprNode(SchemeExpression left, SchemeExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return subtractOperation.execute(left.executeGeneric(frame), right.executeGeneric(frame));
    }
}
