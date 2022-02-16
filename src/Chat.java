import java.util.Scanner;

class Chat {

    public static void main(String[] args) {

        String[] bot1ReplaysLegal =
                {
                        ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + "? okay: "
                                + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + " ",
                        "want me to say: " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + "? Fine, here goes: "
                                + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER
                };
        String[] bot1ReplaysIllegal =
                {
                        "what ",
                        "say i should say ",
                        "say what? " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "? what’s "
                                + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "? "
                };


        String[] bot2ReplaysLegal =
                {
                        ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + "? okay: "
                                + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + " ",
                        "want me to say: " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + "? Fine, here goes: "
                                + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER
                };
        String[] bot2ReplaysIllegal =
                {
                        "say say ",
                        "whaaat ",
                        "say what? " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "? what’s "
                                + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "? "
                };


        ChatterBot[] bots =
                {
                        new ChatterBot("Kermit", bot1ReplaysLegal, bot1ReplaysIllegal),
                        new ChatterBot("Piggy", bot2ReplaysLegal, bot2ReplaysIllegal)
                };

        String statement = "hello";
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; ; i++) {
            ChatterBot bot = bots[i % bots.length];
            statement = bot.replyTo(statement);
            System.out.print(bot.getName() + ": " + statement);
            scanner.nextLine();
        }
    }

}
