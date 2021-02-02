
public class Row {
    public static final int COLUMN_USERNAME_SIZE = 32;
    public static final int COLUMN_EMAIL_SIZE = 255;

    private int id;
    private char[] username = new char[COLUMN_USERNAME_SIZE];
    private char[] email = new char[COLUMN_EMAIL_SIZE];
}
