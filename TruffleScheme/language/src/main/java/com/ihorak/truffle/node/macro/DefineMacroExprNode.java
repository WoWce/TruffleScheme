package com.ihorak.truffle.node.macro;

import com.ihorak.truffle.exceptions.SchemeException;
import com.ihorak.truffle.node.SchemeExpression;
import com.ihorak.truffle.type.SchemeMacro;
import com.ihorak.truffle.type.SchemeSymbol;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class DefineMacroExprNode extends SchemeExpression {

    private final SchemeSymbol name;
    @Child private SchemeExpression transformationProcedure;

    public DefineMacroExprNode(SchemeSymbol name, SchemeExpression transformationProcedure) {
        this.name = name;
        this.transformationProcedure = transformationProcedure;
    }

    @Override
    public Object executeGeneric(VirtualFrame virtualFrame) {
        try {
            var transformationProc = transformationProcedure.executeFunction(virtualFrame);
            return new SchemeMacro(transformationProc);
        } catch (UnexpectedResultException e) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new SchemeException("define-macro:\nexpected: procedure\ngiven: " + e.getResult());
        }

    }

    public SchemeSymbol getName() {
        return name;
    }
}
