public class Statement {
    StatementType type;
    Row insert;

    public Row getInsert() {
        return insert;
    }

    public void setInsert(Row insert) {
        this.insert = insert;
    }

    public StatementType getType() {
        return type;
    }

    public void setType(StatementType type) {
        this.type = type;
    }
}
