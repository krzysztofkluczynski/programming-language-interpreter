package org.example.parser.Structure.Statement;

import lombok.Value;
import org.example.interpreter.Visitor;
import org.example.token.Position;

@Value
public class AssignmentWithQueryStatement implements Statement{
    String IdentifierName;
    QueryStatement QueryStatement;
    Position position;

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
