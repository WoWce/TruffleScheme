package com.ihorak.truffle.node.exprs.builtin.comparison;

import com.ihorak.truffle.node.SchemeExpression;
import com.ihorak.truffle.node.exprs.core.BinaryOperationNode;
import com.ihorak.truffle.node.exprs.core.comperison.EqualBinaryNodeGen;
import com.oracle.truffle.api.frame.VirtualFrame;


public class EqualExprNode extends SchemeExpression {

    @Child private SchemeExpression left;
    @Child private SchemeExpression right;
    @Child private BinaryOperationNode equalOperation = EqualBinaryNodeGen.create();

    public EqualExprNode(SchemeExpression left, SchemeExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean executeBoolean(VirtualFrame frame)  {
        return equalOperation.executeBoolean(left.executeGeneric(frame), right.executeGeneric(frame));
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return executeBoolean(frame);
    }
}
