import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //死循环用来打印提示，获取下一行输入，并进行处理
        while (true) {
            //命令行提示
            printPrompt();
            //输入
            String input = sc.nextLine().trim();
            //元命令(非sql语句)
            if (input.startsWith(".")) {
                switch (doMetaCommand(input)) {
                    //命令成功
                    case (META_COMMAND_SUCCESS):
                        continue;
                        //没有这个命令
                    case (META_COMMAND_UNRECOGNIZED_COMMAND):
                        System.out.printf("Unrecognized command '%s'%n", input);
                        continue;
                }
            }
            //装配命令
            Statement statement = new Statement();
            switch (perpareStatement(input, statement)) {
                case (PREPARE_SUCCESS):
                    break;
                case (PREPARE_UNRECOGNIZED_STATEMENT):
                    System.out.printf("Unrecognized keyword at start of '%s'.%n", input);
                    continue;
            }
            //执行命令
            execute_statement(statement);
            System.out.println("Executed.");

        }
    }

    //提示信息
    public static void printPrompt() {
        System.out.print("StartDB> ");
    }


    public static MetaCommandResult doMetaCommand(String input) {
        if (".exit".equals(input)) {
            return MetaCommandResult.META_COMMAND_EXIT;
        } else {
            return MetaCommandResult.META_COMMAND_UNRECOGNIZED_COMMAND;
        }
    }

    public static PrepareResult perpareStatement(String input, Statement statement) {
        if (input.startsWith("insert")) {
            statement.setType(StatementType.STATEMENT_INSERT);

            return PrepareResult.PREPARE_SUCCESS;
        }
        if (input.startsWith("select")) {
            statement.setType(StatementType.STATEMENT_SELECT);
            return PrepareResult.PREPARE_SUCCESS;
        }

        return PrepareResult.PREPARE_UNRECOGNIZED_STATEMENT;
    }

    public static void execute_statement(Statement statement) {
        switch (statement.type) {
            case (StatementType.STATEMENT_INSERT):
                System.out.println("This is where we would do an insert.");
                break;
            case (StatementType.STATEMENT_SELECT):
                System.out.println("This is where we would do an select.");
                break;
        }
    }

}
