package br.com.moraes.clean.architecture.infrastructure.postgres.repository.queries;

public enum StudentSqlCommands {

    SAVE("insert into student (id, name, document_type, document_value, email, phones) values (?, ?, ?, ?, ?, ?)"),
    UPDATE_BY_ID("update student set email = ?, phones = ? where id = ?"),
    FIND_BY_ID("select * from student s where s.id = ?"),
    FIND_BY_DOCUMENT("select * from student s where s.document_value = ?"),
    FIND_BY_DOCUMENT_OR_EMAIL("select count(*) from student s where s.document_value = ? or s.email = ?");

    public final String sql;

    StudentSqlCommands(String sql) {
        this.sql = sql;
    }
}
